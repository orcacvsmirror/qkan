package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 地域密着型特定施設入居者生活介護
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13611_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "地域密着型特定施設入居者生活介護";
    }

    public String getServiceCodeKind() {
        return "36";
    }

    public String getSystemServiceKindDetail() {
        return "13611";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1360102 個別機能訓練指導加算 1-なし 2-あり
        int _1360102 = getIntValue(map, "1360102");

        // 1360101 人員減算 1-なし 2-看護・介護職員不足
        int _1360101 = getIntValue(map, "1360101");

        // 1360103 夜間看護体制加算 1-なし 2-あり
        int _1360103 = getIntValue(map, "1360103");

        // 1360104 医療機関連携加算
        int _1360104 = getIntValue(map, "1360104");

        // 1360106 看取り介護加算
        int _1360106 = getIntValue(map, "1360106");

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 人員減算 1-なし 2-看護・介護職員不足
        sb.append(CODE_CHAR[_1360101]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        // Z6003 地域特定施設個別機能訓練加算
        if (_1360102 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
        }
        
        // Z6123 地域特定施設医療機関連携加算
        if (_1360104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6123");
        }
        
        // 夜間看護体制加算 1-なし 2-あり
        if (_1360103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z2000");
        }
        
        // 1360106 看取り介護加算
        switch(_1360106) {
        case 2:
            // 地域特定施設看取り介護加算１
            putSystemServiceCodeItem(sysSvcCdItems, "Z6125");
            break;
        case 3:
            // 地域特定施設看取り介護加算２
            putSystemServiceCodeItem(sysSvcCdItems, "Z6126");
            break;
        case 4:
            // 地域特定施設看取り介護加算３
            putSystemServiceCodeItem(sysSvcCdItems, "Z6127");
            break;
        }
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
            break;
        }

        return sysSvcCdItems;
    }
}
