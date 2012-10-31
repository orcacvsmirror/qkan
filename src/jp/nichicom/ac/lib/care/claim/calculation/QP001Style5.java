/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKANCHO（JMA care benefit management software）
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKANCHO (JMA care benefit management software)".
 *
 * This program is distributed in the hope that it will be useful
 * for further advancement in medical care, according to JMA Open
 * Source License, but WITHOUT ANY WARRANTY.
 * Everyone is granted permission to use, copy, modify and
 * redistribute this program, but only under the conditions described
 * in the JMA Open Source License. You should have received a copy of
 * this license along with this program. If not, stop using this
 * program and contact JMA, 2-28-16 Honkomagome, Bunkyo-ku, Tokyo,
 * 113-8621, Japan.
 *****************************************************************
 * アプリ: QKANCHO
 * 開発者: 藤原　伸
 * 作成日: 2006/01/24  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 様式第五 (QP001Style5)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.text.parsers.VRDateParser;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

/**
 * 様式第五 一帳票分の情報
 * 
 * @author shin fujihara
 * 
 */
public class QP001Style5 extends QP001StyleAbstract {

    /**
     * 基本情報レコード(一帳票にひとつ)
     */
    private QP001RecordBase base = new QP001RecordBase();

    /**
     * 明細情報レコード集合
     */
    private VRMap detailMap = new VRHashMap();

    /**
     * 集計情報レコード集合(一帳票にひとつ)
     */
    private QP001RecordType type = new QP001RecordType();

    /**
     * 特定診療費情報レコード
     */
    private Map<String, QP001RecordDiagnosis> diagnosisMap = new TreeMap<String, QP001RecordDiagnosis>();

    /**
     * 特定入所者介護サービス情報レコード
     */
    private VRMap nursingMap = new VRHashMap();
    
    /**
     * 内部様式番号
     */
    private int claimStyleFormat = 0;
    /**
     * 交換識別番号
     */
    private String identificationNo = "";
    private QP001Manager manager = null;

    public QP001Style5(int claimStyleFormat,QP001Manager manager){
        this.claimStyleFormat = claimStyleFormat;
        this.identificationNo = getIdentificationNo(claimStyleFormat,manager.getTargetDate());
        this.manager = manager;
    }

    public static String getSerialId(
            Date targetDate,
            VRMap serviceDetail,
            QP001PatientState patientState,
            int claimStyleFormat) throws Exception {
        StringBuilder serial = new StringBuilder();
        // 201001 交換情報識別番号4桁
        
        //[H20.4 法改正対応] fujihara edit start
        //serial.append(getIdentificationNo(claimStyleFormat));
        serial.append(getIdentificationNo(claimStyleFormat,targetDate));
        //[H20.4 法改正対応] fujihara edit end
        
        // サービス提供年月6桁(YYYYMM)
        serial.append(VRDateParser.format(targetDate, "yyyyMM"));
        // 事業所番号10桁
        serial.append(VRBindPathParser.get("PROVIDER_ID", serviceDetail));
        // 証記載保険者番号8桁
        serial.append(patientState.getInsurerId(VRBindPathParser.get(
                "SERVICE_DATE", serviceDetail)));
        // 被保険者番号10桁
        serial.append(patientState.getInsuredId(VRBindPathParser.get(
                "SERVICE_DATE", serviceDetail)));

        return serial.toString();

    }

    /**
     * データの解析を実行する。
     * 
     * @param serviceDetail
     * @param targetDate
     * @param patientState
     * @param serviceCode
     * @throws Exception
     */
    public void parse(VRMap serviceDetail, Date targetDate,
            QP001PatientState patientState, VRMap serviceCode,boolean firstRecord) throws Exception {

        Object targetServiceDate = VRBindPathParser.get("SERVICE_DATE",
                serviceDetail);
        /* 明細情報レコード集計処理 */
        QP001RecordDetail detail = QP001RecordDetail.getInstance(identificationNo,
                targetDate,
                targetServiceDate,
                serviceDetail,
                serviceCode,
                patientState,
                detailMap,
                manager);
        
        //レコードが作成されていれば
        if(detail != null){
            //明細情報データ解析
            detail.parse(serviceDetail,targetDate,patientState,serviceCode,identificationNo,manager);
        }
        
        
        /* 特定診療費情報レコード */
        QP001RecordDiagnosisMaker diagnosisMaker = new QP001RecordDiagnosisMaker(
                identificationNo, serviceDetail, targetDate,
                targetServiceDate, patientState, serviceCode, diagnosisMap,manager);
        
        if(firstRecord){
            // 特定診療費情報レコードの作成
            diagnosisMap = diagnosisMaker.make();
        }

        /* 特定入所者介護サービス */
        QP001RecordNursing nursing = QP001RecordNursing.getInstance(identificationNo,
                                                                targetDate,
                                                                targetServiceDate,
                                                                serviceDetail,
                                                                serviceCode,
                                                                patientState,
                                                                nursingMap,
                                                                manager);

        if(nursing != null){
            // 特定入所者レコードの解析を行う。
            nursing.parse(serviceDetail, targetDate, patientState, serviceCode,
                    identificationNo,manager);
        }

    }

