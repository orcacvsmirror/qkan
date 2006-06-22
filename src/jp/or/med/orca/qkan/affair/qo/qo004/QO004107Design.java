
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
 * 開発者: 松本　幸一
 * 作成日: 2006/03/08  日本コンピューター株式会社 松本　幸一 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム その他機能 (O)
 * プロセス 事業者登録 (004)
 * プログラム 通所介護 (QO004107)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qo.qo004;
import java.awt.Component;
import java.awt.im.InputSubset;

import javax.swing.SwingConstants;

import jp.nichicom.ac.component.ACClearableRadioButtonGroup;
import jp.nichicom.ac.component.ACIntegerCheckBox;
import jp.nichicom.ac.component.ACLabel;
import jp.nichicom.ac.component.ACRadioButtonItem;
import jp.nichicom.ac.component.ACTextField;
import jp.nichicom.ac.container.ACGroupBox;
import jp.nichicom.ac.container.ACLabelContainer;
import jp.nichicom.ac.core.ACAffairInfo;
import jp.nichicom.ac.core.ACFrame;
import jp.nichicom.ac.util.adapter.ACListModelAdapter;
import jp.nichicom.vr.layout.VRLayout;
import jp.nichicom.vr.text.VRCharType;
import jp.nichicom.vr.util.VRMap;
import jp.or.med.orca.qkan.affair.QkanFrameEventProcesser;
import jp.or.med.orca.qkan.affair.qs.qs001.QS001ServicePanel;
/**
 * 通所介護画面項目デザイン(QO004107) 
 */
public class QO004107Design extends QS001ServicePanel {
  //GUIコンポーネント

  private ACGroupBox mainGroup;

  private ACLabelContainer facilitiesDivisionContainer;

  private ACClearableRadioButtonGroup facilitiesDivision;

  private ACListModelAdapter facilitiesDivisionModel;

  private ACRadioButtonItem facilitiesDivisionItem1;

  private ACRadioButtonItem facilitiesDivisionItem2;

  private ACRadioButtonItem facilitiesDivisionItem3;

  private ACIntegerCheckBox facilitiesDivisionOther1;

  private ACClearableRadioButtonGroup staffLack;

  private ACLabelContainer staffLackContainer;

  private ACListModelAdapter staffLackModel;

  private ACRadioButtonItem staffLackItem1;

  private ACRadioButtonItem staffLackItem2;

  private ACRadioButtonItem staffLackItem3;

  private ACClearableRadioButtonGroup extendTime;

  private ACLabelContainer extendTimeContainer;

  private ACListModelAdapter extendTimeModel;

  private ACRadioButtonItem extendTimeItem1;

  private ACRadioButtonItem extendTimeItem2;

  private ACClearableRadioButtonGroup functionTrainingGuidanceSystem;

  private ACLabelContainer functionTrainingGuidanceSystemContainer;

  private ACListModelAdapter functionTrainingGuidanceSystemModel;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem1;

  private ACRadioButtonItem functionTrainingGuidanceSystemItem2;

  private ACClearableRadioButtonGroup bathingHelpSystem;

  private ACLabelContainer bathingHelpSystemContainer;

  private ACListModelAdapter bathingHelpSystemModel;

  private ACRadioButtonItem bathingHelpSystemItem1;

  private ACRadioButtonItem bathingHelpSystemItem2;

  private ACClearableRadioButtonGroup dementiaCare;

  private ACLabelContainer dementiaCareContainer;

  private ACListModelAdapter dementiaCareModel;

  private ACRadioButtonItem dementiaCareItem1;

  private ACRadioButtonItem dementiaCareItem2;

  private ACClearableRadioButtonGroup nourishmentManagementAdd;

  private ACLabelContainer nourishmentManagementAddContainer;

  private ACListModelAdapter nourishmentManagementAddModel;

  private ACRadioButtonItem nourishmentManagementAddItem1;

  private ACRadioButtonItem nourishmentManagementAddItem2;

  private ACClearableRadioButtonGroup mouthImprovementAdd;

  private ACLabelContainer mouthImprovementAddContainer;

  private ACListModelAdapter mouthImprovementAddModel;

  private ACRadioButtonItem mouthImprovementAddItem1;

  private ACRadioButtonItem mouthImprovementAddItem2;

  private ACLabelContainer reduceRateContainer;

  private ACTextField reduceRate;

  private ACLabel percentSign;

