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
 * 開発者: 上司　和善
 * 作成日: 2006/02/16  日本コンピューター株式会社 上司　和善 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求データ作成 (P)
 * プロセス 確認・修正 (003)
 * プログラム 利用者向け請求詳細編集 (QP003)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp003;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;


import com.lowagie.text.pdf.PRAcroForm;

import jp.nichicom.ac.*;
import jp.nichicom.ac.bind.*;
import jp.nichicom.ac.component.*;
import jp.nichicom.ac.component.dnd.*;
import jp.nichicom.ac.component.dnd.event.*;
import jp.nichicom.ac.component.event.*;
import jp.nichicom.ac.component.mainmenu.*;
import jp.nichicom.ac.component.table.*;
import jp.nichicom.ac.container.*;
import jp.nichicom.ac.core.*;
import jp.nichicom.ac.filechooser.*;
import jp.nichicom.ac.io.*;
import jp.nichicom.ac.lang.*;
import jp.nichicom.ac.pdf.*;
import jp.nichicom.ac.sql.*;
import jp.nichicom.ac.text.*;
import jp.nichicom.ac.util.*;
import jp.nichicom.ac.util.adapter.*;
import jp.nichicom.vr.*;
import jp.nichicom.vr.bind.*;
import jp.nichicom.vr.bind.event.*;
import jp.nichicom.vr.border.*;
import jp.nichicom.vr.component.*;
import jp.nichicom.vr.component.event.*;
import jp.nichicom.vr.component.table.*;
import jp.nichicom.vr.container.*;
import jp.nichicom.vr.focus.*;
import jp.nichicom.vr.image.*;
import jp.nichicom.vr.io.*;
import jp.nichicom.vr.layout.*;
import jp.nichicom.vr.text.*;
import jp.nichicom.vr.text.parsers.*;
import jp.nichicom.vr.util.*;
import jp.nichicom.vr.util.adapter.*;
import jp.nichicom.vr.util.logging.*;
import jp.or.med.orca.qkan.*;
import jp.or.med.orca.qkan.affair.*;
import jp.or.med.orca.qkan.component.*;
import jp.or.med.orca.qkan.lib.*;
import jp.or.med.orca.qkan.text.*;

/**
 * 利用者向け請求詳細編集(QP003)
 */
public class QP003 extends QP003Event {
    /**
     * コンストラクタです。
     */
    public QP003() {
    }

    public void initAffair(ACAffairInfo affair) throws Exception {
        super.initAffair(affair);
        initAction(affair);
    }

    /**
     * 初期化処理を行ないます。
     * 
     * @param affair 業務情報
     * @throws Exception 処理例外
     */
    protected void initAction(ACAffairInfo affair) throws Exception {
        // 下記の渡りパラメータを退避する。
        VRMap params = affair.getParameters();
        // ・patientId KEY：PATIENT_ID
        if (VRBindPathParser.has("PATIENT_ID", params)) {
            setPatientId(ACCastUtilities.toInt(params.getData("PATIENT_ID")));
        }
        // ・targetDate KEY：TARGET_DATE
        if (VRBindPathParser.has("TARGET_DATE", params)) {
            setTargetDate(ACCastUtilities.toDate(params.getData("TARGET_DATE")));
        }
        // ・claimDate KEY：CLAIM_DATE
        if (VRBindPathParser.has("CLAIM_DATE", params)) {
            setClaimDate(ACCastUtilities.toDate(params.getData("CLAIM_DATE")));
        }
        // ・listIndex KEY：LIST_INDEX
        if (VRBindPathParser.has("LIST_INDEX", params)) {
            setListIndex(ACCastUtilities.toInt(params.getData("LIST_INDEX")));
        }
        // ・providerId KEY：PROVIDER_ID
        if (VRBindPathParser.has("PROVIDER_ID", params)) {
            setProviderId(ACCastUtilities.toString(params
                    .getData("PROVIDER_ID")));
        }
        // ・insurerId KEY：INSURER_ID
        if (VRBindPathParser.has("INSURER_ID", params)) {
            setInsurerId(ACCastUtilities.toString(params.getData("INSURER_ID")));
        }
        // ・insuredId KEY：INSURED_ID
        if (VRBindPathParser.has("INSURED_ID", params)) {
            setInsuredId(ACCastUtilities.toString(params.getData("INSURED_ID")));
        }

        setPASSIVE_CHECK_KEY(new ACPassiveKey("CLAIM_PATIENT_DETAIL",
                new String[] { "CLAIM_ID" }, new Format[] { null },
                "LAST_TIME", "LAST_TIME"));

        // コンボ候補の設定
        comboInitialize();

        // 業務情報マスタより、データを取得する。
        setAffairTitle("QP003", getButtons());
        // 取得したデータのウィンドウタイトル（WINDOW_TITLE）をウィンドウに設定する。
        // 取得したデータの業務タイトル（AFFAIR_TITLE）を業務ボタンバーに設定する。
        // DBよりデータを取得し、画面に展開する。
        doFind();

    }

