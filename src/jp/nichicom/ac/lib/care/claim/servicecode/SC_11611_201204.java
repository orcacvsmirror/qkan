package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Ênre[V
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_11611_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "Ênre[V";
    }

    public String getServiceCodeKind() {
        return "16";
    }

    public String getSystemServiceKindDetail() {
        return "11611";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // p[^o
        // =========================================================================
        // 1160116 {Ýæª
        int _1160116 = getIntValue(map, "1160116" ,1);

        // 1160104 Ôæª
        int _1160104 = getIntValue(map, "1160104" ,1);

        // 1160109 lõ¸Z
        int _1160109 = getIntValue(map, "1160109" ,1);

        // 1 vîìx
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1160105 üÁZ
        int _1160105 = getIntValue(map, "1160105" ,1);

        // 1160107 nrKâw±ÁZ
        int _1160107 = getIntValue(map, "1160107" ,1);

        // 1160111 nre[VE}lWgÁZ
        int _1160111 = getIntValue(map, "1160111" ,1);

        // 1160112 ZúWnre[VÀ{ÁZ
        int _1160112 = getIntValue(map, "1160112" ,1);

        // 1160114 h{üPÁZ
        int _1160114 = getIntValue(map, "1160114" ,1);

        // 1160115 ûo@\üãÁZ
        int _1160115 = getIntValue(map, "1160115" ,1);
        
        // 1160118 ÂÊnrÀ{ÁZ
        int _1160118 = getIntValue(map, "1160118" , 1);
        
        // 1160119 wÃ@mÌ§­»ÁZ
        int _1160119 = getIntValue(map, "1160119" , 1);
        
        // 1160120 FmÇZúWnrÀ{ÁZ
        int _1160120 = getIntValue(map, "1160120" , 1);
        
        // 1160121 áN«FmÇpÒóüÁZ
        int _1160121 = getIntValue(map, "1160121" , 1);
        
        // 12 RÔnæÅÌT[rXñÁZ
        int _12 = getIntValue(map, "12", 1);
        
        // 1160122 T[rXñÌ§­»ÁZ
        int _1160122 = getIntValue(map, "1160122" ,1);
        
        // 1160123 dxÃ{ÇÁZ
        int _1160123 = getIntValue(map, "1160123", 1);

        // 16 ¯ê¨ZÒÖÌT[rXñ
        int _16 = getIntValue(map, "16", 1);
        
        // 17 îìEõöüPÁZ
        int _17 = getIntValue(map, Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
 
        // KâÅìÃ{ïÌûÎ
        // PÆÁZ
        int _9 = getIntValue(map,"9");
 
        // PÆÁZÌÝ---------------------------------------------------------------
        // PÆÁZT[rX
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // nrKâw±ÁZ
            if (_1160107 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5400");
            }
            
            // [ID:0000710][Shin Fujihara] 2010/11 add begin 2012NxÎ
            // 6111 ÊnÂÊnrÁZ
            if (_1160118 > 1) {
                // ñÔÅªò
                // PÔÈãQÔ¢Ìê
                if (_1160104 == 1) {
                    // ÊnÂÊnrÁZP
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                    
                // QÔÈãÌê
                } else  {
                    // ÊnÂÊnrÁZQ
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6112");
                }
            }
            //[ID:0000710][Shin Fujihara] 2010/11 add end 2012NxÎ
            
            // îìEõöüPðÔp
            switch(_17){
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
        
        // Æ©R[h¶¬
        // ===========================================================================
        StringBuilder sb = new StringBuilder();
        
        // {ÝæªªðP ÊíKÍAåKÍÆIAåKÍÆII
        int sisetuKubun1 = 1;
        switch (_1160116) {
        // ÊíKÍ(a@EfÃ)
        case 1:
        // ÊíKÍ(V{Ý)
        case 2:
            sisetuKubun1 = 1;
            break;
        // åKÍI(a@EfÃ)
        case 3:
        // åKÍI(V{Ý)
        case 4:
            sisetuKubun1 = 2;
            break;
        // åKÍII(a@EfÃ)
        case 5:
        // åKÍII(V{Ý)
        case 6:
            sisetuKubun1 = 3;
            break;
        }
        
        // {ÝæªªðQ a@ÍfÃAîìVlÛ{Ý
        int sisetuKubun2 = 1;
        switch (_1160116) {
        // ÊíKÍ(a@EfÃ)
        case 1:
        // åKÍI(a@EfÃ)
        case 3:
        // åKÍII(a@EfÃ)
        case 5:
            sisetuKubun2 = 1;
            break;
        // ÊíKÍ(V{Ý)
        case 2:
        // åKÍI(V{Ý)
        case 4:
        // åKÍII(V{Ý)
        case 6:
            sisetuKubun2 = 2;
            break;
        }
        
        // {Ýæª(KÍ)
        sb.append(CODE_CHAR[sisetuKubun1]);
        // {Ýæª(`Ô)
        sb.append(CODE_CHAR[sisetuKubun2]);

        // Ôæª
        sb.append(CODE_CHAR[_1160104]);

        // lõ¸Z
        sb.append(CODE_CHAR[_1160109]);
        
        // vîìx
        sb.append(CODE_CHAR[_1]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // ÁZ
        // ============================================================================
        // 6143 ÊnwÃ@mÌ§­»ÁZ
        if (_1160119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6143");
        }
        
        // 8110 ÊnRÔnæñÁZ
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // üÁZ
        if (_1160105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5301");
        }
        
        // nrKâw±ÁZ
        if (_1160107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5400");
        }
        
        // nre[VE}lWgÁZ
        if (_1160111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5601");
        }
        
        // ZúWnre[VÀ{ÁZ
        switch (_1160112) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5602");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5603");
            break;
        }
        
        // 6111 ÊnÂÊnrÁZ
        if (_1160118 > 1) {
            // ñÔÅªò
            // PÔÈãQÔ¢Ìê
            if (_1160104 == 1) {
                // ÊnÂÊnrÁZP
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                
            // QÔÈãÌê
            } else  {
                // ÊnÂÊnrÁZQ
                putSystemServiceCodeItem(sysSvcCdItems, "Z6112");
            }
        }
        
        // 6253 ÊnFmÇZúWnÁZ
        if (_1160120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6253");
        }
        
        // 6109 ÊnáN«FmÇóüÁZ
        if (_1160121 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // h{üPÁZ
        if (_1160114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5605");
        }
        
        // ûo@\üãÁZ
        if (_1160115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5606");
        }
        
        // dxÃ{ÇÁZ
        if (_1160123 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5610");
        }
        
        // Ên}¸Z
        if (_16 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5611");
        }
        
        // ÊnT[rXñÌ§ÁZ
        switch (_1160122) {
        // ÊnT[rXñÌ§ÁZI
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        // ÊnT[rXñÌ§ÁZII
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        }
        
        // îìEõöüPðÔp
        switch(_17){
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