    /**
     * 情報の確定を行う。
     */
    public void commitRecords(QP001PatientState patientState,VRMap styles, VRMap planUnitMap)
            throws Exception {
        VRMap kohiMap;
        TreeMap kohiRank = new TreeMap();
        QP001RecordDetail detail = null;
        QP001RecordNursing nursing = null;
        QP001RecordDiagnosis diagnosis = null;

        // 本帳票における公費順位の確定を行う。
        // TODO もう少し処理をすっきりさせたい。

        Iterator it = detailMap.keySet().iterator();
        while (it.hasNext()) {
            detail = (QP001RecordDetail) detailMap.get(it.next());
            // 作成した明細情報レコードの公費適用状況を取得する。
            kohiMap = detail.getKohiList();
            Iterator itKohi = kohiMap.keySet().iterator();
            // 公費の順位を登録する。
            while (itKohi.hasNext()) {
                Object key = itKohi.next();
                if (!kohiRank.containsKey(key)) {
                    kohiRank.put(key, kohiMap.get(key));
                }
            }
        }
        it = nursingMap.keySet().iterator();
        while (it.hasNext()) {
            nursing = (QP001RecordNursing) nursingMap.get(it.next());
            // 作成した特定入所者レコードの公費適用状況を取得する。
            kohiMap = nursing.getKohiList();
            Iterator itKohi = kohiMap.keySet().iterator();
            // 公費の順位を登録する。
            while (itKohi.hasNext()) {
                Object key = itKohi.next();
                if (!kohiRank.containsKey(key)) {
                    kohiRank.put(key, kohiMap.get(key));
                }
            }
        }
        it = diagnosisMap.keySet().iterator();
        while (it.hasNext()) {
            diagnosis = (QP001RecordDiagnosis) diagnosisMap.get(it.next());
            // 作成した特定診療費レコードの公費状況を取得する。
            kohiMap = diagnosis.getKohiList();
            Iterator itKohi = kohiMap.keySet().iterator();
            // 公費の順位を登録する。
            while (itKohi.hasNext()) {
                Object key = itKohi.next();
                if (!kohiRank.containsKey(key)) {
                    kohiRank.put(key, kohiMap.get(key));
                }
            }
        }

        // 公費適用順位
        String[] kohiTypes = new String[3];
        it = kohiRank.keySet().iterator();
        int count = 0;
        while (it.hasNext()) {
            VRMap temp = (VRMap) kohiRank.get(it.next());
            kohiTypes[count] = ACCastUtilities.toString(VRBindPathParser.get(
                    "KOHI_TYPE", temp));
            count++;
            if (count > kohiTypes.length - 1)
                break;
        }

        // 明細情報レコードの確定処理
        it = detailMap.keySet().iterator();
        while (it.hasNext()) {
            // 作成した明細情報レコードの確定を行う。
            ((QP001RecordDetail) detailMap.get(it.next()))
                    .commitRecord(kohiTypes,patientState);
        }

        // 特定入所者レコードの確定処理
        //全額利用者請求対応
        QP001RecordNursing nursingLast = null;
        it = nursingMap.keySet().iterator();
        while (it.hasNext()) {
            nursing = (QP001RecordNursing) nursingMap.get(it.next());
            // 作成した特定入所者レコードの確定処理を行う。
            nursing.commitRecord(kohiTypes,patientState,manager);
            //2006.04.28 全額自己負担対応
            if((nursing.get_801017() + nursing.get_801018() + nursing.get_801019() + nursing.get_801020()) > 0){
                nursingLast = nursing;
            }
        }
        // 最終レコードの集計を行う。
        if (nursingLast != null) {
            // 集計を行う
            nursingLast.commitRecord(nursingMap);
        }

        // 特定診療費情報レコードの確定処理
//        it = diagnosisMap.keySet().iterator();
//        int recordCount = 1;
//        while (it.hasNext()) {
//            diagnosis = (QP001RecordDiagnosis) diagnosisMap.get(it.next());
//            // 作成した特定診療費情報レコードの確定処理を行う。
//            diagnosis.commitRecord(kohiTypes, recordCount,patientState);
//            recordCount++;
//        }
//        if (diagnosis != null) {
//            // 集計を行う。
//            diagnosis.commitRecord(diagnosisMap,patientState);
//        }
        
        //[ID:0000682][Shin Fujihara] add begin 【法改正対応】介護職員処遇改善加算
        // 特定診療費情報レコード、処遇改善レコードの確定処理
        diagnosisMap = commitTreatmentImprovement(detailMap, diagnosisMap, patientState, kohiTypes, styles, planUnitMap);
        //[ID:0000682][Shin Fujihara] add end 【法改正対応】介護職員処遇改善加算

        it = detailMap.keySet().iterator();
        // 集計情報レコードの作成(明細情報より)
        while (it.hasNext()) {
            detail = ((QP001RecordDetail) detailMap.get(it.next()));
            type.parse(detail,patientState,manager);
        }
        
        // 集計情報レコードの確定処理
        type.commitRecord(kohiTypes, patientState,styles,planUnitMap);
        // 集計情報レコードの作成(特定診療情報レコードより)
        if (diagnosis != null) {
        	//[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009年度対応
            //type.parse(diagnosis, kohiTypes,patientState);
        	type.parse(diagnosis, kohiTypes,patientState, nursingLast);
            //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009年度対応
        }
        
        

        // 基本情報レコードの確定処理
        base.parse(type, patientState,kohiTypes,manager);
        
        // 特定入所者レコードの確定処理
        //base.parse(nursing);
        base.parse(nursingLast,patientState,kohiTypes);

        //特定診療費レコードの確定処理
        base.parse(diagnosis,patientState,kohiTypes);
        
    }

