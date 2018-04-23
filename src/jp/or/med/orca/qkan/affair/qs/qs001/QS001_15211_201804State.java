
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
 * 作成日: 2018/02/26  日本コンピューター株式会社 樋口　雅彦 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービス予定 (001)
 * プログラム サービスパターン介護老人保健施設 (QS001_15211_201804)
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
/**
 * サービスパターン介護老人保健施設状態定義(QS001_15211_201804) 
 */
public class QS001_15211_201804State extends QS001_15211_201804Design {
  /**
   * コンストラクタです。
   */
  public QS001_15211_201804State(){
  }

  /**
   * 「食事提供・あり」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_USE_MEAT() throws Exception {

        getKaigoHealthCareOfTheAgedDinnerCost().setEnabled(true);

  }

  /**
   * 「食事提供・なし」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_NOT_USE_MEAT() throws Exception {

        getKaigoHealthCareOfTheAgedDinnerCost().setEnabled(false);

  }

  /**
   * 「経口移行・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_NUTRITION() throws Exception {

        getKaigoHealthCareOfTheAgedOralSwitchRadio().setEnabled(true);
        getKaigoHealthCareOfTheAgedOralSwitchRadio().getParent().setEnabled(true);

  }

  /**
   * 「経口移行・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_NUTRITION() throws Exception {

        getKaigoHealthCareOfTheAgedOralSwitchRadio().setEnabled(false);
        getKaigoHealthCareOfTheAgedOralSwitchRadio().getParent().setEnabled(false);

  }

  /**
   * 「経口維持加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceAdd().setEnabled(true);
        getOralMaintenanceAdd().getParent().setEnabled(true);

  }

  /**
   * 「経口維持加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_KEEP_NUTRITION() throws Exception {

        getOralMaintenanceAdd().setEnabled(false);
        getOralMaintenanceAdd().getParent().setEnabled(false);

  }

  /**
   * 「外泊加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_GAIHAKU() throws Exception {

        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().setEnabled(true);
        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().getParent().setEnabled(true);

  }

  /**
   * 「外泊加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_GAIHAKU() throws Exception {

        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().setEnabled(false);
        getKaigoHealthCareOfTheAgedStayingOutOvernightCostRadio().getParent().setEnabled(false);

  }

  /**
   * 「介護老人保健施設（I）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_1() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(false);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(true);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(true);

        getStayReturnSupportRyoyoAddRadio().setEnabled(true);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(true);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(false);
        getStayReturnSupportAddRadio().getParent().setEnabled(false);

        getRecuperationRadio().setEnabled(false);

  }

  /**
   * 「ユニット型介護老人保健施設（I）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_2() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(false);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(false);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(false);

        getStayReturnSupportRyoyoAddRadio().setEnabled(true);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(true);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(true);

        getStayReturnSupportAddRadio().setEnabled(false);
        getStayReturnSupportAddRadio().getParent().setEnabled(false);

        getRecuperationRadio().setEnabled(false);

  }

  /**
   * 「介護老人保健施設（II）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_3() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(true);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(true);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);

  }

  /**
   * 「ユニット型介護老人保健施設（II）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_4() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(false);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(false);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);

  }

  /**
   * 「介護老人保健施設（III）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_5() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(true);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(true);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);

  }

  /**
   * 「ユニット型介護老人保健施設（III）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_6() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(false);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(false);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);

  }

  /**
   * 「介護老人保健施設（IV）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_7() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(true);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(false);

        getUnitCareMaintenanceRadio().setEnabled(false);
        getUnitCareMaintenanceRadio().getParent().setEnabled(false);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(true);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(true);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);

  }

  /**
   * 「ユニット型介護老人保健施設（IV）」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_FACILITY_TYPE_8() throws Exception {

        getKaigoHealthCareOfTheAgedHospitalRoomRadio().setEnabled(false);

        getKaigoHealthCareOfTheAgedUnitHospitalRoomRadio().setEnabled(true);

        getUnitCareMaintenanceRadio().setEnabled(true);
        getUnitCareMaintenanceRadio().getParent().setEnabled(true);

        getSpecialMedicalExpense().setEnabled(true);

        getIntentionCommunicationDifficultyAddRadio().setEnabled(false);
        getIntentionCommunicationDifficultyAddRadio().getParent().setEnabled(false);

        getStayReturnSupportRyoyoAddRadio().setEnabled(false);
        getStayReturnSupportRyoyoAddRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHospitalDivision1().setEnabled(false);

        getStayReturnSupportAddRadio().setEnabled(true);
        getStayReturnSupportAddRadio().getParent().setEnabled(true);

        getRecuperationRadio().setEnabled(true);

  }

  /**
   * 「口腔機能維持管理加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_ORAL_CARE() throws Exception {

        getOralKeepAddRadioGroup().setEnabled(true);
        getOralKeepAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「口腔機能維持管理加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_ORAL_CARE() throws Exception {

        getOralKeepAddRadioGroup().setEnabled(false);
        getOralKeepAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「看取り介護・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_TERMINAL() throws Exception {

        getTerminalDays().setEnabled(true);
        getTerminalDays().getParent().setEnabled(true);

  }

  /**
   * 「看取り介護・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_TERMINAL() throws Exception {

        getTerminalDays().setEnabled(false);
        getTerminalDays().getParent().setEnabled(false);

  }

  /**
   * 「経口維持加算２・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_ORAL_MAINTENANCE2() throws Exception {

        getOralMaintenanceAddItem3().setEnabled(true);

  }

  /**
   * 「経口維持加算２・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_ORAL_MAINTENANCE2() throws Exception {

        getOralMaintenanceAddItem3().setEnabled(false);

  }

  /**
   * 「若年性認知症利用者受入加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(true);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「若年性認知症利用者受入加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_YOUNG_DEMENTIA_PATINET() throws Exception {

        getYoungDementiaPatinetAddRadioGroup().setEnabled(false);
        getYoungDementiaPatinetAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「認知症行動・心理症状緊急対応加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_DEMENTIA_ACTION() throws Exception {

        getDementiaEmergencyAddRadioGroup().setEnabled(true);
        getDementiaEmergencyAddRadioGroup().getParent().setEnabled(true);

  }

  /**
   * 「認知症行動・心理症状緊急対応加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_DEMENTIA_ACTION() throws Exception {

        getDementiaEmergencyAddRadioGroup().setEnabled(false);
        getDementiaEmergencyAddRadioGroup().getParent().setEnabled(false);

  }

  /**
   * 「特別型の関連加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_SPECIAL() throws Exception {

        getKaigoHealthCareOfTheAgedOralSwitchRadio().setEnabled(true);
        getKaigoHealthCareOfTheAgedOralSwitchRadio().getParent().setEnabled(true);

        getOralKeepAddRadioGroup().setEnabled(true);
        getOralKeepAddRadioGroup().getParent().setEnabled(true);

        getReEntryNutritionCooperationAdd().setEnabled(true);
        getReEntryNutritionCooperationAdd().getParent().setEnabled(true);

        getEnterHospitalPreConsultantRadio().setEnabled(true);
        getEnterHospitalPreConsultantRadio().getParent().setEnabled(true);

        getKaigoHealthCareOfTheAgedHijoAddition().setEnabled(true);

        getLowNutritionalRiskImprovementAdd().setEnabled(true);
        getLowNutritionalRiskImprovementAdd().getParent().setEnabled(true);

        getOralMaintenanceAddContainer().setEnabled(true);

        getOralKeepStructureAddRadioGroup().setEnabled(true);
        getOralKeepStructureAddRadioGroup().getParent().setEnabled(true);

        getFamilyCoordinationAdjustment().setEnabled(true);
        getFamilyCoordinationAdjustment().getParent().setEnabled(true);

        getPneumoniaTreatmentRadio().setEnabled(true);
        getPneumoniaTreatmentRadio().getParent().setEnabled(true);

        getLocalTreatmentPlanInfoAddRadio().setEnabled(true);
        getLocalTreatmentPlanInfoAddRadio().getParent().setEnabled(true);

        getPressureSoresManagement().setEnabled(true);
        getPressureSoresManagement().getParent().setEnabled(true);

        getExcretionSupport().setEnabled(true);
        getExcretionSupport().getParent().setEnabled(true);

  }

  /**
   * 「特別型の関連加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_SPECIAL() throws Exception {

        getKaigoHealthCareOfTheAgedOralSwitchRadio().setEnabled(false);
        getKaigoHealthCareOfTheAgedOralSwitchRadio().getParent().setEnabled(false);

        getOralKeepAddRadioGroup().setEnabled(false);
        getOralKeepAddRadioGroup().getParent().setEnabled(false);

        getReEntryNutritionCooperationAdd().setEnabled(false);
        getReEntryNutritionCooperationAdd().getParent().setEnabled(false);

        getEnterHospitalPreConsultantRadio().setEnabled(false);
        getEnterHospitalPreConsultantRadio().getParent().setEnabled(false);

        getKaigoHealthCareOfTheAgedHijoAddition().setEnabled(false);

        getLowNutritionalRiskImprovementAdd().setEnabled(false);
        getLowNutritionalRiskImprovementAdd().getParent().setEnabled(false);

        getOralMaintenanceAddContainer().setEnabled(false);

        getOralKeepStructureAddRadioGroup().setEnabled(false);
        getOralKeepStructureAddRadioGroup().getParent().setEnabled(false);

        getFamilyCoordinationAdjustment().setEnabled(false);
        getFamilyCoordinationAdjustment().getParent().setEnabled(false);

        getPneumoniaTreatmentRadio().setEnabled(false);
        getPneumoniaTreatmentRadio().getParent().setEnabled(false);

        getLocalTreatmentPlanInfoAddRadio().setEnabled(false);
        getLocalTreatmentPlanInfoAddRadio().getParent().setEnabled(false);

        getPressureSoresManagement().setEnabled(false);
        getPressureSoresManagement().getParent().setEnabled(false);

        getExcretionSupport().setEnabled(false);
        getExcretionSupport().getParent().setEnabled(false);

  }

  /**
   * 「低栄養リスク改善加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_LOW_NUTRITIONAL() throws Exception {

        getLowNutritionalRiskImprovementAdd().setEnabled(true);
        getLowNutritionalRiskImprovementAdd().getParent().setEnabled(true);

  }

  /**
   * 「低栄養リスク改善加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_LOW_NUTRITIONAL() throws Exception {

        getLowNutritionalRiskImprovementAdd().setEnabled(false);
        getLowNutritionalRiskImprovementAdd().getParent().setEnabled(false);

  }

  /**
   * 「再入所時栄養連携加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_RE_ENTRY_NUTRITION() throws Exception {

        getReEntryNutritionCooperationAdd().setEnabled(true);
        getReEntryNutritionCooperationAdd().getParent().setEnabled(true);

  }

  /**
   * 「再入所時栄養連携加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_RE_ENTRY_NUTRITION() throws Exception {

        getReEntryNutritionCooperationAdd().setEnabled(false);
        getReEntryNutritionCooperationAdd().getParent().setEnabled(false);

  }

  /**
   * 「外泊時在宅サービス利用費用・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_HOME_SERVICE_USAGE() throws Exception {

        getHomeServiceUsageFeeAtHome().setEnabled(true);
        getHomeServiceUsageFeeAtHome().getParent().setEnabled(true);

  }

  /**
   * 「外泊時在宅サービス利用費用・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_HOME_SERVICE_USAGE() throws Exception {

        getHomeServiceUsageFeeAtHome().setEnabled(false);
        getHomeServiceUsageFeeAtHome().getParent().setEnabled(false);

  }

}
