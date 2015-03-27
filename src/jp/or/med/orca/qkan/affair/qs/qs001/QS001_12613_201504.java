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
 * 開発者: 樋口雅彦
 * 作成日: 2011/11/16  日本コンピューター株式会社 樋口雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護予防短期入所療養介護（認知症） (QS001_12613_201504)
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
 * サービスパターン介護予防短期入所療養介護（認知症）(QS001_12613_201504)
 */
@SuppressWarnings("serial")
public class QS001_12613_201504 extends QS001_12613_201504Event {
    /**
     * コンストラクタです。
     */
    public QS001_12613_201504() {
        // 必須の事業所設定項目
        putCheckProviderBindPath("介護職員処遇改善加算", "4");
        
        // 値を転記する事業所設定項目
        putImportProviderBindPath("施設等の区分", "1260301", "1260301");
        putImportProviderBindPath("人員配置区分", "1260302", "1260303");
        putImportProviderBindPath("ユニットケア体制", "1260304", "1260311");
        putImportProviderBindPath("サービス提供体制強化加算", "1260316", "1260312");
        
        // 値により入力を禁止する事業所設定項目
        putRestrictProviderBindPath("療養食", "1260315", "1260307");
        putRestrictProviderBindPath("ユニットケア体制", "1260304", "1260311");
    }

    // コンポーネントイベント

