package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 複合型サービス（看護小規模多機能型居宅介護・短期利用以外）
 * 
 * @since V7.0.0
 * @author Shinobu Hitaka
 * 
 */
public class SC_17711_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "複合型サービス(看護小規模多機能型居宅介護・短期利用以外)";
    }

    public String getServiceCodeKind() {
        return "77";
    }

    public String getSystemServiceKindDetail() {
        return "17711";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));
        // 明らかに要介護度がおかしい場合は空を返す
        switch (_1) {
        case 1: // 自立
        case 3: // 要支援１
        case 4: // 要支援２
            return new ArrayList<HashMap<String, String>>();
        }

        // 1770101 人員減算
        int _1770101 = getIntValue(map, "1770101", 1);

        // 1770102 過小サービスに対する減算
        int _1770102 = getIntValue(map, "1770102", 1);

        // 1770104 初期加算
        int _1770104 = getIntValue(map, "1770104", 1);

        // 1770105 認知症加算
        int _1770105 = getIntValue(map, "1770105", 1);

        // 1770106 退院時共同指導加算
        int _1770106 = getIntValue(map, "1770106", 1);

        // 1770107 事業開始時支援加算
        int _1770107 = getIntValue(map, "1770107", 1);

        // 1770108 緊急時訪問看護加算
        int _1770108 = getIntValue(map, "1770108", 1);

        // 1770109 特別管理加算
        int _1770109 = getIntValue(map, "1770109", 1);

        // 1770110 ターミナルケア加算
        int _1770110 = getIntValue(map, "1770110", 1);

        // 1770111 サービス提供体制強化加算
        int _1770111 = getIntValue(map, "1770111", 1);

        // 1770112 複合型市町村独自加算
        int _1770112 = getIntValue(map, "1770112", 1);

        // 1770113 訪問看護減算 1-なし 2-あり
        int _1770113 = getIntValue(map, "1770113", 1);

        // 1770114 訪問看護特別指示減算 1-なし 2-あり
        int _1770114 = getIntValue(map, "1770114", 1);

        // 1770115 日割　1-日割でない 2-日割である
        int _1770115 = getIntValue(map, "1770115", 1);
        
        // 1770118 訪問看護体制減算 1-なし 2-あり 2015.04
        int _1770118 = getIntValue(map, "1770118", 1);
        
        // 1770119 訪問看護体制強化加算 1-なし 2-あり 2015.04
        int _1770119 = getIntValue(map, "1770119", 1);

        // 1770120 総合マネジメント体制強化加算 1-なし 2-あり 2015.04
        int _1770120 = getIntValue(map, "1770120", 1);
        
        // 16 同一の建物に居住する利用者 1-なし 2-あり 2015.04
        int _16 = getIntValue(map, "16", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 加算のみ(退院時共同指導加算対応)
        int _9 = getIntValue(map, "9");

        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // 1770104 初期加算
            if (_1770104 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
            }

            // 訪問看護特別指示減算 1-なし 2-あり
            if (_1770114 > 1) {
                // 要介護度を確認
                switch (_1) {
                case 5: // 要介護１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6011");
                    break;
                case 6: // 要介護２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6012");
                    break;
                case 7: // 要介護３
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6013");
                    break;
                case 8: // 要介護４
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6014");
                    break;
                case 9: // 要介護５
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6015");
                    break;
                }
            }

            // 1770106 退院時共同指導加算
            if (_1770106 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
            }

            // 1770110 ターミナルケア加算
            if (_1770110 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
            }

            // 介護職員処遇改善を返却
            switch (_17) {
            case 5:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6110");
                break;
            case 2:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
                break;
            case 3:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
                break;
            case 4:
                putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
                break;
            }

            return sysSvcCdItems;
        }

        // 独自コード生成
        // =========================================================================
        StringBuilder sb = new StringBuilder();

        // 同一の建物に居住する利用者 
        sb.append(CODE_CHAR[_16]);        //2015.04

        // 要介護度
        sb.append(CODE_CHAR[_1]);
        
        // 過小サービスに対する減算
        sb.append(CODE_CHAR[_1770102]);

        // 人員減算
        sb.append(CODE_CHAR[_1770101]);

        // 日割り
        sb.append(CODE_CHAR[_1770115]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
        

        // 加算
        // =========================================================================

        // 訪問看護特別指示減算 1-なし 2-あり
        if (_1770114 > 1) {
            // 要介護度を確認
            switch (_1) {
            case 5: // 要介護１
                putSystemServiceCodeItem(sysSvcCdItems, "Z6011");
                break;
            case 6: // 要介護２
                putSystemServiceCodeItem(sysSvcCdItems, "Z6012");
                break;
            case 7: // 要介護３
                putSystemServiceCodeItem(sysSvcCdItems, "Z6013");
                break;
            case 8: // 要介護４
                putSystemServiceCodeItem(sysSvcCdItems, "Z6014");
                break;
            case 9: // 要介護５
                putSystemServiceCodeItem(sysSvcCdItems, "Z6015");
                break;
            }
        }

        // 1770104 初期加算
        if (_1770104 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6300");
        }

        // 1770105 認知症加算
        switch (_1770105) {
        // 複合型認知症加算I
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
            break;
        // 複合型認知症加算II
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;

        }

        // 1770106 退院時共同指導加算
        if (_1770106 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
        }

        // 1770107 事業開始時支援加算
        if (_1770107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6139");
        }

        // 1770108 緊急時訪問看護加算
        if (_1770108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3100");
        }

        // 1770109 特別管理加算
        switch (_1770109) {
        case 2:
            // 複合型特別管理加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            break;
        case 3:
            // 複合型特別管理加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
            break;

        }

        // 1770110 ターミナルケア加算
        if (_1770110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6100");
        }

        // 1770111 サービス提供体制強化加算
        switch (_1770111) {
        case 5:
            // 提供体制加算Iイ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6111");//2015.04
            break;
        case 2:
            // 提供体制加算Iロ
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 提供体制加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        case 4:
            // 提供体制加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        }

        // 1770108 緊急時訪問看護加算
        if (_1770108 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z3100");
        }

        // 1770119 訪問看護体制強化加算 2015.04
        if (_1770119 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4015");//2015.04
        }

        // 1770120 総合マネジメント体制強化加算 2015.04
        if (_1770120 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4010");//2015.04
        }
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 5:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6112");//2015.04
            break;
        case 2:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6104");
            break;
        case 3:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6106");
            break;
        case 4:
            putSystemServiceCodeItem(sysSvcCdItems, "Z6108");
            break;
        }

        // 日割りではない場合
        if (_1770115 == 1) {
            // 訪問看護体制減算 2015.04
            if (_1770118 > 1) {
                // 要介護度を確認
                switch (_1) {
                case 5: // 要介護１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6021");//2015.04
                    break;
                case 6: // 要介護２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6023");//2015.04
                    break;
                case 7: // 要介護３
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6025");//2015.04
                    break;
                case 8: // 要介護４
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6027");//2015.04
                    break;
                case 9: // 要介護５
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6029");//2015.04
                    break;
                }
            }
            
            // 訪問看護減算
            if (_1770113 > 1) {
                // 要介護度を確認
                switch (_1) {
                case 5: // 要介護１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6001");
                    break;
                case 6: // 要介護２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6003");
                    break;
                case 7: // 要介護３
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6005");
                    break;
                case 8: // 要介護４
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6007");
                    break;
                case 9: // 要介護５
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6009");
                    break;
                }
            }

            // 複合型市町村独自加算
            switch (_1770112) {
            case 2:
                // 複合型市町村独自加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z7101");
                break;
            case 3:
                // 複合型市町村独自加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z7103");
                break;
            case 4:
                // 複合型市町村独自加算３
                putSystemServiceCodeItem(sysSvcCdItems, "Z7105");
                break;
            case 5:
                // 複合型市町村独自加算４
                putSystemServiceCodeItem(sysSvcCdItems, "Z7107");
                break;
            case 6:
                // 複合型市町村独自加算５
                putSystemServiceCodeItem(sysSvcCdItems, "Z7109");
                break;
            case 7:
                // 複合型市町村独自加算６
                putSystemServiceCodeItem(sysSvcCdItems, "Z7111");
                break;
            case 8:
                // 複合型市町村独自加算７
                putSystemServiceCodeItem(sysSvcCdItems, "Z7113");
                break;
            case 9:
                // 複合型市町村独自加算８
                putSystemServiceCodeItem(sysSvcCdItems, "Z7115");
                break;
            case 10:
                // 複合型市町村独自加算９
                putSystemServiceCodeItem(sysSvcCdItems, "Z7117");
                break;
            case 11:
                // 複合型市町村独自加算１０
                putSystemServiceCodeItem(sysSvcCdItems, "Z7119");
                break;
            case 12:
                // 複合型市町村独自加算１１
                putSystemServiceCodeItem(sysSvcCdItems, "Z7121");
                break;
            case 13:
                // 複合型市町村独自加算１２
                putSystemServiceCodeItem(sysSvcCdItems, "Z7123");
                break;
            case 14:
                // 複合型市町村独自加算１３
                putSystemServiceCodeItem(sysSvcCdItems, "Z7125");
                break;
            case 15:
                // 複合型市町村独自加算１４
                putSystemServiceCodeItem(sysSvcCdItems, "Z7127");
                break;
            case 16:
                // 複合型市町村独自加算１５
                putSystemServiceCodeItem(sysSvcCdItems, "Z7129");
                break;
            case 17:
                // 複合型市町村独自加算１６
                putSystemServiceCodeItem(sysSvcCdItems, "Z7131");
                break;
            case 18:
                // 複合型市町村独自加算１７
                putSystemServiceCodeItem(sysSvcCdItems, "Z7133");
                break;
            case 19:
                // 複合型市町村独自加算１８
                putSystemServiceCodeItem(sysSvcCdItems, "Z7135");
                break;
            case 20:
                // 複合型市町村独自加算１９
                putSystemServiceCodeItem(sysSvcCdItems, "Z7137");
                break;
            case 21:
                // 複合型市町村独自加算２０
                putSystemServiceCodeItem(sysSvcCdItems, "Z7139");
                break;
            }

            // 日割りの場合
        } else {
            // 訪問看護体制減算日割 2015.04
            if (_1770118 > 1) {
                // 要介護度を確認
                switch (_1) {
                case 5: // 要介護１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6022");//2015.04
                    break;
                case 6: // 要介護２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6024");//2015.04
                    break;
                case 7: // 要介護３
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6026");//2015.04
                    break;
                case 8: // 要介護４
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6028");//2015.04
                    break;
                case 9: // 要介護５
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6030");//2015.04
                    break;
                }
            }
            
            // 訪問看護減算日割
            if (_1770113 > 1) {
                // 要介護度を確認
                switch (_1) {
                case 5: // 要介護１
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6002");
                    break;
                case 6: // 要介護２
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6004");
                    break;
                case 7: // 要介護３
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6006");
                    break;
                case 8: // 要介護４
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6008");
                    break;
                case 9: // 要介護５
                    putSystemServiceCodeItem(sysSvcCdItems, "Z6010");
                    break;
                }
            }

            // 複合型市町村独自加算
            switch (_1770112) {
            case 2:
                // 複合型市町村独自加算１日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7102");
                break;
            case 3:
                // 複合型市町村独自加算２日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7104");
                break;
            case 4:
                // 複合型市町村独自加算３日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7106");
                break;
            case 5:
                // 複合型市町村独自加算４日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7108");
                break;
            case 6:
                // 複合型市町村独自加算５日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7110");
                break;
            case 7:
                // 複合型市町村独自加算６日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7112");
                break;
            case 8:
                // 複合型市町村独自加算７日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7114");
                break;
            case 9:
                // 複合型市町村独自加算８日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7116");
                break;
            case 10:
                // 複合型市町村独自加算９日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7118");
                break;
            case 11:
                // 複合型市町村独自加算１０日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7120");
                break;
            case 12:
                // 複合型市町村独自加算１１日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7122");
                break;
            case 13:
                // 複合型市町村独自加算１２日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7124");
                break;
            case 14:
                // 複合型市町村独自加算１３日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7126");
                break;
            case 15:
                // 複合型市町村独自加算１４日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7128");
                break;
            case 16:
                // 複合型市町村独自加算１５日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7130");
                break;
            case 17:
                // 複合型市町村独自加算１６日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7132");
                break;
            case 18:
                // 複合型市町村独自加算１７日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7134");
                break;
            case 19:
                // 複合型市町村独自加算１８日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7136");
                break;
            case 20:
                // 複合型市町村独自加算１９日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7138");
                break;
            case 21:
                // 複合型市町村独自加算２０日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7140");
                break;
            }

        }

        return sysSvcCdItems;
    }
}
