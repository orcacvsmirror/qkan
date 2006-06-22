
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
 * 作成日: 2006/02/23  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン小規模多機能型介護 (QS001125)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
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
 * サービスパターン小規模多機能型介護(QS001125) 
 */
public class QS001125 extends QS001125Event {
  /**
   * コンストラクタです。
   */
  public QS001125(){
  }

  //コンポーネントイベント

  /**
   * 「介護支援専門員番号の表示」イベントです。
   * 
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void kaigoSupportSpecialMemberNameActionPerformed(ActionEvent e)
          throws Exception {
      if (getKaigoSupportSpecialMemberName().isSelected()) {
          // コンボで選択されているデータを取得
          VRMap data = (VRMap) getKaigoSupportSpecialMemberName()
                  .getSelectedModelItem();

          // 取得データより介護支援専門員番号を取得し、表示
          getKaigoSupportSpecialMemberNumber().setText(
                  ACCastUtilities.toString(VRBindPathParser.get(
                          "CARE_MANAGER_NO", data)));
      }
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QS001125.class.getName(), param));
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
    // ※画面展開時の初期設定
    // ※コンボアイテムの設定
    // 　※準備
    // 　　コンボアイテム設定用のレコード comboItemMap を生成する。
    VRMap comboItemMap = new VRHashMap();
    // 　※設定
    // 　※展開
    // 　　自身(this)にcomboItemMapに設定する。
    getThis().setModelSource(comboItemMap);
    // 　　コンボアイテムを展開する。
    getThis().bindModelSource();
    // ※選択項目の初期設定
    QkanCommon.selectFirstRadioItem(getThis());
    // 　※準備
    // 　　初期選択設定用のレコード defaultMap を生成する。
    VRMap defaultMap = new VRHashMap();
    // 　※設定
    // 　※展開
    // 　　自身(this)にdefaultMapに設定する。
    getThis().setSource(defaultMap);
    // 　　初期選択項目を展開する。
    getThis().bindSource();

  }

  public void binded()throws Exception{
      super.binded();
      ComboBoxModel mdl = getKaigoSupportSpecialMemberName().getModel();
      VRBindSource src=null;
      if(mdl instanceof VRComboBoxModelAdapter){
          src = ((VRComboBoxModelAdapter)mdl).getAdaptee();
      }
      if (src instanceof VRList) {
          int idx = ACBindUtilities.getMatchIndexFromValue(
                  (VRList)src, "CARE_MANAGER_NO",
                  getKaigoSupportSpecialMemberNumber().getText());
          if(idx>=0){
              getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
          }
      }
  }

  /**
   * 「事業所コンボ変更時関数」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void providerSelected(VRMap provider) throws Exception{
    // ※事業所コンボ変更時に呼ぶ関数
	  if(provider != null){
        // 選択事業所情報がnullでない場合
        // ※以下の内容詳細項目は、選択事業所の値を設定する。
        // ※準備
        // 事業所連動用のレコード defaultMap を生成する。
        VRMap defaultMap = new VRHashMap();
        // ※設定
        // 人員減算
        Object obj;
        obj = VRBindPathParser.get("1730101", provider);
        if(obj != null){
               //事業所登録の減算項目に合わせ初期値を調整
            switch(ACCastUtilities.toInt(obj)){
            case 1: //なしだった場合
                VRBindPathParser.set("1730102", defaultMap, new Integer(1));
                break;
            case 2: //医師だった場合
            case 3: //看護職員だった場合
                VRBindPathParser.set("1730102", defaultMap, new Integer(3));
                break;
            }
        }

        // 介護支援専門員コンボ
        VRMap sqlParam = new VRHashMap();
        VRBindPathParser.set("PROVIDER_ID", sqlParam, VRBindPathParser.get(
                "PROVIDER_ID", provider));

        VRList staffs =getDBManager().executeQuery(
                getSQL_GET_CARE_MANAGER(sqlParam)); 
        Iterator it=staffs.iterator();
        while(it.hasNext()){
            Map staff=(Map)it.next();
            staff.put("STAFF_NAME", QkanCommon.toFullName(staff
                    .get("STAFF_FAMILY_NAME"), staff
                    .get("STAFF_FIRST_NAME")));
        }
        
        getKaigoSupportSpecialMemberName().setModel(
                staffs);
        
        // ※展開
        // 自身(this)にdefaultMapに設定する。
        getThis().setSource(defaultMap);
        // 初期選択項目を展開する。
        getThis().bindSource();
        // ※以下の内容詳細項目は、選択事業所の「なし」「あり」によって、無効/有効を切り替える。

        if (staffs instanceof VRList) {
            int idx = ACBindUtilities.getMatchIndexFromValue(
                    staffs, "CARE_MANAGER_NO",
                    getKaigoSupportSpecialMemberNumber().getText());
            if(idx>=0){
                getKaigoSupportSpecialMemberName().setSelectedIndex(idx);
            }
        }
	  }
  }

  /**
   * 「入力内容の不備を検査」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public VRMap getValidData() throws Exception{
    // ※入力内容に不備がないかをチェックし、サービスデータを返す。
    // ※返却用のレコード(data)を生成
    VRMap data = new VRHashMap();
    // 　自身(this)のソースとして生成レコードを設定する。
    getThis().setSource(data);
    // 　自身(this)のapplySourceを呼び出してデータを収集する。
    getThis().applySource();
    // ※返却用レコードから不要なキーを除去
    QkanCommon.removeDisabledBindPath(getThis(), data);
    // 　問題なければ返却用レコード(data)を返す。
return data;
  }

  /**
   * 「事業所情報の必要性を取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public boolean isUseProvider() throws Exception{
    // ※事業所情報が必要なサービスであるかを返す。
    // 　trueを返す。
return true;
  }

  /**
   * 「開始時刻入力用のコンボ取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public ACComboBox getBeginTimeCombo() throws Exception{
    // ※開始時刻入力用のコンボを返す。
    // 　関数の返り値として開始時間コンボを返す。
return null;
  }

  /**
   * 「終了時刻入力用のコンボ取得」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public ACComboBox getEndTimeCombo() throws Exception{
    // ※終了時刻入力用のコンボを返す。
    // 　関数の返り値として終了時間コンボを返す。
return null;
  }

}
