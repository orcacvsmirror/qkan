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
 * ì¬ú: 2006/01/13  ú{Rs[^[®ïÐ ¡´@L VKì¬
 * XVú: ----/--/--
 * VXe tÇä  (Q)
 * TuVXe ¿oÍ (P)
 * vZX ÝîT[rXîìtï¾×iîj (001)
 * vO ÝîT[rXîìtï¾×iîj (QP001P031)
 *
 *****************************************************************
 */
package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.pdf.ACChotarouXMLUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRList;
import jp.nichicom.vr.util.VRMap;

public class QP001P021_201204 extends QP001P02_201204{
    
	//l®æñ 201204NÈ~

    public void addFormat() throws Exception {
        ACChotarouXMLUtilities.addFormat(writer, getFormatId(), "QP001P021_201204.xml");
    }

    public String getFormatId() throws Exception {
        return "QP001P021_201204";
    }
    
    public void doPrintDetailList(VRList detailList,int kohiCount) throws Exception {
        setDetailList(detailList,11,kohiCount);
    }
    
    @Override
    public double getDetailRowCount() {
        return 10d;
    }

    public void doPrintReductionList(VRList reductionList) throws Exception {
        
        if (reductionList.getDataSize() > 0) {
            //y¸¦ðÝè·éB
            ACChotarouXMLUtilities.setValue(writer, "keigenritsu",
                    pad(VRBindPathParser.get("901007",
                            (VRMap) reductionList.getData(0)), 4));

            for (int j = 0; j < reductionList.getDataSize(); j++) {
                VRMap reduction = (VRMap) reductionList.getData(j);
                
                String kind = ACCastUtilities.toString(VRBindPathParser.get("901008", reduction));
                
                //kindªT[rXíÞR[h
                //11:KâîìA15:ÊîìA76:èúñA71:éÔÎ^A72:FmÇÎ^
                //73:¬KÍ½@\A77:¡^
                
                //pÒSzÌzðÝè
                ACChotarouXMLUtilities.setValue(writer, "jyuryo" + kind, pad(VRBindPathParser.get("901009", reduction), 6));
                //y¸zðÝè
                ACChotarouXMLUtilities.setValue(writer, "keigen" + kind, pad(VRBindPathParser .get("901010", reduction), 6));
                //y¸ãpÒSzðÝè
                ACChotarouXMLUtilities.setValue(writer, "keigengo" + kind, pad(VRBindPathParser.get("901011", reduction), 6));
                //õl
                ACChotarouXMLUtilities.setValue(writer, "syafuku.h" + kind + ".biko", VRBindPathParser.get("901012", reduction));
            }
        }
    }

}
