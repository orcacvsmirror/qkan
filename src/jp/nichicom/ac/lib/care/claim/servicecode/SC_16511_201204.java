package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 介護予防通所介護
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_16511_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "介護予防通所介護";
    }

    public String getServiceCodeKind() {
        return "65";
    }

    public String getSystemServiceKindDetail() {
        return "16511";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1650101 人員減算　1-なし 2-定員超過 3-看護・介護職員が欠員
        int _1650101 = getIntValue(map, "1650101", 1);

        // 1650102 日割　1-日割でない 2-日割である
        int _1650102 = getIntValue(map, "1650102", 1);

        // 1650103 生活機能向上グループ活動加算　1-なし 2-あり
        int _1650103 = getIntValue(map, "1650103", 1);

        // 1650104 運動器機能向上加算　1-なし 2-あり
        int _1650104 = getIntValue(map, "1650104", 1);

        // 1650105 栄養改善加算　1-なし 2-あり
        int _1650105 = getIntValue(map, "1650105", 1);

        // 1650106 口腔機能向上加算　1-なし 2-あり
        int _1650106 = getIntValue(map, "1650106", 1);

        // 1650107 事業所評価加算　1-なし 2-あり
        int _1650107 = getIntValue(map, "1650107", 1);

        // 1650108 若年性認知症利用者受入加算
        int _1650108 = getIntValue(map, "1650108", 1);

        // 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 1650109 サービス提供体制強化加算
        int _1650109 = getIntValue(map, "1650109");

        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);
        
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - begin  加算のみ対応
        // 加算のみ(運動機器・栄養改善・口腔機能向上)
        int _9 = getIntValue(map,"9");

        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // 1650104 運動器機能向上加算　1-なし 2-あり
            if (_1650104 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
            }
            
            // 1650105 栄養改善加算　1-なし 2-あり
            if (_1650105 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
            }
            
            // 1650106 口腔機能向上加算　1-なし 2-あり
            if (_1650106 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
            }
            
            // 介護職員処遇改善を返却
            switch (_17) {
            case 2:
                // 予防通所介護処遇改善加算I
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                break;
            case 3:
                // 予防通所介護処遇改善加算II
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
                break;
            case 4:
                // 予防通所介護処遇改善加算III
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
                break;
            }
            
            return sysSvcCdItems;
        }
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - end

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 人員減算　1-なし 2-定員超過 3-看護・介護職員が欠員
        sb.append(CODE_CHAR[_1650101]);

        // 日割　1-日割でない 2-日割である
        sb.append(CODE_CHAR[_1650102]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        
        // 6109 予防通所介護若年性認知症受入加算
        if (_1650108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 同一建物居住者へのサービス提供がありの場合
        if (_16 > 1) {
            
            // 要介護度で分岐
            switch(_1) {
            // 要支援１
            case 3:
                // 予防通所介護送迎減算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                break;
            // 要支援２
            case 4:
                // 予防通所介護送迎減算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            }
            
        }
        
        // 生活機能向上グループ活動加算　1-なし 2-あり
        if (_1650103 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5010");
        }
        
        // 運動器機能向上加算、栄養改善加算、口腔機能向上加算の例外処理
        // 
        // [運動器機能向上加算のフラグ][栄養改善加算のフラグ][口腔機能向上加算のフラグ]
        // という並びの3桁の数値を作成して分岐（フラグは 1-なし 2-あり）
        int addParam = (_1650104 * 100) + (_1650105 * 10) + _1650106;
        
        switch(addParam) {
        // 運動器機能向上加算
        case 211:
            // 予防通所介護運動器機能向上加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
            break;
        // 栄養改善加算
        case 121:
            // 予防通所介護栄養改善加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
            break;
        // 口腔機能向上加算
        case 112:
            // 予防通所介護口腔機能向上加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
            break;
        // 運動器機能向上加算 + 栄養改善加算
        case 221:
            // 予防通介複数サービス実施加算I１
            putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
            break;
        // 運動器機能向上加算 + 口腔機能向上加算
        case 212:
            // 予防通介複数サービス実施加算I２
            putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
            break;
        // 栄養改善加算 + 口腔機能向上加算
        case 122:
            // 予防通介複数サービス実施加算I３
            putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
            break;
        // 運動器機能向上加算 + 栄養改善加算 + 口腔機能向上加算
        case 222:
            // 予防通介複数サービス実施加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
            break;
        }
        
        // 事業所評価加算　1-なし 2-あり
        if (_1650107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5005");
        }
        
        switch (_1650109) {
        case 2:
            if (_1 == 3) {
                // 要支援１の場合
                // 6101 予防通所サービス提供体制加算I１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            } else if (_1 == 4) {
                // 要支援２の場合
                // 6102 予防通所サービス提供体制加算I２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            }
            break;
        case 3:
            if (_1 == 3) {
                // 要支援１の場合
                // 6103 予防通所サービス提供体制加算II１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            } else if (_1 == 4) {
                // 要支援２の場合
                // 6104 予防通所サービス提供体制加算II２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            }
            break;
        }
        
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 2:
            // 予防通所介護処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
            break;
        case 3:
            // 予防通所介護処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            break;
        case 4:
            // 予防通所介護処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            break;
        }
        
        
        // 日割りではない場合
        if (_1650102 == 1) {
            
            // 8110 予防通所介護中山間地域等提供加算
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
            }
            
            
        // 日割りの場合
        } else {
            
            // 8111 予防通所介護中山間地域等加算日割
            if (_12 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
            }
        }

        return sysSvcCdItems;
    }

}