    /**
     * 「施設区分選択時イベント」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void shortStayDementiaRecuperationInstitutionDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // ※「施設区分」選択時の「病室区分」の状態切替
        // 画面の状態を変更する。
        checkState();

    }

    /**
     * 「特定診療費の設定」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void shortStayDementiaRecuperationSpecificConsultationFeeActionPerformed(
            ActionEvent e) throws Exception {

        // ※特定診療費の編集
        // 特定診療費編集画面(QS001199_H2104)を生成する。
        // 特定診療費ボタンのデータを引数に生成した特定診療費編集画面(QS001199)のshoModalを実行する。
        if (new QS001S01_201204().showModal(SYSTEM_SERVICE_KIND_DETAIL,
                getShortStayDementiaRecuperationSpecificConsultationFee()
                        .getDataModel())) {
            // 特定診療費を変更した場合
            if (getShortStayDementiaRecuperationSpecificConsultationFee()
                    .getDataModel().isEmpty()) {
                // 特定診療費ボタンのデータが空の場合
                // 特定診療費ラベルに「設定なし」と表示する。
                getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                        .setText("設定なし");
            } else {
                // 特定診療費ボタンのデータが空ではない場合
                // 特定診療費ラベルに「設定あり」と表示する。
                getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                        .setText("設定あり");
            }
        }

    }

    /**
     * 「食事提供選択」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void shortStayDementiaRecuperationDinnerOfferActionPerformed(
            ActionEvent e) throws Exception {

        // ※「食事提供」選択時に「食費」の状態切替
        if (getShortStayDementiaRecuperationDinnerOffer().getSelectedIndex() < 1) {
            // 「食事提供」が「なし」の場合
            // 食費を無効にする。
            checkDinnerState();
        } else {
            // 「食事提供」が「なし」以外の場合
            // 食費を有効にする。
            checkDinnerState();

            // 食事費用(shortStayDementiaRecuperationDinnerCost)を設定する。
            checkMeatCost();
        }
    }

    /**
     * 「病室区分」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void shortStayDementiaRecuperationHospitalDivisionRadioActionPerformed(
            ActionEvent e) throws Exception {
        // 病室区分選択イベント
        // 画面の状態を変更する。
        checkState();

    }

    /**
     * 「人員減算選択」イベントです。
     * 
     * @param e
     *            イベント情報
     * @throws Exception
     *             処理例外
     */
    protected void shortStayDementiaRecuperationPersonSubtractionActionPerformed(
            ActionEvent e) throws Exception {
        // 人員減算選択時の処理
        // 画面状態を変更する。
        checkState();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QS001_12613_201504.class.getName(),
                param));
    }

    // 内部関数

    /**
     * 「初期化」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void initialize() throws Exception {
        // ※画面展開時の初期設定
        // QS001199_H2104(特定診療費)よりサービス種類(SYSTEM_SERVICE_KIND_DETAIL)に応じたbindPath配列を取得し、特定診療費ボタンに設定する。
        getShortStayDementiaRecuperationSpecificConsultationFee()
                .clearDataModel();
        getShortStayDementiaRecuperationSpecificConsultationFee()
                .setBindPathes(
                        QS001S01_201204
                                .getTargetBindPathes(SYSTEM_SERVICE_KIND_DETAIL));
        // ※コンボアイテムの設定
        // ※準備
        // コンボアイテム設定用のレコード comboItemMap を生成する。
        VRMap comboItemMap = new VRHashMap();
        // ※設定
        // ※食事提供
        // コードマスタデータよりCODE_ID：191（食事提供）を取得する。
        // 取得した値を、comboItemMapの KEY : 1260309 の VALUE として設定する。
        comboItemMap.setData("1260309",
                QkanCommon.getArrayFromMasterCode(191, "1260309"));
        // ※人員減算
        // コードマスタデータよりCODE_ID：77（人員減算）を取得する。
        // 取得した値を、comboItemMapの KEY : 1260308 の VALUE として設定する。
        comboItemMap.setData("1260308",
                QkanCommon.getArrayFromMasterCode(77, "1260308"));
        // ※展開
        // 自身(this)にcomboItemMapに設定する。
        getThis().setModelSource(comboItemMap);
        // コンボアイテムを展開する。
        getThis().bindModelSource();
        // ※選択項目の初期設定
        // ※準備
        // 初期選択設定用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // ※設定
        // 画面のラジオの初期値を設定する。（selectFirstRadioItem）
        QkanCommon.selectFirstRadioItem(getThis());
        // 食事提供を「なし」にする。
        VRBindPathParser.set("1260309", defaultMap, new Integer(1));
        // 人員減算を「なし」にする。
        VRBindPathParser.set("1260308", defaultMap, new Integer(1));
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();
        // 画面状態を変更する。
        checkState();

    }

    /**
     * 「事業所コンボ変更時関数」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void providerSelected(VRMap provider) throws Exception {
        // ※事業所コンボ変更時に呼ぶ関数
        if (provider != null) {
            // 選択事業所情報がnullでない場合
            // ※以下の内容詳細項目は、選択事業所の値を設定する。
            // ※準備
            // 事業所連動用のレコード defaultMap を生成する。
            VRMap defaultMap = getImportData();
            // ※設定
            // 職員の欠員による減算の状況（事業所パネル）KEY：1260303の値をチェックする。
            switch (ACCastUtilities.toInt(
                    VRBindPathParser.get("1260303", provider), 0)) {
            case 1:
            case 2:
                // 値が1又は2（なし、医師）だった場合
                // defaultMapに KEY：1260308 VALUE：1（なし）を設定する。
                VRBindPathParser.set("1260308", defaultMap, new Integer(1));
                break;
            case 3:
            case 4:
                // 値が3又は4（看護職員・介護職員）だった場合
                // defaultMapに KEY：1260308 VALUE：3（看護・介護職員）を設定する。
                VRBindPathParser.set("1260308", defaultMap, new Integer(3));
                break;
            }

            // 2015/03/02 [H27.4改正対応][Shinobu Hitaka] edit - begin 体制があってもなしを選択する。
            VRBindPathParser.set("6", defaultMap, new Integer(1));
            // 送迎体制（事業所パネル）KEY：1260305の値をチェックする。
            //switch (ACCastUtilities.toInt(
            //        VRBindPathParser.get("1260305", provider), 0)) {
            //case 1:
            //    // 値が1（対応不可）だった場合
            //    // defaultMapに KEY：6 VALUE：1（送迎なし）を設定する。
            //    VRBindPathParser.set("6", defaultMap, new Integer(1));
            //    break;
            //case 2:
            //    // 値が2（対応可）だった場合
            //    // defaultMapに KEY：6 VALUE：3（送迎往復）を設定する。
            //    VRBindPathParser.set("6", defaultMap, new Integer(3));
            //    break;
            //}
            // 2015/03/02 [H27.4改正対応][Shinobu Hitaka] edit - end
            
            // 施設区分が認知症疾患型の場合は、病院区分を設定
            if (ACCastUtilities.toInt(VRBindPathParser.get("1260301", provider), 0) == 1) {
                switch (ACCastUtilities.toInt(VRBindPathParser.get("1260302", provider), 0)) {
                case 1: // I型
                    // 病院区分を「大学病院」に
                    defaultMap.setData("1260302", new Integer(1));
                    break;
                case 2: // II型
                case 3: // III型
                case 4: // IV型
                case 5: // V型
                    // 病院区分を「一般病院」に
                    defaultMap.setData("1260302", new Integer(2));
                    break;
                }
            }
            

            // ※展開
            // 自身(this)にdefaultMapに設定する。
            getThis().setSource(defaultMap);
            // 初期選択項目を展開する。
            getThis().bindSource();
            // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。
            // 画面状態を設定する。
            checkState();

            // ※初期設定
            // 食事提供コンボチェック
            if (getShortStayDementiaRecuperationDinnerOffer()
                    .getSelectedIndex() == 0) {
                // 値が1（なし）だった場合
                // 食費コンボの｢朝昼夜｣を選択する。（初期選択）
                getShortStayDementiaRecuperationDinnerOffer().setSelectedIndex(
                        1);
            }
        }

    }

    /**
     * 「入力内容の不備を検査」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public VRMap getValidData() throws Exception {
        // ※入力内容に不備がないかをチェックし、サービスデータを返す。
        // ※返却用のレコード(data)を生成
        VRMap data = new VRHashMap();
        // 自身(this)のソースとして生成レコードを設定する。
        getThis().setSource(data);
        // 自身(this)のapplySourceを呼び出してデータを収集する。
        getThis().applySource();
        // ※返却用レコードから不要なキーを除去
        // ※食事テキストチェック
        // 食事提供コンボの値をチェックする。
        if (getShortStayDementiaRecuperationDinnerOffer().getSelectedIndex() > 0) {
            // 値が1（なし）以外だった場合
            // 食事費用(shortStayLifeDinnerCost)の値をチェックする。
            if (ACTextUtilities
                    .isNullText(getShortStayDementiaRecuperationDinnerCost()
                            .getText())) {
                // 値が空白だった場合
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }
        // ※人員配置区分チェック
        // 施設区分がユニット型ではなかった場合
        if (getShortStayDementiaRecuperationInstitutionDivisionRadio()
                .getSelectedIndex() == 1) {
            // 人員配置区分の現在選択されているラジオのEnableをチェックする。
            if (!getShortStayDementiaRecuperationDivision().getSelectedButton()
                    .isEnabled()) {
                // Enableがfalse だった場合
                // 内容詳細の不備メッセージを表示する。※ID=QS001_ERROR_OF_NO_CONTENT
                QkanMessageList.getInstance().QS001_ERROR_OF_NO_CONTENT();
                // nullを返す。
                return null;
            }
        }
        QkanCommon.removeDisabledBindPath(getThis(), data);
        // 問題なければ返却用レコード(data)を返す。
        return data;
    }

    /**
     * 「事業所情報の必要性を取得」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public boolean isUseProvider() throws Exception {
        // ※事業所情報が必要なサービスであるかを返す。
        // trueを返す。
        return true;
    }

    /**
     * 「画面状態制御」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void checkState() throws Exception {
        // ※画面状態制御処理
        // ※サービス連動
        // 施設等の区分（サービスパネル）の値をチェックする。
        switch (getShortStayDementiaRecuperationInstitutionDivisionRadio()
                .getSelectedIndex()) {
        case 1:
            // 値が1（認知症疾患型）だった場合
            // 病院区分の値をチェックする。
            switch (getShortStayDementiaRecuperationHospitalDivisionRadio()
                    .getSelectedIndex()) {
            case 1:
                // 値が1（大学病院）だった場合
                // 画面の状態を｢状態１｣に変更する。
                setState_STATE_MODE_1();
                break;
            case 2:
                // 値が2（一般病院）だった場合
                // 人員減算コンボの値をチェックする。
                switch (getShortStayDementiaRecuperationPersonSubtraction()
                        .getSelectedIndex()) {
                case 0:
                case 1:
                case 4:
                    // 値が1又は2又は5（なし、定員超過、僻地届出無）だった場合
                    // 画面の状態を｢状態２｣に変更する。
                    setState_STATE_MODE_2();
                    break;
                case 2:
                case 3:
                case 5:
                    // 値が3又は4又は6（看護・介護職員の不足、正看比率が20%未満、僻地届出有）だった場合
                    // 画面の状態を｢状態３｣に変更する。
                    setState_STATE_MODE_3();
                    break;
                }
                break;
            }
            break;
        case 2:
            // 値が2（ユニット型認知症疾患型）だった場合
            // 画面の状態を｢状態４｣に変更する。
            setState_STATE_MODE_4();
            break;
        case 3:
            // 値が3（経過型）だった場合
            // 画面の状態を｢状態５｣に変更する。
            setState_STATE_MODE_5();
            break;
        }
        
        // 事業所体制と同期
        resetStateByRestrictBindPath();
    }

    /**
     * 「食費テキスト制御」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void checkDinnerState() throws Exception {
        // ※食費テキストのEnable制御処理
        // 食事提供（shortStayDementiaRecuperationDinnerCost）の値をチェックする。
        if (getShortStayDementiaRecuperationDinnerOffer().getSelectedIndex() == 0) {
            // 値が1だった場合
            // 食事テキストのEnableをfalseにする。
            setState_DINNER_COST_ENABLE_FALSE();
        } else {
            // 値が1以外だった場合
            // 食事テキストのEnableをtrueにする。
            setState_DINNER_COST_ENABLE_TRUE();
        }
    }

    /**
     * 「食事費用合計値」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void checkMeatCost() throws Exception {
        // ※食事時期をもとに選択事業所における食事費用を返す。
        if (getSelectedProvider() != null) {
            // 事業所が未選択（null） ではない場合
            String meat = "";
            switch (getShortStayDementiaRecuperationDinnerOffer()
                    .getSelectedIndex()) {
            case 1:
                // 食事時期が「朝昼夜」の場合
                // 「朝」の食費、「昼」の食費、「夜」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260307", getSelectedProvider()),
                        0));
                break;
            case 2:
                // 食事時期が「朝のみ」の場合
                // 「朝」の食費を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260308", getSelectedProvider()),
                        0));
                break;
            case 3:
                // 食事時期が「昼のみ」の場合
                // 「昼」の食費を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260309", getSelectedProvider()),
                        0));
                break;
            case 4:
                // 食事時期が「夜のみ」の場合
                // 「夜」の食費を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260310", getSelectedProvider()),
                        0));
                break;
            case 5:
                // 食事時期が「朝昼」の場合
                // 「朝」の食費と「昼」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260308", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260309",
                                getSelectedProvider()), 0));
                break;
            case 6:
                // 食事時期が「昼夜」の場合
                // 「昼」の食費と「夜」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260309", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260310",
                                getSelectedProvider()), 0));
                break;
            case 7:
                // 食事時期が「夜朝」の場合
                // 「夜」の食費と「朝」の食費の合算を返す。
                meat = ACCastUtilities.toString(ACCastUtilities.toInt(
                        VRBindPathParser.get("1260310", getSelectedProvider()),
                        0)
                        + ACCastUtilities.toInt(VRBindPathParser.get("1260308",
                                getSelectedProvider()), 0));
                break;
            }
            getShortStayDementiaRecuperationDinnerCost().setText(meat);
        } else {
            // 事業所が未選択の場合
            // 空文字を返す。
            getShortStayDementiaRecuperationDinnerCost().setText("");
        }
    }

    /**
     * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public ACComboBox getBeginTimeCombo() throws Exception {
        // ※開始時刻入力用のコンボを返す。
        // 関数の返り値として開始時間コンボを返す。
        return null;
    }

    /**
     * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public ACComboBox getEndTimeCombo() throws Exception {
        // ※終了時刻入力用のコンボを返す。
        // 関数の返り値として終了時間コンボを返す。
        return null;
    }

    /**
     * 「データバインド時の処理」に関する処理を行ないます。
     * 
     * @throws Exception
     *             処理例外
     */
    public void binded() throws Exception {
        // ※データバインド時の処理
        // 特定診療費ボタンのデータの有無をチェックする。
        if (getShortStayDementiaRecuperationSpecificConsultationFee()
                .getDataModel().isEmpty()) {
            // 特定診療費ボタンのデータが空の場合
            // 特定診療費ラベルに「設定なし」と表示する。
            getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                    .setText("設定なし");
        } else {
            // 特定診療費ボタンのデータが空ではない場合
            // 特定診療費ラベルに「設定あり」と表示する。
            getShortStayDementiaRecuperationSpecificConsultationFeeOutline()
                    .setText("設定あり");
        }

    }

}
