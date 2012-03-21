
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
 * サブシステム 実績データ作成 (P)
 * プロセス 明細書詳細編集 (005)
 * プログラム 特定診療費レコード追加 (QP005001)
 *
 *****************************************************************
 */
package jp.or.med.orca.qkan.affair.qp.qp005;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * 特定診療費レコード追加イベント定義(QP005001) 
 */
public abstract class QP005001Event extends QP005001SQL {
  /**
   * コンストラクタです。
   */
  public QP005001Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getAddButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                addButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getCancelButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                cancelButtonActionPerformed(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getServiceCodeDetailText().addFocusListener(new FocusAdapter(){
        private boolean lockFlag = false;
        public void focusLost(FocusEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                serviceCodeDetailTextFocusLost(e);
            }catch(Throwable ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //コンポーネントイベント

  /**
   * 「追加」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void addButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「キャンセル」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void cancelButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「サービスコード変換」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void serviceCodeDetailTextFocusLost(FocusEvent e) throws Exception;

  //変数定義

  private VRMap values = new VRHashMap();
  private boolean isAdd = false;
  private Date targetDate;
  //getter/setter

  /**
   * valuesを返します。
   * @return values
   */
  protected VRMap getValues(){
    return values;
  }
  /**
   * valuesを設定します。
   * @param values values
   */
  protected void setValues(VRMap values){
    this.values = values;
  }

  /**
   * isAddを返します。
   * @return isAdd
   */
  protected boolean getIsAdd(){
    return isAdd;
  }
  /**
   * isAddを設定します。
   * @param isAdd isAdd
   */
  protected void setIsAdd(boolean isAdd){
    this.isAdd = isAdd;
  }

  /**
   * targetDateを返します。
   * @return targetDate
   */
  protected Date getTargetDate(){
    return targetDate;
  }
  /**
   * targetDateを設定します。
   * @param targetDate targetDate
   */
  protected void setTargetDate(Date targetDate){
    this.targetDate = targetDate;
  }

  //内部関数

  /**
   * 「初期化」に関する処理を行ないます。
   *
   * @param targetDate Date
   * @throws Exception 処理例外
   *
   */
  public abstract void showModal(Date targetDate) throws Exception;

  /**
   * 「入力チェック」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean isValidData() throws Exception;

  /**
   * 「サービスコード名称置換処理」に関する処理を行ないます。
   *
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean setServiceCode() throws Exception;

  /**
   * 「サービスコードチェック処理」に関する処理を行ないます。
   *
   * @param isMessageShow boolean
   * @throws Exception 処理例外
   * @return boolean
   */
  public abstract boolean checkServiceCode(boolean isMessageShow) throws Exception;

}
