package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * ¬KÍ½@\^îîì
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_16811_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "¬KÍ½@\^îîì(Zúp)";
    }

    public String getServiceCodeKind() {
        return "68";
    }

    public String getSystemServiceKindDetail() {
        return "16811";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // p[^o
        // =========================================================================
        // 1 vîìx
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1680101 lõ¸Z 1-Èµ 2-èõ´ß 3-îì]Æõs«
        int _1680101 = getIntValue(map, "1680101");

        // 1680102 T[rXñÌ§­»ÁZ
        int _1680102 = getIntValue(map, "1680102");

        // 1680104 ¶@\üãAgÁZ
        int _1680104 = getIntValue(map, "1680104", 1);
        
        // 17 îìEõöüPÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);



        // Æ©R[h¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();


        // vîìx
        sb.append(CODE_CHAR[_1]);
        // lõ¸Z 1-Èµ 2-èõ´ß 3-îì]Æõs«
        sb.append(CODE_CHAR[_1680101]);

        

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ÁZ
        // ============================================================================
        
        // 1680104 ¶@\üãAgÁZ
        switch(_1680104) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");//2018.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");//2018.04
            break;
        }
        
        switch (_1680102) {
        case 5:
            //  ¬½@\^T[rXñÌ§ÁZIC
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 ¬½@\^T[rXñÌ§ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//2015.04
            break;
        case 3:
            // 6102 ¬½@\^T[rXñÌ§ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");//2015.04
            break;
        case 4:
            // 6103 ¬½@\^T[rXñÌ§ÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");//2015.04
            break;
        }

        // îìEõöüPðÔp
        switch (_17) {
        case 6:
            // ¬KÍ½@\^öüPÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2017.04
            break;
        case 5:
            // ¬KÍ½@\^öüPÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
            break;
        case 2:
            // ¬KÍ½@\^öüPÁZIII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");//2015.04
            break;
        case 3:
            // ¬KÍ½@\^öüPÁZIV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");//2015.04
            break;
        case 4:
            // ¬KÍ½@\^öüPÁZV
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2015.04
            break;
        }

        return sysSvcCdItems;
    }
}
