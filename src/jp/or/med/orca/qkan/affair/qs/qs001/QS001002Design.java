
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
 * 作成日: 2012/07/03  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 週間表 (QS001002)
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
import jp.nichicom.ac.component.table.event.*;
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
import jp.or.med.orca.qkan.text.*;
/**
 * 週間表画面項目デザイン(QS001002) 
 */
public class QS001002Design extends ACPanel {
  //GUIコンポーネント

  private ACPanel contents;

  private ACPanel uppers;

  private ACGroupBox sumups;

  private ACTextField limit;

  private ACLabelContainer limitContainer;

  private ACTextField limitAmount;

  private ACLabelContainer limitAmountContainer;

  private ACTextField over;

  private ACLabelContainer overContainer;

  private ACButton calcurate;

  private ACTextField afterAdjustment;

  private ACLabelContainer afterAdjustmentContainer;

  private ACTextField adjustment;

  private ACLabelContainer adjustmentContainer;

  private ACPanel buttons;

  private ACButton coordinatePrivateExpenses;

  private ACButton detailsbutton;

  private ACButton tokubetuButton;

  private ACPanel addInfomations;

  private ACButton planUnit;

  private ACPanel monthlyCharts;

  private QS001MonthSchedule monthlySchedule;

  //getter

  /**
   * クライアント領域を取得します。
   * @return クライアント領域
   */
  public ACPanel getContents(){
    if(contents==null){

      contents = new ACPanel();

      addContents();
    }
    return contents;

  }

  /**
   * 上部領域を取得します。
   * @return 上部領域
   */
  public ACPanel getUppers(){
    if(uppers==null){

      uppers = new ACPanel();

      addUppers();
    }
    return uppers;

  }

  /**
   * 集計情報領域を取得します。
   * @return 集計情報領域
   */
  public ACGroupBox getSumups(){
    if(sumups==null){

      sumups = new ACGroupBox();

      sumups.setText("集計情報");

      sumups.setAutoWrap(false);

      sumups.setHgap(0);

      sumups.setHgrid(100);

      sumups.setAlignment(SwingConstants.RIGHT);

      addSumups();
    }
    return sumups;

  }

  /**
   * 限度額を取得します。
   * @return 限度額
   */
  public ACTextField getLimit(){
    if(limit==null){

      limit = new ACTextField();

      getLimitContainer().setText("限度額");

      limit.setEditable(false);

      limit.setColumns(5);

      limit.setHorizontalAlignment(SwingConstants.RIGHT);

      addLimit();
    }
    return limit;

  }

  /**
   * 限度額コンテナを取得します。
   * @return 限度額コンテナ
   */
  protected ACLabelContainer getLimitContainer(){
    if(limitContainer==null){
      limitContainer = new ACLabelContainer();
      limitContainer.setFollowChildEnabled(true);
      limitContainer.setVAlignment(VRLayout.CENTER);
      limitContainer.add(getLimit(), null);
    }
    return limitContainer;
  }

  /**
   * 限度額管理対象内単位数を取得します。
   * @return 限度額管理対象内単位数
   */
  public ACTextField getLimitAmount(){
    if(limitAmount==null){

      limitAmount = new ACTextField();

      getLimitAmountContainer().setText("管理対象内");

      limitAmount.setEditable(false);

      limitAmount.setColumns(5);

      limitAmount.setHorizontalAlignment(SwingConstants.RIGHT);

      addLimitAmount();
    }
    return limitAmount;

  }

  /**
   * 限度額管理対象内単位数コンテナを取得します。
   * @return 限度額管理対象内単位数コンテナ
   */
  protected ACLabelContainer getLimitAmountContainer(){
    if(limitAmountContainer==null){
      limitAmountContainer = new ACLabelContainer();
      limitAmountContainer.setFollowChildEnabled(true);
      limitAmountContainer.setVAlignment(VRLayout.CENTER);
      limitAmountContainer.add(getLimitAmount(), null);
    }
    return limitAmountContainer;
  }

  /**
   * 超過単位数を取得します。
   * @return 超過単位数
   */
  public ACTextField getOver(){
    if(over==null){

      over = new ACTextField();

      getOverContainer().setText("超過分");

      over.setEditable(false);

      over.setColumns(5);

      over.setHorizontalAlignment(SwingConstants.RIGHT);

      addOver();
    }
    return over;

  }

