
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
 * J­Ò: ¡´@L
 * ì¬ú: 2006/01/17  ú{Rs[^[®ïÐ ¡´@L VKì¬
 * XVú: ----/--/--
 * VXe tÇä  (Q)
 * TuVXe ¿oÍ (P)
 * vZX ÝîT[rXîìtï¾×iîìVlÛ{Ýj (001)
 * vO ÝîT[rXîìtï¾×iîìVlÛ{Ýj (QP001052)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;

public class QP001P042_201804 extends QP001P04_201804{
    
    // l®ælÌñ 201804È~

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P042_201804.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P042_201804";
    }

}
