
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
 * サブシステム 利用者管理 (U)
 * プロセス 利用者登録 (004)
 * プログラム 公費・社福軽減情報 (QU004)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qu.qu004;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

import jp.nichicom.ac.ACConstants;
import jp.nichicom.ac.component.ACAffairButton;
import jp.nichicom.ac.component.ACAffairButtonBar;
import jp.nichicom.ac.component.ACButton;
import jp.nichicom.ac.component.ACComboBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.component.table.ACTable;
import jp.nichicom.ac.component.table.ACTableCellViewer;
import jp.nichicom.ac.component.table.ACTableColumn;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.container.ACPanel;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACAffairable;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.text.ACBorderBlankDateFormat;
import jp.nichicom.ac.util.adapter.ACComboBoxModelAdapter;
import jp.nichicom.vr.component.table.VRTableCellViewer;
import jp.nichicom.vr.component.table.VRTableColumnModel;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanAffairContainer;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.component.QkanDateTextField;
/**
 * 公費・社福軽減情報画面項目デザイン(QU004) 
 */
@SuppressWarnings("serial")
public class QU004Design extends QkanAffairContainer implements ACAffairable {
  //GUIコンポーネント

  private ACAffairButtonBar buttons;

  private ACAffairButton insert;

  private ACAffairButton update;

  private ACPanel contents;

  private ACPanel patientInfo;

  private ACLabel patientNameCaption;

  private ACLabel patientName;

  private JTabbedPane tabs;

  private ACPanel points1;

  private VRLayout kaigoLayout;

  private ACPanel kaigoInfos;

  private ACPanel kaigoInfo;

  private ACComboBox kaigoInfoPublicExpense;

  private ACLabelContainer kaigoInfoPublicExpenseContainer;

  private ACComboBoxModelAdapter kaigoInfoPublicExpenseModel;

  private ACLabelContainer kaigoInfoBenefitRateContena;

  private ACTextField kaigoInfoBenefitRate;

  private ACLabel kaigoInfoPercentLabel;

  private ACLabelContainer kaigoInfoBearNoContena;

  private ACTextField kaigoInfoKohiNo;

  private ACTextField kaigoInfoInsurerNo;

  private ACComboBox kaigoInfoBearName;

  private ACLabelContainer kaigoInfoBearNameContainer;

  private ACComboBoxModelAdapter kaigoInfoBearNameModel;

  private ACTextField kaigoInfoReceiptNo;

  private ACLabelContainer kaigoInfoReceiptNoContainer;

  private ACLabelContainer kaigoInfoValidLimitContena;

  private QkanDateTextField kaigoInfoValidLimit1;

  private ACLabel kaigoInfoValidLimitLabel;

  private QkanDateTextField kaigoInfoValidLimit2;

  private ACLabelContainer kaigoInfoSelfPaymentContents;

  private ACTextField kaigoInfoSelfPayment;

  private ACLabel kaigoInfoSelfPaymentYen;

  private ACPanel kaigoInfoButtons;

  private ACButton kaigoInfoButtonClear;

  private ACButton kaigoInfoButtonInsert;

  private ACButton kaigoInfoButtonConpile;

  private ACButton kaigoInfoButtonDelete;

  private ACPanel kaigoInfoTables;

  private ACTable kaigoInfoTable;

  private VRTableColumnModel kaigoInfoTableColumnModel;

  private ACTableColumn kaigoInfoTableColumn0;

  private ACTableColumn kaigoInfoTableColumn1;

  private ACTableColumn kaigoInfoTableColumn2;

  private ACTableColumn kaigoInfoTableColumn3;

  private ACTableColumn kaigoInfoTableColumn5;

  private ACTableColumn kaigoInfoTableColumn6;

  private ACTableColumn kaigoInfoTableColumn7;

  private ACPanel kaigoInfoServices;

  private ACGroupBox kaigoInfoService;

  private ACLabel kaigoInfoServiceComment;

  private ACTable kaigoInfoServiceTable;

  private VRTableColumnModel kaigoInfoServiceTableColumnModel;

  private ACTableColumn kaigoInfoServiceTableColumn1;

  private ACTableColumn kaigoInfoServiceTableColumn2;

  private ACTableColumn kaigoInfoServiceTableColumn3;

  private ACPanel points3;

  private VRLayout shahukuLayout;

  private ACPanel shahukuInfos;

  private ACPanel shahukuInfo;

  private ACLabelContainer shahukuInfoBenefitRateContena;

  private ACTextField shahukuInfoBenefitRate;

  private ACLabel shahukuInfoPercentLabel;

  private ACLabelContainer shahukuInfoValidLimitContena;

  private QkanDateTextField shahukuInfoValidLimit1;

  private ACLabel shahukuInfoValidLimitLabel;

  private QkanDateTextField shahukuInfoValidLimit2;

  private ACPanel shahukuInfoButtons;

  private ACButton shahukuInfoButtonClear;

  private ACButton shahukuInfoButtonInsert;

  private ACButton shahukuInfoButtonConpile;

  private ACButton shahukuInfoButtonDelete;

  private ACPanel shahukuInfoTables;

  private ACTable shahukuInfoTable;

  private VRTableColumnModel shahukuInfoTableColumnModel;

  private ACTableColumn shahukuInfoTableColumn0;

  private ACTableColumn shahukuInfoTableColumn1;

  private ACTableColumn shahukuInfoTableColumn2;

  private ACTableColumn shahukuInfoTableColumn3;

  //getter

  /**
   * 業務ボタンバーを取得します。
   * @return 業務ボタンバー
   */
  public ACAffairButtonBar getButtons(){
    if(buttons==null){

      buttons = new ACAffairButtonBar();

      buttons.setText("公費・社福軽減情報");

      addButtons();
    }
    return buttons;

  }

  /**
   * 登録を取得します。
   * @return 登録
   */
  public ACAffairButton getInsert(){
    if(insert==null){

      insert = new ACAffairButton();

      insert.setText("登録(S)");

      insert.setToolTipText("現在の内容を登録します。");

      insert.setMnemonic('S');

      insert.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addInsert();
    }
    return insert;

  }

  /**
   * 更新を取得します。
   * @return 更新
   */
  public ACAffairButton getUpdate(){
    if(update==null){

      update = new ACAffairButton();

      update.setText("更新(S)");

      update.setToolTipText("現在の内容を更新します。");

      update.setMnemonic('S');

      update.setIconPath(ACConstants.ICON_PATH_UPDATE_24);

      addUpdate();
    }
    return update;

  }

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
   * 利用者名領域を取得します。
   * @return 利用者名領域
   */
  public ACPanel getPatientInfo(){
    if(patientInfo==null){

      patientInfo = new ACPanel();

      addPatientInfo();
    }
    return patientInfo;

  }

  /**
   * 利用者名キャプションを取得します。
   * @return 利用者名キャプション
   */
  public ACLabel getPatientNameCaption(){
    if(patientNameCaption==null){

      patientNameCaption = new ACLabel();

      patientNameCaption.setText("利用者名");

      addPatientNameCaption();
    }
    return patientNameCaption;

  }