  /**
   * 超過単位数コンテナを取得します。
   * @return 超過単位数コンテナ
   */
  protected ACLabelContainer getOverContainer(){
    if(overContainer==null){
      overContainer = new ACLabelContainer();
      overContainer.setFollowChildEnabled(true);
      overContainer.setVAlignment(VRLayout.CENTER);
      overContainer.add(getOver(), null);
    }
    return overContainer;
  }

  /**
   * 再集計を取得します。
   * @return 再集計
   */
  public ACButton getCalcurate(){
    if(calcurate==null){

      calcurate = new ACButton();

      calcurate.setText("再集計");

      calcurate.setToolTipText("サービス単位数を再集計します。");

      addCalcurate();
    }
    return calcurate;

  }

  /**
   * 調整後合計単位数を取得します。
   * @return 調整後合計単位数
   */
  public ACTextField getAfterAdjustment(){
    if(afterAdjustment==null){

      afterAdjustment = new ACTextField();

      getAfterAdjustmentContainer().setText("調整後合計");

      afterAdjustment.setEditable(false);

      afterAdjustment.setColumns(5);

      afterAdjustment.setHorizontalAlignment(SwingConstants.RIGHT);

      addAfterAdjustment();
    }
    return afterAdjustment;

  }

  /**
   * 調整後合計単位数コンテナを取得します。
   * @return 調整後合計単位数コンテナ
   */
  protected ACLabelContainer getAfterAdjustmentContainer(){
    if(afterAdjustmentContainer==null){
      afterAdjustmentContainer = new ACLabelContainer();
      afterAdjustmentContainer.setFollowChildEnabled(true);
      afterAdjustmentContainer.setVAlignment(VRLayout.CENTER);
      afterAdjustmentContainer.add(getAfterAdjustment(), null);
    }
    return afterAdjustmentContainer;
  }

  /**
   * 調整単位数を取得します。
   * @return 調整単位数
   */
  public ACTextField getAdjustment(){
    if(adjustment==null){

      adjustment = new ACTextField();

      getAdjustmentContainer().setText("調整分");

      adjustment.setEditable(false);

      adjustment.setColumns(5);

      adjustment.setHorizontalAlignment(SwingConstants.RIGHT);

      addAdjustment();
    }
    return adjustment;

  }

  /**
   * 調整単位数コンテナを取得します。
   * @return 調整単位数コンテナ
   */
  protected ACLabelContainer getAdjustmentContainer(){
    if(adjustmentContainer==null){
      adjustmentContainer = new ACLabelContainer();
      adjustmentContainer.setFollowChildEnabled(true);
      adjustmentContainer.setVAlignment(VRLayout.CENTER);
      adjustmentContainer.add(getAdjustment(), null);
    }
    return adjustmentContainer;
  }

  /**
   * ボタン領域を取得します。
   * @return ボタン領域
   */
  public ACPanel getButtons(){
    if(buttons==null){

      buttons = new ACPanel();

      addButtons();
    }
    return buttons;

  }

  /**
   * 自己負担調整画面を取得します。
   * @return 自己負担調整画面
   */
  public ACButton getCoordinatePrivateExpenses(){
    if(coordinatePrivateExpenses==null){

      coordinatePrivateExpenses = new ACButton();

      coordinatePrivateExpenses.setText("自己負担調整");

      coordinatePrivateExpenses.setEnabled(false);

      coordinatePrivateExpenses.setToolTipText("利用者の自己負担分を調整します。");

      addCoordinatePrivateExpenses();
    }
    return coordinatePrivateExpenses;

  }

  /**
   * 集計明細画面を取得します。
   * @return 集計明細画面
   */
  public ACButton getDetailsbutton(){
    if(detailsbutton==null){

      detailsbutton = new ACButton();

      detailsbutton.setText("集計明細");

      detailsbutton.setToolTipText("サービスごとの集計情報を表示します。");

      addDetailsbutton();
    }
    return detailsbutton;

  }

  /**
   * 特定診療・特別療養費画面を取得します。
   * @return 特定診療・特別療養費画面
   */
  public ACButton getTokubetuButton(){
    if(tokubetuButton==null){

      tokubetuButton = new ACButton();

      tokubetuButton.setText("特定診療・特別療養費");

      tokubetuButton.setToolTipText("サービス毎の特定診療費・特別療養費を表示します。");

      addTokubetuButton();
    }
    return tokubetuButton;

  }

  /**
   * 追加情報領域を取得します。
   * @return 追加情報領域
   */
  public ACPanel getAddInfomations(){
    if(addInfomations==null){

      addInfomations = new ACPanel();

      addAddInfomations();
    }
    return addInfomations;

  }

