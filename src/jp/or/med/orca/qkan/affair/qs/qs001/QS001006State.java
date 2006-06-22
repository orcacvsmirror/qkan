
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
 * 作成日: 2006/04/16  日本コンピューター株式会社 堤 瑞樹 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 予定管理 (S)
 * プロセス サービスパターン訪問看護(医療) (001)
 * プログラム サービスパターン訪問看護(医療) (QS001006)
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
 * サービスパターン訪問看護(医療)状態定義(QS001006) 
 */
public class QS001006State extends QS001006Design {
  /**
   * コンストラクタです。
   */
  public QS001006State(){
  }

  /**
   * 「基本医療費I・選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_IRYO_BASIC_CHARGE1_SELECTED() throws Exception {

        getHoumonKangoIryoClass().setEnabled(true);

        getHoumonKangoIryoIntractableDiseaseRadio().setEnabled(true);

        getHoumonKangoIryoExtensionTimeText().setEnabled(false);

        getHoumonKangoIryoExtensionTimeLabel().setEnabled(false);

  }

  /**
   * 「基本医療費II・選択」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_IRYO_BASIC_CHARGE2_SELECTED() throws Exception {

        getHoumonKangoIryoClass().setEnabled(false);

        getHoumonKangoIryoIntractableDiseaseRadio().setEnabled(false);

        getHoumonKangoIryoExtensionTimeText().setEnabled(true);

        getHoumonKangoIryoExtensionTimeLabel().setEnabled(true);

  }

  /**
   * 「共同指導加算・有効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_VALID_GUIDANCE() throws Exception {

        getHoumonKangoIryoGuidanceRadio().setEnabled(true);

  }

  /**
   * 「共同指導加算・無効」の状態に設定します。
   * @throws Exception 処理例外
   */
  public void setState_INVALID_GUIDANCE() throws Exception {

        getHoumonKangoIryoGuidanceRadio().setEnabled(false);

  }

}