    /**
     * 前画面遷移処理を行います。 
     */
    public boolean canBack(VRMap parameters) throws Exception {
        if (!super.canBack(parameters)) {
            return false;
        }
        // 更新チェック（スナップショットのチェック）を行う。
        if (getSnapshot().isModified()) {
            // 最後に保存されてから、項目・テーブルが変更されている場合場合(not isModified)
            // 確認メッセージを表示する。
            int msgID = 0;
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                msgID = QkanMessageList.getInstance()
                        .WARNING_OF_INSERT_ON_MODIFIED();
            } else {
                msgID = QkanMessageList.getInstance()
                        .WARNING_OF_UPDATE_ON_MODIFIED();
            }
            // ・メッセージID：WARNING_OF_UPDATE_ON_MODIFIED
            switch (msgID) {
            // 「はい」を選択した場合
            case ACMessageBox.RESULT_YES:
                // 保存処理を行う。
                if (!doSave()) {
                    // 保存処理が正常終了しなかった場合
                    // 処理を中断する。(終了)
                    return false;
                }
                break;
            // ｢いいえ｣を選択した場合
            case ACMessageBox.RESULT_NO:
                break;
            // ｢キャンセル｣を選択した場合
            case ACMessageBox.RESULT_CANCEL:
                return false;
            }
            // 「はい」「いいえ」以外を選択した場合
            // 処理を中断する（何もしない）。
        }

        // 下記を渡りパラメータとして、帳票(様式)・事業所選択画面（QP002）に遷移する。
        // ・KEY：PATIENT_ID VALUE：patientId
        // ・KEY：TARGET_DATE VALUE：targetDate
        // ・KEY：CLAIM_DATE VALUE：claimDate
        // ・KEY：LIST_INDEX VALUE：listIndex
        parameters.setData("PATIENT_ID", new Integer(getPatientId()));
        parameters.setData("TARGET_DATE", getTargetDate());
        parameters.setData("CLAIM_DATE", getClaimDate());
        parameters.setData("LIST_INDEX", new Integer(getListIndex()));

