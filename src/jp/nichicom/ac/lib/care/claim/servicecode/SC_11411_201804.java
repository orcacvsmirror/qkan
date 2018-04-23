package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 訪問リハビリテーション
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_11411_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "訪問リハビリテーション";
    }

    public String getServiceCodeKind() {
        return "14";
    }

    public String getSystemServiceKindDetail() {
        return "11411";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        
        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        // 明らかに要介護度がおかしい場合は空を返す
        switch(_1){
        case 1: // 自立
        case 3: // 要支援１
        case 4: // 要支援２
        case 10: // 事業対象者
            return new ArrayList<HashMap<String, String>>();
        }
        
        // 1140103 施設区分
        int _1140103 = getIntValue(map, "1140103");

        // 1140106 短期集中リハビリテーション実施加算
        int _1140106 = getIntValue(map, "1140106");

        // 12 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);   
        
        // 中山間地域等小規模事業所加算
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 2 特別地域加算
        int _2 = getIntValue(map, "2");
        
        // 1140113 計画診療未実施減算
        int _1140113 = getIntValue(map, "1140113");
        
        // 1140107 サービス提供体制強化加算
        int _1140107 = getIntValue(map, "1140107" ,1);

        // 23 同一建物減算
        int _23 = getIntValue(map, "23", 1);

        // リハビリテーション・マネジメント加算
        int _1140110 = getIntValue(map, "1140110");
        
        // 社会参加支援加算
        int _1140112 = getIntValue(map, "1140112", 1);
        
        // 加算のみ
        int _9 = getIntValue(map,"9");
        
        
        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // リハビリテーション・マネジメント加算
            switch (_1140110) {
            // II型
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z5005");//2015.04
                break;
            // III型
    		case 4:
    			putSystemServiceCodeItem(sysSvcCdItems, "Z5006");// 2018.04
    			break;
    		// IV型
    		case 5:
    			putSystemServiceCodeItem(sysSvcCdItems, "Z5007");// 2018.04
    			break;
            }
            return sysSvcCdItems;
        }
        
        
        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分
        sb.append(CODE_CHAR[_1140103]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        
        // 特別地域加算
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");//2018.04
        }
        
        // 訪問介護小規模事業所加算
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");//2018.04
        }
        
        // 8110 訪問リハ中山間地域等提供加算
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // 短期集中リハビリテーション実施加算
        if (_1140106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5003");//2015.04
        }
        
        
        // 6101 訪問リハサービス提供体制加算
        if (_1140107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
        }
        
        // リハビリテーション・マネジメント加算
        switch (_1140110) {
        // I型
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5004");//2015.04
            break;
        // II型
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z5005");//2015.04
            break;
		// III型
		case 4:
			putSystemServiceCodeItem(sysSvcCdItems, "Z5006");// 2018.04
			break;
		// IV型
		case 5:
			putSystemServiceCodeItem(sysSvcCdItems, "Z5007");// 2018.04
			break;
		}
        
        // 社会参加支援加算
        if (_1140112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6110");//2015.04
        }
        
        // 同一建物減算 //2018.04
        switch (_23) {
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4111");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z4112");
            break;
        }
        
        // 計画診療未実施減算
        if (_1140113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5010");// 2018.04
        }
        
        return sysSvcCdItems;
    }

}
