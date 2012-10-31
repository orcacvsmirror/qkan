package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SC_17211_201204 extends Qkan10011_ServiceUnitGetter {

    public String getServiceName() {
        return "FmÇÎ^Êîì";
    }

    public String getServiceCodeKind() {
        return "72";
    }

    public String getSystemServiceKindDetail() {
        return "17211";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // p[^o
        // =========================================================================

        // 1 vîìx
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1720101 {Ýæª
        int _1720101 = getIntValue(map, "1720101");

        // 1720102 æª
        int _1720102 = getIntValue(map, "1720102");

        // 1720103 Ôæª
        int _1720103 = getIntValue(map, "1720103");

        // 1720104 lõ¸Z
        int _1720104 = getIntValue(map, "1720104");

        // 1720107 ÂÊ@\Pûw±ÁZ
        int _1720107 = getIntValue(map, "1720107");

        // 1720106 üîÁZ
        int _1720106 = getIntValue(map, "1720106");

        // 1720105 h{üPÁZ
        int _1720105 = getIntValue(map, "1720105");

        // 1720108 ûo@\üãÁZ
        int _1720108 = getIntValue(map, "1720108");

        // 1720109 áN«FmÇpÒóüÁZ
        int _1720109 = getIntValue(map, "1720109");

        // 1720110 T[rXñÌ§­»ÁZ
        int _1720110 = getIntValue(map, "1720110");

        // 16 ¯ê¨ZÒÖÌT[rXñ
        int _16 = getIntValue(map, "16");

        // 17 îìEõöüPÁZ
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // Æ©R[h¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // {Ýæª
        sb.append(CODE_CHAR[_1720101]);

        // æª
        sb.append(CODE_CHAR[_1720102]);

        // Ôæª
        sb.append(CODE_CHAR[_1720103]);

        // lõ¸Z
        sb.append(CODE_CHAR[_1720104]);

        // vîìx
        sb.append(CODE_CHAR[_1]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ÁZ
        // ============================================================================

        // üîÁZ
        if (_1720106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        // ÂÊ@\Pûw±ÁZ
        if (_1720107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5050");
        }
        
        // 6109 \FÊîìáN«FmÇóüÁZ
        if (_1720109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }

        // h{üPÁZ
        if (_1720105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // ûo@\üãÁZ
        if (_1720108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5607");
        }

        // FmÊîì}¸Z(¯ê¨ZÒÖÌT[rXñ)
        if (_16 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }

        switch (_1720110) {
        case 2:
            // 6101 \FÊîT[rXñÌ§ÁZI
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 \FÊîT[rXñÌ§ÁZII
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        }

        // îìEõöüPðÔp
        switch (_17) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        }

        return sysSvcCdItems;
    }

}