  /**
   * 利用者名を取得します。
   * @return 利用者名
   */
  public ACLabel getPatientName(){
    if(patientName==null){

      patientName = new ACLabel();

      patientName.setText("サンプル利用者");

      patientName.setBindPath("PATIENT_NAME");

      patientName.setColumns(35);

      addPatientName();
    }
    return patientName;

  }

  /**
   * タブを取得します。
   * @return タブ
   */
  public JTabbedPane getTabs(){
    if(tabs==null){

      tabs = new JTabbedPane();

      addTabs();
    }
    return tabs;

  }

  /**
   * 介護公費領域を取得します。
   * @return 介護公費領域
   */
  public ACPanel getPoints1(){
    if(points1==null){

      points1 = new ACPanel();

      points1.setLayout(getKaigoLayout());

      addPoints1();
    }
    return points1;

  }

  /**
   * 介護公費領域・レイアウトを取得します。
   * @return 介護公費領域・レイアウト
   */
  public VRLayout getKaigoLayout(){
    if(kaigoLayout==null){

      kaigoLayout = new VRLayout();

      kaigoLayout.setAutoWrap(false);

      addKaigoLayout();
    }
    return kaigoLayout;

  }

  /**
   * 介護公費領域・情報を取得します。
   * @return 介護公費領域・情報
   */
  public ACPanel getKaigoInfos(){
    if(kaigoInfos==null){

      kaigoInfos = new ACPanel();

      addKaigoInfos();
    }
    return kaigoInfos;

  }

  /**
   * 介護公費領域・情報2を取得します。
   * @return 介護公費領域・情報2
   */
  public ACPanel getKaigoInfo(){
    if(kaigoInfo==null){

      kaigoInfo = new ACPanel();

      addKaigoInfo();
    }
    return kaigoInfo;

  }

  /**
   * 公費情報を取得します。
   * @return 公費情報
   */
  public ACComboBox getKaigoInfoPublicExpense(){
    if(kaigoInfoPublicExpense==null){

      kaigoInfoPublicExpense = new ACComboBox();

      getKaigoInfoPublicExpenseContainer().setText("公費情報");

      kaigoInfoPublicExpense.setBindPath("KOHI_TYPE");

      kaigoInfoPublicExpense.setEditable(false);

      kaigoInfoPublicExpense.setColumns(10);

      kaigoInfoPublicExpense.setModelBindPath("KAIGO_KOHI");

      kaigoInfoPublicExpense.setRenderBindPath("KOHI_NAME");

      kaigoInfoPublicExpense.setModel(getKaigoInfoPublicExpenseModel());

      addKaigoInfoPublicExpense();
    }
    return kaigoInfoPublicExpense;

  }

  /**
   * 公費情報コンテナを取得します。
   * @return 公費情報コンテナ
   */
  protected ACLabelContainer getKaigoInfoPublicExpenseContainer(){
    if(kaigoInfoPublicExpenseContainer==null){
      kaigoInfoPublicExpenseContainer = new ACLabelContainer();
      kaigoInfoPublicExpenseContainer.setFollowChildEnabled(true);
      kaigoInfoPublicExpenseContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoPublicExpenseContainer.add(getKaigoInfoPublicExpense(), null);
    }
    return kaigoInfoPublicExpenseContainer;
  }

  /**
   * 公費情報モデルを取得します。
   * @return 公費情報モデル
   */
  protected ACComboBoxModelAdapter getKaigoInfoPublicExpenseModel(){
    if(kaigoInfoPublicExpenseModel==null){
      kaigoInfoPublicExpenseModel = new ACComboBoxModelAdapter();
      addKaigoInfoPublicExpenseModel();
    }
    return kaigoInfoPublicExpenseModel;
  }

  /**
   * (給付率・コンテナ)を取得します。
   * @return (給付率・コンテナ)
   */
  public ACLabelContainer getKaigoInfoBenefitRateContena(){
    if(kaigoInfoBenefitRateContena==null){

      kaigoInfoBenefitRateContena = new ACLabelContainer();

      kaigoInfoBenefitRateContena.setText("給付率");

      addKaigoInfoBenefitRateContena();
    }
    return kaigoInfoBenefitRateContena;

  }

  /**
   * 給付率を取得します。
   * @return 給付率
   */
  public ACTextField getKaigoInfoBenefitRate(){
    if(kaigoInfoBenefitRate==null){

      kaigoInfoBenefitRate = new ACTextField();

      kaigoInfoBenefitRate.setBindPath("BENEFIT_RATE");

      kaigoInfoBenefitRate.setColumns(3);

      kaigoInfoBenefitRate.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoBenefitRate.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoBenefitRate.setIMEMode(InputSubset.LATIN);

      kaigoInfoBenefitRate.setMaxLength(3);

      addKaigoInfoBenefitRate();
    }
    return kaigoInfoBenefitRate;

  }

  /**
   * %ラベルを取得します。
   * @return %ラベル
   */
  public ACLabel getKaigoInfoPercentLabel(){
    if(kaigoInfoPercentLabel==null){

      kaigoInfoPercentLabel = new ACLabel();

      kaigoInfoPercentLabel.setText(" ％");

      addKaigoInfoPercentLabel();
    }
    return kaigoInfoPercentLabel;

  }

  /**
   * (負担者番号・コンテナ)を取得します。
   * @return (負担者番号・コンテナ)
   */
  public ACLabelContainer getKaigoInfoBearNoContena(){
    if(kaigoInfoBearNoContena==null){

      kaigoInfoBearNoContena = new ACLabelContainer();

      kaigoInfoBearNoContena.setText("負担者番号");

      addKaigoInfoBearNoContena();
    }
    return kaigoInfoBearNoContena;

  }

  /**
   * 公費法別番号を取得します。
   * @return 公費法別番号
   */
  public ACTextField getKaigoInfoKohiNo(){
    if(kaigoInfoKohiNo==null){

      kaigoInfoKohiNo = new ACTextField();

      kaigoInfoKohiNo.setBindPath("KOHI_LAW_NO");

      kaigoInfoKohiNo.setEditable(false);

      kaigoInfoKohiNo.setColumns(2);

      kaigoInfoKohiNo.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoKohiNo.setIMEMode(InputSubset.LATIN);

      kaigoInfoKohiNo.setMaxLength(2);

      addKaigoInfoKohiNo();
    }
    return kaigoInfoKohiNo;

  }

  /**
   * 保険者番号を取得します。
   * @return 保険者番号
   */
  public ACTextField getKaigoInfoInsurerNo(){
    if(kaigoInfoInsurerNo==null){

      kaigoInfoInsurerNo = new ACTextField();

      kaigoInfoInsurerNo.setBindPath("INSURER_ID");

      kaigoInfoInsurerNo.setColumns(6);

      kaigoInfoInsurerNo.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoInsurerNo.setMaxLength(6);

      addKaigoInfoInsurerNo();
    }
    return kaigoInfoInsurerNo;

  }

  /**
   * 負担者名を取得します。
   * @return 負担者名
   */
  public ACComboBox getKaigoInfoBearName(){
    if(kaigoInfoBearName==null){

      kaigoInfoBearName = new ACComboBox();

      kaigoInfoBearName.setVisible(false);

      kaigoInfoBearName.setEditable(false);

      kaigoInfoBearName.setColumns(10);

      kaigoInfoBearName.setModelBindPath("KOHI_PAYER_NAME");

      kaigoInfoBearName.setRenderBindPath("INSURER_NAME");

      kaigoInfoBearName.setModel(getKaigoInfoBearNameModel());

      addKaigoInfoBearName();
    }
    return kaigoInfoBearName;

  }

