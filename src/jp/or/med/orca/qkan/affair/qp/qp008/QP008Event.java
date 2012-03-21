
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
 * 開発者: 藤原　伸
 * 作成日: 2006/02/16  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス CSV出力 (008)
 * プログラム フォルダ選択 (QP008)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qp.qp008;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.nichicom.ac.ACCommon;
import jp.nichicom.vr.util.VRHashMap;
import jp.nichicom.vr.util.VRMap;

/**
 * フォルダ選択イベント定義(QP008) 
 */
public abstract class QP008Event extends QP008State {
  /**
   * コンストラクタです。
   */
  public QP008Event(){
    addEvents();
  }
  /**
   * イベント発生条件を定義します。
   */
  protected void addEvents() {
    getOk().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                okActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getGoBack().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                goBackActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getCancel().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                cancelActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSaveStandardButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                saveStandardButtonActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });
    getSaveOptionButton().addActionListener(new ActionListener(){
        private boolean lockFlag = false;
        public void actionPerformed(ActionEvent e) {
            if (lockFlag) {
                return;
            }
            lockFlag = true;
            try {
                saveOptionButtonActionPerformed(e);
            }catch(Exception ex){
                ACCommon.getInstance().showExceptionMessage(ex);
            }finally{
                lockFlag = false;
            }
        }
    });

  }
  //コンポーネントイベント

  /**
   * 「OK押下時の処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void okActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「戻る押下時の処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void goBackActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「キャンセル押下時の処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void cancelActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「A:ボタン押下時の処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void saveStandardButtonActionPerformed(ActionEvent e) throws Exception;

  /**
   * 「任意のフォルダ:押下時の処理」イベントです。
   * @param e イベント情報
   * @throws Exception 処理例外
   */
  protected abstract void saveOptionButtonActionPerformed(ActionEvent e) throws Exception;

  //変数定義

  private VRMap values = new VRHashMap();
  private boolean outPut;
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
   * outPutを返します。
   * @return outPut
   */
  protected boolean getOutPut(){
    return outPut;
  }
  /**
   * outPutを設定します。
   * @param outPut outPut
   */
  protected void setOutPut(boolean outPut){
    this.outPut = outPut;
  }

}
