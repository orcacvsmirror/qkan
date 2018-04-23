package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 介護予防認知症対応型共同生活介護(短期利用以外)
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_13711_201804 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "介護予防認知症対応型共同生活介護(短期利用以外)";
    }

    public String getServiceCodeKind() {
        return "37";
    }

    public String getSystemServiceKindDetail() {
        return "13711";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1370101 初期加算　1-なし 2-あり
        int _1370101 = getIntValue(map, "1370101", 1);

        // 1370102 人員減算　1-なし 2-定員超過 3-介護従業員の不足
        int _1370102 = getIntValue(map, "1370102", 1);

        // 1370103 夜間勤務条件基準　1-満たしている 2-満たしていない
        int _1370103 = getIntValue(map, "1370103", 1);

        // 1370104 夜間支援体制加算
        int _1370104 = getIntValue(map, "1370104", 1);

        // 1370105 若年性認知症利用者受入加算
        int _1370105 = getIntValue(map, "1370105", 1);

        // 1370106 認知症専門ケア加算
        int _1370106 = getIntValue(map, "1370106", 1);

        // 1370108 退居時相談援助加算
        int _1370108 = getIntValue(map, "1370108", 1);

        // 1370107 サービス提供体制強化加算
        int _1370107 = getIntValue(map, "1370107", 1);

        // 1370109 施設等の区分
        int _1370109 = getIntValue(map, "1370109", 1);

        // 1370110 身体拘束廃止未実施減算
        int _1370110 = getIntValue(map, "1370110", 1);
        
        // 1370111 入院時費用
        int _1370111 = getIntValue(map, "1370111", 1);

        // 1370112 生活機能向上連携加算
        int _1370112 = getIntValue(map, "1370112", 1);
        
        // 1370113 口腔衛生管理体制加算
        int _1370113 = getIntValue(map, "1370113", 1);
        
        // 1370114 栄養スクリーニング加算
        int _1370114 = getIntValue(map, "1370114", 1);
        
        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        
        // 加算のみ(退院時共同指導加算対応)
        int _9 = getIntValue(map, "9");
        
        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            
            // 初期加算　1-なし 2-あり
            if (_1370101 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z1550");
            }

            // 予認知症対応退居時相談援助加算 2015.04 一応足した
            if (_1370108 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
            }
            
            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }

            return sysSvcCdItems;
        }
        
        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分
        sb.append(CODE_CHAR[_1370109]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 夜間勤務条件基準　1-満たしている 2-満たしていない
        sb.append(CODE_CHAR[_1370103]);

        // 人員減算　1-なし 2-定員超過 3-介護従業員の不足
        sb.append(CODE_CHAR[_1370102]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 予認知症対応夜間支援体制加算
        if (_1370104 > 1) {
            //施設区分により分岐
            switch (_1370109) {
            case 1: // I型
                putSystemServiceCodeItem(sysSvcCdItems, "Z6161");//2015.04
                break;
            case 2: // II型
                putSystemServiceCodeItem(sysSvcCdItems, "Z6171");//2015.04
                break;
            }
        }
        
        // 6109 予認知症対応若年性認知症受入加算
        if (_1370105 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 初期加算　1-なし 2-あり
        if (_1370101 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z1550");
        }
        
        // 6502 予認知症対応退居時相談援助加算
        if (_1370108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6502");
        }
        
        switch (_1370106) {
        case 2:
            // 6133 予認知症対応認知症専門ケア加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            break;
        case 3:
            // 6134 予認知症対応認知症専門ケア加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
            break;
        }
        
        // 身体拘束廃止未実施減算 //2018.04
        if (_1370110 > 1) {
            StringBuilder sb1 = new StringBuilder();
            // プレフィックス
            sb1.append(SYSTEM_SERVICE_CODE_PREFIX_SK);
            // 施設等の区分
            sb1.append(CODE_CHAR[_1370109]);
            // 要介護度
            sb1.append(CODE_CHAR[_1]);
            putSystemServiceCodeItem(sysSvcCdItems, sb1.toString());
        }

        // 生活機能向上連携加算
        if (_1370112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");//2018.04
        }
        
        // 口腔衛生管理体制加算
        if (_1370113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6122");//2018.04
        }
        
        // 栄養スクリーニング加算
        if (_1370114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6201");//2018.04
        }
        
        switch (_1370107) {
        case 5:
            // 6100 予認知対応サービス提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");//2015.04
            break;
        case 2:
            // 6101 予認知対応サービス提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 予認知対応サービス提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 6103 予認知対応サービス提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 6:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
            break;
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        }

        // 2018/03/05 [H30.4改正対応][Shinobu Hitaka] add - begin
        // 入院時費用がありだった場合は一律入院時費用のコードを返す
        if (_1370111 > 1) {        
            // 内部サービスコードを初期化
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // 入院時費用にあたるサービスコードを追加
            putSystemServiceCodeItem(sysSvcCdItems, "Z6400");

            // 介護職員処遇改善を返却
            switch (_17) {
            case 6:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");//2017.04
                break;
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6107");//2015.04
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }
        }
        // 2018/03/05 [H30.4改正対応][Shinobu Hitaka] add - end
        
        return sysSvcCdItems;
    }
}