  /**
   * 負担者名コンテナを取得します。
   * @return 負担者名コンテナ
   */
  protected ACLabelContainer getKaigoInfoBearNameContainer(){
    if(kaigoInfoBearNameContainer==null){
      kaigoInfoBearNameContainer = new ACLabelContainer();
      kaigoInfoBearNameContainer.setFollowChildEnabled(true);
      kaigoInfoBearNameContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoBearNameContainer.add(getKaigoInfoBearName(), null);
    }
    return kaigoInfoBearNameContainer;
  }

  /**
   * 負担者名モデルを取得します。
   * @return 負担者名モデル
   */
  protected ACComboBoxModelAdapter getKaigoInfoBearNameModel(){
    if(kaigoInfoBearNameModel==null){
      kaigoInfoBearNameModel = new ACComboBoxModelAdapter();
      addKaigoInfoBearNameModel();
    }
    return kaigoInfoBearNameModel;
  }

  /**
   * 受給者番号を取得します。
   * @return 受給者番号
   */
  public ACTextField getKaigoInfoReceiptNo(){
    if(kaigoInfoReceiptNo==null){

      kaigoInfoReceiptNo = new ACTextField();

      getKaigoInfoReceiptNoContainer().setText("受給者番号");

      kaigoInfoReceiptNo.setBindPath("KOHI_RECIPIENT_NO");

      kaigoInfoReceiptNo.setCharType(VRCharType.ONLY_ALNUM);

      kaigoInfoReceiptNo.setColumns(10);

      kaigoInfoReceiptNo.setMaxLength(7);

      addKaigoInfoReceiptNo();
    }
    return kaigoInfoReceiptNo;

  }

  /**
   * 受給者番号コンテナを取得します。
   * @return 受給者番号コンテナ
   */
  protected ACLabelContainer getKaigoInfoReceiptNoContainer(){
    if(kaigoInfoReceiptNoContainer==null){
      kaigoInfoReceiptNoContainer = new ACLabelContainer();
      kaigoInfoReceiptNoContainer.setFollowChildEnabled(true);
      kaigoInfoReceiptNoContainer.setVAlignment(VRLayout.CENTER);
      kaigoInfoReceiptNoContainer.add(getKaigoInfoReceiptNo(), null);
    }
    return kaigoInfoReceiptNoContainer;
  }

  /**
   * 有効期間・コンテナを取得します。
   * @return 有効期間・コンテナ
   */
  public ACLabelContainer getKaigoInfoValidLimitContena(){
    if(kaigoInfoValidLimitContena==null){

      kaigoInfoValidLimitContena = new ACLabelContainer();

      kaigoInfoValidLimitContena.setText("有効期間");

      addKaigoInfoValidLimitContena();
    }
    return kaigoInfoValidLimitContena;

  }

  /**
   * 有効期間・テキスト1を取得します。
   * @return 有効期間・テキスト1
   */
  public QkanDateTextField getKaigoInfoValidLimit1(){
    if(kaigoInfoValidLimit1==null){

      kaigoInfoValidLimit1 = new QkanDateTextField();

      kaigoInfoValidLimit1.setBindPath("KOHI_VALID_START");

      kaigoInfoValidLimit1.setColumns(10);

      kaigoInfoValidLimit1.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      kaigoInfoValidLimit1.setMaxLength(11);

      addKaigoInfoValidLimit1();
    }
    return kaigoInfoValidLimit1;

  }

  /**
   * 有効期間・ラベルを取得します。
   * @return 有効期間・ラベル
   */
  public ACLabel getKaigoInfoValidLimitLabel(){
    if(kaigoInfoValidLimitLabel==null){

      kaigoInfoValidLimitLabel = new ACLabel();

      kaigoInfoValidLimitLabel.setText(" から ");

      addKaigoInfoValidLimitLabel();
    }
    return kaigoInfoValidLimitLabel;

  }

  /**
   * 有効期間・テキスト2を取得します。
   * @return 有効期間・テキスト2
   */
  public QkanDateTextField getKaigoInfoValidLimit2(){
    if(kaigoInfoValidLimit2==null){

      kaigoInfoValidLimit2 = new QkanDateTextField();

      kaigoInfoValidLimit2.setBindPath("KOHI_VALID_END");

      kaigoInfoValidLimit2.setColumns(10);

      kaigoInfoValidLimit2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      kaigoInfoValidLimit2.setMaxLength(11);

      addKaigoInfoValidLimit2();
    }
    return kaigoInfoValidLimit2;

  }

  /**
   * (自己負担額・コンテナ)を取得します。
   * @return (自己負担額・コンテナ)
   */
  public ACLabelContainer getKaigoInfoSelfPaymentContents(){
    if(kaigoInfoSelfPaymentContents==null){

      kaigoInfoSelfPaymentContents = new ACLabelContainer();

      kaigoInfoSelfPaymentContents.setText("自己負担額");

      addKaigoInfoSelfPaymentContents();
    }
    return kaigoInfoSelfPaymentContents;

  }

  /**
   * 自己負担額を取得します。
   * @return 自己負担額
   */
  public ACTextField getKaigoInfoSelfPayment(){
    if(kaigoInfoSelfPayment==null){

      kaigoInfoSelfPayment = new ACTextField();

      kaigoInfoSelfPayment.setBindPath("SELF_PAY");

      kaigoInfoSelfPayment.setColumns(5);

      kaigoInfoSelfPayment.setCharType(VRCharType.ONLY_DIGIT);

      kaigoInfoSelfPayment.setHorizontalAlignment(SwingConstants.RIGHT);

      kaigoInfoSelfPayment.setMaxLength(6);

      addKaigoInfoSelfPayment();
    }
    return kaigoInfoSelfPayment;

  }

  /**
   * 自己負担額ラベルを取得します。
   * @return 自己負担額ラベル
   */
  public ACLabel getKaigoInfoSelfPaymentYen(){
    if(kaigoInfoSelfPaymentYen==null){

      kaigoInfoSelfPaymentYen = new ACLabel();

      kaigoInfoSelfPaymentYen.setText(" 円");

      addKaigoInfoSelfPaymentYen();
    }
    return kaigoInfoSelfPaymentYen;

  }