  private ACIntegerCheckBox ShahukuReduce;

  //getter

  /**
   * 事業グループを取得します。
   * @return 事業グループ
   */
  public ACGroupBox getMainGroup(){
    if(mainGroup==null){

      mainGroup = new ACGroupBox();

      mainGroup.setText("通所介護");

      mainGroup.setFollowChildEnabled(true);

      mainGroup.setHgrid(200);

      addMainGroup();
    }
    return mainGroup;

  }

  /**
   * 施設区分コンテナを取得します。
   * @return 施設区分コンテナ
   */
  public ACLabelContainer getFacilitiesDivisionContainer(){
    if(facilitiesDivisionContainer==null){

      facilitiesDivisionContainer = new ACLabelContainer();

      facilitiesDivisionContainer.setText("施設等の区分");

      facilitiesDivisionContainer.setFollowChildEnabled(true);

      addFacilitiesDivisionContainer();
    }
    return facilitiesDivisionContainer;

  }

  /**
   * 施設区分ラジオグループを取得します。
   * @return 施設区分ラジオグループ
   */
  public ACClearableRadioButtonGroup getFacilitiesDivision(){
    if(facilitiesDivision==null){

      facilitiesDivision = new ACClearableRadioButtonGroup();

      facilitiesDivision.setBindPath("1150101");

      facilitiesDivision.setModel(getFacilitiesDivisionModel());

      facilitiesDivision.setUseClearButton(false);

      addFacilitiesDivision();
    }
    return facilitiesDivision;

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
   * 小規模を取得します。
   * @return 小規模
   */
  public ACRadioButtonItem getFacilitiesDivisionItem1(){
    if(facilitiesDivisionItem1==null){

      facilitiesDivisionItem1 = new ACRadioButtonItem();

      facilitiesDivisionItem1.setText("小規模型");

      facilitiesDivisionItem1.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem1.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem1();
    }
    return facilitiesDivisionItem1;

  }

  /**
   * 通常規模を取得します。
   * @return 通常規模
   */
  public ACRadioButtonItem getFacilitiesDivisionItem2(){
    if(facilitiesDivisionItem2==null){

      facilitiesDivisionItem2 = new ACRadioButtonItem();

      facilitiesDivisionItem2.setText("通常規模型");

      facilitiesDivisionItem2.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem2.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem2();
    }
    return facilitiesDivisionItem2;

  }

  /**
   * 療養通所を取得します。
   * @return 療養通所
   */
  public ACRadioButtonItem getFacilitiesDivisionItem3(){
    if(facilitiesDivisionItem3==null){

      facilitiesDivisionItem3 = new ACRadioButtonItem();

      facilitiesDivisionItem3.setText("療養通所介護");

      facilitiesDivisionItem3.setGroup(getFacilitiesDivision());

      facilitiesDivisionItem3.setConstraints(VRLayout.FLOW);

      addFacilitiesDivisionItem3();
    }
    return facilitiesDivisionItem3;

  }

  /**
   * 大規模事業所（利用者数900人超）を取得します。
   * @return 大規模事業所（利用者数900人超）
   */
  public ACIntegerCheckBox getFacilitiesDivisionOther1(){
    if(facilitiesDivisionOther1==null){

      facilitiesDivisionOther1 = new ACIntegerCheckBox();

      facilitiesDivisionOther1.setText("大規模事業所（利用者数900人超）");

      facilitiesDivisionOther1.setBindPath("1150107");

      facilitiesDivisionOther1.setSelectValue(2);

      facilitiesDivisionOther1.setUnSelectValue(1);

      addFacilitiesDivisionOther1();
    }
    return facilitiesDivisionOther1;

  }

  /**
   * 職員の欠員による減算の状況ラジオグループを取得します。
   * @return 職員の欠員による減算の状況ラジオグループ
   */
  public ACClearableRadioButtonGroup getStaffLack(){
    if(staffLack==null){

      staffLack = new ACClearableRadioButtonGroup();

      getStaffLackContainer().setText("職員の欠員による減算の状況");

      staffLack.setBindPath("1150106");

      staffLack.setModel(getStaffLackModel());

      staffLack.setUseClearButton(false);

      addStaffLack();
    }
    return staffLack;

  }

  /**
   * 職員の欠員による減算の状況ラジオグループコンテナを取得します。
   * @return 職員の欠員による減算の状況ラジオグループコンテナ
   */
  protected ACLabelContainer getStaffLackContainer(){
    if(staffLackContainer==null){
      staffLackContainer = new ACLabelContainer();
      staffLackContainer.setFollowChildEnabled(true);
      staffLackContainer.setVAlignment(VRLayout.CENTER);
      staffLackContainer.add(getStaffLack(), null);
    }
    return staffLackContainer;
  }

  /**
   * 職員の欠員による減算の状況ラジオグループモデルを取得します。
   * @return 職員の欠員による減算の状況ラジオグループモデル
   */
  protected ACListModelAdapter getStaffLackModel(){
    if(staffLackModel==null){
      staffLackModel = new ACListModelAdapter();
      addStaffLackModel();
    }
    return staffLackModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getStaffLackItem1(){
    if(staffLackItem1==null){

      staffLackItem1 = new ACRadioButtonItem();

      staffLackItem1.setText("なし");

      staffLackItem1.setGroup(getStaffLack());

      staffLackItem1.setConstraints(VRLayout.FLOW);

      addStaffLackItem1();
    }
    return staffLackItem1;

  }

  /**
   * 看護職員を取得します。
   * @return 看護職員
   */
  public ACRadioButtonItem getStaffLackItem2(){
    if(staffLackItem2==null){

      staffLackItem2 = new ACRadioButtonItem();

      staffLackItem2.setText("看護職員");

      staffLackItem2.setGroup(getStaffLack());

      staffLackItem2.setConstraints(VRLayout.FLOW);

      addStaffLackItem2();
    }
    return staffLackItem2;

  }

  /**
   * 介護職員を取得します。
   * @return 介護職員
   */
  public ACRadioButtonItem getStaffLackItem3(){
    if(staffLackItem3==null){

      staffLackItem3 = new ACRadioButtonItem();

      staffLackItem3.setText("介護職員");

      staffLackItem3.setGroup(getStaffLack());

      staffLackItem3.setConstraints(VRLayout.FLOW);

      addStaffLackItem3();
    }
    return staffLackItem3;

  }

  /**
   * 時間延長サービス体制を取得します。
   * @return 時間延長サービス体制
   */
  public ACClearableRadioButtonGroup getExtendTime(){
    if(extendTime==null){

      extendTime = new ACClearableRadioButtonGroup();

      getExtendTimeContainer().setText("時間延長サービス体制");

      extendTime.setBindPath("1150110");

      extendTime.setModel(getExtendTimeModel());

      extendTime.setUseClearButton(false);

      addExtendTime();
    }
    return extendTime;

  }

  /**
   * 時間延長サービス体制コンテナを取得します。
   * @return 時間延長サービス体制コンテナ
   */
  protected ACLabelContainer getExtendTimeContainer(){
    if(extendTimeContainer==null){
      extendTimeContainer = new ACLabelContainer();
      extendTimeContainer.setFollowChildEnabled(true);
      extendTimeContainer.setVAlignment(VRLayout.CENTER);
      extendTimeContainer.add(getExtendTime(), null);
    }
    return extendTimeContainer;
  }

  /**
   * 時間延長サービス体制モデルを取得します。
   * @return 時間延長サービス体制モデル
   */
  protected ACListModelAdapter getExtendTimeModel(){
    if(extendTimeModel==null){
      extendTimeModel = new ACListModelAdapter();
      addExtendTimeModel();
    }
    return extendTimeModel;
  }

  /**
   * 対応不可を取得します。
   * @return 対応不可
   */
  public ACRadioButtonItem getExtendTimeItem1(){
    if(extendTimeItem1==null){

      extendTimeItem1 = new ACRadioButtonItem();

      extendTimeItem1.setText("対応不可");

      extendTimeItem1.setGroup(getExtendTime());

      extendTimeItem1.setConstraints(VRLayout.FLOW);

      addExtendTimeItem1();
    }
    return extendTimeItem1;

  }

  /**
   * 対応可を取得します。
   * @return 対応可
   */
  public ACRadioButtonItem getExtendTimeItem2(){
    if(extendTimeItem2==null){

      extendTimeItem2 = new ACRadioButtonItem();

      extendTimeItem2.setText("対応可");

      extendTimeItem2.setGroup(getExtendTime());

      extendTimeItem2.setConstraints(VRLayout.FLOW);

      addExtendTimeItem2();
    }
    return extendTimeItem2;

  }

  /**
   * 個別機能訓練体制ラジオグループを取得します。
   * @return 個別機能訓練体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getFunctionTrainingGuidanceSystem(){
    if(functionTrainingGuidanceSystem==null){

      functionTrainingGuidanceSystem = new ACClearableRadioButtonGroup();

      getFunctionTrainingGuidanceSystemContainer().setText("個別機能訓練体制");

      functionTrainingGuidanceSystem.setBindPath("1150102");

      functionTrainingGuidanceSystem.setModel(getFunctionTrainingGuidanceSystemModel());

      functionTrainingGuidanceSystem.setUseClearButton(false);

      addFunctionTrainingGuidanceSystem();
    }
    return functionTrainingGuidanceSystem;

  }

  /**
   * 個別機能訓練体制ラジオグループコンテナを取得します。
   * @return 個別機能訓練体制ラジオグループコンテナ
   */
  protected ACLabelContainer getFunctionTrainingGuidanceSystemContainer(){
    if(functionTrainingGuidanceSystemContainer==null){
      functionTrainingGuidanceSystemContainer = new ACLabelContainer();
      functionTrainingGuidanceSystemContainer.setFollowChildEnabled(true);
      functionTrainingGuidanceSystemContainer.setVAlignment(VRLayout.CENTER);
      functionTrainingGuidanceSystemContainer.add(getFunctionTrainingGuidanceSystem(), null);
    }
    return functionTrainingGuidanceSystemContainer;
  }

  /**
   * 個別機能訓練体制ラジオグループモデルを取得します。
   * @return 個別機能訓練体制ラジオグループモデル
   */
  protected ACListModelAdapter getFunctionTrainingGuidanceSystemModel(){
    if(functionTrainingGuidanceSystemModel==null){
      functionTrainingGuidanceSystemModel = new ACListModelAdapter();
      addFunctionTrainingGuidanceSystemModel();
    }
    return functionTrainingGuidanceSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemItem1(){
    if(functionTrainingGuidanceSystemItem1==null){

      functionTrainingGuidanceSystemItem1 = new ACRadioButtonItem();

      functionTrainingGuidanceSystemItem1.setText("なし");

      functionTrainingGuidanceSystemItem1.setGroup(getFunctionTrainingGuidanceSystem());

      functionTrainingGuidanceSystemItem1.setConstraints(VRLayout.FLOW);

      addFunctionTrainingGuidanceSystemItem1();
    }
    return functionTrainingGuidanceSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getFunctionTrainingGuidanceSystemItem2(){
    if(functionTrainingGuidanceSystemItem2==null){

      functionTrainingGuidanceSystemItem2 = new ACRadioButtonItem();

      functionTrainingGuidanceSystemItem2.setText("あり");

      functionTrainingGuidanceSystemItem2.setGroup(getFunctionTrainingGuidanceSystem());

      functionTrainingGuidanceSystemItem2.setConstraints(VRLayout.FLOW);

      addFunctionTrainingGuidanceSystemItem2();
    }
    return functionTrainingGuidanceSystemItem2;

  }

  /**
   * 入浴介助体制ラジオグループを取得します。
   * @return 入浴介助体制ラジオグループ
   */
  public ACClearableRadioButtonGroup getBathingHelpSystem(){
    if(bathingHelpSystem==null){

      bathingHelpSystem = new ACClearableRadioButtonGroup();

      getBathingHelpSystemContainer().setText("入浴介助体制");

      bathingHelpSystem.setBindPath("1150103");

      bathingHelpSystem.setModel(getBathingHelpSystemModel());

      bathingHelpSystem.setUseClearButton(false);

      addBathingHelpSystem();
    }
    return bathingHelpSystem;

  }

  /**
   * 入浴介助体制ラジオグループコンテナを取得します。
   * @return 入浴介助体制ラジオグループコンテナ
   */
  protected ACLabelContainer getBathingHelpSystemContainer(){
    if(bathingHelpSystemContainer==null){
      bathingHelpSystemContainer = new ACLabelContainer();
      bathingHelpSystemContainer.setFollowChildEnabled(true);
      bathingHelpSystemContainer.setVAlignment(VRLayout.CENTER);
      bathingHelpSystemContainer.add(getBathingHelpSystem(), null);
    }
    return bathingHelpSystemContainer;
  }

  /**
   * 入浴介助体制ラジオグループモデルを取得します。
   * @return 入浴介助体制ラジオグループモデル
   */
  protected ACListModelAdapter getBathingHelpSystemModel(){
    if(bathingHelpSystemModel==null){
      bathingHelpSystemModel = new ACListModelAdapter();
      addBathingHelpSystemModel();
    }
    return bathingHelpSystemModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getBathingHelpSystemItem1(){
    if(bathingHelpSystemItem1==null){

      bathingHelpSystemItem1 = new ACRadioButtonItem();

      bathingHelpSystemItem1.setText("なし");

      bathingHelpSystemItem1.setGroup(getBathingHelpSystem());

      bathingHelpSystemItem1.setConstraints(VRLayout.FLOW);

      addBathingHelpSystemItem1();
    }
    return bathingHelpSystemItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getBathingHelpSystemItem2(){
    if(bathingHelpSystemItem2==null){

      bathingHelpSystemItem2 = new ACRadioButtonItem();

      bathingHelpSystemItem2.setText("あり");

      bathingHelpSystemItem2.setGroup(getBathingHelpSystem());

      bathingHelpSystemItem2.setConstraints(VRLayout.FLOW);

      addBathingHelpSystemItem2();
    }
    return bathingHelpSystemItem2;

  }

  /**
   * 若年性認知症ケア体制を取得します。
   * @return 若年性認知症ケア体制
   */
  public ACClearableRadioButtonGroup getDementiaCare(){
    if(dementiaCare==null){

      dementiaCare = new ACClearableRadioButtonGroup();

      getDementiaCareContainer().setText("若年性認知症ケア体制");

      dementiaCare.setBindPath("1150111");

      dementiaCare.setModel(getDementiaCareModel());

      dementiaCare.setUseClearButton(false);

      addDementiaCare();
    }
    return dementiaCare;

  }

  /**
   * 若年性認知症ケア体制コンテナを取得します。
   * @return 若年性認知症ケア体制コンテナ
   */
  protected ACLabelContainer getDementiaCareContainer(){
    if(dementiaCareContainer==null){
      dementiaCareContainer = new ACLabelContainer();
      dementiaCareContainer.setFollowChildEnabled(true);
      dementiaCareContainer.setVAlignment(VRLayout.CENTER);
      dementiaCareContainer.add(getDementiaCare(), null);
    }
    return dementiaCareContainer;
  }

  /**
   * 若年性認知症ケア体制モデルを取得します。
   * @return 若年性認知症ケア体制モデル
   */
  protected ACListModelAdapter getDementiaCareModel(){
    if(dementiaCareModel==null){
      dementiaCareModel = new ACListModelAdapter();
      addDementiaCareModel();
    }
    return dementiaCareModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getDementiaCareItem1(){
    if(dementiaCareItem1==null){

      dementiaCareItem1 = new ACRadioButtonItem();

      dementiaCareItem1.setText("なし");

      dementiaCareItem1.setGroup(getDementiaCare());

      dementiaCareItem1.setConstraints(VRLayout.FLOW);

      addDementiaCareItem1();
    }
    return dementiaCareItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getDementiaCareItem2(){
    if(dementiaCareItem2==null){

      dementiaCareItem2 = new ACRadioButtonItem();

      dementiaCareItem2.setText("あり");

      dementiaCareItem2.setGroup(getDementiaCare());

      dementiaCareItem2.setConstraints(VRLayout.FLOW);

      addDementiaCareItem2();
    }
    return dementiaCareItem2;

  }

  /**
   * 栄養マネジメント体制を取得します。
   * @return 栄養マネジメント体制
   */
  public ACClearableRadioButtonGroup getNourishmentManagementAdd(){
    if(nourishmentManagementAdd==null){

      nourishmentManagementAdd = new ACClearableRadioButtonGroup();

      getNourishmentManagementAddContainer().setText("栄養マネジメント体制");

      nourishmentManagementAdd.setBindPath("1150108");

      nourishmentManagementAdd.setModel(getNourishmentManagementAddModel());

      nourishmentManagementAdd.setUseClearButton(false);

      addNourishmentManagementAdd();
    }
    return nourishmentManagementAdd;

  }

  /**
   * 栄養マネジメント体制コンテナを取得します。
   * @return 栄養マネジメント体制コンテナ
   */
  protected ACLabelContainer getNourishmentManagementAddContainer(){
    if(nourishmentManagementAddContainer==null){
      nourishmentManagementAddContainer = new ACLabelContainer();
      nourishmentManagementAddContainer.setFollowChildEnabled(true);
      nourishmentManagementAddContainer.setVAlignment(VRLayout.CENTER);
      nourishmentManagementAddContainer.add(getNourishmentManagementAdd(), null);
    }
    return nourishmentManagementAddContainer;
  }

  /**
   * 栄養マネジメント体制モデルを取得します。
   * @return 栄養マネジメント体制モデル
   */
  protected ACListModelAdapter getNourishmentManagementAddModel(){
    if(nourishmentManagementAddModel==null){
      nourishmentManagementAddModel = new ACListModelAdapter();
      addNourishmentManagementAddModel();
    }
    return nourishmentManagementAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getNourishmentManagementAddItem1(){
    if(nourishmentManagementAddItem1==null){

      nourishmentManagementAddItem1 = new ACRadioButtonItem();

      nourishmentManagementAddItem1.setText("なし");

      nourishmentManagementAddItem1.setGroup(getNourishmentManagementAdd());

      nourishmentManagementAddItem1.setConstraints(VRLayout.FLOW);

      addNourishmentManagementAddItem1();
    }
    return nourishmentManagementAddItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getNourishmentManagementAddItem2(){
    if(nourishmentManagementAddItem2==null){

      nourishmentManagementAddItem2 = new ACRadioButtonItem();

      nourishmentManagementAddItem2.setText("あり");

      nourishmentManagementAddItem2.setGroup(getNourishmentManagementAdd());

      nourishmentManagementAddItem2.setConstraints(VRLayout.FLOW);

      addNourishmentManagementAddItem2();
    }
    return nourishmentManagementAddItem2;

  }

  /**
   * 口腔機能向上体制を取得します。
   * @return 口腔機能向上体制
   */
  public ACClearableRadioButtonGroup getMouthImprovementAdd(){
    if(mouthImprovementAdd==null){

      mouthImprovementAdd = new ACClearableRadioButtonGroup();

      getMouthImprovementAddContainer().setText("口腔機能向上体制");

      mouthImprovementAdd.setBindPath("1150109");

      mouthImprovementAdd.setModel(getMouthImprovementAddModel());

      mouthImprovementAdd.setUseClearButton(false);

      addMouthImprovementAdd();
    }
    return mouthImprovementAdd;

  }

  /**
   * 口腔機能向上体制コンテナを取得します。
   * @return 口腔機能向上体制コンテナ
   */
  protected ACLabelContainer getMouthImprovementAddContainer(){
    if(mouthImprovementAddContainer==null){
      mouthImprovementAddContainer = new ACLabelContainer();
      mouthImprovementAddContainer.setFollowChildEnabled(true);
      mouthImprovementAddContainer.setVAlignment(VRLayout.CENTER);
      mouthImprovementAddContainer.add(getMouthImprovementAdd(), null);
    }
    return mouthImprovementAddContainer;
  }

  /**
   * 口腔機能向上体制モデルを取得します。
   * @return 口腔機能向上体制モデル
   */
  protected ACListModelAdapter getMouthImprovementAddModel(){
    if(mouthImprovementAddModel==null){
      mouthImprovementAddModel = new ACListModelAdapter();
      addMouthImprovementAddModel();
    }
    return mouthImprovementAddModel;
  }

  /**
   * なしを取得します。
   * @return なし
   */
  public ACRadioButtonItem getMouthImprovementAddItem1(){
    if(mouthImprovementAddItem1==null){

      mouthImprovementAddItem1 = new ACRadioButtonItem();

      mouthImprovementAddItem1.setText("なし");

      mouthImprovementAddItem1.setGroup(getMouthImprovementAdd());

      mouthImprovementAddItem1.setConstraints(VRLayout.FLOW);

      addMouthImprovementAddItem1();
    }
    return mouthImprovementAddItem1;

  }

  /**
   * ありを取得します。
   * @return あり
   */
  public ACRadioButtonItem getMouthImprovementAddItem2(){
    if(mouthImprovementAddItem2==null){

      mouthImprovementAddItem2 = new ACRadioButtonItem();

      mouthImprovementAddItem2.setText("あり");

      mouthImprovementAddItem2.setGroup(getMouthImprovementAdd());

      mouthImprovementAddItem2.setConstraints(VRLayout.FLOW);

      addMouthImprovementAddItem2();
    }
    return mouthImprovementAddItem2;

  }

  /**
   * 割引率コンテナを取得します。
   * @return 割引率コンテナ
   */
  public ACLabelContainer getReduceRateContainer(){
    if(reduceRateContainer==null){

      reduceRateContainer = new ACLabelContainer();

      reduceRateContainer.setText("割引率");

      reduceRateContainer.setFollowChildEnabled(true);

      addReduceRateContainer();
    }
    return reduceRateContainer;

  }

  /**
   * 割引率を取得します。
   * @return 割引率
   */
  public ACTextField getReduceRate(){
    if(reduceRate==null){

      reduceRate = new ACTextField();

      reduceRate.setBindPath("REDUCT_RATE");

      reduceRate.setColumns(3);

      reduceRate.setCharType(VRCharType.ONLY_DIGIT);

      reduceRate.setHorizontalAlignment(SwingConstants.RIGHT);

      reduceRate.setIMEMode(InputSubset.LATIN);

      reduceRate.setMaxLength(3);

      addReduceRate();
    }
    return reduceRate;

  }

  /**
   * ％ラベルを取得します。
   * @return ％ラベル
   */
  public ACLabel getPercentSign(){
    if(percentSign==null){

      percentSign = new ACLabel();

      percentSign.setText("％");

      addPercentSign();
    }
    return percentSign;

  }

  /**
   * 社福減免対象事業者を取得します。
   * @return 社福減免対象事業者
   */
  public ACIntegerCheckBox getShahukuReduce(){
    if(ShahukuReduce==null){

      ShahukuReduce = new ACIntegerCheckBox();

      ShahukuReduce.setText("社会福祉法人等の軽減制度");

      ShahukuReduce.setBindPath("1");

      ShahukuReduce.setSelectValue(2);

      ShahukuReduce.setUnSelectValue(1);

      addShahukuReduce();
    }
    return ShahukuReduce;

  }

  /**
   * コンストラクタです。
   */
  public QO004107Design() {

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

    this.add(getMainGroup(), VRLayout.CLIENT);

  }

  /**
   * 事業グループに内部項目を追加します。
   */
  protected void addMainGroup(){

    mainGroup.add(getFacilitiesDivisionContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getStaffLackContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getExtendTimeContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getFunctionTrainingGuidanceSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getBathingHelpSystemContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getDementiaCareContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getNourishmentManagementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getMouthImprovementAddContainer(), VRLayout.FLOW_INSETLINE_RETURN);

    mainGroup.add(getReduceRateContainer(), VRLayout.FLOW_INSETLINE);

    mainGroup.add(getShahukuReduce(), VRLayout.FLOW_RETURN);

  }

  /**
   * 施設区分コンテナに内部項目を追加します。
   */
  protected void addFacilitiesDivisionContainer(){

    facilitiesDivisionContainer.add(getFacilitiesDivision(), VRLayout.FLOW_RETURN);

    facilitiesDivisionContainer.add(getFacilitiesDivisionOther1(), VRLayout.FLOW);

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
   * 小規模に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem1(){

  }

  /**
   * 通常規模に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem2(){

  }

  /**
   * 療養通所に内部項目を追加します。
   */
  protected void addFacilitiesDivisionItem3(){

  }

  /**
   * 大規模事業所（利用者数900人超）に内部項目を追加します。
   */
  protected void addFacilitiesDivisionOther1(){

  }

  /**
   * 職員の欠員による減算の状況ラジオグループに内部項目を追加します。
   */
  protected void addStaffLack(){

  }

  /**
   * 職員の欠員による減算の状況ラジオグループモデルに内部項目を追加します。
   */
  protected void addStaffLackModel(){

    getStaffLackItem1().setButtonIndex(1);
    getStaffLackModel().add(getStaffLackItem1());

    getStaffLackItem2().setButtonIndex(2);
    getStaffLackModel().add(getStaffLackItem2());

    getStaffLackItem3().setButtonIndex(3);
    getStaffLackModel().add(getStaffLackItem3());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addStaffLackItem1(){

  }

  /**
   * 看護職員に内部項目を追加します。
   */
  protected void addStaffLackItem2(){

  }

  /**
   * 介護職員に内部項目を追加します。
   */
  protected void addStaffLackItem3(){

  }

  /**
   * 時間延長サービス体制に内部項目を追加します。
   */
  protected void addExtendTime(){

  }

  /**
   * 時間延長サービス体制モデルに内部項目を追加します。
   */
  protected void addExtendTimeModel(){

    getExtendTimeItem1().setButtonIndex(1);
    getExtendTimeModel().add(getExtendTimeItem1());

    getExtendTimeItem2().setButtonIndex(2);
    getExtendTimeModel().add(getExtendTimeItem2());

  }

  /**
   * 対応不可に内部項目を追加します。
   */
  protected void addExtendTimeItem1(){

  }

  /**
   * 対応可に内部項目を追加します。
   */
  protected void addExtendTimeItem2(){

  }

  /**
   * 個別機能訓練体制ラジオグループに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystem(){

  }

  /**
   * 個別機能訓練体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystemModel(){

    getFunctionTrainingGuidanceSystemItem1().setButtonIndex(1);
    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemItem1());

    getFunctionTrainingGuidanceSystemItem2().setButtonIndex(2);
    getFunctionTrainingGuidanceSystemModel().add(getFunctionTrainingGuidanceSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addFunctionTrainingGuidanceSystemItem2(){

  }

  /**
   * 入浴介助体制ラジオグループに内部項目を追加します。
   */
  protected void addBathingHelpSystem(){

  }

  /**
   * 入浴介助体制ラジオグループモデルに内部項目を追加します。
   */
  protected void addBathingHelpSystemModel(){

    getBathingHelpSystemItem1().setButtonIndex(1);
    getBathingHelpSystemModel().add(getBathingHelpSystemItem1());

    getBathingHelpSystemItem2().setButtonIndex(2);
    getBathingHelpSystemModel().add(getBathingHelpSystemItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addBathingHelpSystemItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addBathingHelpSystemItem2(){

  }

  /**
   * 若年性認知症ケア体制に内部項目を追加します。
   */
  protected void addDementiaCare(){

  }

  /**
   * 若年性認知症ケア体制モデルに内部項目を追加します。
   */
  protected void addDementiaCareModel(){

    getDementiaCareItem1().setButtonIndex(1);
    getDementiaCareModel().add(getDementiaCareItem1());

    getDementiaCareItem2().setButtonIndex(2);
    getDementiaCareModel().add(getDementiaCareItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addDementiaCareItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addDementiaCareItem2(){

  }

  /**
   * 栄養マネジメント体制に内部項目を追加します。
   */
  protected void addNourishmentManagementAdd(){

  }

  /**
   * 栄養マネジメント体制モデルに内部項目を追加します。
   */
  protected void addNourishmentManagementAddModel(){

    getNourishmentManagementAddItem1().setButtonIndex(1);
    getNourishmentManagementAddModel().add(getNourishmentManagementAddItem1());

    getNourishmentManagementAddItem2().setButtonIndex(2);
    getNourishmentManagementAddModel().add(getNourishmentManagementAddItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addNourishmentManagementAddItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addNourishmentManagementAddItem2(){

  }

  /**
   * 口腔機能向上体制に内部項目を追加します。
   */
  protected void addMouthImprovementAdd(){

  }

  /**
   * 口腔機能向上体制モデルに内部項目を追加します。
   */
  protected void addMouthImprovementAddModel(){

    getMouthImprovementAddItem1().setButtonIndex(1);
    getMouthImprovementAddModel().add(getMouthImprovementAddItem1());

    getMouthImprovementAddItem2().setButtonIndex(2);
    getMouthImprovementAddModel().add(getMouthImprovementAddItem2());

  }

  /**
   * なしに内部項目を追加します。
   */
  protected void addMouthImprovementAddItem1(){

  }

  /**
   * ありに内部項目を追加します。
   */
  protected void addMouthImprovementAddItem2(){

  }

  /**
   * 割引率コンテナに内部項目を追加します。
   */
  protected void addReduceRateContainer(){

    reduceRateContainer.add(getReduceRate(), VRLayout.FLOW);

    reduceRateContainer.add(getPercentSign(), VRLayout.FLOW);

  }

  /**
   * 割引率に内部項目を追加します。
   */
  protected void addReduceRate(){

  }

  /**
   * ％ラベルに内部項目を追加します。
   */
  protected void addPercentSign(){

  }

  /**
   * 社福減免対象事業者に内部項目を追加します。
   */
  protected void addShahukuReduce(){

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
      ACFrame.debugStart(new ACAffairInfo(QO004107Design.class.getName()));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 自身を返します。
   */
  protected QO004107Design getThis() {
    return this;
  }
}
