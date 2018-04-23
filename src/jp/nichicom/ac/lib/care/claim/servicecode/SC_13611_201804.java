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
public class SC_13611_201804 extends Qkan10011_ServiceUnitGetter {
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

        // 1360107 認知症専門ケア加算
        int _1360107 = getIntValue(map, "1360107", 1);
        
        // 1360109 身体拘束廃止未実施減算
        int _1360109 = getIntValue(map, "1360109", 1);
        
        // 1360110 入居継続支援加算
        int _1360110 = getIntValue(map, "1360110", 1);
        
        // 1360111 生活機能向上連携加算
        int _1360111 = getIntValue(map, "1360111", 1);
        
        // 1360112 若年性認知症受入加算
        int _1360112 = getIntValue(map, "1360112", 1);
        
        // 1360113 口腔衛生管理体制加算
        int _1360113 = getIntValue(map, "1360113", 1);
        
        // 1360114 栄養スクリーニング加算
        int _1360114 = getIntValue(map, "1360114", 1);
        
        // 1360115 退院・退所時連携加算
        int _1360115 = getIntValue(map, "1360115", 1);
        
        // 1360108 サービス提供体制強化加算
        int _1360108 = getIntValue(map, "1360108", 1);

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
        
        // 1360107 認知症専門ケア加算
        switch (_1360107) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");//2015.04
            break;
        }        
        
        // 1360109 身体拘束廃止未実施減算 //2018.04
        if (_1360109 > 1) {
            StringBuilder sb1 = new StringBuilder();
            // プレフィックス
            sb1.append(SYSTEM_SERVICE_CODE_PREFIX_SK);
            // 要介護度
            sb1.append(CODE_CHAR[_1]);
            putSystemServiceCodeItem(sysSvcCdItems, sb1.toString());
        }
        
        // 1360110 入居継続支援加算
        if (_1360110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6320");//2018.04
        }
        
        // 1360111 生活機能向上連携加算
        if (_1360111 > 1) {
        	if (_1360102 > 1) { //個別機能訓練指導加算を算定している場合
        		putSystemServiceCodeItem(sysSvcCdItems, "Z4003"); //2018.04
        	} else {
        		putSystemServiceCodeItem(sysSvcCdItems, "Z4002"); //2018.04
        	}
        }
        
        // 1360112 若年性認知症受入加算
        if (_1360112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");//2018.04
        }
        
        // 1360113 口腔衛生管理体制加算
        if (_1360113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6122");//2018.04
        }
        
        // 1360114 栄養スクリーニング加算
        if (_1360114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6201");//2018.04
        }
        
        // 1360115 退院・退所時連携加算
        if (_1360115 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6330");//2018.04
        }  
        
        
        // 1360108 サービス提供体制加算
        switch (_1360108) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");//2015.04
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");//2015.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");//2015.04
            break;
        }
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6132");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6131");//2015.04
            break;
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
