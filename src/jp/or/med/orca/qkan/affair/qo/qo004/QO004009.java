
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
 * 作成日: 2006/02/10  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業所登録 (004)
 * プログラム 介護老人保健施設 (QO004009)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qo.qo004;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.*;
import java.io.*;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
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

/**
 * 介護老人保健施設(QO004009) 
 */
public class QO004009 extends QO004009Event {
  /**
   * コンストラクタです。
   */
  public QO004009(){
  }

  //コンポーネントイベント

  /**
   * 「短期入所療養介護（介護老人保健施設）食費基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayCareOldPersonMorningDinnerStandardMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（介護老人保健施設）食費基準額合計表示処理
    // 　短期入所療養介護（介護老人保健施設）食費基準額を合計し結果を合計テキストフィールドに代入する
	  dinnerStandeirdMoneyTotal();

  }

  /**
   * 「短期入所療養介護（介護老人保健施設）食費基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayCareOldPersonNoonDinnerStandardMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（介護老人保健施設）食費基準額合計表示処理
    // 　短期入所療養介護（介護老人保健施設）食費基準額を合計し結果を合計テキストフィールドに代入する
	  dinnerStandeirdMoneyTotal();

  }

  /**
   * 「短期入所療養介護（介護老人保健施設）食費基準額合計表示処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected void shortStayCareOldPersonNightDinnerStandardMoneyFocusLost(FocusEvent e) throws Exception{
    // 短期入所療養介護（介護老人保健施設）食費基準額合計表示処理
    // 　短期入所療養介護（介護老人保健施設）食費基準額を合計し結果を合計テキストフィールドに代入する
	  dinnerStandeirdMoneyTotal();

  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
    QkanCommon.debugInitialize();
    VRMap param = new VRHashMap();
    //paramに渡りパラメタを詰めて実行することで、簡易デバッグが可能です。
    ACFrame.debugStart(new ACAffairInfo(QO004009.class.getName(), param));
  }

  //内部関数

  /**
   * 「短期入所療養介護（介護老人保健施設）食費基準額合計処理」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void dinnerStandeirdMoneyTotal() throws Exception{
    // 短期入所療養介護（介護老人保健施設）食費基準額合計処理
    // 下記のテキストフィールドの入力されている値を合計する。
	// shortStayCareOldPersonDinnerStandarTotal（食費基準額・合計テキストフィールド）に値を代入する。
	// ・shortStayCareOldPersonMorningDinnerStandardMoney(食費基準額・朝・テキスト)
	// ・shortStayCareOldPersonNoonDinnerStandardMoney(食費基準額・昼・テキスト)
	// ・shortStayCareOldPersonNightDinnerStandardMoney(食費基準額・夜・テキスト)
    int valMorning = 0;
    int valNoon = 0;
    int valNight = 0;
	
    if(!ACTextUtilities.isNullText(getShortStayCareOldPersonMorningDinnerStandardMoney().getText())){
    	valMorning = ACCastUtilities.toInt(getShortStayCareOldPersonMorningDinnerStandardMoney().getText());
    }
    if(!ACTextUtilities.isNullText(getShortStayCareOldPersonNoonDinnerStandardMoney().getText())){
    	valNoon = ACCastUtilities.toInt(getShortStayCareOldPersonNoonDinnerStandardMoney().getText());
    }
    if(!ACTextUtilities.isNullText(getShortStayCareOldPersonNightDinnerStandardMoney().getText())){
    	valNight = ACCastUtilities.toInt(getShortStayCareOldPersonNightDinnerStandardMoney().getText());
    }
    
    int valTotal = valMorning + valNoon + valNight;
    
    if(valTotal == 0){
    	getShortStayCareOldPersonDinnerStandarTotal().setText("");
    }else{
    	getShortStayCareOldPersonDinnerStandarTotal().setText(ACCastUtilities.toString(valTotal));
    }
  }

  /**
   * 「初期化」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public void initialize() throws Exception{
    // ※初期化------------------------------------------------------
    // ※初期値設定------------------------------------------------------
	// ソースを生成し、パネル全体に設定する。
	// 画面に展開し、初期値を表示する。
	getShortStayCareOldPersonDiscountText().setText("0");
	  
  }

  /**
   * 「入力チェック」に関する処理を行ないます。
   * @throws Exception 処理例外
   */
  public boolean isValidInput() throws Exception{
    // ※入力チェック------------------------------------------------------
    // エラーメッセージ文言格納用に errMsg　を作成する。
    String errMsg = null;
    
    // 下記のテキストフィールドに対して入力チェックを行う。未入力だった場合は errMsg にメッセージを格納する。
    // ・shortStayCareOldPersonDiscountText（割引率テキスト）　※errMsg = 割引率
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonDiscountText().getText())){
    	errMsg = "割引率";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonDiscountText().requestFocus();
    	return false;
    }

    // 割引率の値をチェックする。
    int reductRate = ACCastUtilities.toInt(getShortStayCareOldPersonDiscountText().getText());
    if(reductRate > 100){
    	// 100を超える値が入力されていた場合
    	QkanMessageList.getInstance().QO004_ERROR_OF_REDUCT_RATE();
	    // エラーが発生したインスタンスにフォーカスを当てる。
    	getShortStayCareOldPersonDiscountText().requestFocus();
	    return false;    	
    }   
    
    // 下記のラジオグループに対して選択チェックを行う。未選択だった場合は errMsg にメッセージを格納する。
    // ・shortStayCareOldPersonInstitutionDivisionRadio（施設区分ラジオグループ）　※errMsg = 施設区分
    if(!getShortStayCareOldPersonInstitutionDivisionRadio().isSelected()){
    	errMsg = "施設区分";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonInstitutionDivisionRadio().requestFocus();
        return false;
    }
    
    // ・shortStayCareOldPersonNightWorkDivisionRadio（夜間勤務条件基準ラジオグループ）　※errMsg = 夜間勤務条件基準
    if(!getShortStayCareOldPersonNightWorkDivisionRadio().isSelected()){
    	errMsg = "夜間勤務条件基準";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonNightWorkDivisionRadio().requestFocus();
        return false;
    }
    
    // ・shortStayCareOldPersonRehabilitationRadio（リハビリテーション機能強化ラジオグループ）　※errMsg = リハビリ機能強化体制
    if(!getShortStayCareOldPersonRehabilitationRadio().isSelected()){
    	errMsg = "リハビリ機能強化体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonRehabilitationRadio().requestFocus();
        return false;
    }
    
    // ・shortStayCareOldPersonCognitiveRadio（認知症専門棟ラジオグループ）　※errMsg = 認知症専門棟
    if(!getShortStayCareOldPersonCognitiveRadio().isSelected()){
    	errMsg = "認知症専門棟";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonCognitiveRadio().requestFocus();
        return false;
    }
    
    // ・shortStayCareOldPersonMeetingAndSendingRadio（送迎体制ラジオグループ）　※errMsg = 送迎体制
    if(!getShortStayCareOldPersonMeetingAndSendingRadio().isSelected()){
    	errMsg = "送迎体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonMeetingAndSendingRadio().requestFocus();
        return false;
    }
    
    // ・shortStayCareOldPersonRecuperationNutritionManageRadio（栄養管理体制ラジオグループ）　※errMsg = 栄養管理体制
    if(!getShortStayCareOldPersonRecuperationNutritionManageRadio().isSelected()){
    	errMsg = "栄養管理体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonRecuperationNutritionManageRadio().requestFocus();
        return false;
    }
    
    // ・shortStayCareOldPersonRecuperationRadio（療養食体制ラジオグループ）　※errMsg = 療養食体制
    if(!getShortStayCareOldPersonRecuperationRadio().isSelected()){
    	errMsg = "療養食体制";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonRecuperationRadio().requestFocus();
        return false;
    }
    
    // ・shortStayCareOldPersonStaffReduceRadio（人員減算）　※errMsg = 人員減算
    if(!getShortStayCareOldPersonStaffReduceRadio().isSelected()){
    	errMsg = "人員減算";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_SELECT(errMsg);
        getShortStayCareOldPersonStaffReduceRadio().requestFocus();
        return false;
    }

    // ・shortStayCareOldPersonMorningDinnerStandardMoney（食費基準額・朝テキスト）　※errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonMorningDinnerStandardMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonMorningDinnerStandardMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayCareOldPersonNoonDinnerStandardMoney（食費基準額・昼テキスト）　※errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonNoonDinnerStandardMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonNoonDinnerStandardMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayCareOldPersonNightDinnerStandardMoney（食費基準額・夜テキスト）　※errMsg = 食費基準額
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonNightDinnerStandardMoney().getText())){
    	errMsg = "食費基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonNightDinnerStandardMoney().requestFocus();
    	return false;
    }
    
    // ・shortStayCareOldPersonUnitRoomText　※ errMsg = ユニット型個室基準額
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonUnitRoomText().getText())){
    	errMsg = "ユニット型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonUnitRoomText().requestFocus();
    	return false;
    }
    
    // ・shortStayCareOldPersonUnitSemiRoomText　※ errMsg = ユニット型準個室基準額
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonUnitSemiRoomText().getText())){
    	errMsg = "ユニット型準個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonUnitSemiRoomText().requestFocus();
    	return false;
    }
    
    // ・shortStayCareOldPersonNormalRoomText　※ errMsg = 従来型個室基準額
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonNormalRoomText().getText())){
    	errMsg = "従来型個室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonNormalRoomText().requestFocus();
    	return false;
    }
    
    // ・shortStayCareOldPersonTasyouRoomText　※ errMsg = 多床室基準額
    if(ACTextUtilities.isNullText(getShortStayCareOldPersonTasyouRoomText().getText())){
    	errMsg = "多床室基準額";
        QkanMessageList.getInstance().ERROR_OF_NEED_CHECK_FOR_INPUT(errMsg);
        getShortStayCareOldPersonTasyouRoomText().requestFocus();
    	return false;
    }
    
    return true;
    
  }

  /**
	 * 「パネル状態制御」に関する処理を行ないます。
	 * 
	 * @throws Exception 処理例外
	 */
  public void stateManager(boolean state) throws Exception {
	
  }

  /**
   * 「パネルデータ取得」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return VRMap
   */
  public void getDetails(VRMap map) throws Exception{
	  
  }

}