  /**
   * 計画単位数を取得します。
   * @return 計画単位数
   */
  public ACButton getPlanUnit(){
    if(planUnit==null){

      planUnit = new ACButton();

      planUnit.setText("計画単位数");

      planUnit.setToolTipText("計画単位数を編集します。");

      addPlanUnit();
    }
    return planUnit;

  }

  /**
   * 月間表領域を取得します。
   * @return 月間表領域
   */
  public ACPanel getMonthlyCharts(){
    if(monthlyCharts==null){

      monthlyCharts = new ACPanel();

      monthlyCharts.setBackground(new Color(233,255,240));

      addMonthlyCharts();
    }
    return monthlyCharts;

  }

  /**
   * 月間表を取得します。
   * @return 月間表
   */
  public QS001MonthSchedule getMonthlySchedule(){
    if(monthlySchedule==null){

      monthlySchedule = new QS001MonthSchedule();

      addMonthlySchedule();
    }
    return monthlySchedule;

  }

  /**
   * コンストラクタです。
   */
  public QS001002Design() {

    try {
      initialize();

      initAffair(null);

    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身の設定を行ないます。
   */
  protected void initThis(){
  }

  /**
   * thisに内部項目を追加します。
   */
  protected void addThis(){

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getUppers(), VRLayout.NORTH);

    contents.add(getMonthlyCharts(), VRLayout.CLIENT);

  }

  /**
   * 上部領域に内部項目を追加します。
   */
  protected void addUppers(){

    uppers.add(getSumups(), VRLayout.WEST);

    uppers.add(getButtons(), VRLayout.CLIENT);

    uppers.add(getAddInfomations(), VRLayout.SOUTH);
  }

  /**
   * 集計情報領域に内部項目を追加します。
   */
  protected void addSumups(){

    sumups.add(getLimitContainer(), VRLayout.FLOW_INSETLINE);

    sumups.add(getLimitAmountContainer(), VRLayout.FLOW_INSETLINE);

    sumups.add(getOverContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    sumups.add(getCalcurate(), VRLayout.FLOW_INSETLINE);

    sumups.add(getAfterAdjustmentContainer(), VRLayout.FLOW_INSETLINE);

    sumups.add(getAdjustmentContainer(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * 限度額に内部項目を追加します。
   */
  protected void addLimit(){

  }

  /**
   * 限度額管理対象内単位数に内部項目を追加します。
   */
  protected void addLimitAmount(){

  }

  /**
   * 超過単位数に内部項目を追加します。
   */
  protected void addOver(){

  }

  /**
   * 再集計に内部項目を追加します。
   */
  protected void addCalcurate(){

  }

  /**
   * 調整後合計単位数に内部項目を追加します。
   */
  protected void addAfterAdjustment(){

  }

  /**
   * 調整単位数に内部項目を追加します。
   */
  protected void addAdjustment(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getCoordinatePrivateExpenses(), VRLayout.FLOW_RETURN);

    buttons.add(getDetailsbutton(), VRLayout.FLOW_RETURN);

    buttons.add(getTokubetuButton(), VRLayout.FLOW);

  }

  /**
   * 自己負担調整画面に内部項目を追加します。
   */
  protected void addCoordinatePrivateExpenses(){

  }

  /**
   * 集計明細画面に内部項目を追加します。
   */
  protected void addDetailsbutton(){

  }

  /**
   * 特定診療・特別療養費画面に内部項目を追加します。
   */
  protected void addTokubetuButton(){

  }

  /**
   * 追加情報領域に内部項目を追加します。
   */
  protected void addAddInfomations(){

    addInfomations.add(getPlanUnit(), VRLayout.FLOW);

  }

  /**
   * 計画単位数に内部項目を追加します。
   */
  protected void addPlanUnit(){

  }

  /**
   * 月間表領域に内部項目を追加します。
   */
  protected void addMonthlyCharts(){

    monthlyCharts.add(getMonthlySchedule(), VRLayout.CLIENT);

  }

  /**
   * 月間表に内部項目を追加します。
   */
  protected void addMonthlySchedule(){

  }

  /**
   * コンポーネントを初期化します。
   * @throws Exception 初期化例外
   */
  private void initialize() throws Exception {
    initThis();
    addThis();
  }
  public boolean canBack(VRMap parameters) throws Exception {
    return true;
  }
  public Component getFirstFocusComponent() {

    return null;

  }
  public void initAffair(ACAffairInfo affair) throws Exception {
  }

  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.getInstance().getContentPane().add(new QS001002Design());
      ACFrame.getInstance().setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001002Design getThis() {
    return this;
  }
}
