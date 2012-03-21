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
 * 開発者: 樋口　雅彦
 * 作成日: 2009/07/09  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 保険者管理 (O)
 * プロセス 保険者登録 (002)
 * プログラム 保険者一覧 (QO002001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo002;

import java.awt.event.ActionEvent;

import javax.swing.event.DocumentEvent;
import javax.swing.event.ListSelectionEvent;

import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.sql.ACDBManager;
import jp.nichicom.ac.util.adapter.ACTableModelAdapter;
import jp.nichicom.vr.util.VRArrayList;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.QkanCommon;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;

/**
 * 保険者一覧(QO002001)
 */
public class QO002001 extends QO002001Event {
    /**
     * コンストラクタです。
     */
    public QO002001() {
    }

    // コンポーネントイベント

    /**
     * 「閉じる」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void closeActionPerformed(ActionEvent e) throws Exception {
        // ■画面を閉じる
        // selectInsurerDataにNullを設定する。
        setSelectInsurerData(null);
        // 画面を破棄します。
        dispose();

    }

    /**
     * 「テキスト変更に伴う検索」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void insurerTextTextChanged(DocumentEvent e) throws Exception {
        if(!getInsurerText().hasFocus()){return;}
        
        // ■リアルタイム検索処理
        String findInsurer = getInsurerText().getText();
        if ("".equals(findInsurer)) {
            VRList empty = new VRArrayList();
            // 　テーブルに結果を反映する。
            getInsurerTableModel().setAdaptee(empty);
            return;
        }
        // 検索処理を行う。
        findData();
        
    }

    /**
     * 「反映」イベントです。
     * 
     * @param e イベント情報
     * @throws Exception 処理例外
     */
    protected void applyActionPerformed(ActionEvent e) throws Exception {
        // 選択されたデータを反映する。
        // 現在選択中のレコードをselectInsurerDataに格納する。
        VRMap selectMap = new VRHashMap();
        if(getDetailsTable().isSelected()) {
            selectMap = (VRMap)getDetailsTable().getSelectedModelRowValue();
            // 保険者番号の桁数チェック
            String insurerNo = ACCastUtilities.toString(selectMap
                    .getData("INSURER_NO"),"");
            // 本当に６桁の値である場合のみ採用する。
            if(insurerNo.length() == 6) {
                setSelectInsurerData(selectMap);
            }
        }
        // 画面を破棄する。
        dispose();

    }

    public static void main(String[] args) {
        // デフォルトデバッグ起動
        ACFrame.getInstance().setFrameEventProcesser(
                new QkanFrameEventProcesser());
        QkanCommon.debugInitialize();
        VRMap param = new VRHashMap();
        // paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
        ACFrame.debugStart(new ACAffairInfo(QO002001.class.getName(), param));
    }

    // 内部関数

    /**
     * 「初期設定」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public VRMap showModal(ACDBManager dbm) throws Exception {
        // ■画面展開時の初期設定
        // ウィンドウタイトルの設定
        // 業務情報マスタより、データを取得する。
        setAffairTitle("QO002001");
        setInsurerDBManager(dbm);
        // テーブルモデルを作成し、保険者テーブル(detailsTable)に設定する。
        // テーブルモデルを定義する。
        ACTableModelAdapter model = new ACTableModelAdapter();
        model.setColumns(new String[] { "INSURER_NO", "INSURER_NO",
                "INSURER_NAME"

        });
        setInsurerTableModel(model);
        getDetailsTable().setModel(getInsurerTableModel());
        // データを設定する。
        getInsurerTableModel().setAdaptee(getMasterInsurerList());
        // １行目を選択
        getDetailsTable().setSelectedSortedFirstRow();
        // 初期は非選択
        setState_INVALID_APPLY();
        // pack();
        setVisible(true);

        // selectInsurerDataを返却する。
        return getSelectInsurerData();
    }

    /**
     * 「データ検索」に関する処理を行ないます。
     * 
     * @throws Exception 処理例外
     */
    public void findData() throws Exception {
        // ■データ検索処理
        // insurerTextより入力文字列を取り出す。
        String findInsurer = getInsurerText().getText();
        // レコードsqlParamにKEY：FIND_INSURER_NAME VALUE：上記で取り出した値を設定する。
        VRMap sqlParam = new VRHashMap();
        sqlParam.setData("FIND_INSURER_NAME", findInsurer);
        // 　保険者マスタ全検索用のSQL文を取得する。
        // 　SQL文を発行する。
        VRList result = getInsurerDBManager().executeQuery(
                getSQL_GET_FIND_M_INSURER_INFO(sqlParam));
        // 　テーブルに結果を反映する。
        getInsurerTableModel().setAdaptee(result);
        // １行目を選択
        getDetailsTable().setSelectedSortedFirstRow();
        
    }

    /**
     * テーブル選択に関する処理を行います。
     */
    protected void detailsTableSelectionChanged(ListSelectionEvent e) throws Exception {
        // テーブルが選択されているかチェックする。
        if(getDetailsTable().isSelected()) {
            // 選択されている場合
            setState_VALID_APPLY();
        } else {
            // 選択されていない場合
            setState_INVALID_APPLY();
        }
    }

}
