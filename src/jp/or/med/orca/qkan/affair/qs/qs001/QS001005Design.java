
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
 * 作成日: 2006/06/05  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム 集計明細画面 (QS001030)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qs.qs001;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairDialog;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.text.QkanServiceAbbreviationFormat;
/**
 * 集計明細画面画面項目デザイン(QS001030) 
 */
@SuppressWarnings("serial")
public class QS001005Design extends QkanAffairDialog {
  //GUIコンポーネント

  private ACPanel contents;

  private ACPanel inLimitAmountInfomation;

  private ACLabel inLimitAmountLimitCaption;

  private ACTextField inLimitAmountLimit;

  private ACLabel inLimitAmountLimitUnit;

  private ACLabel inLimitAmountValueCaption;

  private ACTextField inLimitAmountValue;

  private ACLabel inLimitAmountValueUnit;

  private ACLabel aboutCalcCaption;

  private ACTextField aboutCalc;

  private ACLabel aboutCalcUnit;

  private ACGroupBox inLimitAmount;

  private ACTable detailsTable;

  private VRTableColumnModel detailsTableColumnModel;

  private ACTableColumn detailsTableColumn1;

  private ACTableColumn detailsTableColumn2;

  private ACTableColumn detailsTableColumn3;

  private ACTableColumn detailsTableColumn4;

  private ACTableColumn detailsTableColumn5;

  private ACPanel outLimitAmountInfomation;

  private ACLabel homeMedicalAdviceCaption;

  private ACTextField homeMedicalAdvice;

  private ACLabel homeMedicalAdviceUnit;

  private ACGroupBox outerServices;

  private ACPanel outerServiceInfomation;

  private ACLabel outerServiceLimitCaption;

  private ACTextField outerServiceLimit;

  private ACLabel outerServiceLimitUnit;

  private ACTable outerTable;

  private VRTableColumnModel outerTableColumnModel;

  private ACTableColumn outerTableColumn1;

  private ACTableColumn outerTableColumn2;

  private ACTableColumn outerTableColumn3;

  private ACTableColumn outerTableColumn4;

  private ACTableColumn outerTableColumn5;

  private ACPanel buttons;

  private ACButton close;

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
   * 給付管理対象情報を取得します。
   * @return 給付管理対象情報
   */
  public ACPanel getInLimitAmountInfomation(){
    if(inLimitAmountInfomation==null){

      inLimitAmountInfomation = new ACPanel();

      inLimitAmountInfomation.setAutoWrap(false);

      inLimitAmountInfomation.setHgap(2);

      addInLimitAmountInfomation();
    }
    return inLimitAmountInfomation;

  }

  /**
   * 給付管理対象支給限度額キャプションを取得します。
   * @return 給付管理対象支給限度額キャプション
   */
  public ACLabel getInLimitAmountLimitCaption(){
    if(inLimitAmountLimitCaption==null){

      inLimitAmountLimitCaption = new ACLabel();

      inLimitAmountLimitCaption.setText("　支給限度額");

      addInLimitAmountLimitCaption();
    }
    return inLimitAmountLimitCaption;

  }

  /**
   * 給付管理対象支給限度額を取得します。
   * @return 給付管理対象支給限度額
   */
  public ACTextField getInLimitAmountLimit(){
    if(inLimitAmountLimit==null){

      inLimitAmountLimit = new ACTextField();

      inLimitAmountLimit.setBindPath("LIMIT_RATE");

      inLimitAmountLimit.setEditable(false);

      inLimitAmountLimit.setColumns(5);

      inLimitAmountLimit.setHorizontalAlignment(SwingConstants.RIGHT);

      addInLimitAmountLimit();
    }
    return inLimitAmountLimit;

  }

  /**
   * 給付管理対象支給限度額単位を取得します。
   * @return 給付管理対象支給限度額単位
   */
  public ACLabel getInLimitAmountLimitUnit(){
    if(inLimitAmountLimitUnit==null){

      inLimitAmountLimitUnit = new ACLabel();

      inLimitAmountLimitUnit.setText("単位");

      addInLimitAmountLimitUnit();
    }
    return inLimitAmountLimitUnit;

  }

  /**
   * 限度内単位数キャプションを取得します。
   * @return 限度内単位数キャプション
   */
  public ACLabel getInLimitAmountValueCaption(){
    if(inLimitAmountValueCaption==null){

      inLimitAmountValueCaption = new ACLabel();

      inLimitAmountValueCaption.setText("　　限度内単位数");

      addInLimitAmountValueCaption();
    }
    return inLimitAmountValueCaption;

  }

