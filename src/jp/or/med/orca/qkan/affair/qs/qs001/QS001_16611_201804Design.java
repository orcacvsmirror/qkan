
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
 * 作成日: 2018/02/12  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム サービス予定作成/変更 (S)
 * プロセス サービス予定週間 (001)
 * プログラム サービスパターン介護予防通所リハビリテーション (QS001_16611_201804)
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
 * サービスパターン介護予防通所リハビリテーション画面項目デザイン(QS001_16611_201804) 
 */
public class QS001_16611_201804Design extends QS001ServicePanel {
  //GUIコンポーネント

  private JTabbedPane preventiveExpertPlaceRihaMultiPatterns;

  private ACPanel tab1;

  private ACIntegerCheckBox crackOnDayCheck;

  private ACIntegerCheckBox printable;

  private ACValueArrayRadioButtonGroup facilitiesDivision;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

  private ACValueArrayRadioButtonGroup moveFunctionImprovementAddRadio;

  private ACLabelContainer moveFunctionImprovementAddRadioContainer;

  private ACListModelAdapter moveFunctionImprovementAddRadioModel;

  private ACRadioButtonItem moveFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem moveFunctionImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup nourishmentImprovementAddRadio;

  private ACLabelContainer nourishmentImprovementAddRadioContainer;

  private ACListModelAdapter nourishmentImprovementAddRadioModel;

  private ACRadioButtonItem nourishmentImprovementAddRadioItem1;

  private ACRadioButtonItem nourishmentImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup nutritionScreening;

  private ACLabelContainer nutritionScreeningContainer;

  private ACListModelAdapter nutritionScreeningModel;

  private ACRadioButtonItem nutritionScreeningItem1;

  private ACRadioButtonItem nutritionScreeningItem2;

  private ACValueArrayRadioButtonGroup mouthFunctionImprovementAddRadio;

  private ACLabelContainer mouthFunctionImprovementAddRadioContainer;

  private ACListModelAdapter mouthFunctionImprovementAddRadioModel;

  private ACRadioButtonItem mouthFunctionImprovementAddRadioItem1;

  private ACRadioButtonItem mouthFunctionImprovementAddRadioItem2;

  private ACValueArrayRadioButtonGroup sentakutekiServiceRadio;

  private ACLabelContainer sentakutekiServiceRadioContainer;

  private ACListModelAdapter sentakutekiServiceRadioModel;

  private ACRadioButtonItem sentakutekiServiceRadioItem1;

  private ACRadioButtonItem sentakutekiServiceRadioItem2;

  private ACRadioButtonItem sentakutekiServiceRadioItem3;

  private ACRadioButtonItem sentakutekiServiceRadioItem4;

  private ACRadioButtonItem sentakutekiServiceRadioItem5;

  private ACBackLabelContainer houmonKaigoTimeContainer;

  private ACTimeComboBox houmonKaigoBeginTime;

  private ACLabelContainer houmonKaigoBeginTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoBeginTimeModel;

  private ACTimeComboBox houmonKaigoEndTime;

  private ACLabelContainer houmonKaigoEndTimeContainer;

  private ACComboBoxModelAdapter houmonKaigoEndTimeModel;

  private ACPanel tab2;

  private ACValueArrayRadioButtonGroup staffSubtractionRadio;

  private ACLabelContainer staffSubtractionRadioContainer;

  private ACListModelAdapter staffSubtractionRadioModel;

  private ACRadioButtonItem staffSubtractionRadioItem1;

  private ACRadioButtonItem staffSubtractionRadioItem2;

  private ACRadioButtonItem staffSubtractionRadioItem3;

  private ACValueArrayRadioButtonGroup houmonRehabilitationManagementAddRadio;

  private ACLabelContainer houmonRehabilitationManagementAddRadioContainer;

  private ACListModelAdapter houmonRehabilitationManagementAddRadioModel;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem1;

  private ACRadioButtonItem houmonRehabilitationManagementAddRadioItem2;

  private ACValueArrayRadioButtonGroup lifeActsImproveRehabilitationRadioGroup;

  private ACLabelContainer lifeActsImproveRehabilitationRadioGroupContainer;

  private ACListModelAdapter lifeActsImproveRehabilitationRadioGroupModel;

  private ACRadioButtonItem lifeActsImproveRehabilitationRadioItem1;

  private ACRadioButtonItem lifeActsImproveRehabilitationRadioItem2;

  private ACRadioButtonItem lifeActsImproveRehabilitationRadioItem3;

  private ACValueArrayRadioButtonGroup lifeActsImproveRehaSubtractionRadioGroup;

  private ACLabelContainer lifeActsImproveRehaSubtractionRadioGroupContainer;

  private ACListModelAdapter lifeActsImproveRehaSubtractionRadioGroupModel;

  private ACRadioButtonItem lifeActsImproveRehaSubtractionRadioItem1;

  private ACRadioButtonItem lifeActsImproveRehaSubtractionRadioItem2;

  private ACValueArrayRadioButtonGroup youngDementiaPatinetAddRadioGroup;

  private ACLabelContainer youngDementiaPatinetAddRadioGroupContainer;

  private ACListModelAdapter youngDementiaPatinetAddRadioGroupModel;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem1;

  private ACRadioButtonItem youngDementiaPatinetAddRadioItem2;

  private ACValueArrayRadioButtonGroup providerAddMountainousAreaRadioGroup;

  private ACLabelContainer providerAddMountainousAreaRadioGroupContainer;

  private ACListModelAdapter providerAddMountainousAreaRadioGroupModel;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem1;

  private ACRadioButtonItem providerAddMountainousAreaRadioItem2;

  private ACValueArrayRadioButtonGroup transportationCallRadioGroup;

  private ACLabelContainer transportationCallRadioGroupContainer;

  private ACListModelAdapter transportationCallRadioGroupModel;

  private ACRadioButtonItem transportationCallRadioItem1;

  private ACRadioButtonItem transportationCallRadioItem2;

  private ACValueArrayRadioButtonGroup calculationDivision;

  private ACLabelContainer calculationDivisionContainer;

  private ACListModelAdapter calculationDivisionModel;

  private ACRadioButtonItem calculationDivisionNormal;

  private ACRadioButtonItem calculationDivisionAddOnly;

  private ACPanel tab3;

  private ACValueArrayRadioButtonGroup officeEvaluationAddRadio;

  private ACLabelContainer officeEvaluationAddRadioContainer;

  private ACListModelAdapter officeEvaluationAddRadioModel;

  private ACRadioButtonItem officeEvaluationAddRadioItem1;

  private ACRadioButtonItem officeEvaluationAddRadioItem2;

  private ACValueArrayRadioButtonGroup serviceAddProvisionStructuralRadioGroup;

  private ACLabelContainer serviceAddProvisionStructuralRadioGroupContainer;

  private ACListModelAdapter serviceAddProvisionStructuralRadioGroupModel;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem1;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem4;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem2;

  private ACRadioButtonItem serviceAddProvisionStructuralRadioItem3;

  private ACGroupBox infoGroup;

  private ACLabel infoLabelPlan;

  //getter

  /**
   * 介護予防通所リハビリテーションパターン領域を取得します。
   * @return 介護予防通所リハビリテーションパターン領域
   */
  public JTabbedPane getPreventiveExpertPlaceRihaMultiPatterns(){
    if(preventiveExpertPlaceRihaMultiPatterns==null){

      preventiveExpertPlaceRihaMultiPatterns = new JTabbedPane();

      addPreventiveExpertPlaceRihaMultiPatterns();
    }
    return preventiveExpertPlaceRihaMultiPatterns;

  }

  /**
   * タブ1を取得します。
   * @return タブ1
   */
  public ACPanel getTab1(){
    if(tab1==null){

      tab1 = new ACPanel();

      tab1.setFollowChildEnabled(true);

      tab1.setLabelMargin(0);

      tab1.setVgap(0);

      addTab1();
    }
    return tab1;

  }

  /**
   * 日割を取得します。
   * @return 日割
   */
  public ACIntegerCheckBox getCrackOnDayCheck(){
    if(crackOnDayCheck==null){

      crackOnDayCheck = new ACIntegerCheckBox();

      crackOnDayCheck.setText("日割");

      crackOnDayCheck.setBindPath("1660102");

      crackOnDayCheck.setSelectValue(2);

      crackOnDayCheck.setUnSelectValue(1);

      addCrackOnDayCheck();
    }
    return crackOnDayCheck;

  }

