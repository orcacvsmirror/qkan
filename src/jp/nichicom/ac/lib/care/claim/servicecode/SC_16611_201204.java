package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SC_16611_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "介護予防通所リハ";
    }

    public String getServiceCodeKind() {
        return "66";
    }

    public String getSystemServiceKindDetail() {
        return "16611";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1660101 人員減算　1-なし 2-定員超過 3-医師、PT・OT・ST、看護・介護職員の欠員
        int _1660101 = getIntValue(map, "1660101", 1);

        // 1660102 日割　1-日割でない 2-日割である
        int _1660102 = getIntValue(map, "1660102", 1);

        // 1660103 運動器機能向上加算　1-なし 2-あり
        int _1660103 = getIntValue(map, "1660103", 1);

        // 1660104 栄養改善加算　1-なし 2-あり
        int _1660104 = getIntValue(map, "1660104", 1);

        // 1660105 口腔機能向上加算　1-なし 2-あり
        int _1660105 = getIntValue(map, "1660105", 1);

        // 1660106 事業所評価加算　1-なし 2-あり
        int _1660106 = getIntValue(map, "1660106", 1);

        // 1660107 若年性認知症利用者受入加算
        int _1660107 = getIntValue(map, "1660107", 1);

        // 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 1660108 サービス提供体制強化加算
        int _1660108 = getIntValue(map, "1660108", 1);

        // 1660110 施設区分ラジオグループ
        int _1660110 = getIntValue(map, "1660110", 1);

        // 16 送迎の必要性
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
            // 1660103 運動器機能向上加算　1-なし 2-あり
            if (_1660103 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
            }
            
            // 1660104 栄養改善加算　1-なし 2-あり
            if (_1660104 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
            }
            
            // 1660105 口腔機能向上加算　1-なし 2-あり
            if (_1660105 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
            }
            
            // 介護職員処遇改善を返却
            switch (_17) {
            case 2:
                // 予防通所リハ処遇改善加算I
                putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
                break;
            case 3:
                // 予防通所リハ処遇改善加算II
                putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
                break;
            case 4:
                // 予防通所リハ処遇改善加算III
                putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
                break;
            }
            
            return sysSvcCdItems;
        }
        // [ID:0000746][Masahiko.Higuchi] 2012/06/20 add - end
        
        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設区分 1-病院又は診療所　2-介護老人保健施設
        sb.append(CODE_CHAR[_1660110]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 人員減算　1-なし 2-定員超過 3-医師、PT・OT・ST、看護・介護職員の欠員
        sb.append(CODE_CHAR[_1660101]);

        // 日割　1-日割でない 2-日割である
        sb.append(CODE_CHAR[_1660102]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 6109 予防通所リハ若年性認知症受入加算
        if (_1660107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6109");
        }
        
        // 同一建物居住者へのサービス提供がありの場合
        if (_16 > 1) {
            
            //施設区分を確認
            switch (_1660110) {
            case 1: // 病院又は診療所
                // 要介護度
                switch(_1) {
                case 3: // 要支援１
                    // 予防通所リハ送迎減算１１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
                    break;
                case 4: // 要支援２
                    // 予防通所リハ送迎減算１２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                    break;
                }
                break;
            case 2: // 介護老人保健施設
                // 要介護度
                switch(_1) {
                case 3: // 要支援１
                    // 予防通所リハ送迎減算２１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
                    break;
                case 4: // 要支援２
                    // 予防通所リハ送迎減算２２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                    break;
                }
                break;
            }
        }
        
        
        // 運動器機能向上加算、栄養改善加算、口腔機能向上加算の例外処理
        // 
        // [運動器機能向上加算のフラグ][栄養改善加算のフラグ][口腔機能向上加算のフラグ]
        // という並びの3桁の数値を作成して分岐（フラグは 1-なし 2-あり）
        int addParam = (_1660103 * 100) + (_1660104 * 10) + _1660105;
        
        switch(addParam) {
        // 運動器機能向上加算
        case 211:
            // 予防通所リハ運動器機能向上加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z5002");
            break;
        // 栄養改善加算
        case 121:
            // 予防通所リハ栄養改善加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z5003");
            break;
        // 口腔機能向上加算
        case 112:
            // 予防通所リハ口腔機能向上加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z5004");
            break;
        // 運動器機能向上加算 + 栄養改善加算
        case 221:
            // 予通リハ複数サービス実施加算I１
            putSystemServiceCodeItem(sysSvcCdItems, "Z5006");
            break;
        // 運動器機能向上加算 + 口腔機能向上加算
        case 212:
            // 予通リハ複数サービス実施加算I２
            putSystemServiceCodeItem(sysSvcCdItems, "Z5007");
            break;
        // 栄養改善加算 + 口腔機能向上加算
        case 122:
            // 予通リハ複数サービス実施加算I３
            putSystemServiceCodeItem(sysSvcCdItems, "Z5008");
            break;
        // 運動器機能向上加算 + 栄養改善加算 + 口腔機能向上加算
        case 222:
            // 予通リハ複数サービス実施加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z5009");
            break;
        }
        
        // 事業所評価加算　1-なし 2-あり
        if (_1660106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z5005");
        }
        
        // サービス提供体制強化加算
        switch (_1660108) {
        case 2: // I型
            // 要介護度
            switch (_1) {
            case 3: // 要支援１
                // 予通リハサービス提供体制加算I１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
                break;
            case 4: // 要支援２
                // 予通リハサービス提供体制加算I２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
                break;
            }
            break;
            
        case 3: // II型
            // 要介護度
            switch (_1) {
            case 3: // 要支援１
                // 予通リハサービス提供体制加算II１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
                break;
            case 4: // 要支援２
                // 予通リハサービス提供体制加算II２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            }
            break;
        }
        
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 2:
            // 予防通所リハ処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");
            break;
        case 3:
            // 予防通所リハ処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6113");
            break;
        case 4:
            // 予防通所リハ処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6115");
            break;
        }
        
        
        // 日割りではない場合
        if (_1660102 == 1) {
            
            if (_12 > 1) {
                // 8110 予防通所リハ中山間地域等提供加算
                putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
            }
            
            
        // 日割りの場合
        } else {
            
            if (_12 > 1) {
                // 8111 予防通所リハ中山間地域等加算日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z8111");
            }
            
        }

        return sysSvcCdItems;
    }
}
