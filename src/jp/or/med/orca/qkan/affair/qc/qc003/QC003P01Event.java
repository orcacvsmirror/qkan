
/*
 * Project code name "ORCA"
 * tÇä \tg QKANCHOiJMA care benefit management softwarej
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
 * Av: QKANCHO
 * J­Ò: óû@ëF
 * ì¬ú: 2005/12/19  ú{Rs[^[®ïÐ óû@ëF VKì¬
 * XVú: ----/--/--
 * VXe tÇä  (Q)
 * TuVXe  [Ç (C)
 * vZX VlKâÅìEKâÅìÌîññ (003)
 * vO VlKâÅìEKâÅìÌîññ (QC00301)
 *
 *****************************************************************
 */

package jp.or.med.orca.qkan.affair.qc.qc003;

import jp.nichicom.ac.pdf.ACChotarouXMLWriter;
import jp.nichicom.vr.util.VRMap;

/**
 * VlKâÅìEKâÅìÌîññCxgè`(QC00301) 
 *  [è`Ìt@C¼ F QC00301.xml
 */
public abstract class QC003P01Event  {
  /**
   * RXgN^Å·B
   */
  public QC003P01Event(){
  }
  /**
   * óüµÜ·B
   * @param writer óüÇNX
   * @param printParam óüp^
   * @throws Exception áO
   */
  public abstract boolean doPrint(ACChotarouXMLWriter writer, VRMap printParam) throws Exception;

  //Ïè`

  //getter/setter

}