    /**
     * DB登録用のデータ取得を行う。
     */
    public VRList getRecords(int patient_id, Date claimDate)
            throws Exception {
        VRList list = new VRArrayList();
        VRHashMap style = new VRHashMap();

		//データが正常に生成されていない場合は処理を終了する。
		if(ACTextUtilities.isNullText(base.get_201003())){
			return list;
		}
        
        // 帳票の様式番号
        style.put("CLAIM_STYLE_TYPE", ACCastUtilities.toString(claimStyleFormat));
        // 利用者ＩＤ
        style.put("PATIENT_ID", Integer.toString(patient_id));
        //基本情報レコードから取得
        //利用者番号(被保険者番号)
        style.put("INSURED_ID", base.get_201006());
        //請求の対象となる年月(サービス提供年月)
        style.put("TARGET_DATE", ACCastUtilities.toDate(base.get_201003()
                + "01"));
        //請求を行う年月日
        style.put("CLAIM_DATE", claimDate);
        //請求元事業所
        style.put("PROVIDER_ID", base.get_201004());
        
        //保険者番号
        style.put("INSURER_ID",base.get_201005());
        //被保険者番号
        style.put("INSURED_ID",base.get_201006());

        style.put("CLAIM_FINISH_FLAG", "0");

        //明細情報レコード
        Iterator it = detailMap.keySet().iterator();
        while (it.hasNext()) {
            list.add(((QP001RecordDetail) detailMap.get(it.next()))
                    .getRecord(style));
        }
        //特定入所者レコード
        it = nursingMap.keySet().iterator();
        while (it.hasNext()) {
            list.add(((QP001RecordNursing) nursingMap.get(it.next()))
                    .getRecord(style));
        }

        //特定診療費情報レコード
        //diagnosisMap
        it = diagnosisMap.keySet().iterator();
        while (it.hasNext()) {
            list.add(((QP001RecordDiagnosis) diagnosisMap.get(it.next()))
                    .getRecord(style));
        }

        //集計情報レコード
        list.add(type.getRecord(style));

        //基本情報レコード
        list.add(base.getRecord(style));

        return list;
    }

}