  /**
   * 介護公費領域・ボタンを取得します。
   * @return 介護公費領域・ボタン
   */
  public ACPanel getKaigoInfoButtons(){
    if(kaigoInfoButtons==null){

      kaigoInfoButtons = new ACPanel();

      addKaigoInfoButtons();
    }
    return kaigoInfoButtons;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACButton getKaigoInfoButtonClear(){
    if(kaigoInfoButtonClear==null){

      kaigoInfoButtonClear = new ACButton();

      kaigoInfoButtonClear.setText("クリア");

      kaigoInfoButtonClear.setToolTipText("介護公費情報をクリアします。");

      kaigoInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addKaigoInfoButtonClear();
    }
    return kaigoInfoButtonClear;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getKaigoInfoButtonInsert(){
    if(kaigoInfoButtonInsert==null){

      kaigoInfoButtonInsert = new ACButton();

      kaigoInfoButtonInsert.setText("追加");

      kaigoInfoButtonInsert.setToolTipText("介護公費情報を追加します。");

      kaigoInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addKaigoInfoButtonInsert();
    }
    return kaigoInfoButtonInsert;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getKaigoInfoButtonConpile(){
    if(kaigoInfoButtonConpile==null){

      kaigoInfoButtonConpile = new ACButton();

      kaigoInfoButtonConpile.setText("書替");

      kaigoInfoButtonConpile.setToolTipText("介護公費情報を編集します。");

      kaigoInfoButtonConpile.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addKaigoInfoButtonConpile();
    }
    return kaigoInfoButtonConpile;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getKaigoInfoButtonDelete(){
    if(kaigoInfoButtonDelete==null){

      kaigoInfoButtonDelete = new ACButton();

      kaigoInfoButtonDelete.setText("削除");

      kaigoInfoButtonDelete.setToolTipText("介護公費情報を削除します。");

      kaigoInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addKaigoInfoButtonDelete();
    }
    return kaigoInfoButtonDelete;

  }

  /**
   * 介護公費領域・パネルを取得します。
   * @return 介護公費領域・パネル
   */
  public ACPanel getKaigoInfoTables(){
    if(kaigoInfoTables==null){

      kaigoInfoTables = new ACPanel();

      addKaigoInfoTables();
    }
    return kaigoInfoTables;

  }

  /**
   * 介護公費・テーブルを取得します。
   * @return 介護公費・テーブル
   */
  public ACTable getKaigoInfoTable(){
    if(kaigoInfoTable==null){

      kaigoInfoTable = new ACTable();

      kaigoInfoTable.setColumnModel(getKaigoInfoTableColumnModel());

      addKaigoInfoTable();
    }
    return kaigoInfoTable;

  }

  /**
   * 介護公費・テーブルカラムモデルを取得します。
   * @return 介護公費・テーブルカラムモデル
   */
  protected VRTableColumnModel getKaigoInfoTableColumnModel(){
    if(kaigoInfoTableColumnModel==null){
      kaigoInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addKaigoInfoTableColumnModel();
    }
    return kaigoInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getKaigoInfoTableColumn0(){
    if(kaigoInfoTableColumn0==null){

      kaigoInfoTableColumn0 = new ACTableColumn(0);

      kaigoInfoTableColumn0.setHeaderValue("No.");

      kaigoInfoTableColumn0.setColumns(3);

      kaigoInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      kaigoInfoTableColumn0.setSortable(false);

      addKaigoInfoTableColumn0();
    }
    return kaigoInfoTableColumn0;

  }

  /**
   * 公費情報を取得します。
   * @return 公費情報
   */
  public ACTableColumn getKaigoInfoTableColumn1(){
    if(kaigoInfoTableColumn1==null){

      kaigoInfoTableColumn1 = new ACTableColumn(0);

      kaigoInfoTableColumn1.setHeaderValue("公費情報");

      kaigoInfoTableColumn1.setColumns(22);

      addKaigoInfoTableColumn1();
    }
    return kaigoInfoTableColumn1;

  }

  /**
   * 給付率を取得します。
   * @return 給付率
   */
  public ACTableColumn getKaigoInfoTableColumn2(){
    if(kaigoInfoTableColumn2==null){

      kaigoInfoTableColumn2 = new ACTableColumn(1);

      kaigoInfoTableColumn2.setHeaderValue("給付率");

      kaigoInfoTableColumn2.setColumns(7);

      kaigoInfoTableColumn2.setHorizontalAlignment(SwingConstants.RIGHT);

      addKaigoInfoTableColumn2();
    }
    return kaigoInfoTableColumn2;

  }

  /**
   * 負担者番号を取得します。
   * @return 負担者番号
   */
  public ACTableColumn getKaigoInfoTableColumn3(){
    if(kaigoInfoTableColumn3==null){

      kaigoInfoTableColumn3 = new ACTableColumn(2);

      kaigoInfoTableColumn3.setHeaderValue("負担者番号");

      kaigoInfoTableColumn3.setColumns(8);

      addKaigoInfoTableColumn3();
    }
    return kaigoInfoTableColumn3;

  }

  /**
   * 受給者番号を取得します。
   * @return 受給者番号
   */
  public ACTableColumn getKaigoInfoTableColumn5(){
    if(kaigoInfoTableColumn5==null){

      kaigoInfoTableColumn5 = new ACTableColumn(4);

      kaigoInfoTableColumn5.setHeaderValue("受給者番号");

      kaigoInfoTableColumn5.setColumns(7);

      addKaigoInfoTableColumn5();
    }
    return kaigoInfoTableColumn5;

  }

  /**
   * 有効期間開始を取得します。
   * @return 有効期間開始
   */
  public ACTableColumn getKaigoInfoTableColumn6(){
    if(kaigoInfoTableColumn6==null){

      kaigoInfoTableColumn6 = new ACTableColumn(5);

      kaigoInfoTableColumn6.setHeaderValue("有効期間開始日");

      kaigoInfoTableColumn6.setColumns(12);

      kaigoInfoTableColumn6.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn6();
    }
    return kaigoInfoTableColumn6;

  }

  /**
   * 有効期間終了を取得します。
   * @return 有効期間終了
   */
  public ACTableColumn getKaigoInfoTableColumn7(){
    if(kaigoInfoTableColumn7==null){

      kaigoInfoTableColumn7 = new ACTableColumn(6);

      kaigoInfoTableColumn7.setHeaderValue("有効期間終了日");

      kaigoInfoTableColumn7.setColumns(12);

      kaigoInfoTableColumn7.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addKaigoInfoTableColumn7();
    }
    return kaigoInfoTableColumn7;

  }

  /**
   * 介護公費領域・サービスを取得します。
   * @return 介護公費領域・サービス
   */
  public ACPanel getKaigoInfoServices(){
    if(kaigoInfoServices==null){

      kaigoInfoServices = new ACPanel();

      kaigoInfoServices.setVisible(false);

      addKaigoInfoServices();
    }
    return kaigoInfoServices;

  }

  /**
   * サービス・グループを取得します。
   * @return サービス・グループ
   */
  public ACGroupBox getKaigoInfoService(){
    if(kaigoInfoService==null){

      kaigoInfoService = new ACGroupBox();

      kaigoInfoService.setText("給付対象サービス");

      kaigoInfoService.setAutoWrap(false);

      addKaigoInfoService();
    }
    return kaigoInfoService;

  }

  /**
   * 説明文ラベル・介護を取得します。
   * @return 説明文ラベル・介護
   */
  public ACLabel getKaigoInfoServiceComment(){
    if(kaigoInfoServiceComment==null){

      kaigoInfoServiceComment = new ACLabel();

      kaigoInfoServiceComment.setText("公費の対象となるサービスにチェックをつけてください。");

      kaigoInfoServiceComment.setIconPath(ACConstants.ICON_PATH_INFORMATION_16);

      addKaigoInfoServiceComment();
    }
    return kaigoInfoServiceComment;

  }

  /**
   * 公費・使用サービステーブルを取得します。
   * @return 公費・使用サービステーブル
   */
  public ACTable getKaigoInfoServiceTable(){
    if(kaigoInfoServiceTable==null){

      kaigoInfoServiceTable = new ACTable();

      kaigoInfoServiceTable.setColumns(36);

      kaigoInfoServiceTable.setColumnModel(getKaigoInfoServiceTableColumnModel());

      kaigoInfoServiceTable.setColumnSort(false);

      addKaigoInfoServiceTable();
    }
    return kaigoInfoServiceTable;

  }

  /**
   * 公費・使用サービステーブルカラムモデルを取得します。
   * @return 公費・使用サービステーブルカラムモデル
   */
  protected VRTableColumnModel getKaigoInfoServiceTableColumnModel(){
    if(kaigoInfoServiceTableColumnModel==null){
      kaigoInfoServiceTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addKaigoInfoServiceTableColumnModel();
    }
    return kaigoInfoServiceTableColumnModel;
  }

  /**
   * 列：提供を取得します。
   * @return 列：提供
   */
  public ACTableColumn getKaigoInfoServiceTableColumn1(){
    if(kaigoInfoServiceTableColumn1==null){

      kaigoInfoServiceTableColumn1 = new ACTableColumn(0);

      kaigoInfoServiceTableColumn1.setHeaderValue("提供");

      kaigoInfoServiceTableColumn1.setEditable(true);

      kaigoInfoServiceTableColumn1.setColumns(3);

      kaigoInfoServiceTableColumn1.setRendererType(VRTableCellViewer.RENDERER_TYPE_CHECK_BOX);

      kaigoInfoServiceTableColumn1.setEditorType(VRTableCellViewer.EDITOR_TYPE_CHECK_BOX);

      addKaigoInfoServiceTableColumn1();
    }
    return kaigoInfoServiceTableColumn1;

  }

  /**
   * 列：サービス種類を取得します。
   * @return 列：サービス種類
   */
  public ACTableColumn getKaigoInfoServiceTableColumn2(){
    if(kaigoInfoServiceTableColumn2==null){

      kaigoInfoServiceTableColumn2 = new ACTableColumn(1);

      kaigoInfoServiceTableColumn2.setHeaderValue("サービス種類");

      kaigoInfoServiceTableColumn2.setColumns(25);

      addKaigoInfoServiceTableColumn2();
    }
    return kaigoInfoServiceTableColumn2;

  }

  /**
   * 列：帳票種類を取得します。
   * @return 列：帳票種類
   */
  public ACTableColumn getKaigoInfoServiceTableColumn3(){
    if(kaigoInfoServiceTableColumn3==null){

      kaigoInfoServiceTableColumn3 = new ACTableColumn(2);

      kaigoInfoServiceTableColumn3.setHeaderValue("帳票種類");

      kaigoInfoServiceTableColumn3.setColumns(8);

      addKaigoInfoServiceTableColumn3();
    }
    return kaigoInfoServiceTableColumn3;

  }

  /**
   * 社会福祉軽減領域を取得します。
   * @return 社会福祉軽減領域
   */
  public ACPanel getPoints3(){
    if(points3==null){

      points3 = new ACPanel();

      points3.setLayout(getShahukuLayout());

      addPoints3();
    }
    return points3;

  }

  /**
   * 社会福祉軽減領域・レイアウトを取得します。
   * @return 社会福祉軽減領域・レイアウト
   */
  public VRLayout getShahukuLayout(){
    if(shahukuLayout==null){

      shahukuLayout = new VRLayout();

      shahukuLayout.setAutoWrap(false);

      addShahukuLayout();
    }
    return shahukuLayout;

  }

  /**
   * 社会福祉軽減領域・情報を取得します。
   * @return 社会福祉軽減領域・情報
   */
  public ACPanel getShahukuInfos(){
    if(shahukuInfos==null){

      shahukuInfos = new ACPanel();

      addShahukuInfos();
    }
    return shahukuInfos;

  }

  /**
   * 社会福祉軽減領域・情報2を取得します。
   * @return 社会福祉軽減領域・情報2
   */
  public ACPanel getShahukuInfo(){
    if(shahukuInfo==null){

      shahukuInfo = new ACPanel();

      addShahukuInfo();
    }
    return shahukuInfo;

  }

  /**
   * (減額割合・コンテナ)を取得します。
   * @return (減額割合・コンテナ)
   */
  public ACLabelContainer getShahukuInfoBenefitRateContena(){
    if(shahukuInfoBenefitRateContena==null){

      shahukuInfoBenefitRateContena = new ACLabelContainer();

      shahukuInfoBenefitRateContena.setText("減額割合");

      addShahukuInfoBenefitRateContena();
    }
    return shahukuInfoBenefitRateContena;

  }

  /**
   * 減額割合を取得します。
   * @return 減額割合
   */
  public ACTextField getShahukuInfoBenefitRate(){
    if(shahukuInfoBenefitRate==null){

      shahukuInfoBenefitRate = new ACTextField();

      shahukuInfoBenefitRate.setBindPath("LOOK");

      shahukuInfoBenefitRate.setColumns(3);

      shahukuInfoBenefitRate.setCharType(VRCharType.ONLY_FLOAT);

      shahukuInfoBenefitRate.setHorizontalAlignment(SwingConstants.RIGHT);

      shahukuInfoBenefitRate.setIMEMode(InputSubset.LATIN);

      shahukuInfoBenefitRate.setMaxLength(4);

      addShahukuInfoBenefitRate();
    }
    return shahukuInfoBenefitRate;

  }

  /**
   * 単位ラベルを取得します。
   * @return 単位ラベル
   */
  public ACLabel getShahukuInfoPercentLabel(){
    if(shahukuInfoPercentLabel==null){

      shahukuInfoPercentLabel = new ACLabel();

      shahukuInfoPercentLabel.setText(" ／100 ");

      addShahukuInfoPercentLabel();
    }
    return shahukuInfoPercentLabel;

  }

  /**
   * 有効期間・コンテナを取得します。
   * @return 有効期間・コンテナ
   */
  public ACLabelContainer getShahukuInfoValidLimitContena(){
    if(shahukuInfoValidLimitContena==null){

      shahukuInfoValidLimitContena = new ACLabelContainer();

      shahukuInfoValidLimitContena.setText("有効期間");

      addShahukuInfoValidLimitContena();
    }
    return shahukuInfoValidLimitContena;

  }

  /**
   * 有効期間・テキスト1を取得します。
   * @return 有効期間・テキスト1
   */
  public QkanDateTextField getShahukuInfoValidLimit1(){
    if(shahukuInfoValidLimit1==null){

      shahukuInfoValidLimit1 = new QkanDateTextField();

      shahukuInfoValidLimit1.setBindPath("KOHI_VALID_START");

      shahukuInfoValidLimit1.setColumns(10);

      shahukuInfoValidLimit1.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      shahukuInfoValidLimit1.setMaxLength(11);

      addShahukuInfoValidLimit1();
    }
    return shahukuInfoValidLimit1;

  }

  /**
   * 有効期間・ラベルを取得します。
   * @return 有効期間・ラベル
   */
  public ACLabel getShahukuInfoValidLimitLabel(){
    if(shahukuInfoValidLimitLabel==null){

      shahukuInfoValidLimitLabel = new ACLabel();

      shahukuInfoValidLimitLabel.setText(" から ");

      addShahukuInfoValidLimitLabel();
    }
    return shahukuInfoValidLimitLabel;

  }

  /**
   * 有効期間・テキスト2を取得します。
   * @return 有効期間・テキスト2
   */
  public QkanDateTextField getShahukuInfoValidLimit2(){
    if(shahukuInfoValidLimit2==null){

      shahukuInfoValidLimit2 = new QkanDateTextField();

      shahukuInfoValidLimit2.setBindPath("KOHI_VALID_END");

      shahukuInfoValidLimit2.setColumns(10);

      shahukuInfoValidLimit2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      shahukuInfoValidLimit2.setMaxLength(11);

      addShahukuInfoValidLimit2();
    }
    return shahukuInfoValidLimit2;

  }

  /**
   * 社会福祉軽減領域・ボタンを取得します。
   * @return 社会福祉軽減領域・ボタン
   */
  public ACPanel getShahukuInfoButtons(){
    if(shahukuInfoButtons==null){

      shahukuInfoButtons = new ACPanel();

      addShahukuInfoButtons();
    }
    return shahukuInfoButtons;

  }

  /**
   * クリアを取得します。
   * @return クリア
   */
  public ACButton getShahukuInfoButtonClear(){
    if(shahukuInfoButtonClear==null){

      shahukuInfoButtonClear = new ACButton();

      shahukuInfoButtonClear.setText("クリア");

      shahukuInfoButtonClear.setToolTipText("社会福祉軽減情報をクリアします。");

      shahukuInfoButtonClear.setIconPath(ACConstants.ICON_PATH_CLEAR_16);

      addShahukuInfoButtonClear();
    }
    return shahukuInfoButtonClear;

  }

  /**
   * 追加を取得します。
   * @return 追加
   */
  public ACButton getShahukuInfoButtonInsert(){
    if(shahukuInfoButtonInsert==null){

      shahukuInfoButtonInsert = new ACButton();

      shahukuInfoButtonInsert.setText("追加");

      shahukuInfoButtonInsert.setToolTipText("社会福祉軽減情報を追加します。");

      shahukuInfoButtonInsert.setIconPath(ACConstants.ICON_PATH_RECORD_DOWNLOAD_16);

      addShahukuInfoButtonInsert();
    }
    return shahukuInfoButtonInsert;

  }

  /**
   * 書替を取得します。
   * @return 書替
   */
  public ACButton getShahukuInfoButtonConpile(){
    if(shahukuInfoButtonConpile==null){

      shahukuInfoButtonConpile = new ACButton();

      shahukuInfoButtonConpile.setText("書替");

      shahukuInfoButtonConpile.setToolTipText("社会福祉軽減情報を編集します。");

      shahukuInfoButtonConpile.setIconPath(ACConstants.ICON_PATH_STATE_UPDATE_16);

      addShahukuInfoButtonConpile();
    }
    return shahukuInfoButtonConpile;

  }

  /**
   * 削除を取得します。
   * @return 削除
   */
  public ACButton getShahukuInfoButtonDelete(){
    if(shahukuInfoButtonDelete==null){

      shahukuInfoButtonDelete = new ACButton();

      shahukuInfoButtonDelete.setText("削除");

      shahukuInfoButtonDelete.setToolTipText("社会福祉軽減情報を削除します。");

      shahukuInfoButtonDelete.setIconPath(ACConstants.ICON_PATH_STATE_DELETE_16);

      addShahukuInfoButtonDelete();
    }
    return shahukuInfoButtonDelete;

  }

  /**
   * 社会福祉軽減領域・テーブルを取得します。
   * @return 社会福祉軽減領域・テーブル
   */
  public ACPanel getShahukuInfoTables(){
    if(shahukuInfoTables==null){

      shahukuInfoTables = new ACPanel();

      addShahukuInfoTables();
    }
    return shahukuInfoTables;

  }

  /**
   * 社会福祉軽減領域・テーブルを取得します。
   * @return 社会福祉軽減領域・テーブル
   */
  public ACTable getShahukuInfoTable(){
    if(shahukuInfoTable==null){

      shahukuInfoTable = new ACTable();

      shahukuInfoTable.setColumnModel(getShahukuInfoTableColumnModel());

      addShahukuInfoTable();
    }
    return shahukuInfoTable;

  }

  /**
   * 社会福祉軽減領域・テーブルカラムモデルを取得します。
   * @return 社会福祉軽減領域・テーブルカラムモデル
   */
  protected VRTableColumnModel getShahukuInfoTableColumnModel(){
    if(shahukuInfoTableColumnModel==null){
      shahukuInfoTableColumnModel = new VRTableColumnModel(new TableColumn[]{});
      addShahukuInfoTableColumnModel();
    }
    return shahukuInfoTableColumnModel;
  }

  /**
   * No.を取得します。
   * @return No.
   */
  public ACTableColumn getShahukuInfoTableColumn0(){
    if(shahukuInfoTableColumn0==null){

      shahukuInfoTableColumn0 = new ACTableColumn(0);

      shahukuInfoTableColumn0.setHeaderValue("No.");

      shahukuInfoTableColumn0.setColumns(3);

      shahukuInfoTableColumn0.setRendererType(ACTableCellViewer.RENDERER_TYPE_SERIAL_NO);

      shahukuInfoTableColumn0.setSortable(false);

      addShahukuInfoTableColumn0();
    }
    return shahukuInfoTableColumn0;

  }

  /**
   * 給付率を取得します。
   * @return 給付率
   */
  public ACTableColumn getShahukuInfoTableColumn1(){
    if(shahukuInfoTableColumn1==null){

      shahukuInfoTableColumn1 = new ACTableColumn(0);

      shahukuInfoTableColumn1.setHeaderValue("減額割合");

      shahukuInfoTableColumn1.setColumns(7);

      shahukuInfoTableColumn1.setHorizontalAlignment(SwingConstants.RIGHT);

      addShahukuInfoTableColumn1();
    }
    return shahukuInfoTableColumn1;

  }

  /**
   * 有効期間開始を取得します。
   * @return 有効期間開始
   */
  public ACTableColumn getShahukuInfoTableColumn2(){
    if(shahukuInfoTableColumn2==null){

      shahukuInfoTableColumn2 = new ACTableColumn(1);

      shahukuInfoTableColumn2.setHeaderValue("有効期間開始日");

      shahukuInfoTableColumn2.setColumns(12);

      shahukuInfoTableColumn2.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addShahukuInfoTableColumn2();
    }
    return shahukuInfoTableColumn2;

  }

  /**
   * 有効期間終了を取得します。
   * @return 有効期間終了
   */
  public ACTableColumn getShahukuInfoTableColumn3(){
    if(shahukuInfoTableColumn3==null){

      shahukuInfoTableColumn3 = new ACTableColumn(2);

      shahukuInfoTableColumn3.setHeaderValue("有効期間終了日");

      shahukuInfoTableColumn3.setColumns(12);

      shahukuInfoTableColumn3.setFormat(new ACBorderBlankDateFormat("gggee年MM月dd日"));

      addShahukuInfoTableColumn3();
    }
    return shahukuInfoTableColumn3;

  }

  /**
   * コンストラクタです。
   */
  public QU004Design() {

    try {
      initialize();

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

    this.add(getButtons(), VRLayout.NORTH);

    this.add(getContents(), VRLayout.CLIENT);

  }

  /**
   * 業務ボタンバーに内部項目を追加します。
   */
  protected void addButtons(){

    buttons.add(getUpdate(), VRLayout.EAST);
    buttons.add(getInsert(), VRLayout.EAST);
  }

  /**
   * 登録に内部項目を追加します。
   */
  protected void addInsert(){

  }

  /**
   * 更新に内部項目を追加します。
   */
  protected void addUpdate(){

  }

  /**
   * クライアント領域に内部項目を追加します。
   */
  protected void addContents(){

    contents.add(getPatientInfo(), VRLayout.NORTH);

    contents.add(getTabs(), VRLayout.CLIENT);

  }

  /**
   * 利用者名領域に内部項目を追加します。
   */
  protected void addPatientInfo(){

    patientInfo.add(getPatientNameCaption(), VRLayout.FLOW);

    patientInfo.add(getPatientName(), VRLayout.FLOW);

  }

  /**
   * 利用者名キャプションに内部項目を追加します。
   */
  protected void addPatientNameCaption(){

  }

  /**
   * 利用者名に内部項目を追加します。
   */
  protected void addPatientName(){

  }

  /**
   * タブに内部項目を追加します。
   */
  protected void addTabs(){

    tabs.addTab("介護公費", getPoints1());

    tabs.addTab("社福軽減", getPoints3());

  }

  /**
   * 介護公費領域に内部項目を追加します。
   */
  protected void addPoints1(){

    points1.add(getKaigoInfos(), VRLayout.CLIENT);

    points1.add(getKaigoInfoServices(), VRLayout.EAST);
  }

  /**
   * 介護公費領域・レイアウトに内部項目を追加します。
   */
  protected void addKaigoLayout(){

  }

  /**
   * 介護公費領域・情報に内部項目を追加します。
   */
  protected void addKaigoInfos(){

    kaigoInfos.add(getKaigoInfo(), VRLayout.NORTH);

    kaigoInfos.add(getKaigoInfoButtons(), VRLayout.NORTH);

    kaigoInfos.add(getKaigoInfoTables(), VRLayout.CLIENT);

  }

  /**
   * 介護公費領域・情報2に内部項目を追加します。
   */
  protected void addKaigoInfo(){

    kaigoInfo.add(getKaigoInfoPublicExpenseContainer(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoBenefitRateContena(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoBearNoContena(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoBearNameContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoReceiptNoContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    kaigoInfo.add(getKaigoInfoValidLimitContena(), VRLayout.FLOW_INSETLINE);

    kaigoInfo.add(getKaigoInfoSelfPaymentContents(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 公費情報に内部項目を追加します。
   */
  protected void addKaigoInfoPublicExpense(){

  }

  /**
   * 公費情報モデルに内部項目を追加します。
   */
  protected void addKaigoInfoPublicExpenseModel(){

  }

  /**
   * (給付率・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoBenefitRateContena(){

    kaigoInfoBenefitRateContena.add(getKaigoInfoBenefitRate(), VRLayout.FLOW);

    kaigoInfoBenefitRateContena.add(getKaigoInfoPercentLabel(), VRLayout.FLOW);

  }

  /**
   * 給付率に内部項目を追加します。
   */
  protected void addKaigoInfoBenefitRate(){

  }

  /**
   * %ラベルに内部項目を追加します。
   */
  protected void addKaigoInfoPercentLabel(){

  }

  /**
   * (負担者番号・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoBearNoContena(){

    kaigoInfoBearNoContena.add(getKaigoInfoKohiNo(), VRLayout.FLOW);

    kaigoInfoBearNoContena.add(getKaigoInfoInsurerNo(), VRLayout.FLOW);

  }

  /**
   * 公費法別番号に内部項目を追加します。
   */
  protected void addKaigoInfoKohiNo(){

  }

  /**
   * 保険者番号に内部項目を追加します。
   */
  protected void addKaigoInfoInsurerNo(){

  }

  /**
   * 負担者名に内部項目を追加します。
   */
  protected void addKaigoInfoBearName(){

  }

  /**
   * 負担者名モデルに内部項目を追加します。
   */
  protected void addKaigoInfoBearNameModel(){

  }

  /**
   * 受給者番号に内部項目を追加します。
   */
  protected void addKaigoInfoReceiptNo(){

  }

  /**
   * 有効期間・コンテナに内部項目を追加します。
   */
  protected void addKaigoInfoValidLimitContena(){

    kaigoInfoValidLimitContena.add(getKaigoInfoValidLimit1(), VRLayout.FLOW);

    kaigoInfoValidLimitContena.add(getKaigoInfoValidLimitLabel(), VRLayout.FLOW);

    kaigoInfoValidLimitContena.add(getKaigoInfoValidLimit2(), VRLayout.FLOW);

  }

  /**
   * 有効期間・テキスト1に内部項目を追加します。
   */
  protected void addKaigoInfoValidLimit1(){

  }

  /**
   * 有効期間・ラベルに内部項目を追加します。
   */
  protected void addKaigoInfoValidLimitLabel(){

  }

  /**
   * 有効期間・テキスト2に内部項目を追加します。
   */
  protected void addKaigoInfoValidLimit2(){

  }

  /**
   * (自己負担額・コンテナ)に内部項目を追加します。
   */
  protected void addKaigoInfoSelfPaymentContents(){

    kaigoInfoSelfPaymentContents.add(getKaigoInfoSelfPayment(), VRLayout.FLOW);

    kaigoInfoSelfPaymentContents.add(getKaigoInfoSelfPaymentYen(), VRLayout.FLOW);

  }

  /**
   * 自己負担額に内部項目を追加します。
   */
  protected void addKaigoInfoSelfPayment(){

  }

  /**
   * 自己負担額ラベルに内部項目を追加します。
   */
  protected void addKaigoInfoSelfPaymentYen(){

  }

  /**
   * 介護公費領域・ボタンに内部項目を追加します。
   */
  protected void addKaigoInfoButtons(){

    kaigoInfoButtons.add(getKaigoInfoButtonDelete(), VRLayout.EAST);
    kaigoInfoButtons.add(getKaigoInfoButtonConpile(), VRLayout.EAST);
    kaigoInfoButtons.add(getKaigoInfoButtonInsert(), VRLayout.EAST);
    kaigoInfoButtons.add(getKaigoInfoButtonClear(), VRLayout.EAST);
  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addKaigoInfoButtonClear(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addKaigoInfoButtonInsert(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addKaigoInfoButtonConpile(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addKaigoInfoButtonDelete(){

  }

  /**
   * 介護公費領域・パネルに内部項目を追加します。
   */
  protected void addKaigoInfoTables(){

    kaigoInfoTables.add(getKaigoInfoTable(), VRLayout.CLIENT);

  }

  /**
   * 介護公費・テーブルに内部項目を追加します。
   */
  protected void addKaigoInfoTable(){

  }

  /**
   * 介護公費・テーブルカラムモデルに内部項目を追加します。
   */
  protected void addKaigoInfoTableColumnModel(){

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn0());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn1());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn2());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn3());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn5());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn6());

    getKaigoInfoTableColumnModel().addColumn(getKaigoInfoTableColumn7());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn0(){

  }

  /**
   * 公費情報に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn1(){

  }

  /**
   * 給付率に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn2(){

  }

  /**
   * 負担者番号に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn3(){

  }

  /**
   * 受給者番号に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn5(){

  }

  /**
   * 有効期間開始に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn6(){

  }

  /**
   * 有効期間終了に内部項目を追加します。
   */
  protected void addKaigoInfoTableColumn7(){

  }

  /**
   * 介護公費領域・サービスに内部項目を追加します。
   */
  protected void addKaigoInfoServices(){

    kaigoInfoServices.add(getKaigoInfoService(), VRLayout.CLIENT);

  }

  /**
   * サービス・グループに内部項目を追加します。
   */
  protected void addKaigoInfoService(){

    kaigoInfoService.add(getKaigoInfoServiceComment(), VRLayout.NORTH);

    kaigoInfoService.add(getKaigoInfoServiceTable(), VRLayout.CLIENT);

  }

  /**
   * 説明文ラベル・介護に内部項目を追加します。
   */
  protected void addKaigoInfoServiceComment(){

  }

  /**
   * 公費・使用サービステーブルに内部項目を追加します。
   */
  protected void addKaigoInfoServiceTable(){

  }

  /**
   * 公費・使用サービステーブルカラムモデルに内部項目を追加します。
   */
  protected void addKaigoInfoServiceTableColumnModel(){

    getKaigoInfoServiceTableColumnModel().addColumn(getKaigoInfoServiceTableColumn1());

    getKaigoInfoServiceTableColumnModel().addColumn(getKaigoInfoServiceTableColumn2());

    getKaigoInfoServiceTableColumnModel().addColumn(getKaigoInfoServiceTableColumn3());

  }

  /**
   * 列：提供に内部項目を追加します。
   */
  protected void addKaigoInfoServiceTableColumn1(){

  }

  /**
   * 列：サービス種類に内部項目を追加します。
   */
  protected void addKaigoInfoServiceTableColumn2(){

  }

  /**
   * 列：帳票種類に内部項目を追加します。
   */
  protected void addKaigoInfoServiceTableColumn3(){

  }

  /**
   * 社会福祉軽減領域に内部項目を追加します。
   */
  protected void addPoints3(){

    points3.add(getShahukuInfos(), VRLayout.CLIENT);

  }

  /**
   * 社会福祉軽減領域・レイアウトに内部項目を追加します。
   */
  protected void addShahukuLayout(){

  }

  /**
   * 社会福祉軽減領域・情報に内部項目を追加します。
   */
  protected void addShahukuInfos(){

    shahukuInfos.add(getShahukuInfo(), VRLayout.NORTH);

    shahukuInfos.add(getShahukuInfoButtons(), VRLayout.NORTH);

    shahukuInfos.add(getShahukuInfoTables(), VRLayout.CLIENT);

  }

  /**
   * 社会福祉軽減領域・情報2に内部項目を追加します。
   */
  protected void addShahukuInfo(){

    shahukuInfo.add(getShahukuInfoBenefitRateContena(), VRLayout.FLOW_INSETLINE_RETURN);

    shahukuInfo.add(getShahukuInfoValidLimitContena(), VRLayout.FLOW_INSETLINE);

  }

  /**
   * (減額割合・コンテナ)に内部項目を追加します。
   */
  protected void addShahukuInfoBenefitRateContena(){

    shahukuInfoBenefitRateContena.add(getShahukuInfoBenefitRate(), VRLayout.FLOW);

    shahukuInfoBenefitRateContena.add(getShahukuInfoPercentLabel(), VRLayout.FLOW);

  }

  /**
   * 減額割合に内部項目を追加します。
   */
  protected void addShahukuInfoBenefitRate(){

  }

  /**
   * 単位ラベルに内部項目を追加します。
   */
  protected void addShahukuInfoPercentLabel(){

  }

  /**
   * 有効期間・コンテナに内部項目を追加します。
   */
  protected void addShahukuInfoValidLimitContena(){

    shahukuInfoValidLimitContena.add(getShahukuInfoValidLimit1(), VRLayout.FLOW);

    shahukuInfoValidLimitContena.add(getShahukuInfoValidLimitLabel(), VRLayout.FLOW);

    shahukuInfoValidLimitContena.add(getShahukuInfoValidLimit2(), VRLayout.FLOW);

  }

  /**
   * 有効期間・テキスト1に内部項目を追加します。
   */
  protected void addShahukuInfoValidLimit1(){

  }

  /**
   * 有効期間・ラベルに内部項目を追加します。
   */
  protected void addShahukuInfoValidLimitLabel(){

  }

  /**
   * 有効期間・テキスト2に内部項目を追加します。
   */
  protected void addShahukuInfoValidLimit2(){

  }

  /**
   * 社会福祉軽減領域・ボタンに内部項目を追加します。
   */
  protected void addShahukuInfoButtons(){

    shahukuInfoButtons.add(getShahukuInfoButtonDelete(), VRLayout.EAST);
    shahukuInfoButtons.add(getShahukuInfoButtonConpile(), VRLayout.EAST);
    shahukuInfoButtons.add(getShahukuInfoButtonInsert(), VRLayout.EAST);
    shahukuInfoButtons.add(getShahukuInfoButtonClear(), VRLayout.EAST);
  }

  /**
   * クリアに内部項目を追加します。
   */
  protected void addShahukuInfoButtonClear(){

  }

  /**
   * 追加に内部項目を追加します。
   */
  protected void addShahukuInfoButtonInsert(){

  }

  /**
   * 書替に内部項目を追加します。
   */
  protected void addShahukuInfoButtonConpile(){

  }

  /**
   * 削除に内部項目を追加します。
   */
  protected void addShahukuInfoButtonDelete(){

  }

  /**
   * 社会福祉軽減領域・テーブルに内部項目を追加します。
   */
  protected void addShahukuInfoTables(){

    shahukuInfoTables.add(getShahukuInfoTable(), VRLayout.CLIENT);

  }

  /**
   * 社会福祉軽減領域・テーブルに内部項目を追加します。
   */
  protected void addShahukuInfoTable(){

  }

  /**
   * 社会福祉軽減領域・テーブルカラムモデルに内部項目を追加します。
   */
  protected void addShahukuInfoTableColumnModel(){

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTableColumn0());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTableColumn1());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTableColumn2());

    getShahukuInfoTableColumnModel().addColumn(getShahukuInfoTableColumn3());

  }

  /**
   * No.に内部項目を追加します。
   */
  protected void addShahukuInfoTableColumn0(){

  }

  /**
   * 給付率に内部項目を追加します。
   */
  protected void addShahukuInfoTableColumn1(){

  }

  /**
   * 有効期間開始に内部項目を追加します。
   */
  protected void addShahukuInfoTableColumn2(){

  }

  /**
   * 有効期間終了に内部項目を追加します。
   */
  protected void addShahukuInfoTableColumn3(){

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
      ACFrame.getInstance().setFrameEventProcesser(new QkanFrameEventProcesser());
      ACFrame.debugStart(new ACAffairInfo(QU004Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QU004Design getThis() {
    return this;
  }
}
