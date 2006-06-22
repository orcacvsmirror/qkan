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
 * 開発者: 堤 瑞樹
 * 作成日: 2006/01/18  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン短期入所療養介護（病院療養） (001)
 * プログラム サービスパターン短期入所療養介護（病院療養） (QS001014)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qs.qs001;

import java.awt.event.ActionEvent;

import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.QkanMessageList;

/**
 * サービスパターン短期入所療養介護（病院療養）(QS001014)
 */
public class QS001013 extends QS001013Event {
    /**
     * コンストラクタです。
     */
    public QS001013() {
    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時イベント」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayHospitalRecuperationInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ※「施設区分」選択時の「病室区分」の状態切替
        // 「施設区分」の値をチェックする。
        switch (getShortStayHospitalRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
        case 2:
            // 「単独型」もしくは「併設型」の場合
            // 「病室区分(通常)」を有効にし、「病室区分(ユニット型)」を無効にする。
            setState_CONVENTIONAL_FORM();
            break;
        case 3:
        case 4:
            // 「単独型ユニット型」もしくは「併設型ユニット型」の場合
            // 「病室区分(通常)」を無効にし、「病室区分(ユニット型)」を有効にする。
            setState_UNIT_FORM();
            break;
        }
    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001013.class.getName(), param));
    }

    // 内部関数

    /**
     * 「初期化」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void initialize() throws Exception {
        // ※画面展開時の初期設定
        //QS001028(特定診療費)よりサービス種類(SYSTEM_SERVICE_KIND_DETAIL)に応じたbindPath配列を取得し、特定診療費ボタンに設定する。
        getShortStayHospitalRecuperationSpecificConsultationFee()
                .setBindPathes(QS001028.getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※食事提供
        // コードマスタデータよりCODE_ID：191（食事提供）を取得する。
        // 取得した値を、comboItemMapの KEY : 1230150 の VALUE として設定する。
        comboItemMap.setData("1230150", QkanCommon.getArrayFromMasterCode(191,
                "1230150"));
        // ※人員減算
        // コードマスタデータよりCODE_ID：66（人員減算）を取得する。
        // 取得した値を、comboItemMapの KEY : 1230149 の VALUE として設定する。
        comboItemMap.setData("1230149", QkanCommon.getArrayFromMasterCode(66,
                "1230149"));
        // ※コンボアイテムの設定
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
        // 病室区分（病室）(shortStayHospitalRecuperationHospitalRoomRadio)の「従来型個室」を選択する。
        getShortStayHospitalRecuperationHospitalRoomRadio().setSelectedIndex(1);
        // 病室区分（ユニット型病院）(shortStayHospitalRecuperationUnitHospitalRoomRadio)の「ユニット型個室」を選択する。
        getShortStayHospitalRecuperationUnitHospitalRoomRadio()
                .setSelectedIndex(1);
        // 栄養管理体制加算(shortStayHospitalRecuperationDieticianManageRadio)の「なし」を選択する。
        getShortStayHospitalRecuperationDieticianManageRadio()
                .setSelectedIndex(1);
        // 療養食加算(shortStayHospitalRecuperationMedicalExpensesRadio)の「なし」を選択する。
        getShortStayHospitalRecuperationMedicalExpensesRadio()
                .setSelectedIndex(1);

        // 人員減算コンボ(shortStayHospitalRecuperationPersonSubtraction)の「なし」を選択する。
        getShortStayHospitalRecuperationPersonSubtraction().setSelectedIndex(0);
        // 食事提供(shortStayRecuperationHealthFacilityDinnerOffer)の「なし」を選択する。
        getShortStayRecuperationHealthFacilityDinnerOffer().setSelectedIndex(0);


    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
        // 選択している事業所情報(selectedProvider)を退避する。
        setSelectedProvider(provider);
        if (provider != null) {
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            Object obj;
            // 施設区分
            obj = VRBindPathParser.get("1230101", provider);
            if (obj != null) {
                getShortStayHospitalRecuperationInstitutionDivisionRadio()
                        .setSelectedIndex(ACCastUtilities.toInt(obj));
            }
            // 人員配置区分
            obj = VRBindPathParser.get("1230102", provider);
            if (obj != null) {
                getShortStayHospitalRecuperationDivision().setSelectedIndex(
                        ACCastUtilities.toInt(obj));
            }
            // 人員減算
            obj = VRBindPathParser.get("1230109", provider);
            if (obj != null) {
                VRMap map = new VRHashMap();
                VRBindPathParser.set(
                        getShortStayHospitalRecuperationPersonSubtraction()
                                .getBindPath(), map, obj);
                getShortStayHospitalRecuperationPersonSubtraction().setSource(
                        map);
                getShortStayHospitalRecuperationPersonSubtraction()
                        .bindSource();
            }
            // 夜間勤務基準条件
            obj = VRBindPathParser.get("1230103", provider);
            if (obj != null) {
                getShortStayHospitalRecuperationAdditionType()
                        .setSelectedIndex(ACCastUtilities.toInt(obj));
            }
            // 療養環境基準
            obj = VRBindPathParser.get("1230104", provider);
            if (obj != null) {
                getShortStayHospitalRecuperationSubtractionType()
                        .setSelectedIndex(ACCastUtilities.toInt(obj));
            }
            // 医師の配置基準
            obj = VRBindPathParser.get("1230105", provider);
            if (obj != null) {
                getShortStayHospitalRecuperationApplicationType()
                        .setSelectedIndex(ACCastUtilities.toInt(obj));
            }
            // 送迎
            obj = VRBindPathParser.get("1230106", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 送迎区分(shortStayHospitalRecuperationMeetingAndSendingOff)の3番目のボタンを選択にする。
                    getShortStayHospitalRecuperationMeetingAndSendingOff()
                            .setSelectedIndex(3);
                    break;
                case 1:
                    // 「なし」の場合
                    // 送迎区分(shortStayHospitalRecuperationMeetingAndSendingOff)の1番目のボタンを選択にする。
                    getShortStayHospitalRecuperationMeetingAndSendingOff()
                            .setSelectedIndex(1);
                    break;
                }
            }
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 栄養管理体制
            obj = VRBindPathParser.get("1230107", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_DIETICIAN_MANAGE();
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_DIETICIAN_MANAGE();
                    break;
                }
            }
            // 療養食
            obj = VRBindPathParser.get("1230108", provider);
            if (obj != null) {
                switch (ACCastUtilities.toInt(obj)) {
                case 2:
                    // 「あり」の場合
                    // 有効にする。
                    setState_VALID_MEDICAL_EXPENSES();
                    break;
                case 1:
                    // 「なし」の場合
                    // 無効にする。
                    setState_INVALID_MEDICAL_EXPENSES();
                    break;
                }
            }
        }
    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。

        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() > 0) {
            // 食事提供（shortStayRecuperationHealthFacilityDinnerOffer)が「なし」以外を選択している場合
            if (ACTextUtilities
                    .isNullText(getShortStayRecuperationHealthFacilityDinnerCost()
                            .getText())) {
                // 食事費用(shortStayLifeDinnerCost)が空欄の場合
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }

        // ※返却用のレコード(data)を生成
        VRMap data = new VRHashMap();
        // 自身(this)のソースとして生成レコードを設定する。
        getThis().setSource(data);
        // 自身(this)のapplySourceを呼び出してデータを収集する。
        getThis().applySource();

        // ※返却用レコードから不要なキーを除去
        if (!getShortStayHospitalRecuperationMeetingAndSendingOff().isEnabled()) {
            // 送迎区分(shortStayHospitalRecuperationMeetingAndSendingOff)が無効の場合
            // 返却用レコードから、送迎区分(shortStayHospitalRecuperationMeetingAndSendingOff)のbindPathを除去する。
            data.remove(getShortStayHospitalRecuperationMeetingAndSendingOff()
                    .getBindPath());
        }
        if (!getShortStayHospitalRecuperationDieticianManageRadio().isEnabled()) {
            // 栄養管理体制加算(shortStayHospitalRecuperationDieticianManageRadio)が無効の場合
            // 返却用レコードから、栄養管理体制加算(shortStayHospitalRecuperationDieticianManageRadio)のbindPathを除去する。
            data.remove(getShortStayHospitalRecuperationDieticianManageRadio()
                    .getBindPath());
        }
        if (!getShortStayHospitalRecuperationMedicalExpensesRadio().isEnabled()) {
            // 療養食加算(shortStayHospitalRecuperationMedicalExpensesRadio)が無効の場合
            // 療養食加算(shortStayHospitalRecuperationMedicalExpensesRadio)のbindPathを除去する。
            data.remove(getShortStayHospitalRecuperationMedicalExpensesRadio()
                    .getBindPath());
        }
        if (!getShortStayRecuperationHealthFacilityDinnerCost().isEnabled()){
            // 食事費用(shortStayRecuperationHealthFacilityDinnerCost)が無効の場合
            // 返却用レコードから、食事費用(shortStayRecuperationHealthFacilityDinnerCost)のbindPathを除去する。
            data.remove(getShortStayRecuperationHealthFacilityDinnerCost()
                    .getBindPath());
        }
        // 問題なければ返却用レコード(data)を返す。
        return data;
    }

    /**
     * 「事業所情報の必要性を取得」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public boolean isUseProvider() throws Exception {
        // ※事業所情報が必要なサービスであるかを返す。
        // trueを返す。
        return true;
    }

    /**
     * 「食事提供選択」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayRecuperationHealthFacilityDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {
        // ※「食事提供」選択時に「食費」の状態切替
        if (getShortStayRecuperationHealthFacilityDinnerOffer()
                .getSelectedIndex() < 1) {
            // 「食事提供」が「なし」の場合
            // 食費を無効にする。
            setState_NOT_USE_MEAT();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            setState_USE_MEAT();
            // 食事費用(shortStayRecuperationHealthFacilityDinnerCost)を設定する。
            getShortStayRecuperationHealthFacilityDinnerCost()
                    .setText(
                            getMeatCost(getShortStayRecuperationHealthFacilityDinnerOffer()
                                    .getSelectedIndex()));
        }

    }

    /**
     * 「食事費用を取得」に関する処理を行ないます。
     * 
     * @param meatType int
     * @throws Exception 処理例外
     * @return String
     */
    public String getMeatCost(int meatType) throws Exception {
        // ※食事時期をもとに選択事業所における食事費用を返す。
        if (getSelectedProvider() != null) {
            // 事業所を選択している場合
            switch (meatType) {
            case 1:
                // 食事時期が「朝昼夜」の場合
                // 「朝」の食費、「昼」の食費、「夜」の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230110", getSelectedProvider()),0));
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230111", getSelectedProvider()),0));
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230112", getSelectedProvider()),0));
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230113", getSelectedProvider()),0));
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費、「昼」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230111", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230112",
                                getSelectedProvider()),0));
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費、「夜」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230112", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230113",
                                getSelectedProvider()),0));
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費、「朝」の食費の食費の合算を返す。
                return String.valueOf(ACCastUtilities.toInt(VRBindPathParser
                        .get("1230113", getSelectedProvider()))
                        + ACCastUtilities.toInt(VRBindPathParser.get("1230111",
                                getSelectedProvider()),0));
            }
        }
        // 空文字を返す。
        return "";
    }

    /**
     * 開始時刻入力用のコンボを返します。
     * 
     * @return 開始時刻入力用のコンボ
     */
    public ACComboBox getBeginTimeCombo() {
        // ※開始時刻入力用のコンボを返す。
        // 関数の返り値としてnullを返す。
        return null;
    }

    /**
     * 終了時刻入力用のコンボを返します。
     * 
     * @return 終了時刻入力用のコンボ
     */
    public ACComboBox getEndTimeCombo() {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値としてnullを返す。
        return null;
    }

    /**
     * 「特定診療費編集」イベントです。
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void shortStayHospitalRecuperationSpecificConsultationFeeActionPerformed(ActionEvent e) throws Exception {
        // ※特定診療費の編集
        // 特定診療費編集画面(QS001028)を生成する。
        // 特定診療費ボタンのデータを引数に生成した特定診療費編集画面(QS001028)のshoModalを実行する。
        if (new QS001028().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayHospitalRecuperationSpecificConsultationFee()
                        .getDataModel())) {
            // 特定診療費を変更した場合
            if (getShortStayHospitalRecuperationSpecificConsultationFee()
                    .getDataModel().isEmpty()) {
                // 特定診療費ボタンのデータが空の場合
                // 特定診療費ラベルに「設定なし」と表示する。
                getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                        .setText("設定なし");
            } else {
                // 特定診療費ボタンのデータが空ではない場合
                // 特定診療費ラベルに「設定あり」と表示する。
                getShortStayHospitalRecuperationSpecificConsultationFeeOutline()
                        .setText("設定あり");
            }
        }
        
    }

}