  /**
   * 提供日を取得します。
   * @return 提供日
   */
  public ACIntegerCheckBox getPrintable(){
    if(printable==null){

      printable = new ACIntegerCheckBox();

      printable.setText("提供日");

      printable.setBindPath("15");

      printable.setSelectValue(2);

      printable.setUnSelectValue(1);

      addPrintable();
    }
    return printable;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACValueArrayRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACValueArrayRadioButtonGroup();

      getFacilitiesDivisionContainer().setText("施設等の区分");

      facilitiesDivision.setBindPath("1660110");

      facilitiesDivision.setUseClearButton(false);

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setValues(new int[]{1,2,3});

      addFacilitiesDivision();
    }
    return facilitiesDivision;

  }

  /**
   * 施設区分ラジオグループコンテナを取得します。
   * @return 施設区分ラジオグループコンテナ
   */
  protected ACLabelContainer getFacilitiesDivisionContainer(){
    if(facilitiesDivisionContainer==null){
      facilitiesDivisionContainer = new ACLabelContainer();
      facilitiesDivisionContainer.setFollowChildEnabled(true);
      facilitiesDivisionContainer.setVAlignment(VRLayout.CENTER);
      facilitiesDivisionContainer.add(getFacilitiesDivision(), null);
    }
    return facilitiesDivisionContainer;
  }

  /**
   * 施設区分ラジオグループモデルを取得します。
   * @return 施設区分ラジオグループモデル
   */
  protected ACListModelAdapter getFacilitiesDivisionModel(){
    if(facilitiesDivisionModel==null){
      facilitiesDivisionModel = new ACListModelAdapter();
      addFacilitiesDivisionModel();
    }
    return facilitiesDivisionModel;
  }

  /**
   * 病院又は診療所を取得します。
   * @return 病院又は診療所
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("病院又は診療所");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * 介護老人保健施設を取得します。
   * @return 介護老人保健施設
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("介護老人保健施設");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW_RETURN);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * 介護医療院を取得します。
   * @return 介護医療院
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("介護医療院");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * 運動器機能向上加算を取得します。
   * @return 運動器機能向上加算
   */
  public ACValueArrayRadioButtonGroup getMoveFunctionImprovementAddRadio(){
    if(moveFunctionImprovementAddRadio==null){

      moveFunctionImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getMoveFunctionImprovementAddRadioContainer().setText("運動器機能向上加算");

      moveFunctionImprovementAddRadio.setBindPath("1660103");

      moveFunctionImprovementAddRadio.setUseClearButton(false);

      moveFunctionImprovementAddRadio.setModel(getMoveFunctionImprovementAddRadioModel());

      moveFunctionImprovementAddRadio.setValues(new int[]{1,2});

      addMoveFunctionImprovementAddRadio();
    }
    return moveFunctionImprovementAddRadio;

  }

  /**
   * 運動器機能向上加算コンテナを取得します。
   * @return 運動器機能向上加算コンテナ
   */
  protected ACLabelContainer getMoveFunctionImprovementAddRadioContainer(){
    if(moveFunctionImprovementAddRadioContainer==null){
      moveFunctionImprovementAddRadioContainer = new ACLabelContainer();
      moveFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      moveFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      moveFunctionImprovementAddRadioContainer.add(getMoveFunctionImprovementAddRadio(), null);
    }
    return moveFunctionImprovementAddRadioContainer;
  }

  /**
   * 運動器機能向上加算モデルを取得します。
   * @return 運動器機能向上加算モデル
   */
  protected ACListModelAdapter getMoveFunctionImprovementAddRadioModel(){
    if(moveFunctionImprovementAddRadioModel==null){
      moveFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addMoveFunctionImprovementAddRadioModel();
    }
    return moveFunctionImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMoveFunctionImprovementAddRadioItem1(){
    if(moveFunctionImprovementAddRadioItem1==null){

      moveFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      moveFunctionImprovementAddRadioItem1.setText("なし");

      moveFunctionImprovementAddRadioItem1.setGroup(getMoveFunctionImprovementAddRadio());

      moveFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMoveFunctionImprovementAddRadioItem1();
    }
    return moveFunctionImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMoveFunctionImprovementAddRadioItem2(){
    if(moveFunctionImprovementAddRadioItem2==null){

      moveFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      moveFunctionImprovementAddRadioItem2.setText("あり");

      moveFunctionImprovementAddRadioItem2.setGroup(getMoveFunctionImprovementAddRadio());

      moveFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMoveFunctionImprovementAddRadioItem2();
    }
    return moveFunctionImprovementAddRadioItem2;

  }

  /**
   * 栄養改善加算を取得します。
   * @return 栄養改善加算
   */
  public ACValueArrayRadioButtonGroup getNourishmentImprovementAddRadio(){
    if(nourishmentImprovementAddRadio==null){

      nourishmentImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getNourishmentImprovementAddRadioContainer().setText("栄養改善加算");

      nourishmentImprovementAddRadio.setBindPath("1660104");

      nourishmentImprovementAddRadio.setUseClearButton(false);

      nourishmentImprovementAddRadio.setModel(getNourishmentImprovementAddRadioModel());

      nourishmentImprovementAddRadio.setValues(new int[]{1,2});

      addNourishmentImprovementAddRadio();
    }
    return nourishmentImprovementAddRadio;

  }

  /**
   * 栄養改善加算コンテナを取得します。
   * @return 栄養改善加算コンテナ
   */
  protected ACLabelContainer getNourishmentImprovementAddRadioContainer(){
    if(nourishmentImprovementAddRadioContainer==null){
      nourishmentImprovementAddRadioContainer = new ACLabelContainer();
      nourishmentImprovementAddRadioContainer.setFollowChildEnabled(true);
      nourishmentImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      nourishmentImprovementAddRadioContainer.add(getNourishmentImprovementAddRadio(), null);
    }
    return nourishmentImprovementAddRadioContainer;
  }

  /**
   * 栄養改善加算モデルを取得します。
   * @return 栄養改善加算モデル
   */
  protected ACListModelAdapter getNourishmentImprovementAddRadioModel(){
    if(nourishmentImprovementAddRadioModel==null){
      nourishmentImprovementAddRadioModel = new ACListModelAdapter();
      addNourishmentImprovementAddRadioModel();
    }
    return nourishmentImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNourishmentImprovementAddRadioItem1(){
    if(nourishmentImprovementAddRadioItem1==null){

      nourishmentImprovementAddRadioItem1 = new ACRadioButtonItem();

      nourishmentImprovementAddRadioItem1.setText("なし");

      nourishmentImprovementAddRadioItem1.setGroup(getNourishmentImprovementAddRadio());

      nourishmentImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementAddRadioItem1();
    }
    return nourishmentImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNourishmentImprovementAddRadioItem2(){
    if(nourishmentImprovementAddRadioItem2==null){

      nourishmentImprovementAddRadioItem2 = new ACRadioButtonItem();

      nourishmentImprovementAddRadioItem2.setText("あり");

      nourishmentImprovementAddRadioItem2.setGroup(getNourishmentImprovementAddRadio());

      nourishmentImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addNourishmentImprovementAddRadioItem2();
    }
    return nourishmentImprovementAddRadioItem2;

  }

  /**
   * 栄養スクリーニング加算を取得します。
   * @return 栄養スクリーニング加算
   */
  public ACValueArrayRadioButtonGroup getNutritionScreening(){
    if(nutritionScreening==null){

      nutritionScreening = new ACValueArrayRadioButtonGroup();

      getNutritionScreeningContainer().setText("栄養スクリーニング加算");

      nutritionScreening.setBindPath("1660112");

      nutritionScreening.setUseClearButton(false);

      nutritionScreening.setModel(getNutritionScreeningModel());

      nutritionScreening.setValues(new int[]{1,2});

      addNutritionScreening();
    }
    return nutritionScreening;

  }

  /**
   * 栄養スクリーニング加算コンテナを取得します。
   * @return 栄養スクリーニング加算コンテナ
   */
  protected ACLabelContainer getNutritionScreeningContainer(){
    if(nutritionScreeningContainer==null){
      nutritionScreeningContainer = new ACLabelContainer();
      nutritionScreeningContainer.setFollowChildEnabled(true);
      nutritionScreeningContainer.setVAlignment(VRLayout.CENTER);
      nutritionScreeningContainer.add(getNutritionScreening(), null);
    }
    return nutritionScreeningContainer;
  }

  /**
   * 栄養スクリーニング加算モデルを取得します。
   * @return 栄養スクリーニング加算モデル
   */
  protected ACListModelAdapter getNutritionScreeningModel(){
    if(nutritionScreeningModel==null){
      nutritionScreeningModel = new ACListModelAdapter();
      addNutritionScreeningModel();
    }
    return nutritionScreeningModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNutritionScreeningItem1(){
    if(nutritionScreeningItem1==null){

      nutritionScreeningItem1 = new ACRadioButtonItem();

      nutritionScreeningItem1.setText("なし");

      nutritionScreeningItem1.setGroup(getNutritionScreening());

      addNutritionScreeningItem1();
    }
    return nutritionScreeningItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNutritionScreeningItem2(){
    if(nutritionScreeningItem2==null){

      nutritionScreeningItem2 = new ACRadioButtonItem();

      nutritionScreeningItem2.setText("あり");

      nutritionScreeningItem2.setGroup(getNutritionScreening());

      addNutritionScreeningItem2();
    }
    return nutritionScreeningItem2;

  }

  /**
   * 口腔機能向上加算を取得します。
   * @return 口腔機能向上加算
   */
  public ACValueArrayRadioButtonGroup getMouthFunctionImprovementAddRadio(){
    if(mouthFunctionImprovementAddRadio==null){

      mouthFunctionImprovementAddRadio = new ACValueArrayRadioButtonGroup();

      getMouthFunctionImprovementAddRadioContainer().setText("口腔機能向上加算");

      mouthFunctionImprovementAddRadio.setBindPath("1660105");

      mouthFunctionImprovementAddRadio.setUseClearButton(false);

      mouthFunctionImprovementAddRadio.setModel(getMouthFunctionImprovementAddRadioModel());

      mouthFunctionImprovementAddRadio.setValues(new int[]{1,2});

      addMouthFunctionImprovementAddRadio();
    }
    return mouthFunctionImprovementAddRadio;

  }

  /**
   * 口腔機能向上加算コンテナを取得します。
   * @return 口腔機能向上加算コンテナ
   */
  protected ACLabelContainer getMouthFunctionImprovementAddRadioContainer(){
    if(mouthFunctionImprovementAddRadioContainer==null){
      mouthFunctionImprovementAddRadioContainer = new ACLabelContainer();
      mouthFunctionImprovementAddRadioContainer.setFollowChildEnabled(true);
      mouthFunctionImprovementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      mouthFunctionImprovementAddRadioContainer.add(getMouthFunctionImprovementAddRadio(), null);
    }
    return mouthFunctionImprovementAddRadioContainer;
  }

  /**
   * 口腔機能向上加算モデルを取得します。
   * @return 口腔機能向上加算モデル
   */
  protected ACListModelAdapter getMouthFunctionImprovementAddRadioModel(){
    if(mouthFunctionImprovementAddRadioModel==null){
      mouthFunctionImprovementAddRadioModel = new ACListModelAdapter();
      addMouthFunctionImprovementAddRadioModel();
    }
    return mouthFunctionImprovementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMouthFunctionImprovementAddRadioItem1(){
    if(mouthFunctionImprovementAddRadioItem1==null){

      mouthFunctionImprovementAddRadioItem1 = new ACRadioButtonItem();

      mouthFunctionImprovementAddRadioItem1.setText("なし");

      mouthFunctionImprovementAddRadioItem1.setGroup(getMouthFunctionImprovementAddRadio());

      mouthFunctionImprovementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addMouthFunctionImprovementAddRadioItem1();
    }
    return mouthFunctionImprovementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMouthFunctionImprovementAddRadioItem2(){
    if(mouthFunctionImprovementAddRadioItem2==null){

      mouthFunctionImprovementAddRadioItem2 = new ACRadioButtonItem();

      mouthFunctionImprovementAddRadioItem2.setText("あり");

      mouthFunctionImprovementAddRadioItem2.setGroup(getMouthFunctionImprovementAddRadio());

      mouthFunctionImprovementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addMouthFunctionImprovementAddRadioItem2();
    }
    return mouthFunctionImprovementAddRadioItem2;

  }

  /**
   * 選択的サービス複数実施加算を取得します。
   * @return 選択的サービス複数実施加算
   */
  public ACValueArrayRadioButtonGroup getSentakutekiServiceRadio(){
    if(sentakutekiServiceRadio==null){

      sentakutekiServiceRadio = new ACValueArrayRadioButtonGroup();

      getSentakutekiServiceRadioContainer().setText("選択的サービス" + ACConstants.LINE_SEPARATOR + "複数実施加算");

      sentakutekiServiceRadio.setBindPath("1660111");

      sentakutekiServiceRadio.setUseClearButton(false);

      sentakutekiServiceRadio.setModel(getSentakutekiServiceRadioModel());

      sentakutekiServiceRadio.setValues(new int[]{1,2,3,4,5});

      addSentakutekiServiceRadio();
    }
    return sentakutekiServiceRadio;

  }

  /**
   * 選択的サービス複数実施加算コンテナを取得します。
   * @return 選択的サービス複数実施加算コンテナ
   */
  protected ACLabelContainer getSentakutekiServiceRadioContainer(){
    if(sentakutekiServiceRadioContainer==null){
      sentakutekiServiceRadioContainer = new ACLabelContainer();
      sentakutekiServiceRadioContainer.setFollowChildEnabled(true);
      sentakutekiServiceRadioContainer.setVAlignment(VRLayout.CENTER);
      sentakutekiServiceRadioContainer.add(getSentakutekiServiceRadio(), null);
    }
    return sentakutekiServiceRadioContainer;
  }

  /**
   * 選択的サービス複数実施加算モデルを取得します。
   * @return 選択的サービス複数実施加算モデル
   */
  protected ACListModelAdapter getSentakutekiServiceRadioModel(){
    if(sentakutekiServiceRadioModel==null){
      sentakutekiServiceRadioModel = new ACListModelAdapter();
      addSentakutekiServiceRadioModel();
    }
    return sentakutekiServiceRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getSentakutekiServiceRadioItem1(){
    if(sentakutekiServiceRadioItem1==null){

      sentakutekiServiceRadioItem1 = new ACRadioButtonItem();

      sentakutekiServiceRadioItem1.setText("なし");

      sentakutekiServiceRadioItem1.setGroup(getSentakutekiServiceRadio());

      sentakutekiServiceRadioItem1.setConstraints(VRLayout.FLOW);

      addSentakutekiServiceRadioItem1();
    }
    return sentakutekiServiceRadioItem1;

  }

  /**
   * I1を取得します。
   * @return I1
   */
  public ACRadioButtonItem getSentakutekiServiceRadioItem2(){
    if(sentakutekiServiceRadioItem2==null){

      sentakutekiServiceRadioItem2 = new ACRadioButtonItem();

      sentakutekiServiceRadioItem2.setText("I1");

      sentakutekiServiceRadioItem2.setGroup(getSentakutekiServiceRadio());

      sentakutekiServiceRadioItem2.setConstraints(VRLayout.FLOW);

      addSentakutekiServiceRadioItem2();
    }
    return sentakutekiServiceRadioItem2;

  }

  /**
   * I2を取得します。
   * @return I2
   */
  public ACRadioButtonItem getSentakutekiServiceRadioItem3(){
    if(sentakutekiServiceRadioItem3==null){

      sentakutekiServiceRadioItem3 = new ACRadioButtonItem();

      sentakutekiServiceRadioItem3.setText("I2");

      sentakutekiServiceRadioItem3.setGroup(getSentakutekiServiceRadio());

      sentakutekiServiceRadioItem3.setConstraints(VRLayout.FLOW);

      addSentakutekiServiceRadioItem3();
    }
    return sentakutekiServiceRadioItem3;

  }

  /**
   * I3を取得します。
   * @return I3
   */
  public ACRadioButtonItem getSentakutekiServiceRadioItem4(){
    if(sentakutekiServiceRadioItem4==null){

      sentakutekiServiceRadioItem4 = new ACRadioButtonItem();

      sentakutekiServiceRadioItem4.setText("I3");

      sentakutekiServiceRadioItem4.setGroup(getSentakutekiServiceRadio());

      sentakutekiServiceRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addSentakutekiServiceRadioItem4();
    }
    return sentakutekiServiceRadioItem4;

  }

  /**
   * IIを取得します。
   * @return II
   */
  public ACRadioButtonItem getSentakutekiServiceRadioItem5(){
    if(sentakutekiServiceRadioItem5==null){

      sentakutekiServiceRadioItem5 = new ACRadioButtonItem();

      sentakutekiServiceRadioItem5.setText("II");

      sentakutekiServiceRadioItem5.setGroup(getSentakutekiServiceRadio());

      sentakutekiServiceRadioItem5.setConstraints(VRLayout.FLOW);

      addSentakutekiServiceRadioItem5();
    }
    return sentakutekiServiceRadioItem5;

  }

  /**
   * 提供時間コンテナを取得します。
   * @return 提供時間コンテナ
   */
  public ACBackLabelContainer getHoumonKaigoTimeContainer(){
    if(houmonKaigoTimeContainer==null){

      houmonKaigoTimeContainer = new ACBackLabelContainer();

      houmonKaigoTimeContainer.setFollowChildEnabled(true);

      addHoumonKaigoTimeContainer();
    }
    return houmonKaigoTimeContainer;

  }

  /**
   * 開始時刻コンボを取得します。
   * @return 開始時刻コンボ
   */
  public ACTimeComboBox getHoumonKaigoBeginTime(){
    if(houmonKaigoBeginTime==null){

      houmonKaigoBeginTime = new ACTimeComboBox();

      getHoumonKaigoBeginTimeContainer().setText("開始時刻");

      houmonKaigoBeginTime.setBindPath("3");

      houmonKaigoBeginTime.setModelBindPath("3");

      houmonKaigoBeginTime.setRenderBindPath("CONTENT");

      houmonKaigoBeginTime.setModel(getHoumonKaigoBeginTimeModel());

      addHoumonKaigoBeginTime();
    }
    return houmonKaigoBeginTime;

  }

  /**
   * 開始時刻コンボコンテナを取得します。
   * @return 開始時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonKaigoBeginTimeContainer(){
    if(houmonKaigoBeginTimeContainer==null){
      houmonKaigoBeginTimeContainer = new ACLabelContainer();
      houmonKaigoBeginTimeContainer.setFollowChildEnabled(true);
      houmonKaigoBeginTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoBeginTimeContainer.add(getHoumonKaigoBeginTime(), null);
    }
    return houmonKaigoBeginTimeContainer;
  }

  /**
   * 開始時刻コンボモデルを取得します。
   * @return 開始時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonKaigoBeginTimeModel(){
    if(houmonKaigoBeginTimeModel==null){
      houmonKaigoBeginTimeModel = new ACComboBoxModelAdapter();
      addHoumonKaigoBeginTimeModel();
    }
    return houmonKaigoBeginTimeModel;
  }

  /**
   * 終了時刻コンボを取得します。
   * @return 終了時刻コンボ
   */
  public ACTimeComboBox getHoumonKaigoEndTime(){
    if(houmonKaigoEndTime==null){

      houmonKaigoEndTime = new ACTimeComboBox();

      getHoumonKaigoEndTimeContainer().setText("終了時刻");

      houmonKaigoEndTime.setBindPath("4");

      houmonKaigoEndTime.setModelBindPath("4");

      houmonKaigoEndTime.setRenderBindPath("CONTENT");

      houmonKaigoEndTime.setModel(getHoumonKaigoEndTimeModel());

      addHoumonKaigoEndTime();
    }
    return houmonKaigoEndTime;

  }

  /**
   * 終了時刻コンボコンテナを取得します。
   * @return 終了時刻コンボコンテナ
   */
  protected ACLabelContainer getHoumonKaigoEndTimeContainer(){
    if(houmonKaigoEndTimeContainer==null){
      houmonKaigoEndTimeContainer = new ACLabelContainer();
      houmonKaigoEndTimeContainer.setFollowChildEnabled(true);
      houmonKaigoEndTimeContainer.setVAlignment(VRLayout.CENTER);
      houmonKaigoEndTimeContainer.add(getHoumonKaigoEndTime(), null);
    }
    return houmonKaigoEndTimeContainer;
  }

  /**
   * 終了時刻コンボモデルを取得します。
   * @return 終了時刻コンボモデル
   */
  protected ACComboBoxModelAdapter getHoumonKaigoEndTimeModel(){
    if(houmonKaigoEndTimeModel==null){
      houmonKaigoEndTimeModel = new ACComboBoxModelAdapter();
      addHoumonKaigoEndTimeModel();
    }
    return houmonKaigoEndTimeModel;
  }

  /**
   * タブ2を取得します。
   * @return タブ2
   */
  public ACPanel getTab2(){
    if(tab2==null){

      tab2 = new ACPanel();

      tab2.setFollowChildEnabled(true);

      tab2.setHgap(0);

      tab2.setLabelMargin(0);

      tab2.setVgap(0);

      addTab2();
    }
    return tab2;

  }

  /**
   * 人員減算を取得します。
   * @return 人員減算
   */
  public ACValueArrayRadioButtonGroup getStaffSubtractionRadio(){
    if(staffSubtractionRadio==null){

      staffSubtractionRadio = new ACValueArrayRadioButtonGroup();

      getStaffSubtractionRadioContainer().setText("人員減算");

      staffSubtractionRadio.setBindPath("1660101");

      staffSubtractionRadio.setUseClearButton(false);

      staffSubtractionRadio.setModel(getStaffSubtractionRadioModel());

      staffSubtractionRadio.setValues(new int[]{1,2,3});

      addStaffSubtractionRadio();
    }
    return staffSubtractionRadio;

  }

  /**
   * 人員減算コンテナを取得します。
   * @return 人員減算コンテナ
   */
  protected ACLabelContainer getStaffSubtractionRadioContainer(){
    if(staffSubtractionRadioContainer==null){
      staffSubtractionRadioContainer = new ACLabelContainer();
      staffSubtractionRadioContainer.setFollowChildEnabled(true);
      staffSubtractionRadioContainer.setVAlignment(VRLayout.CENTER);
      staffSubtractionRadioContainer.add(getStaffSubtractionRadio(), null);
    }
    return staffSubtractionRadioContainer;
  }

  /**
   * 人員減算モデルを取得します。
   * @return 人員減算モデル
   */
  protected ACListModelAdapter getStaffSubtractionRadioModel(){
    if(staffSubtractionRadioModel==null){
      staffSubtractionRadioModel = new ACListModelAdapter();
      addStaffSubtractionRadioModel();
    }
    return staffSubtractionRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem1(){
    if(staffSubtractionRadioItem1==null){

      staffSubtractionRadioItem1 = new ACRadioButtonItem();

      staffSubtractionRadioItem1.setText("なし");

      staffSubtractionRadioItem1.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem1();
    }
    return staffSubtractionRadioItem1;

  }

  /**
   * 定員超過を取得します。
   * @return 定員超過
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem2(){
    if(staffSubtractionRadioItem2==null){

      staffSubtractionRadioItem2 = new ACRadioButtonItem();

      staffSubtractionRadioItem2.setText("定員超過");

      staffSubtractionRadioItem2.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem2.setConstraints(VRLayout.FLOW_INSETLINE_RETURN);

      addStaffSubtractionRadioItem2();
    }
    return staffSubtractionRadioItem2;

  }

  /**
   * 医師、PT・OT・ST、看護・介護職員の不足が欠員を取得します。
   * @return 医師、PT・OT・ST、看護・介護職員の不足が欠員
   */
  public ACRadioButtonItem getStaffSubtractionRadioItem3(){
    if(staffSubtractionRadioItem3==null){

      staffSubtractionRadioItem3 = new ACRadioButtonItem();

      staffSubtractionRadioItem3.setText("<html>医師、PT・OT・ST、<br>看護・介護職員が欠員</html>");

      staffSubtractionRadioItem3.setGroup(getStaffSubtractionRadio());

      staffSubtractionRadioItem3.setConstraints(VRLayout.FLOW);

      addStaffSubtractionRadioItem3();
    }
    return staffSubtractionRadioItem3;

  }

  /**
   * リハビリテーションマネジメント加算を取得します。
   * @return リハビリテーションマネジメント加算
   */
  public ACValueArrayRadioButtonGroup getHoumonRehabilitationManagementAddRadio(){
    if(houmonRehabilitationManagementAddRadio==null){

      houmonRehabilitationManagementAddRadio = new ACValueArrayRadioButtonGroup();

      getHoumonRehabilitationManagementAddRadioContainer().setText("<html>リハビリテーション<br>マネジメント加算<html>");

      houmonRehabilitationManagementAddRadio.setBindPath("1660113");

      houmonRehabilitationManagementAddRadio.setUseClearButton(false);

      houmonRehabilitationManagementAddRadio.setModel(getHoumonRehabilitationManagementAddRadioModel());

      houmonRehabilitationManagementAddRadio.setValues(new int[]{1,2});

      addHoumonRehabilitationManagementAddRadio();
    }
    return houmonRehabilitationManagementAddRadio;

  }

  /**
   * リハビリテーションマネジメント加算コンテナを取得します。
   * @return リハビリテーションマネジメント加算コンテナ
   */
  protected ACLabelContainer getHoumonRehabilitationManagementAddRadioContainer(){
    if(houmonRehabilitationManagementAddRadioContainer==null){
      houmonRehabilitationManagementAddRadioContainer = new ACLabelContainer();
      houmonRehabilitationManagementAddRadioContainer.setFollowChildEnabled(true);
      houmonRehabilitationManagementAddRadioContainer.setVAlignment(VRLayout.CENTER);
      houmonRehabilitationManagementAddRadioContainer.add(getHoumonRehabilitationManagementAddRadio(), null);
    }
    return houmonRehabilitationManagementAddRadioContainer;
  }

  /**
   * リハビリテーションマネジメント加算モデルを取得します。
   * @return リハビリテーションマネジメント加算モデル
   */
  protected ACListModelAdapter getHoumonRehabilitationManagementAddRadioModel(){
    if(houmonRehabilitationManagementAddRadioModel==null){
      houmonRehabilitationManagementAddRadioModel = new ACListModelAdapter();
      addHoumonRehabilitationManagementAddRadioModel();
    }
    return houmonRehabilitationManagementAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem1(){
    if(houmonRehabilitationManagementAddRadioItem1==null){

      houmonRehabilitationManagementAddRadioItem1 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem1.setText("なし");

      houmonRehabilitationManagementAddRadioItem1.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem1.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem1();
    }
    return houmonRehabilitationManagementAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getHoumonRehabilitationManagementAddRadioItem2(){
    if(houmonRehabilitationManagementAddRadioItem2==null){

      houmonRehabilitationManagementAddRadioItem2 = new ACRadioButtonItem();

      houmonRehabilitationManagementAddRadioItem2.setText("あり");

      houmonRehabilitationManagementAddRadioItem2.setGroup(getHoumonRehabilitationManagementAddRadio());

      houmonRehabilitationManagementAddRadioItem2.setConstraints(VRLayout.FLOW);

      addHoumonRehabilitationManagementAddRadioItem2();
    }
    return houmonRehabilitationManagementAddRadioItem2;

  }

  /**
   * 生活行為向上リハビリ実施加算を取得します。
   * @return 生活行為向上リハビリ実施加算
   */
  public ACValueArrayRadioButtonGroup getLifeActsImproveRehabilitationRadioGroup(){
    if(lifeActsImproveRehabilitationRadioGroup==null){

      lifeActsImproveRehabilitationRadioGroup = new ACValueArrayRadioButtonGroup();

      getLifeActsImproveRehabilitationRadioGroupContainer().setText("生活行為向上リハビリ実施加算");

      lifeActsImproveRehabilitationRadioGroup.setBindPath("1660114");

      lifeActsImproveRehabilitationRadioGroup.setUseClearButton(false);

      lifeActsImproveRehabilitationRadioGroup.setModel(getLifeActsImproveRehabilitationRadioGroupModel());

      lifeActsImproveRehabilitationRadioGroup.setValues(new int[]{1,2,3});

      addLifeActsImproveRehabilitationRadioGroup();
    }
    return lifeActsImproveRehabilitationRadioGroup;

  }

  /**
   * 生活行為向上リハビリ実施加算コンテナを取得します。
   * @return 生活行為向上リハビリ実施加算コンテナ
   */
  protected ACLabelContainer getLifeActsImproveRehabilitationRadioGroupContainer(){
    if(lifeActsImproveRehabilitationRadioGroupContainer==null){
      lifeActsImproveRehabilitationRadioGroupContainer = new ACLabelContainer();
      lifeActsImproveRehabilitationRadioGroupContainer.setFollowChildEnabled(true);
      lifeActsImproveRehabilitationRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      lifeActsImproveRehabilitationRadioGroupContainer.add(getLifeActsImproveRehabilitationRadioGroup(), null);
    }
    return lifeActsImproveRehabilitationRadioGroupContainer;
  }

  /**
   * 生活行為向上リハビリ実施加算モデルを取得します。
   * @return 生活行為向上リハビリ実施加算モデル
   */
  protected ACListModelAdapter getLifeActsImproveRehabilitationRadioGroupModel(){
    if(lifeActsImproveRehabilitationRadioGroupModel==null){
      lifeActsImproveRehabilitationRadioGroupModel = new ACListModelAdapter();
      addLifeActsImproveRehabilitationRadioGroupModel();
    }
    return lifeActsImproveRehabilitationRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getLifeActsImproveRehabilitationRadioItem1(){
    if(lifeActsImproveRehabilitationRadioItem1==null){

      lifeActsImproveRehabilitationRadioItem1 = new ACRadioButtonItem();

      lifeActsImproveRehabilitationRadioItem1.setText("なし");

      lifeActsImproveRehabilitationRadioItem1.setGroup(getLifeActsImproveRehabilitationRadioGroup());

      lifeActsImproveRehabilitationRadioItem1.setConstraints(VRLayout.FLOW);

      addLifeActsImproveRehabilitationRadioItem1();
    }
    return lifeActsImproveRehabilitationRadioItem1;

  }

  /**
   * 3月以内を取得します。
   * @return 3月以内
   */
  public ACRadioButtonItem getLifeActsImproveRehabilitationRadioItem2(){
    if(lifeActsImproveRehabilitationRadioItem2==null){

      lifeActsImproveRehabilitationRadioItem2 = new ACRadioButtonItem();

      lifeActsImproveRehabilitationRadioItem2.setText("3月以内");

      lifeActsImproveRehabilitationRadioItem2.setGroup(getLifeActsImproveRehabilitationRadioGroup());

      lifeActsImproveRehabilitationRadioItem2.setConstraints(VRLayout.FLOW_RETURN);

      addLifeActsImproveRehabilitationRadioItem2();
    }
    return lifeActsImproveRehabilitationRadioItem2;

  }

  /**
   * 3月超6月以内を取得します。
   * @return 3月超6月以内
   */
  public ACRadioButtonItem getLifeActsImproveRehabilitationRadioItem3(){
    if(lifeActsImproveRehabilitationRadioItem3==null){

      lifeActsImproveRehabilitationRadioItem3 = new ACRadioButtonItem();

      lifeActsImproveRehabilitationRadioItem3.setText("3月超6月以内");

      lifeActsImproveRehabilitationRadioItem3.setGroup(getLifeActsImproveRehabilitationRadioGroup());

      lifeActsImproveRehabilitationRadioItem3.setConstraints(VRLayout.FLOW_RETURN);

      addLifeActsImproveRehabilitationRadioItem3();
    }
    return lifeActsImproveRehabilitationRadioItem3;

  }

  /**
   * 生活行為向上リハビリテーション後の継続減算を取得します。
   * @return 生活行為向上リハビリテーション後の継続減算
   */
  public ACValueArrayRadioButtonGroup getLifeActsImproveRehaSubtractionRadioGroup(){
    if(lifeActsImproveRehaSubtractionRadioGroup==null){

      lifeActsImproveRehaSubtractionRadioGroup = new ACValueArrayRadioButtonGroup();

      getLifeActsImproveRehaSubtractionRadioGroupContainer().setText("生活行為向上リハビリ後の継続減算");

      lifeActsImproveRehaSubtractionRadioGroup.setBindPath("1660115");

      lifeActsImproveRehaSubtractionRadioGroup.setVisible(true);

      lifeActsImproveRehaSubtractionRadioGroup.setEnabled(true);

      lifeActsImproveRehaSubtractionRadioGroup.setNoSelectIndex(0);

      lifeActsImproveRehaSubtractionRadioGroup.setUseClearButton(false);

      lifeActsImproveRehaSubtractionRadioGroup.setModel(getLifeActsImproveRehaSubtractionRadioGroupModel());

      lifeActsImproveRehaSubtractionRadioGroup.setValues(new int[]{1,2});

      addLifeActsImproveRehaSubtractionRadioGroup();
    }
    return lifeActsImproveRehaSubtractionRadioGroup;

  }

  /**
   * 生活行為向上リハビリテーション後の継続減算コンテナを取得します。
   * @return 生活行為向上リハビリテーション後の継続減算コンテナ
   */
  protected ACLabelContainer getLifeActsImproveRehaSubtractionRadioGroupContainer(){
    if(lifeActsImproveRehaSubtractionRadioGroupContainer==null){
      lifeActsImproveRehaSubtractionRadioGroupContainer = new ACLabelContainer();
      lifeActsImproveRehaSubtractionRadioGroupContainer.setFollowChildEnabled(true);
      lifeActsImproveRehaSubtractionRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      lifeActsImproveRehaSubtractionRadioGroupContainer.add(getLifeActsImproveRehaSubtractionRadioGroup(), null);
    }
    return lifeActsImproveRehaSubtractionRadioGroupContainer;
  }

  /**
   * 生活行為向上リハビリテーション後の継続減算モデルを取得します。
   * @return 生活行為向上リハビリテーション後の継続減算モデル
   */
  protected ACListModelAdapter getLifeActsImproveRehaSubtractionRadioGroupModel(){
    if(lifeActsImproveRehaSubtractionRadioGroupModel==null){
      lifeActsImproveRehaSubtractionRadioGroupModel = new ACListModelAdapter();
      addLifeActsImproveRehaSubtractionRadioGroupModel();
    }
    return lifeActsImproveRehaSubtractionRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getLifeActsImproveRehaSubtractionRadioItem1(){
    if(lifeActsImproveRehaSubtractionRadioItem1==null){

      lifeActsImproveRehaSubtractionRadioItem1 = new ACRadioButtonItem();

      lifeActsImproveRehaSubtractionRadioItem1.setText("なし");

      lifeActsImproveRehaSubtractionRadioItem1.setGroup(getLifeActsImproveRehaSubtractionRadioGroup());

      lifeActsImproveRehaSubtractionRadioItem1.setConstraints(VRLayout.FLOW);

      addLifeActsImproveRehaSubtractionRadioItem1();
    }
    return lifeActsImproveRehaSubtractionRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getLifeActsImproveRehaSubtractionRadioItem2(){
    if(lifeActsImproveRehaSubtractionRadioItem2==null){

      lifeActsImproveRehaSubtractionRadioItem2 = new ACRadioButtonItem();

      lifeActsImproveRehaSubtractionRadioItem2.setText("あり");

      lifeActsImproveRehaSubtractionRadioItem2.setGroup(getLifeActsImproveRehaSubtractionRadioGroup());

      lifeActsImproveRehaSubtractionRadioItem2.setConstraints(VRLayout.FLOW);

      addLifeActsImproveRehaSubtractionRadioItem2();
    }
    return lifeActsImproveRehaSubtractionRadioItem2;

  }

  /**
   * 若年性認知症利用者受入加算を取得します。
   * @return 若年性認知症利用者受入加算
   */
  public ACValueArrayRadioButtonGroup getYoungDementiaPatinetAddRadioGroup(){
    if(youngDementiaPatinetAddRadioGroup==null){

      youngDementiaPatinetAddRadioGroup = new ACValueArrayRadioButtonGroup();

      getYoungDementiaPatinetAddRadioGroupContainer().setText("若年性認知症利用者受入加算");

      youngDementiaPatinetAddRadioGroup.setBindPath("1660107");

      youngDementiaPatinetAddRadioGroup.setNoSelectIndex(0);

      youngDementiaPatinetAddRadioGroup.setUseClearButton(false);

      youngDementiaPatinetAddRadioGroup.setModel(getYoungDementiaPatinetAddRadioGroupModel());

      youngDementiaPatinetAddRadioGroup.setValues(new int[]{1,2});

      addYoungDementiaPatinetAddRadioGroup();
    }
    return youngDementiaPatinetAddRadioGroup;

  }

  /**
   * 若年性認知症利用者受入加算コンテナを取得します。
   * @return 若年性認知症利用者受入加算コンテナ
   */
  protected ACLabelContainer getYoungDementiaPatinetAddRadioGroupContainer(){
    if(youngDementiaPatinetAddRadioGroupContainer==null){
      youngDementiaPatinetAddRadioGroupContainer = new ACLabelContainer();
      youngDementiaPatinetAddRadioGroupContainer.setFollowChildEnabled(true);
      youngDementiaPatinetAddRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      youngDementiaPatinetAddRadioGroupContainer.add(getYoungDementiaPatinetAddRadioGroup(), null);
    }
    return youngDementiaPatinetAddRadioGroupContainer;
  }

  /**
   * 若年性認知症利用者受入加算モデルを取得します。
   * @return 若年性認知症利用者受入加算モデル
   */
  protected ACListModelAdapter getYoungDementiaPatinetAddRadioGroupModel(){
    if(youngDementiaPatinetAddRadioGroupModel==null){
      youngDementiaPatinetAddRadioGroupModel = new ACListModelAdapter();
      addYoungDementiaPatinetAddRadioGroupModel();
    }
    return youngDementiaPatinetAddRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem1(){
    if(youngDementiaPatinetAddRadioItem1==null){

      youngDementiaPatinetAddRadioItem1 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem1.setText("なし");

      youngDementiaPatinetAddRadioItem1.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem1.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem1();
    }
    return youngDementiaPatinetAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getYoungDementiaPatinetAddRadioItem2(){
    if(youngDementiaPatinetAddRadioItem2==null){

      youngDementiaPatinetAddRadioItem2 = new ACRadioButtonItem();

      youngDementiaPatinetAddRadioItem2.setText("あり");

      youngDementiaPatinetAddRadioItem2.setGroup(getYoungDementiaPatinetAddRadioGroup());

      youngDementiaPatinetAddRadioItem2.setConstraints(VRLayout.FLOW);

      addYoungDementiaPatinetAddRadioItem2();
    }
    return youngDementiaPatinetAddRadioItem2;

  }

  /**
   * 中山間地域等でのサービス提供加算を取得します。
   * @return 中山間地域等でのサービス提供加算
   */
  public ACValueArrayRadioButtonGroup getProviderAddMountainousAreaRadioGroup(){
    if(providerAddMountainousAreaRadioGroup==null){

      providerAddMountainousAreaRadioGroup = new ACValueArrayRadioButtonGroup();

      getProviderAddMountainousAreaRadioGroupContainer().setText("中山間地域等でのサービス提供加算");

      providerAddMountainousAreaRadioGroup.setBindPath("12");

      providerAddMountainousAreaRadioGroup.setNoSelectIndex(0);

      providerAddMountainousAreaRadioGroup.setUseClearButton(false);

      providerAddMountainousAreaRadioGroup.setModel(getProviderAddMountainousAreaRadioGroupModel());

      providerAddMountainousAreaRadioGroup.setValues(new int[]{1,2});

      addProviderAddMountainousAreaRadioGroup();
    }
    return providerAddMountainousAreaRadioGroup;

  }

  /**
   * 中山間地域等でのサービス提供加算コンテナを取得します。
   * @return 中山間地域等でのサービス提供加算コンテナ
   */
  protected ACLabelContainer getProviderAddMountainousAreaRadioGroupContainer(){
    if(providerAddMountainousAreaRadioGroupContainer==null){
      providerAddMountainousAreaRadioGroupContainer = new ACLabelContainer();
      providerAddMountainousAreaRadioGroupContainer.setFollowChildEnabled(true);
      providerAddMountainousAreaRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      providerAddMountainousAreaRadioGroupContainer.add(getProviderAddMountainousAreaRadioGroup(), null);
    }
    return providerAddMountainousAreaRadioGroupContainer;
  }

  /**
   * 中山間地域等でのサービス提供加算モデルを取得します。
   * @return 中山間地域等でのサービス提供加算モデル
   */
  protected ACListModelAdapter getProviderAddMountainousAreaRadioGroupModel(){
    if(providerAddMountainousAreaRadioGroupModel==null){
      providerAddMountainousAreaRadioGroupModel = new ACListModelAdapter();
      addProviderAddMountainousAreaRadioGroupModel();
    }
    return providerAddMountainousAreaRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRadioItem1(){
    if(providerAddMountainousAreaRadioItem1==null){

      providerAddMountainousAreaRadioItem1 = new ACRadioButtonItem();

      providerAddMountainousAreaRadioItem1.setText("なし");

      providerAddMountainousAreaRadioItem1.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaRadioItem1.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRadioItem1();
    }
    return providerAddMountainousAreaRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getProviderAddMountainousAreaRadioItem2(){
    if(providerAddMountainousAreaRadioItem2==null){

      providerAddMountainousAreaRadioItem2 = new ACRadioButtonItem();

      providerAddMountainousAreaRadioItem2.setText("あり");

      providerAddMountainousAreaRadioItem2.setGroup(getProviderAddMountainousAreaRadioGroup());

      providerAddMountainousAreaRadioItem2.setConstraints(VRLayout.FLOW);

      addProviderAddMountainousAreaRadioItem2();
    }
    return providerAddMountainousAreaRadioItem2;

  }

  /**
   * 同一建物居住者へのサービス提供を取得します。
   * @return 同一建物居住者へのサービス提供
   */
  public ACValueArrayRadioButtonGroup getTransportationCallRadioGroup(){
    if(transportationCallRadioGroup==null){

      transportationCallRadioGroup = new ACValueArrayRadioButtonGroup();

      getTransportationCallRadioGroupContainer().setText("同一建物居住者へのサービス提供");

      transportationCallRadioGroup.setBindPath("16");

      transportationCallRadioGroup.setNoSelectIndex(0);

      transportationCallRadioGroup.setUseClearButton(false);

      transportationCallRadioGroup.setModel(getTransportationCallRadioGroupModel());

      transportationCallRadioGroup.setValues(new int[]{1,2});

      addTransportationCallRadioGroup();
    }
    return transportationCallRadioGroup;

  }

  /**
   * 同一建物居住者へのサービス提供コンテナを取得します。
   * @return 同一建物居住者へのサービス提供コンテナ
   */
  protected ACLabelContainer getTransportationCallRadioGroupContainer(){
    if(transportationCallRadioGroupContainer==null){
      transportationCallRadioGroupContainer = new ACLabelContainer();
      transportationCallRadioGroupContainer.setFollowChildEnabled(true);
      transportationCallRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      transportationCallRadioGroupContainer.add(getTransportationCallRadioGroup(), null);
    }
    return transportationCallRadioGroupContainer;
  }

  /**
   * 同一建物居住者へのサービス提供モデルを取得します。
   * @return 同一建物居住者へのサービス提供モデル
   */
  protected ACListModelAdapter getTransportationCallRadioGroupModel(){
    if(transportationCallRadioGroupModel==null){
      transportationCallRadioGroupModel = new ACListModelAdapter();
      addTransportationCallRadioGroupModel();
    }
    return transportationCallRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getTransportationCallRadioItem1(){
    if(transportationCallRadioItem1==null){

      transportationCallRadioItem1 = new ACRadioButtonItem();

      transportationCallRadioItem1.setText("なし");

      transportationCallRadioItem1.setGroup(getTransportationCallRadioGroup());

      transportationCallRadioItem1.setConstraints(VRLayout.FLOW);

      addTransportationCallRadioItem1();
    }
    return transportationCallRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getTransportationCallRadioItem2(){
    if(transportationCallRadioItem2==null){

      transportationCallRadioItem2 = new ACRadioButtonItem();

      transportationCallRadioItem2.setText("あり");

      transportationCallRadioItem2.setGroup(getTransportationCallRadioGroup());

      transportationCallRadioItem2.setConstraints(VRLayout.FLOW);

      addTransportationCallRadioItem2();
    }
    return transportationCallRadioItem2;

  }

  /**
   * 算定区分を取得します。
   * @return 算定区分
   */
  public ACValueArrayRadioButtonGroup getCalculationDivision(){
    if(calculationDivision==null){

      calculationDivision = new ACValueArrayRadioButtonGroup();

      getCalculationDivisionContainer().setText("算定区分");

      calculationDivision.setBindPath("9");

      calculationDivision.setUseClearButton(false);

      calculationDivision.setModel(getCalculationDivisionModel());

      calculationDivision.setValues(new int[]{1,2});

      addCalculationDivision();
    }
    return calculationDivision;

  }

  /**
   * 算定区分コンテナを取得します。
   * @return 算定区分コンテナ
   */
  protected ACLabelContainer getCalculationDivisionContainer(){
    if(calculationDivisionContainer==null){
      calculationDivisionContainer = new ACLabelContainer();
      calculationDivisionContainer.setFollowChildEnabled(true);
      calculationDivisionContainer.setVAlignment(VRLayout.CENTER);
      calculationDivisionContainer.add(getCalculationDivision(), null);
    }
    return calculationDivisionContainer;
  }

  /**
   * 算定区分モデルを取得します。
   * @return 算定区分モデル
   */
  protected ACListModelAdapter getCalculationDivisionModel(){
    if(calculationDivisionModel==null){
      calculationDivisionModel = new ACListModelAdapter();
      addCalculationDivisionModel();
    }
    return calculationDivisionModel;
  }

  /**
   * 通常を取得します。
   * @return 通常
   */
  public ACRadioButtonItem getCalculationDivisionNormal(){
    if(calculationDivisionNormal==null){

      calculationDivisionNormal = new ACRadioButtonItem();

      calculationDivisionNormal.setText("通常");

      calculationDivisionNormal.setGroup(getCalculationDivision());

      calculationDivisionNormal.setConstraints(VRLayout.FLOW);

      addCalculationDivisionNormal();
    }
    return calculationDivisionNormal;

  }

  /**
   * 加算のみを取得します。
   * @return 加算のみ
   */
  public ACRadioButtonItem getCalculationDivisionAddOnly(){
    if(calculationDivisionAddOnly==null){

      calculationDivisionAddOnly = new ACRadioButtonItem();

      calculationDivisionAddOnly.setText("加算のみ");

      calculationDivisionAddOnly.setGroup(getCalculationDivision());

      calculationDivisionAddOnly.setConstraints(VRLayout.FLOW);

      addCalculationDivisionAddOnly();
    }
    return calculationDivisionAddOnly;

  }

  /**
   * タブ3を取得します。
   * @return タブ3
   */
  public ACPanel getTab3(){
    if(tab3==null){

      tab3 = new ACPanel();

      tab3.setFollowChildEnabled(true);

      tab3.setHgap(0);

      tab3.setLabelMargin(0);

      tab3.setVgap(0);

      addTab3();
    }
    return tab3;

  }

  /**
   * 事業所評価加算を取得します。
   * @return 事業所評価加算
   */
  public ACValueArrayRadioButtonGroup getOfficeEvaluationAddRadio(){
    if(officeEvaluationAddRadio==null){

      officeEvaluationAddRadio = new ACValueArrayRadioButtonGroup();

      getOfficeEvaluationAddRadioContainer().setText("事業所評価加算");

      officeEvaluationAddRadio.setBindPath("1660106");

      officeEvaluationAddRadio.setUseClearButton(false);

      officeEvaluationAddRadio.setModel(getOfficeEvaluationAddRadioModel());

      officeEvaluationAddRadio.setValues(new int[]{1,2});

      addOfficeEvaluationAddRadio();
    }
    return officeEvaluationAddRadio;

  }

  /**
   * 事業所評価加算コンテナを取得します。
   * @return 事業所評価加算コンテナ
   */
  protected ACLabelContainer getOfficeEvaluationAddRadioContainer(){
    if(officeEvaluationAddRadioContainer==null){
      officeEvaluationAddRadioContainer = new ACLabelContainer();
      officeEvaluationAddRadioContainer.setFollowChildEnabled(true);
      officeEvaluationAddRadioContainer.setVAlignment(VRLayout.CENTER);
      officeEvaluationAddRadioContainer.add(getOfficeEvaluationAddRadio(), null);
    }
    return officeEvaluationAddRadioContainer;
  }

  /**
   * 事業所評価加算モデルを取得します。
   * @return 事業所評価加算モデル
   */
  protected ACListModelAdapter getOfficeEvaluationAddRadioModel(){
    if(officeEvaluationAddRadioModel==null){
      officeEvaluationAddRadioModel = new ACListModelAdapter();
      addOfficeEvaluationAddRadioModel();
    }
    return officeEvaluationAddRadioModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getOfficeEvaluationAddRadioItem1(){
    if(officeEvaluationAddRadioItem1==null){

      officeEvaluationAddRadioItem1 = new ACRadioButtonItem();

      officeEvaluationAddRadioItem1.setText("なし");

      officeEvaluationAddRadioItem1.setGroup(getOfficeEvaluationAddRadio());

      officeEvaluationAddRadioItem1.setConstraints(VRLayout.FLOW);

      addOfficeEvaluationAddRadioItem1();
    }
    return officeEvaluationAddRadioItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getOfficeEvaluationAddRadioItem2(){
    if(officeEvaluationAddRadioItem2==null){

      officeEvaluationAddRadioItem2 = new ACRadioButtonItem();

      officeEvaluationAddRadioItem2.setText("あり");

      officeEvaluationAddRadioItem2.setGroup(getOfficeEvaluationAddRadio());

      officeEvaluationAddRadioItem2.setConstraints(VRLayout.FLOW);

      addOfficeEvaluationAddRadioItem2();
    }
    return officeEvaluationAddRadioItem2;

  }

  /**
   * サービス提供体制強化加算を取得します。
   * @return サービス提供体制強化加算
   */
  public ACValueArrayRadioButtonGroup getServiceAddProvisionStructuralRadioGroup(){
    if(serviceAddProvisionStructuralRadioGroup==null){

      serviceAddProvisionStructuralRadioGroup = new ACValueArrayRadioButtonGroup();

      getServiceAddProvisionStructuralRadioGroupContainer().setText("サービス提供体制強化加算");

      serviceAddProvisionStructuralRadioGroup.setBindPath("1660108");

      serviceAddProvisionStructuralRadioGroup.setNoSelectIndex(0);

      serviceAddProvisionStructuralRadioGroup.setUseClearButton(false);

      serviceAddProvisionStructuralRadioGroup.setModel(getServiceAddProvisionStructuralRadioGroupModel());

      serviceAddProvisionStructuralRadioGroup.setValues(new int[]{1,4,2,3});

      addServiceAddProvisionStructuralRadioGroup();
    }
    return serviceAddProvisionStructuralRadioGroup;

  }

  /**
   * サービス提供体制強化加算コンテナを取得します。
   * @return サービス提供体制強化加算コンテナ
   */
  protected ACLabelContainer getServiceAddProvisionStructuralRadioGroupContainer(){
    if(serviceAddProvisionStructuralRadioGroupContainer==null){
      serviceAddProvisionStructuralRadioGroupContainer = new ACLabelContainer();
      serviceAddProvisionStructuralRadioGroupContainer.setFollowChildEnabled(true);
      serviceAddProvisionStructuralRadioGroupContainer.setVAlignment(VRLayout.CENTER);
      serviceAddProvisionStructuralRadioGroupContainer.add(getServiceAddProvisionStructuralRadioGroup(), null);
    }
    return serviceAddProvisionStructuralRadioGroupContainer;
  }

  /**
   * サービス提供体制強化加算モデルを取得します。
   * @return サービス提供体制強化加算モデル
   */
  protected ACListModelAdapter getServiceAddProvisionStructuralRadioGroupModel(){
    if(serviceAddProvisionStructuralRadioGroupModel==null){
      serviceAddProvisionStructuralRadioGroupModel = new ACListModelAdapter();
      addServiceAddProvisionStructuralRadioGroupModel();
    }
    return serviceAddProvisionStructuralRadioGroupModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem1(){
    if(serviceAddProvisionStructuralRadioItem1==null){

      serviceAddProvisionStructuralRadioItem1 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem1.setText("なし");

      serviceAddProvisionStructuralRadioItem1.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem1.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem1();
    }
    return serviceAddProvisionStructuralRadioItem1;

  }

  /**
   * Iイ型を取得します。
   * @return Iイ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem4(){
    if(serviceAddProvisionStructuralRadioItem4==null){

      serviceAddProvisionStructuralRadioItem4 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem4.setText("Iイ型");

      serviceAddProvisionStructuralRadioItem4.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem4.setConstraints(VRLayout.FLOW_RETURN);

      addServiceAddProvisionStructuralRadioItem4();
    }
    return serviceAddProvisionStructuralRadioItem4;

  }

  /**
   * Iロ型を取得します。
   * @return Iロ型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem2(){
    if(serviceAddProvisionStructuralRadioItem2==null){

      serviceAddProvisionStructuralRadioItem2 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem2.setText("Iロ型");

      serviceAddProvisionStructuralRadioItem2.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem2.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem2();
    }
    return serviceAddProvisionStructuralRadioItem2;

  }

  /**
   * II型を取得します。
   * @return II型
   */
  public ACRadioButtonItem getServiceAddProvisionStructuralRadioItem3(){
    if(serviceAddProvisionStructuralRadioItem3==null){

      serviceAddProvisionStructuralRadioItem3 = new ACRadioButtonItem();

      serviceAddProvisionStructuralRadioItem3.setText("II型");

      serviceAddProvisionStructuralRadioItem3.setGroup(getServiceAddProvisionStructuralRadioGroup());

      serviceAddProvisionStructuralRadioItem3.setConstraints(VRLayout.FLOW);

      addServiceAddProvisionStructuralRadioItem3();
    }
    return serviceAddProvisionStructuralRadioItem3;

  }

  /**
   * 注意書きグループを取得します。
   * @return 注意書きグループ
   */
  public ACGroupBox getInfoGroup(){
    if(infoGroup==null){

      infoGroup = new ACGroupBox();

      infoGroup.setFollowChildEnabled(true);

      infoGroup.setHgap(0);

      infoGroup.setLabelMargin(0);

      infoGroup.setVgap(0);

      addInfoGroup();
    }
    return infoGroup;

  }

  /**
   * 注意書きラベルを取得します。
   * @return 注意書きラベル
   */
  public ACLabel getInfoLabelPlan(){
    if(infoLabelPlan==null){

      infoLabelPlan = new ACLabel();

      infoLabelPlan.setText("月途中で要支援1⇔要支援2の変更となる場合" + ACConstants.LINE_SEPARATOR + "(1) 各日割りサービスを全ての日数に貼り付け、" + ACConstants.LINE_SEPARATOR + "実際の提供日には『提供日』のチェックをつけ" + ACConstants.LINE_SEPARATOR + "〔設定〕ボタンをクリックしてください。" + ACConstants.LINE_SEPARATOR + "(2) サービス提供体制加算の算定は、まず全ての日数で" + ACConstants.LINE_SEPARATOR + "加算「なし」と貼り付け、次に月初(1日)のサービスを" + ACConstants.LINE_SEPARATOR + "クリック、加算(1型／2型）にチェックをつけ、" + ACConstants.LINE_SEPARATOR + "〔設定〕ボタンをクリックしてください。");

      addInfoLabelPlan();
    }
    return infoLabelPlan;

  }

  /**
   * コンストラクタです。
   */
  public QS001_16611_201804Design() {

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

    this.add(getPreventiveExpertPlaceRihaMultiPatterns(), VRLayout.CLIENT);

  }

  /**
   * 介護予防通所リハビリテーションパターン領域に内部項目を追加します。
   */
  protected void addPreventiveExpertPlaceRihaMultiPatterns(){

    preventiveExpertPlaceRihaMultiPatterns.addTab("1", getTab1());

    preventiveExpertPlaceRihaMultiPatterns.addTab("2", getTab2());

    preventiveExpertPlaceRihaMultiPatterns.addTab("3", getTab3());

  }

  /**
   * タブ1に内部項目を追加します。
   */
  protected void addTab1(){

    tab1.add(getCrackOnDayCheck(), VRLayout.FLOW);

    tab1.add(getPrintable(), VRLayout.FLOW_RETURN);

    tab1.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMoveFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNourishmentImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getNutritionScreeningContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getMouthFunctionImprovementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getSentakutekiServiceRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab1.add(getHoumonKaigoTimeContainer(), VRLayout.FLOW_DOUBLEINSETLINE_RETURN);

  }

  /**
   * 日割に内部項目を追加します。
   */
  protected void addCrackOnDayCheck(){

  }

  /**
   * 提供日に内部項目を追加します。
   */
  protected void addPrintable(){

  }

  /**
   * 施設区分ラジオグループに内部項目を追加します。
   */
  protected void addFacilitiesDivision(){

  }

  /**
   * 施設区分ラジオグループモデルに内部項目を追加します。
   */
  protected void addFacilitiesDivisionModel(){

    getFacilitiesDivisionItem1().setButtonIndex(1);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem1());

    getFacilitiesDivisionItem2().setButtonIndex(2);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem2());

    getFacilitiesDivisionItem3().setButtonIndex(3);

    getFacilitiesDivisionModel().add(getFacilitiesDivisionItem3());

  }

  /**
   * 病院又は診療所に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * 介護老人保健施設に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * 介護医療院に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * 運動器機能向上加算に内部項目を追加します。
   */
  protected void addMoveFunctionImprovementAddRadio(){

  }

  /**
   * 運動器機能向上加算モデルに内部項目を追加します。
   */
  protected void addMoveFunctionImprovementAddRadioModel(){

    getMoveFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getMoveFunctionImprovementAddRadioModel().add(getMoveFunctionImprovementAddRadioItem1());

    getMoveFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getMoveFunctionImprovementAddRadioModel().add(getMoveFunctionImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMoveFunctionImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMoveFunctionImprovementAddRadioItem2(){

  }

  /**
   * 栄養改善加算に内部項目を追加します。
   */
  protected void addNourishmentImprovementAddRadio(){

  }

  /**
   * 栄養改善加算モデルに内部項目を追加します。
   */
  protected void addNourishmentImprovementAddRadioModel(){

    getNourishmentImprovementAddRadioItem1().setButtonIndex(1);

    getNourishmentImprovementAddRadioModel().add(getNourishmentImprovementAddRadioItem1());

    getNourishmentImprovementAddRadioItem2().setButtonIndex(2);

    getNourishmentImprovementAddRadioModel().add(getNourishmentImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNourishmentImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNourishmentImprovementAddRadioItem2(){

  }

  /**
   * 栄養スクリーニング加算に内部項目を追加します。
   */
  protected void addNutritionScreening(){

  }

  /**
   * 栄養スクリーニング加算モデルに内部項目を追加します。
   */
  protected void addNutritionScreeningModel(){

    getNutritionScreeningItem1().setButtonIndex(1);

    getNutritionScreeningModel().add(getNutritionScreeningItem1());

    getNutritionScreeningItem2().setButtonIndex(2);

    getNutritionScreeningModel().add(getNutritionScreeningItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNutritionScreeningItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNutritionScreeningItem2(){

  }

  /**
   * 口腔機能向上加算に内部項目を追加します。
   */
  protected void addMouthFunctionImprovementAddRadio(){

  }

  /**
   * 口腔機能向上加算モデルに内部項目を追加します。
   */
  protected void addMouthFunctionImprovementAddRadioModel(){

    getMouthFunctionImprovementAddRadioItem1().setButtonIndex(1);

    getMouthFunctionImprovementAddRadioModel().add(getMouthFunctionImprovementAddRadioItem1());

    getMouthFunctionImprovementAddRadioItem2().setButtonIndex(2);

    getMouthFunctionImprovementAddRadioModel().add(getMouthFunctionImprovementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMouthFunctionImprovementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMouthFunctionImprovementAddRadioItem2(){

  }

  /**
   * 選択的サービス複数実施加算に内部項目を追加します。
   */
  protected void addSentakutekiServiceRadio(){

  }

  /**
   * 選択的サービス複数実施加算モデルに内部項目を追加します。
   */
  protected void addSentakutekiServiceRadioModel(){

    getSentakutekiServiceRadioItem1().setButtonIndex(1);

    getSentakutekiServiceRadioModel().add(getSentakutekiServiceRadioItem1());

    getSentakutekiServiceRadioItem2().setButtonIndex(2);

    getSentakutekiServiceRadioModel().add(getSentakutekiServiceRadioItem2());

    getSentakutekiServiceRadioItem3().setButtonIndex(3);

    getSentakutekiServiceRadioModel().add(getSentakutekiServiceRadioItem3());

    getSentakutekiServiceRadioItem4().setButtonIndex(4);

    getSentakutekiServiceRadioModel().add(getSentakutekiServiceRadioItem4());

    getSentakutekiServiceRadioItem5().setButtonIndex(5);

    getSentakutekiServiceRadioModel().add(getSentakutekiServiceRadioItem5());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addSentakutekiServiceRadioItem1(){

  }

  /**
   * I1に内部項目を追加します。
   */
  protected void addSentakutekiServiceRadioItem2(){

  }

  /**
   * I2に内部項目を追加します。
   */
  protected void addSentakutekiServiceRadioItem3(){

  }

  /**
   * I3に内部項目を追加します。
   */
  protected void addSentakutekiServiceRadioItem4(){

  }

  /**
   * IIに内部項目を追加します。
   */
  protected void addSentakutekiServiceRadioItem5(){

  }

  /**
   * 提供時間コンテナに内部項目を追加します。
   */
  protected void addHoumonKaigoTimeContainer(){

    houmonKaigoTimeContainer.add(getHoumonKaigoBeginTimeContainer(), VRLayout.FLOW);

    houmonKaigoTimeContainer.add(getHoumonKaigoEndTimeContainer(), VRLayout.FLOW_RETURN);

  }

  /**
   * 開始時刻コンボに内部項目を追加します。
   */
  protected void addHoumonKaigoBeginTime(){

  }

  /**
   * 開始時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonKaigoBeginTimeModel(){

  }

  /**
   * 終了時刻コンボに内部項目を追加します。
   */
  protected void addHoumonKaigoEndTime(){

  }

  /**
   * 終了時刻コンボモデルに内部項目を追加します。
   */
  protected void addHoumonKaigoEndTimeModel(){

  }

  /**
   * タブ2に内部項目を追加します。
   */
  protected void addTab2(){

    tab2.add(getStaffSubtractionRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getHoumonRehabilitationManagementAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getLifeActsImproveRehabilitationRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getLifeActsImproveRehaSubtractionRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getYoungDementiaPatinetAddRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getProviderAddMountainousAreaRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getTransportationCallRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab2.add(getCalculationDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

  }

  /**
   * 人員減算に内部項目を追加します。
   */
  protected void addStaffSubtractionRadio(){

  }

  /**
   * 人員減算モデルに内部項目を追加します。
   */
  protected void addStaffSubtractionRadioModel(){

    getStaffSubtractionRadioItem1().setButtonIndex(1);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem1());

    getStaffSubtractionRadioItem2().setButtonIndex(2);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem2());

    getStaffSubtractionRadioItem3().setButtonIndex(3);

    getStaffSubtractionRadioModel().add(getStaffSubtractionRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffSubtractionRadioItem1(){

  }

  /**
   * 定員超過に内部項目を追加します。
   */
  protected void addStaffSubtractionRadioItem2(){

  }

  /**
   * 医師、PT・OT・ST、看護・介護職員の不足が欠員に内部項目を追加します。
   */
  protected void addStaffSubtractionRadioItem3(){

  }

  /**
   * リハビリテーションマネジメント加算に内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadio(){

  }

  /**
   * リハビリテーションマネジメント加算モデルに内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioModel(){

    getHoumonRehabilitationManagementAddRadioItem1().setButtonIndex(1);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem1());

    getHoumonRehabilitationManagementAddRadioItem2().setButtonIndex(2);

    getHoumonRehabilitationManagementAddRadioModel().add(getHoumonRehabilitationManagementAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addHoumonRehabilitationManagementAddRadioItem2(){

  }

  /**
   * 生活行為向上リハビリ実施加算に内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioGroup(){

  }

  /**
   * 生活行為向上リハビリ実施加算モデルに内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioGroupModel(){

    getLifeActsImproveRehabilitationRadioItem1().setButtonIndex(1);

    getLifeActsImproveRehabilitationRadioGroupModel().add(getLifeActsImproveRehabilitationRadioItem1());

    getLifeActsImproveRehabilitationRadioItem2().setButtonIndex(2);

    getLifeActsImproveRehabilitationRadioGroupModel().add(getLifeActsImproveRehabilitationRadioItem2());

    getLifeActsImproveRehabilitationRadioItem3().setButtonIndex(3);

    getLifeActsImproveRehabilitationRadioGroupModel().add(getLifeActsImproveRehabilitationRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioItem1(){

  }

  /**
   * 3月以内に内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioItem2(){

  }

  /**
   * 3月超6月以内に内部項目を追加します。
   */
  protected void addLifeActsImproveRehabilitationRadioItem3(){

  }

  /**
   * 生活行為向上リハビリテーション後の継続減算に内部項目を追加します。
   */
  protected void addLifeActsImproveRehaSubtractionRadioGroup(){

  }

  /**
   * 生活行為向上リハビリテーション後の継続減算モデルに内部項目を追加します。
   */
  protected void addLifeActsImproveRehaSubtractionRadioGroupModel(){

    getLifeActsImproveRehaSubtractionRadioItem1().setButtonIndex(1);

    getLifeActsImproveRehaSubtractionRadioGroupModel().add(getLifeActsImproveRehaSubtractionRadioItem1());

    getLifeActsImproveRehaSubtractionRadioItem2().setButtonIndex(2);

    getLifeActsImproveRehaSubtractionRadioGroupModel().add(getLifeActsImproveRehaSubtractionRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addLifeActsImproveRehaSubtractionRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addLifeActsImproveRehaSubtractionRadioItem2(){

  }

  /**
   * 若年性認知症利用者受入加算に内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioGroup(){

  }

  /**
   * 若年性認知症利用者受入加算モデルに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioGroupModel(){

    getYoungDementiaPatinetAddRadioItem1().setButtonIndex(1);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem1());

    getYoungDementiaPatinetAddRadioItem2().setButtonIndex(2);

    getYoungDementiaPatinetAddRadioGroupModel().add(getYoungDementiaPatinetAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addYoungDementiaPatinetAddRadioItem2(){

  }

  /**
   * 中山間地域等でのサービス提供加算に内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioGroup(){

  }

  /**
   * 中山間地域等でのサービス提供加算モデルに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioGroupModel(){

    getProviderAddMountainousAreaRadioItem1().setButtonIndex(1);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaRadioItem1());

    getProviderAddMountainousAreaRadioItem2().setButtonIndex(2);

    getProviderAddMountainousAreaRadioGroupModel().add(getProviderAddMountainousAreaRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addProviderAddMountainousAreaRadioItem2(){

  }

  /**
   * 同一建物居住者へのサービス提供に内部項目を追加します。
   */
  protected void addTransportationCallRadioGroup(){

  }

  /**
   * 同一建物居住者へのサービス提供モデルに内部項目を追加します。
   */
  protected void addTransportationCallRadioGroupModel(){

    getTransportationCallRadioItem1().setButtonIndex(1);

    getTransportationCallRadioGroupModel().add(getTransportationCallRadioItem1());

    getTransportationCallRadioItem2().setButtonIndex(2);

    getTransportationCallRadioGroupModel().add(getTransportationCallRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addTransportationCallRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addTransportationCallRadioItem2(){

  }

  /**
   * 算定区分に内部項目を追加します。
   */
  protected void addCalculationDivision(){

  }

  /**
   * 算定区分モデルに内部項目を追加します。
   */
  protected void addCalculationDivisionModel(){

    getCalculationDivisionNormal().setButtonIndex(1);

    getCalculationDivisionModel().add(getCalculationDivisionNormal());

    getCalculationDivisionAddOnly().setButtonIndex(2);

    getCalculationDivisionModel().add(getCalculationDivisionAddOnly());

  }

  /**
   * 通常に内部項目を追加します。
   */
  protected void addCalculationDivisionNormal(){

  }

  /**
   * 加算のみに内部項目を追加します。
   */
  protected void addCalculationDivisionAddOnly(){

  }

  /**
   * タブ3に内部項目を追加します。
   */
  protected void addTab3(){

    tab3.add(getOfficeEvaluationAddRadioContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getServiceAddProvisionStructuralRadioGroupContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    tab3.add(getInfoGroup(), VRLayout.FLOW);

  }

  /**
   * 事業所評価加算に内部項目を追加します。
   */
  protected void addOfficeEvaluationAddRadio(){

  }

  /**
   * 事業所評価加算モデルに内部項目を追加します。
   */
  protected void addOfficeEvaluationAddRadioModel(){

    getOfficeEvaluationAddRadioItem1().setButtonIndex(1);

    getOfficeEvaluationAddRadioModel().add(getOfficeEvaluationAddRadioItem1());

    getOfficeEvaluationAddRadioItem2().setButtonIndex(2);

    getOfficeEvaluationAddRadioModel().add(getOfficeEvaluationAddRadioItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addOfficeEvaluationAddRadioItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addOfficeEvaluationAddRadioItem2(){

  }

  /**
   * サービス提供体制強化加算に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioGroup(){

  }

  /**
   * サービス提供体制強化加算モデルに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioGroupModel(){

    getServiceAddProvisionStructuralRadioItem1().setButtonIndex(1);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem1());

    getServiceAddProvisionStructuralRadioItem4().setButtonIndex(4);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem4());

    getServiceAddProvisionStructuralRadioItem2().setButtonIndex(2);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem2());

    getServiceAddProvisionStructuralRadioItem3().setButtonIndex(3);

    getServiceAddProvisionStructuralRadioGroupModel().add(getServiceAddProvisionStructuralRadioItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem1(){

  }

  /**
   * Iイ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem4(){

  }

  /**
   * Iロ型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem2(){

  }

  /**
   * II型に内部項目を追加します。
   */
  protected void addServiceAddProvisionStructuralRadioItem3(){

  }

  /**
   * 注意書きグループに内部項目を追加します。
   */
  protected void addInfoGroup(){

    infoGroup.add(getInfoLabelPlan(), VRLayout.FLOW);

  }

  /**
   * 注意書きラベルに内部項目を追加します。
   */
  protected void addInfoLabelPlan(){

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
      ACFrame.debugStart(new ACAffairInfo(QS001_16611_201804Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QS001_16611_201804Design getThis() {
    return this;
  }
}