  /**
   * 限度内単位数を取得します。
   * @return 限度内単位数
   */
  public ACTextField getInLimitAmountValue(){
    if(inLimitAmountValue==null){

      inLimitAmountValue = new ACTextField();

      inLimitAmountValue.setEditable(false);

      inLimitAmountValue.setColumns(5);

      inLimitAmountValue.setHorizontalAlignment(SwingConstants.RIGHT);

      addInLimitAmountValue();
    }
    return inLimitAmountValue;

  }

  /**
   * 限度内単位数単位を取得します。
   * @return 限度内単位数単位
   */
  public ACLabel getInLimitAmountValueUnit(){
    if(inLimitAmountValueUnit==null){

      inLimitAmountValueUnit = new ACLabel();

      inLimitAmountValueUnit.setText("単位");

      addInLimitAmountValueUnit();
    }
    return inLimitAmountValueUnit;

  }

  /**
   * 負担額概算キャプションを取得します。
   * @return 負担額概算キャプション
   */
  public ACLabel getAboutCalcCaption(){
    if(aboutCalcCaption==null){

      aboutCalcCaption = new ACLabel();

      aboutCalcCaption.setText("　　負担額概算");

      addAboutCalcCaption();
    }
    return aboutCalcCaption;

  }

  /**
   * 負担額概算を取得します。
   * @return 負担額概算
   */
  public ACTextField getAboutCalc(){
    if(aboutCalc==null){

      aboutCalc = new ACTextField();

      aboutCalc.setEditable(false);

      aboutCalc.setColumns(7);

      aboutCalc.setHorizontalAlignment(SwingConstants.RIGHT);

      addAboutCalc();
    }
    return aboutCalc;

  }

  /**
   * 負担額概算単位を取得します。
   * @return 負担額概算単位
   */
  public ACLabel getAboutCalcUnit(){
    if(aboutCalcUnit==null){

      aboutCalcUnit = new ACLabel();

      aboutCalcUnit.setText("円");

      addAboutCalcUnit();
    }
    return aboutCalcUnit;

  }

  /**
   * 給付管理対象テーブル領域を取得します。
   * @return 給付管理対象テーブル領域
   */
  public ACGroupBox getInLimitAmount(){
    if(inLimitAmount==null){

      inLimitAmount = new ACGroupBox();

      inLimitAmount.setText("給付管理対象サービス");

      addInLimitAmount();
    }
    return inLimitAmount;

  }

  /**
   * 給付管理対象集計明細テーブルを取得します。
   * @return 給付管理対象集計明細テーブル
   */
  public ACTable getDetailsTable(){
    if(detailsTable==null){

      detailsTable = new ACTable();

      detailsTable.setColumnModel(getDetailsTableColumnModel());

      addDetailsTable();
    }
    return detailsTable;

  }