        // TODO 前画面への遷移を許可するならばtrueを返す。
        return true;

    }

    // コンポーネントイベント
    /**
     * 終了処理を行います。
     */
    public boolean canClose() throws Exception {
        if (!super.canClose()) {
            return false;
        }
        // ※スナップショットチェック
        // スナップショットの更新チェックを行う。
        if (!getSnapshot().isModified()) {
            // 更新されていない場合
            return true;
            // システムを終了する。
        }
        // 更新されている場合
        // 処理を継続する。
        // ※終了確認
        // 終了確認のメッセージを表示する。※メッセージID = WARNING_OF_CLOSE_ON_MODIFIED
        int msgID = QkanMessageList.getInstance()
                .WARNING_OF_CLOSE_ON_MODIFIED();
        // 「OK」選択時
        if (ACMessageBox.RESULT_OK == msgID) {
            // システムを終了する。
            return true;
        } else {
            // 「キャンセル」選択時
            // 処理を中断する。
            return false;
        }
        //TODO 終了を許可するならばtrueを返す。

    }

    // コンポーネントイベントk

    /**
     * 「DB登録」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void insertActionPerformed(ActionEvent e) throws Exception {
        // 登録処理を行う。
        if (doSave()) {
            // 登録処理が正常終了した場合
            // 完了メッセージを表示する。
            QkanMessageList.getInstance().INSERT_SUCCESSED();
            // ・メッセージID：INSERT_SUCCESSED
        }
        // 登録処理が正常終了しなかった場合
        // 処理を中断する（終了）

    }

    // コンポーネントイベント

    /**
     * 「DB登録」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void updateActionPerformed(ActionEvent e) throws Exception {

        // 更新処理を行う。
        if (doSave()) {
            // 更新処理が正常終了した場合
            // 完了メッセージを表示する。
            // ・メッセージID：UPDATE_SUCCESSED
            QkanMessageList.getInstance().UPDATE_SUCCESSED();
        }
        // 更新処理が正常終了しなかった場合
        // 処理を中断する。(終了)

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentJikohutanUse1FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentJikohutanUse2FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentJikohutanUse3FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcUse1FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcUse2FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcUse3FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcUse4FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    /**
     * 「合計金額の計算」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void contentEtcUse5FocusLost(FocusEvent e) throws Exception {
        // 金額の合計を算出し、表示する。
        calcSum();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        param.setData("PATIENT_ID", new Integer(1));
        param.setData("CLAIM_DATE", new Date(106, 2, 1));
        param.setData("PROVIDER_ID", "0000000005");
        param.setData("TARGET_DATE", new Date(106, 1, 1));
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QP003.class.getName(), param));
    }

    // 内部関数

    // 内部関数

    /**
     * 「データ取得、画面展開」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFind() throws Exception {
        // データの取得、展開を行う。
        // 利用者情報を取得する。
        VRList patientList = QkanCommon.getPatientInfo(getDBManager(),
                getPatientId());
        // 取得した利用者情報より、下記の値を抽出してデータ展開用HashMap(sourceMap)に設定する。
        if (!patientList.isEmpty()) {
            VRMap patientMap = (VRMap) patientList.getData(0);
            // ・利用者ID KEY：PATIENT_ID
            getSourceMap().setData("PATIENT_CODE",
                    patientMap.getData("PATIENT_CODE"));
            // ・利用者名 KEY：PATIENT_NAME
            getSourceMap().setData(
                    "PATIENT_NAME",
                    QkanCommon.toFullName(patientMap
                            .getData("PATIENT_FAMILY_NAME"), patientMap
                            .getData("PATIENT_FIRST_NAME")));
        }
        // 事業所情報を取得する。
        VRList providerList = QkanCommon.getProviderInfo(getDBManager(),
                getProviderId());
        // 取得した事業所情報より、下記の値を抽出してデータ展開用HashMap(sourceMap)に設定する。
        if (!providerList.isEmpty()) {
            VRMap providerMap = (VRMap) providerList.getData(0);
            // ・事業所ID KEY：PROVIDER_ID
            getSourceMap().setData("PROVIDER_ID",
                    providerMap.getData("PROVIDER_ID"));
            // ・事業所名 KEY：PROVIDER_NAME
            getSourceMap().setData("PROVIDER_NAME",
                    providerMap.getData("PROVIDER_NAME"));
        }
        // 対象年月（targetDate）をデータ展開用HashMap(sourceMap)にKEY：TARGET_DATEで設定する。
        getSourceMap().setData("TARGET_DATE", getTargetDate());
        // 利用者向け請求詳細情報を取得する。
        doFindClaimForPatient();

        VRList claimList = getClaimList();
        // 利用者向け請求詳細情報（claimList）の最初のレコードをデータ展開用HashMap(sourceMap)と結合する。
        if (!claimList.isEmpty()) {
            getSourceMap().putAll((VRMap) claimList.getData(0));
        }
        // データ展開用HashMap(sourceMap)を「クライアント領域（contents）」に設定する。
        getContents().setSource(getSourceMap());

        // 画面に展開する。
        getContents().bindSource();

        // 金額の合計を算出する。
        calcSum();

        // スナップショットの撮影対象を「クライアント領域（contents）」に指定する。
        getSnapshot().setRootContainer(getContents());
        // スナップショットを撮影する。
        getSnapshot().snapshot();

    }

    /**
     * 「利用者向け請求詳細情報を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doFindClaimForPatient() throws Exception {
        // 利用者向け請求詳細情報を取得
        // SQL文取得用のVRMap paramを生成し、以下のKEY/VALUEを設定する。
        VRMap param = new VRHashMap();
        // ・KEY：PATIENT_ID VALUE：patientId
        // ・KEY：TARGET_DATE VALUE：targetDate
        // ・KEY：CLAIM_DATE VALUE：claimDate
        // ・KEY：PROVIDER_ID VALUE：providerId
        // ・KEY：CLAIM_STYLE_TYPE VALUE：claimDate
        // ・KEY：CATEGORY_NO VALUE：
        // ・KEY：INSURED_ID VALUE：insuredId
        param.setData("PATIENT_ID", new Integer(getPatientId()));
        param.setData("TARGET_DATE", getTargetDate());
        param.setData("CLAIM_DATE", getClaimDate());
        param.setData("PROVIDER_ID", getProviderId());
        param.setData("CLAIM_STYLE_TYPE", new Integer(
                STYLE_TYPE_CLAIM_FOR_PATIENT));
        param
                .setData("CATEGORY_NO", new Integer(
                        CATEGORY_NO_CLAIM_FOR_PATIENT));
        param.setData("INSURED_ID", getInsuredId());
        // 利用者向け請求詳細情報を取得するSQL文を取得する。
        // 取得したSQL文を実行し、データをclaimListに格納する。
        setClaimList(getDBManager().executeQuery(
                getSQL_GET_CLAIM_PATIENT_DETAIL(param)));
        // claimListの件数が0件の場合
        // if(getClaimList()!=null){
        if (getClaimList().size() <= 0) {
            // processMode に共通定数のPROCESS_MODE_INSERTを代入する。
            setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
            // dataFlg に0を代入する。
            setDataFlg(0);
            setState_INSERT_STATE();

        } else {
            // claimListの件数が1件以上の場合
            // claimListの最初のレコードを取り出す。
            VRMap map = (VRMap) getClaimList().getData(0);
            // 取り出したレコードのKEY：CLAIM_IDの値をclaimIdへ退避する。
            setClaimId(ACCastUtilities.toInt(map.getData("CLAIM_ID")));

            setState_UPDATE_STATE();
            // 取り出したレコードのKEY：DATA_FLAGの値をチェックする。
            if (map.getData("DATA_FLAG") == null) {
                // KEY：DATA_FLAGの値がnull の場合
                // processMode に共通定数のPROCESS_MODE_INSERTを代入する。
                setProcessMode(QkanConstants.PROCESS_MODE_INSERT);
                // dataFlg に1を代入する。
                setDataFlg(1);
            } else {
                // KEY：DATA_FLAGの値がnull でない場合
                // processMode に共通定数のPROCESS_MODE_UPDATEを代入する。
                setProcessMode(QkanConstants.PROCESS_MODE_UPDATE);
                // dataFlg に１を代入する。
                setDataFlg(1);
            }
        }
        // claimListをパッシブチェック用に退避する。
        getPassiveChecker().reservedPassive(getPASSIVE_CHECK_KEY(),
                getClaimList());

    }

    /**
     * 「合計金額の計算処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void calcSum() throws Exception {
        // 合計金額の計算処理
        int sum = 0;
        // 下記のフィールドのいずれかに値が表示されている場合、フィールドの値の合計を計算する。
        // ・全額自己負担分利用料１（contentJikohutanUse1）
        if (!"".equals(getContentJikohutanUse1().getText())) {
            sum += ACCastUtilities.toInt(getContentJikohutanUse1().getText());
        }

        // ・全額自己負担分利用料２（contentJikohutanUse2）
        if (!"".equals(getContentJikohutanUse2().getText())) {
            sum += ACCastUtilities.toInt(getContentJikohutanUse2().getText());
        }

        // ・全額自己負担分利用料３（contentJikohutanUse3）
        if (!"".equals(getContentJikohutanUse3().getText())) {
            sum += ACCastUtilities.toInt(getContentJikohutanUse3().getText());
        }

        // 計算結果を全額自己負担小計フィールド（contentJikohutanSubtotal）に表示する。
        getContentJikohutanSubtotal().setText(ACCastUtilities.toString(sum));
        // 下記のフィールドのいずれかに値が表示されている場合、フィールドの値の合計を計算する。
        int etcSum = 0;
        // ・その他利用料１（contentEtcUse1）
        if (!"".equals(getContentEtcUse1().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse1().getText());
        }

        // ・その他利用料２（contentEtcUse2）
        if (!"".equals(getContentEtcUse2().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse2().getText());
        }

        // ・その他利用料３（contentEtcUse3）
        if (!"".equals(getContentEtcUse3().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse3().getText());
        }

        // ・その他利用料４（contentEtcUse4）
        if (!"".equals(getContentEtcUse4().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse4().getText());
        }

        // ・その他利用料５（contentEtcUse5）
        if (!"".equals(getContentEtcUse5().getText())) {
            etcSum += ACCastUtilities.toInt(getContentEtcUse5().getText());
        }

        // 計算結果をその他費用小計フィールド（contentEtcSubtotal）に表示する。
        getContentEtcSubtotal().setText(ACCastUtilities.toString(etcSum));
        // 下記のフィールドの値とsumを合計し、合計額（contentTotalText）に表示する。
        sum = sum + etcSum;
        // ・全額自己負担小計フィールド（contentJikohutanSubtotal）
        // ・その他費用小計フィールド（contentEtcSubtotal）
        getContentTotalText().setText(ACCastUtilities.toString(sum));

    }

    /**
     * 「保存処理」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean doSave() throws Exception {
        // 保存処理
        // トランザクションを開始する。
        try {
            getDBManager().beginTransaction();

            // 画面上のデータのチェックを行う。
            doCheckInput();

            // 更新モードの場合（processModeが共通定数のPROCESS_MODE_UPDATEの場合）
            if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // パッシブチェックのタスクをクリアする。
                // clearPassiveTask();
                getPassiveChecker().clearPassiveTask();
                // パッシブチェックを下記のパッシブキーで行う。
                // addPassiveDeleteTask();
                // ・PASSIVE_CHECK_KEY
                getPassiveChecker()
                        .addPassiveUpdateTask(getPASSIVE_CHECK_KEY());
                // パッシブエラーが発生した場合
                if (!getPassiveChecker().passiveCheck(getDBManager())) {
                    //テーブルロック解除のためロールバック
                    getDBManager().rollbackTransaction();
                    // エラーメッセージを表示する。
                    QkanMessageList.getInstance()
                            .ERROR_OF_PASSIVE_CHECK_ON_UPDATE();
                    // ・メッセージID：ERROR_OF_PASSIVE_CHECK_ON_UPDATE
                    return false;
                    // （終了）
                }
            }
            // CLAIMテーブルの更新
            // dataFlg が0の場合
            if (getDataFlg() == 0) {
                // 新たにCLAIM_IDを取得する。
                // getBookingNumber(CLAIM, CLAIM_ID, 1);
                // 取得したCLAIM_IDをclaimIdに退避する。
                setClaimId(QkanCommon.getBookingNumber(getDBManager(), "CLAIM",
                        "CLAIM_ID", 1));
                // SQL文取得用のVRMap paramを生成し、以下のKEY/VALUEを設定する。
                VRMap param = new VRHashMap();
                // ・KEY：CLAIM_ID VALUE：claimId
                // ・KEY：CLAIM_STYLE_TYPE VALUE：STYLE_TYPE_CLAIM_FOR_PATIENT
                // ・KEY：CATEGORY_NO VALUE：CATEGORY_NO_CLAIM_FOR_PATIENT
                // ・KEY：PATIENT_ID VALUE：patientId
                // ・KEY：INSURED_ID VALUE：insuredId
                // ・KEY：TARGET_DATE VALUE：targetDate
                // ・KEY：CLAIM_DATE VALUE：claimDate
                // ・KEY：INSURER_ID VALUE：insurerId
                // ・KEY：PROVIDER_ID VALUE：providerId
                // ・KEY：CLAIM_FINISH_FLAG VALUE：0
                param.setData("CLAIM_ID", new Integer(getClaimId()));
                param.setData("CLAIM_STYLE_TYPE", new Integer(
                        STYLE_TYPE_CLAIM_FOR_PATIENT));
                param.setData("CATEGORY_NO", new Integer(
                        CATEGORY_NO_CLAIM_FOR_PATIENT));
                param.setData("PATIENT_ID", new Integer(getPatientId()));
                param.setData("INSURED_ID", getInsuredId());
                param.setData("TARGET_DATE", getTargetDate());
                param.setData("CLAIM_DATE", getClaimDate());
                param.setData("INSURER_ID", getInsurerId());
                param.setData("PROVIDER_ID", getProviderId());
                param.setData("CLAIM_FINISH_FLAG", new Integer(0));

                // paramを引数として、SQL文を取得する。
                // SQL文を実行する。
                getDBManager().executeUpdate(getSQL_INSERT_CLAIM(param));
            }

            VRMap param = new VRHashMap();
            // PATIENT_CLAIM_DETAILテーブルの更新
            // 画面上のデータを取得する。
            // applySource(contents);
            getContents().setSource(param);
            getContents().applySource();
            // 画面上のデータを格納しているVRMap（以下、param）に以下のKEY/VALUEを設定する。;
            // ・KEY：CLAIM_ID VALUE：claimId
            param.setData("CLAIM_ID", new Integer(getClaimId()));
            // 登録モードの場合（processModeが共通定数のPROCESS_MODE_INSERTの場合）
            if (getProcessMode() == QkanConstants.PROCESS_MODE_INSERT) {
                // paramを引数として、SQL文を取得する。
                // SQL文を実行する。
                getDBManager().executeUpdate(
                        getSQL_INSERT_CLAIM_PATIENT_DETAIL(param));
            } else if (getProcessMode() == QkanConstants.PROCESS_MODE_UPDATE) {
                // 更新モードの場合（processModeが共通定数のPROCESS_MODE_UPDATEの場合）
                // paramを引数として、SQL文を取得する。
                // SQL文を実行する。
                getDBManager().executeUpdate(
                        getSQL_UPDATE_CLAIM_PATIENT_DETAIL(param));
            }

            // FIXED_FORMテーブルの更新
            // 画面上のデータのを登録用に振り分ける。
            // ※自己負担分サービス
            // 画面上のデータより、以下の値を取得し、VRList selfListに追加する。
            VRList selfList = new VRArrayList();
            // ・SELF_SERVICE_NO1
            // ・SELF_SERVICE_NO2
            // ・SELF_SERVICE_NO3
            selfList.add(param.getData("SELF_SERVICE_NO1"));
            selfList.add(param.getData("SELF_SERVICE_NO2"));
            selfList.add(param.getData("SELF_SERVICE_NO3"));

            // ※その他費目
            // 画面上のデータより、以下の値を取得し、VRList otherListに追加する。
            VRList otherList = new VRArrayList();
            // ・OTHER_HIMOKU_NO1
            // ・OTHER_HIMOKU_NO2
            // ・OTHER_HIMOKU_NO3
            // ・OTHER_HIMOKU_NO4
            // ・OTHER_HIMOKU_NO5
            otherList.add(param.getData("OTHER_HIMOKU_NO1"));
            otherList.add(param.getData("OTHER_HIMOKU_NO2"));
            otherList.add(param.getData("OTHER_HIMOKU_NO3"));
            otherList.add(param.getData("OTHER_HIMOKU_NO4"));
            otherList.add(param.getData("OTHER_HIMOKU_NO5"));

            // SQL文取得用のHashMap paramを生成する。
            VRMap params = new VRHashMap();
            // ※自己負担サービスの登録
            for (int i = 0; i < selfList.size(); i++) {
                // selfListの件数文ループする。
                if (!"".equals(selfList.getData(i))) {
                    // paramを初期化し、以下のKEY/VALUEを設定する。
                    param = new VRHashMap();
                    // ・KEY：FIXED_FORM_ID VALUE：1
                    // ・KEY：CONTENT VALUE：selfListの値
                    param.setData("FIXED_FORM_ID", new Integer(1));
                    param.setData("CONTENT", selfList.getData(i));
                    // 選択肢として既にテーブルに存在するかどうか確認するSQL文を取得する。
                    // SQL文を実行する。
                    VRList countList = getDBManager().executeQuery(
                            getSQL_GET_COUNT_SELF_PAY(param));
                    VRMap map = (VRMap) countList.getData(0);
                    // 取得した件数が0件の場合
                    if (ACCastUtilities.toInt(map.getData("CONTENT_SELF_PAY")) == 0) {
                        // paramを初期化し、以下のKEY/VALUEを設定する。
                        param = new VRHashMap();
                        // ・KEY：FIXED_FORM_ID VALUE：1
                        param.setData("FIXED_FORM_ID", new Integer(1));
                        // 登録に使用するCONTENT_KEYを取得するためのSQL文を取得する。
                        // SQL文を実行する。
                        countList = getDBManager().executeQuery(
                                getSQL_GET_NEW_CONTENT_KEY(param));

                        VRMap contentKeyMap = (VRMap) countList.getData(0);
                        // 登録に使用するCONTENT_SORTを取得するためのSQL文を取得する。
                        // SQL文を実行する。
                        countList = getDBManager().executeQuery(
                                getSQL_GET_NEW_CONTENT_SORT(param));
                        VRMap contentSortMap = (VRMap) countList.getData(0);

                        // paramを初期化し、以下のKEY/VALUEを設定する。
                        // ・KEY：TABLE_TYPE VALUE：1
                        // ・KEY：FIXED_FORM_ID VALUE：1
                        // ・KEY：CONTENT_KEY VALUE：（取得した新たなCONTENT_KEY）
                        // ・KEY：CONTENT VALUE：（selfListの値）
                        // ・KEY：CONTENT_SORT VALUE：（取得した新たなCONTENT_SORT）
                        param = new VRHashMap();
                        param.setData("TABLE_TYPE", new Integer(1));
                        param.setData("FIXED_FORM_ID", new Integer(1));
                        param.setData("CONTENT_KEY", contentKeyMap
                                .getData("NEW_CONTENT_KEY"));
                        param.setData("CONTENT", selfList.getData(i));
                        param.setData("CONTENT_SORT", contentSortMap
                                .getData("NEW_CONTENT_SORT"));

                        // 定型文登録用SQL文を取得する。
                        // SQL文を実行する。
                        getDBManager().executeUpdate(
                                getSQL_INSERT_FIXED_FORM(param));
                    }
                }
            }

            // ※その他費目の登録
            // otherListの件数文ループする。
            for (int j = 0; j < otherList.size(); j++) {
                if (!"".equals(otherList.getData(j))) {
                    // paramを初期化し、以下のKEY/VALUEを設定する。
                    // ・KEY：FIXED_FORM_ID VALUE：2
                    // ・KEY：CONTENT VALUE：otherListの値
                    param = new VRHashMap();
                    param.setData("FIXED_FORM_ID", new Integer(2));
                    param.setData("CONTENT", otherList.getData(j));
                    // 選択肢として既にテーブルに存在するかどうか確認するSQL文を取得する。
                    // SQL文を実行する。
                    VRList countList = getDBManager().executeQuery(
                            getSQL_GET_COUNT_SELF_PAY(param));
                    VRMap checkMap = (VRMap) countList.getData(0);
                    // 取得した件数が0件の場合
                    if (ACCastUtilities.toInt(checkMap
                            .getData("CONTENT_SELF_PAY")) == 0) {
                        // paramを初期化し、以下のKEY/VALUEを設定する。
                        param = new VRHashMap();
                        // ・KEY：FIXED_FORM_ID VALUE：2
                        param.setData("FIXED_FORM_ID", new Integer(2));
                        // 登録に使用するCONTENT_KEYを取得するためのSQL文を取得する。
                        // SQL文を実行する。
                        VRList contentKeyList = getDBManager().executeQuery(
                                getSQL_GET_NEW_CONTENT_KEY(param));
                        VRMap contentKeyMap = (VRMap) contentKeyList.getData(0);
                        // 登録に使用するCONTENT_SORTを取得するためのSQL文を取得する。
                        // SQL文を実行する。
                        VRList contentSortList = getDBManager().executeQuery(
                                getSQL_GET_NEW_CONTENT_SORT(param));
                        VRMap contentSortMap = (VRMap) contentSortList
                                .getData(0);

                        // paramを初期化し、以下のKEY/VALUEを設定する。
                        // ・KEY：TABLE_TYPE VALUE：1
                        // ・KEY：FIXED_FORM_ID VALUE：2
                        // ・KEY：CONTENT_KEY VALUE：（取得した新たなCONTENT_KEY）
                        // ・KEY：CONTENT VALUE：（selfListの値）
                        // ・KEY：CONTENT_SORT VALUE：（取得した新たなCONTENT_SORT）
                        param = new VRHashMap();
                        param.setData("TABLE_TYPE", new Integer(1));
                        param.setData("FIXED_FORM_ID", new Integer(2));
                        param.setData("CONTENT_KEY", contentKeyMap
                                .getData("NEW_CONTENT_KEY"));
                        param.setData("CONTENT", otherList.getData(j));
                        param.setData("CONTENT_SORT", contentSortMap
                                .getData("NEW_CONTENT_SORT"));
                        // 定型文登録用SQL文を取得する。
                        // SQL文を実行する。
                        getDBManager().executeUpdate(
                                getSQL_INSERT_FIXED_FORM(param));
                    }
                }
            }
            // コミット/ロールバック
            // 更新に成功した場合
            // コミットする。
            getDBManager().commitTransaction();

        } catch (Exception ex) {
            // 更新に失敗した場合
            ex.printStackTrace();
            // ロールバックを行う。
            getDBManager().rollbackTransaction();
            // 例外を投げる。
            throw ex;
            // （終了）

        }

        // コンボ候補再取り込み
        comboInitialize();
        // 最新のデータを取得し、パッシブチェック用に退避する。
        doFind();
        // 正常終了
        return true;

    }

    /**
     * 「画面データチェック・編集」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void doCheckInput() throws Exception {
        // 画面データチェック・編集
        // 全額自己負担1列目
        // 全額自己負担分費目１（contentJikohutanHimoku1）が空文字の場合
        // 全額自己負担分利用料１（contentJikohutanUse1）が空文字でない場合
        // 全額自己負担分利用料１（contentJikohutanUse1）に0を代入する。
        // 全額自己負担分費目１（contentJikohutanHimoku1）が空文字でない場合
        // 全額自己負担分利用料１（contentJikohutanUse1）が空文字の場合
        // 全額自己負担分費目１（contentJikohutanHimoku1）を空文字を代入する。
        checkValue(getContentJikohutanHimoku1(), getContentJikohutanUse1());

        // 全額自己負担2列目
        // 全額自己負担分費目２（contentJikohutanHimoku2）が空文字の場合
        // 全額自己負担分利用料２（contentJikohutanUse2）が空文字でない場合
        // 全額自己負担分利用料２（contentJikohutanUse2）に0を代入する。
        // 全額自己負担分費目２（contentJikohutanHimoku2）が空文字でない場合
        // 全額自己負担分利用料２（contentJikohutanUse2）が空文字の場合
        // 全額自己負担分費目２（contentJikohutanHimoku2）を空文字を代入する。
        checkValue(getContentJikohutanHimoku2(), getContentJikohutanUse2());

        // 全額自己負担3列目
        // 全額自己負担分費目３（contentJikohutanHimoku3）が空文字の場合
        // 全額自己負担分利用料３（contentJikohutanUse3）が空文字でない場合
        // 全額自己負担分利用料３（contentJikohutanUse3）に0を代入する。
        // 全額自己負担分費目３（contentJikohutanHimoku3）が空文字でない場合
        // 全額自己負担分利用料３（contentJikohutanUse3）が空文字の場合
        // 全額自己負担分費目３（contentJikohutanHimoku3）を空文字を代入する。
        checkValue(getContentJikohutanHimoku3(), getContentJikohutanUse3());

        // その他費目1列目
        // その他費目１（contentEtcHimoku1）が空文字の場合
        // その他利用料１（contentEtcUse1）が空文字でない場合
        // その他利用料１（contentEtcUse1）に0を代入する。
        // その他費目１（contentEtcHimoku1）が空文字でない場合
        // その他利用料１（contentEtcUse1）が空文字の場合
        // その他費目１（contentEtcHimoku1）を空文字を代入する。
        checkValue(getContentEtcHimoku1(), getContentEtcUse1());
        // その他費目2列目
        // その他費目２（contentEtcHimoku2）が空文字の場合
        // その他利用料２（contentEtcUse2）が空文字でない場合
        // その他利用料２（contentEtcUse2）に0を代入する。
        // その他費目２（contentEtcHimoku2）が空文字でない場合
        // その他利用料２（contentEtcUse2）が空文字の場合
        // その他費目２（contentEtcHimoku2）を空文字を代入する。
        checkValue(getContentEtcHimoku2(), getContentEtcUse2());
        // その他費目3列目
        // その他費目３（contentEtcHimoku3）が空文字の場合
        // その他利用料３（contentEtcUse3）が空文字でない場合
        // その他利用料３（contentEtcUse3）に0を代入する。
        // その他費目３（contentEtcHimoku3）が空文字でない場合
        // その他利用料３（contentEtcUse3）が空文字の場合
        // その他費目３（contentEtcHimoku3）を空文字を代入する。
        checkValue(getContentEtcHimoku3(), getContentEtcUse3());
        // その他費目4列目
        // その他費目４（contentEtcHimoku4）が空文字の場合
        // その他利用料４（contentEtcUse4）が空文字でない場合
        // その他利用料４（contentEtcUse4）に0を代入する。
        // その他費目４（contentEtcHimoku4）が空文字でない場合
        // その他利用料４（contentEtcUse4）が空文字の場合
        // その他費目４（contentEtcHimoku4）を空文字を代入する。
        checkValue(getContentEtcHimoku4(), getContentEtcUse4());
        // その他費目5列目
        // その他費目５（contentEtcHimoku5）が空文字の場合
        // その他利用料５（contentEtcUse5）が空文字でない場合
        // その他利用料５（contentEtcUse5）に0を代入する。
        // その他費目５（contentEtcHimoku5）が空文字でない場合
        // その他利用料５（contentEtcUse5）が空文字の場合
        // その他費目５（contentEtcHimoku5）を空文字を代入する。
        checkValue(getContentEtcHimoku5(), getContentEtcUse5());

        calcSum();

    }

    /**
     * コンボの値をチェックします。
     * 
     * @param himokuCombo
     * @param jikohutanText
     * @throws Exception
     */
    public void checkValue(ACComboBox himokuCombo, ACTextField jikohutanText)
            throws Exception {
        // 全額自己負担
        // 全額自己負担分費目(himokuCombo)が空文字の場合
        if ("".equals(himokuCombo.getText())) {
            // 全額自己負担分利用料（jikohutanText）が空文字でない場合
            if (!"".equals(jikohutanText.getText())) {
                // 全額自己負担分利用料１（jikohutanText）に0を代入する。
                jikohutanText.setText("");
            }
        }
        // 全額自己負担分費目（himokuCombo）が空文字でない場合
        if (!"".equals(himokuCombo.getText())) {
            // 全額自己負担分利用料（jikohutanText）が空文字の場合
            if ("".equals(jikohutanText.getText())) {
                // 全額自己負担分費目１（himokuCombo）を空文字を代入する。
                himokuCombo.setText("");
            }
        }

    }

    /**
     * コンボの初期設定を行います。
     */
    public void comboInitialize() throws Exception {

        // コンボの選択肢候補を取得するためのSQL文を取得する。
        // コンボの選択肢候補を取得する
        VRList list = getDBManager()
                .executeQuery(getSQL_GET_COMBO_DETAIL(null));
        // 取得したデータの件数分ループする。
        // VRList fixedForm1List = new VRArrayList();
        // VRList fixedForm2List = new VRArrayList();
        setComboSet1(new VRArrayList());
        setComboSet2(new VRArrayList());
        for (int i = 0; i < list.size(); i++) {
            VRMap map = (VRMap) list.getData(i);
            // レコードのFIXED_FORM_IDの値が、1の場合
            if (new Integer(1).equals(map.getData("FIXED_FORM_ID"))) {
                // レコードのCONTENTの値をcomboSet1に追加する。
                getComboSet1().add(map.getData("CONTENT"));
            } else if (new Integer(2).equals(map.getData("FIXED_FORM_ID"))) {
                // レコードのFIXED_FORM_IDの値が、2の場合
                // レコードのCONTENTの値をcomboSet2に追加する。
                getComboSet2().add(map.getData("CONTENT"));
            }
        }

        // コンボの選択肢を下記のKEYで、modelMapに設定する。
        VRMap modelMap = new VRHashMap();
        // ・comboSet1 KEY：SELF_PAY
        if (getComboSet1() != null) {
            modelMap.setData("SELF_PAY", getComboSet1());
        }

        // ・comboSet2 KEY：OTHER
        if (getComboSet2() != null) {
            modelMap.setData("OTHER", getComboSet2());
        }

        setModelMap(modelMap);
        // modelMapを「クライアント領域（contents）」に設定する。
        getContents().setModelSource(getModelMap());

        // modelMapを画面に展開する。
        getContents().bindModelSource();

    }

}