  /**
   * 給付管理対象集計明細テーブルカラムモデルを取得します。
   * @return 給付管理対象集計明細テーブルカラムモデル
   */
  protected VRTableColumnModel getDetailsTableColumnModel(){
    if(detailsTableColumnModel==null){
      detailsTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addDetailsTableColumnModel();
    }
    return detailsTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getDetailsTableColumn1(){
    if(detailsTableColumn1==null){

      detailsTableColumn1 = new ACTableColumn();

      detailsTableColumn1.setHeaderValue("No.");

      detailsTableColumn1.setColumnName("SYSTEM_SERVICE_KIND_DETAIL");

      detailsTableColumn1.setColumns(2);

      detailsTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      detailsTableColumn1.setSortable(false);

      addDetailsTableColumn1();
    }
    return detailsTableColumn1;

  }

  /**
   * サービス種類を取得します。
   * @return サービス種類
   */
  public ACTableColumn getDetailsTableColumn2(){
    if(detailsTableColumn2==null){

      detailsTableColumn2 = new ACTableColumn();

      detailsTableColumn2.setHeaderValue("サービス種類");

      detailsTableColumn2.setColumnName("SYSTEM_SERVICE_KIND_DETAIL");

      detailsTableColumn2.setColumns(28);

      detailsTableColumn2.setFormat(QkanServiceAbbreviationFormat.getInstance());

      addDetailsTableColumn2();
    }
    return detailsTableColumn2;

  }

  /**
   * 給付単位を取得します。
   * @return 給付単位
   */
  public ACTableColumn getDetailsTableColumn3(){
    if(detailsTableColumn3==null){

      detailsTableColumn3 = new ACTableColumn();

      detailsTableColumn3.setHeaderValue("給付単位");

      detailsTableColumn3.setColumnName("UNIT");

      detailsTableColumn3.setColumns(6);

      detailsTableColumn3.setHorizontalAlignment(SwingConstants.RIGHT);

      addDetailsTableColumn3();
    }
    return detailsTableColumn3;

  }

  /**
   * 調整単位を取得します。
   * @return 調整単位
   */
  public ACTableColumn getDetailsTableColumn4(){
    if(detailsTableColumn4==null){

      detailsTableColumn4 = new ACTableColumn();

      detailsTableColumn4.setHeaderValue("調整単位");

      detailsTableColumn4.setColumnName("ADJUST");

      detailsTableColumn4.setColumns(6);

      detailsTableColumn4.setHorizontalAlignment(SwingConstants.RIGHT);

      addDetailsTableColumn4();
    }
    return detailsTableColumn4;

  }

  /**
   * 調整後単位を取得します。
   * @return 調整後単位
   */
  public ACTableColumn getDetailsTableColumn5(){
    if(detailsTableColumn5==null){

      detailsTableColumn5 = new ACTableColumn();

      detailsTableColumn5.setHeaderValue("調整後単位");

      detailsTableColumn5.setColumnName("RESULT");

      detailsTableColumn5.setColumns(8);

      detailsTableColumn5.setHorizontalAlignment(SwingConstants.RIGHT);

      addDetailsTableColumn5();
    }
    return detailsTableColumn5;

  }

  /**
   * 給付管理対象外情報を取得します。
   * @return 給付管理対象外情報
   */
  public ACPanel getOutLimitAmountInfomation(){
    if(outLimitAmountInfomation==null){

      outLimitAmountInfomation = new ACPanel();

      addOutLimitAmountInfomation();
    }
    return outLimitAmountInfomation;

  }

  /**
   * 給付管理対象外サービス単位数キャプションを取得します。
   * @return 給付管理対象外サービス単位数キャプション
   */
  public ACLabel getHomeMedicalAdviceCaption(){
    if(homeMedicalAdviceCaption==null){

      homeMedicalAdviceCaption = new ACLabel();

      homeMedicalAdviceCaption.setText("給付管理対象外サービス");

      addHomeMedicalAdviceCaption();
    }
    return homeMedicalAdviceCaption;

  }

  /**
   * 給付管理対象外サービス単位数を取得します。
   * @return 給付管理対象外サービス単位数
   */
  public ACTextField getHomeMedicalAdvice(){
    if(homeMedicalAdvice==null){

      homeMedicalAdvice = new ACTextField();

      homeMedicalAdvice.setEditable(false);

      homeMedicalAdvice.setColumns(6);

      homeMedicalAdvice.setHorizontalAlignment(SwingConstants.RIGHT);

      addHomeMedicalAdvice();
    }
    return homeMedicalAdvice;

  }

  /**
   * 給付管理対象外サービス単位数単位を取得します。
   * @return 給付管理対象外サービス単位数単位
   */
  public ACLabel getHomeMedicalAdviceUnit(){
    if(homeMedicalAdviceUnit==null){

      homeMedicalAdviceUnit = new ACLabel();

      homeMedicalAdviceUnit.setText("単位");

      addHomeMedicalAdviceUnit();
    }
    return homeMedicalAdviceUnit;

  }

  /**
   * 外部利用型テーブル領域を取得します。
   * @return 外部利用型テーブル領域
   */
  public ACGroupBox getOuterServices(){
    if(outerServices==null){

      outerServices = new ACGroupBox();

      outerServices.setText("外部利用型サービス");

      addOuterServices();
    }
    return outerServices;

  }

  /**
   * 外部利用型情報を取得します。
   * @return 外部利用型情報
   */
  public ACPanel getOuterServiceInfomation(){
    if(outerServiceInfomation==null){

      outerServiceInfomation = new ACPanel();

      addOuterServiceInfomation();
    }
    return outerServiceInfomation;

  }

  /**
   * 外部利用型給付上限単位数キャプションを取得します。
   * @return 外部利用型給付上限単位数キャプション
   */
  public ACLabel getOuterServiceLimitCaption(){
    if(outerServiceLimitCaption==null){

      outerServiceLimitCaption = new ACLabel();

      outerServiceLimitCaption.setText("給付上限単位数");

      addOuterServiceLimitCaption();
    }
    return outerServiceLimitCaption;

  }

  /**
   * 外部利用型給付上限単位数を取得します。
   * @return 外部利用型給付上限単位数
   */
  public ACTextField getOuterServiceLimit(){
    if(outerServiceLimit==null){

      outerServiceLimit = new ACTextField();

      outerServiceLimit.setBindPath("EXTERNAL_USE_LIMIT");

      outerServiceLimit.setEditable(false);

      outerServiceLimit.setColumns(5);

      outerServiceLimit.setHorizontalAlignment(SwingConstants.RIGHT);

      addOuterServiceLimit();
    }
    return outerServiceLimit;

  }

  /**
   * 外部利用型給付上限単位数単位を取得します。
   * @return 外部利用型給付上限単位数単位
   */
  public ACLabel getOuterServiceLimitUnit(){
    if(outerServiceLimitUnit==null){

      outerServiceLimitUnit = new ACLabel();

      outerServiceLimitUnit.setText("単位");

      addOuterServiceLimitUnit();
    }
    return outerServiceLimitUnit;

  }

  /**
   * 外部利用型集計明細テーブルを取得します。
   * @return 外部利用型集計明細テーブル
   */
  public ACTable getOuterTable(){
    if(outerTable==null){

      outerTable = new ACTable();

      outerTable.setColumnModel(getOuterTableColumnModel());

      outerTable.setPreferredSize(new Dimension(100,50));

      addOuterTable();
    }
    return outerTable;

  }

  /**
   * 外部利用型集計明細テーブルカラムモデルを取得します。
   * @return 外部利用型集計明細テーブルカラムモデル
   */
  protected VRTableColumnModel getOuterTableColumnModel(){
    if(outerTableColumnModel==null){
      outerTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addOuterTableColumnModel();
    }
    return outerTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getOuterTableColumn1(){
    if(outerTableColumn1==null){

      outerTableColumn1 = new ACTableColumn();

      outerTableColumn1.setHeaderValue("No.");

      outerTableColumn1.setColumnName("SYSTEM_SERVICE_KIND_DETAIL");

      outerTableColumn1.setColumns(2);

      outerTableColumn1.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      outerTableColumn1.setSortable(false);

      addOuterTableColumn1();
    }
    return outerTableColumn1;

  }

  /**
   * サービス種類を取得します。
   * @return サービス種類
   */
  public ACTableColumn getOuterTableColumn2(){
    if(outerTableColumn2==null){

      outerTableColumn2 = new ACTableColumn();

      outerTableColumn2.setHeaderValue("サービス種類");

      outerTableColumn2.setColumnName("SYSTEM_SERVICE_KIND_DETAIL");

      outerTableColumn2.setColumns(28);

      outerTableColumn2.setFormat(QkanServiceAbbreviationFormat.getInstance());

      addOuterTableColumn2();
    }
    return outerTableColumn2;

  }

  /**
   * 給付単位を取得します。
   * @return 給付単位
   */
  public ACTableColumn getOuterTableColumn3(){
    if(outerTableColumn3==null){

      outerTableColumn3 = new ACTableColumn();

      outerTableColumn3.setHeaderValue("給付単位");

      outerTableColumn3.setColumnName("UNIT");

      outerTableColumn3.setColumns(6);

      outerTableColumn3.setHorizontalAlignment(SwingConstants.RIGHT);

      addOuterTableColumn3();
    }
    return outerTableColumn3;

  }

  /**
   * 調整単位を取得します。
   * @return 調整単位
   */
  public ACTableColumn getOuterTableColumn4(){
    if(outerTableColumn4==null){

      outerTableColumn4 = new ACTableColumn();

      outerTableColumn4.setHeaderValue("調整単位");

      outerTableColumn4.setColumnName("ADJUST");

      outerTableColumn4.setColumns(6);

      outerTableColumn4.setHorizontalAlignment(SwingConstants.RIGHT);

      addOuterTableColumn4();
    }
    return outerTableColumn4;

  }

  /**
   * 調整後単位を取得します。
   * @return 調整後単位
   */
  public ACTableColumn getOuterTableColumn5(){
    if(outerTableColumn5==null){

      outerTableColumn5 = new ACTableColumn();

      outerTableColumn5.setHeaderValue("調整後単位");

      outerTableColumn5.setColumnName("RESULT");

      outerTableColumn5.setColumns(8);

      outerTableColumn5.setHorizontalAlignment(SwingConstants.RIGHT);

      addOuterTableColumn5();
    }
    return outerTableColumn5;

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
   * 閉じるを取得します。
   * @return 閉じる
   */
  public ACButton getClose(){
    if(close==null){

      close = new ACButton();

      close.setText("閉じる(C)");

      close.setMnemonic('C');

      addClose();
    }
    return close;

  }

  /**
   * コンストラクタです。
   */
  public QS001005Design() {

    super(ACFrame.getInstance(), true);
    this.getContentPane().setLayout(new VRLayout());
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    try {
      initialize();

      setSize(600, 420);

      // ウィンドウを中央に配置
      Point pos;
      try{
          pos= ACFrame.getInstance().getLocationOnScreen();
      }catch(Exception ex){
          pos = new Point(0,0);
      }
      Dimension screenSize = ACFrame.getInstance().getSize();
      Dimension frameSize = this.getSize();
      if (frameSize.height > screenSize.height) {
          frameSize.height = screenSize.height;
      }
      if (frameSize.width > screenSize.width) {
          frameSize.width = screenSize.width;
      }
      this.setLocation((int)(pos.getX()+(screenSize.width - frameSize.width) / 2),
              (int)(pos.getY()+(screenSize.height - frameSize.height) / 2));

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

    this.getContentPane().add(getContents(), VRLayout.CLIENT);

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getInLimitAmountInfomation(), VRLayout.NORTH);

    contents.add(getInLimitAmount(), VRLayout.CLIENT);

    contents.add(getButtons(), VRLayout.SOUTH);
    contents.add(getOuterServices(), VRLayout.SOUTH);
    contents.add(getOutLimitAmountInfomation(), VRLayout.SOUTH);
  }

  /**
   * 給付管理対象情報に内部項目を追加します。
   */
  protected void addInLimitAmountInfomation(){

    inLimitAmountInfomation.add(getInLimitAmountLimitCaption(), VRLayout.FLOW);

    inLimitAmountInfomation.add(getInLimitAmountLimit(), VRLayout.FLOW);

    inLimitAmountInfomation.add(getInLimitAmountLimitUnit(), VRLayout.FLOW);

    inLimitAmountInfomation.add(getInLimitAmountValueCaption(), VRLayout.FLOW);

    inLimitAmountInfomation.add(getInLimitAmountValue(), VRLayout.FLOW);

    inLimitAmountInfomation.add(getInLimitAmountValueUnit(), VRLayout.FLOW);

    inLimitAmountInfomation.add(getAboutCalcCaption(), VRLayout.FLOW);

    inLimitAmountInfomation.add(getAboutCalc(), VRLayout.FLOW);

    inLimitAmountInfomation.add(getAboutCalcUnit(), VRLayout.FLOW);

  }

  /**
   * 給付管理対象支給限度額キャプションに内部項目を追加します。
   */
  protected void addInLimitAmountLimitCaption(){

  }

  /**
   * 給付管理対象支給限度額に内部項目を追加します。
   */
  protected void addInLimitAmountLimit(){

  }

  /**
   * 給付管理対象支給限度額単位に内部項目を追加します。
   */
  protected void addInLimitAmountLimitUnit(){

  }

  /**
   * 限度内単位数キャプションに内部項目を追加します。
   */
  protected void addInLimitAmountValueCaption(){

  }

  /**
   * 限度内単位数に内部項目を追加します。
   */
  protected void addInLimitAmountValue(){

  }

  /**
   * 限度内単位数単位に内部項目を追加します。
   */
  protected void addInLimitAmountValueUnit(){

  }

  /**
   * 負担額概算キャプションに内部項目を追加します。
   */
  protected void addAboutCalcCaption(){

  }

  /**
   * 負担額概算に内部項目を追加します。
   */
  protected void addAboutCalc(){

  }

  /**
   * 負担額概算単位に内部項目を追加します。
   */
  protected void addAboutCalcUnit(){

  }

  /**
   * 給付管理対象テーブル領域に内部項目を追加します。
   */
  protected void addInLimitAmount(){

    inLimitAmount.add(getDetailsTable(), VRLayout.CLIENT);

  }

  /**
   * 給付管理対象集計明細テーブルに内部項目を追加します。
   */
  protected void addDetailsTable(){

  }

  /**
   * 給付管理対象集計明細テーブルカラムモデルに内部項目を追加します。
   */
  protected void addDetailsTableColumnModel(){

    getDetailsTableColumnModel().addColumn(getDetailsTableColumn1());

    getDetailsTableColumnModel().addColumn(getDetailsTableColumn2());

    getDetailsTableColumnModel().addColumn(getDetailsTableColumn3());

    getDetailsTableColumnModel().addColumn(getDetailsTableColumn4());

    getDetailsTableColumnModel().addColumn(getDetailsTableColumn5());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addDetailsTableColumn1(){

  }

  /**
   * サービス種類に内部項目を追加します。
   */
  protected void addDetailsTableColumn2(){

  }

  /**
   * 給付単位に内部項目を追加します。
   */
  protected void addDetailsTableColumn3(){

  }

  /**
   * 調整単位に内部項目を追加します。
   */
  protected void addDetailsTableColumn4(){

  }

  /**
   * 調整後単位に内部項目を追加します。
   */
  protected void addDetailsTableColumn5(){

  }

  /**
   * 給付管理対象外情報に内部項目を追加します。
   */
  protected void addOutLimitAmountInfomation(){

    outLimitAmountInfomation.add(getHomeMedicalAdviceCaption(), VRLayout.FLOW);

    outLimitAmountInfomation.add(getHomeMedicalAdvice(), VRLayout.FLOW);

    outLimitAmountInfomation.add(getHomeMedicalAdviceUnit(), VRLayout.FLOW_RETURN);

  }

  /**
   * 給付管理対象外サービス単位数キャプションに内部項目を追加します。
   */
  protected void addHomeMedicalAdviceCaption(){

  }

  /**
   * 給付管理対象外サービス単位数に内部項目を追加します。
   */
  protected void addHomeMedicalAdvice(){

  }

  /**
   * 給付管理対象外サービス単位数単位に内部項目を追加します。
   */
  protected void addHomeMedicalAdviceUnit(){

  }

  /**
   * 外部利用型テーブル領域に内部項目を追加します。
   */
  protected void addOuterServices(){

    outerServices.add(getOuterServiceInfomation(), VRLayout.NORTH);

    outerServices.add(getOuterTable(), VRLayout.CLIENT);

  }

  /**
   * 外部利用型情報に内部項目を追加します。
   */
  protected void addOuterServiceInfomation(){

    outerServiceInfomation.add(getOuterServiceLimitCaption(), VRLayout.FLOW);

    outerServiceInfomation.add(getOuterServiceLimit(), VRLayout.FLOW);

    outerServiceInfomation.add(getOuterServiceLimitUnit(), VRLayout.FLOW);

  }

  /**
   * 外部利用型給付上限単位数キャプションに内部項目を追加します。
   */
  protected void addOuterServiceLimitCaption(){

  }

  /**
   * 外部利用型給付上限単位数に内部項目を追加します。
   */
  protected void addOuterServiceLimit(){

  }

  /**
   * 外部利用型給付上限単位数単位に内部項目を追加します。
   */
  protected void addOuterServiceLimitUnit(){

  }

  /**
   * 外部利用型集計明細テーブルに内部項目を追加します。
   */
  protected void addOuterTable(){

  }

  /**
   * 外部利用型集計明細テーブルカラムモデルに内部項目を追加します。
   */
  protected void addOuterTableColumnModel(){

    getOuterTableColumnModel().addColumn(getOuterTableColumn1());

    getOuterTableColumnModel().addColumn(getOuterTableColumn2());

    getOuterTableColumnModel().addColumn(getOuterTableColumn3());

    getOuterTableColumnModel().addColumn(getOuterTableColumn4());

    getOuterTableColumnModel().addColumn(getOuterTableColumn5());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addOuterTableColumn1(){

  }

  /**
   * サービス種類に内部項目を追加します。
   */
  protected void addOuterTableColumn2(){

  }

  /**
   * 給付単位に内部項目を追加します。
   */
  protected void addOuterTableColumn3(){

  }

  /**
   * 調整単位に内部項目を追加します。
   */
  protected void addOuterTableColumn4(){

  }

  /**
   * 調整後単位に内部項目を追加します。
   */
  protected void addOuterTableColumn5(){

  }

  /**
   * ボタン領域に内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getClose(), VRLayout.EAST);
  }

  /**
   * 閉じるに内部項目を追加します。
   */
  protected void addClose(){

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

  public void setVisible(boolean visible){
    if(visible){
      try{
        initAffair(null);
      }catch(Throwable ex){
        ACCommon.getInstance().showExceptionMessage(ex);
      }
    }
    super.setVisible(visible);
  }
  public static void main(String[] args) {
    //デフォルトデバッグ起動
    try {
      ACFrame.setVRLookAndFeel();
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      new QS001005Design().setVisible(true);
      System.exit(0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001005Design getThis() {
    return this;
  }
}
