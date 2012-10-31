package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 夜間対応型訪問介護
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_17111_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "夜間対応型訪問介護";
    }

    public String getServiceCodeKind() {
        return "71";
    }

    public String getSystemServiceKindDetail() {
        return "17111";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1710101 施設区分
        int _1710101 = getIntValue(map, "1710101", 1);

        // 1710102 サービス区分
        int _1710102 = getIntValue(map, "1710102", 1);

        // 1710104 対応人数
        int _1710104 = getIntValue(map, "1710104", 1);

        // 1710106 日割
        int _1710106 = getIntValue(map, "1710106", 1);

        // 1710107 24時間通報対応加算
        int _1710107 = getIntValue(map, "1710107", 1);

        // 1710108 サービス提供体制強化加算
        int _1710108 = getIntValue(map, "1710108", 1);

        // 1710109 基本夜間訪問 I 市町村独自加算
        int _1710109 = getIntValue(map, "1710109", 1);

        // 1710110 夜間訪問介護 II 市町村独自加算
        int _1710110 = getIntValue(map, "1710110", 1);

        // 算定区分　1-通常 2-加算のみ 3-基本のみ
        int _9 = getIntValue(map, "9", 1);

        // 1710111 訪問の必要性
        int _1710111 = getIntValue(map, "1710111", 1);

        // 17 介護職員処遇改善加算
        int _17 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.SYOGUKAIZEN_KASAN, 1);

        // 共通系の加算項目
        // =========================================================================
        // 6136 夜間訪問介護２４時間通報対応加算
        if (_1710107 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6136");
        }
        
        switch (_1710108) {
        case 2:
            // 6101 夜間訪問サービス提供体制加算�T
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
            break;
        case 3:
            // 6102 夜間訪問サービス提供体制加算�U
            putSystemServiceCodeItem(sysSvcCdItems, "Z6102");
            break;
        }
        
        // 介護職員処遇改善を返却
        switch (_17) {
        case 2:
            // 夜間訪問介護処遇改善加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z6103");
            break;
        case 3:
            // 夜間訪問介護処遇改善加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z6105");
            break;
        case 4:
            // 夜間訪問介護処遇改善加算III
            putSystemServiceCodeItem(sysSvcCdItems, "Z6107");
            break;
        }
        
        
        // 日割り選択時
        if (_1710106 == 2) {
            
            // 基本夜間訪問�T市町村独自加算
            switch (_1710109) {
            case 1:
                break;
            case 2:
                // 基本夜間訪問�T市町村独自加算１日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7202");
                break;
            case 3:
                // 基本夜間訪問�T市町村独自加算２日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7204");
                break;
            case 4:
                // 基本夜間訪問�T市町村独自加算３日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7206");
                break;
            case 5:
                // 基本夜間訪問�T市町村独自加算４日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7208");
                break;
            case 6:
                // 基本夜間訪問�T市町村独自加算５日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7210");
                break;
            case 7:
                // 基本夜間訪問�T市町村独自加算６日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7212");
                break;
            }
            
            
            // 夜間訪問�U市町村独自加算
            switch (_1710110) {
            case 1:
                break;
            case 2:
                // 夜間訪問�U市町村独自加算１日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7302");
                break;
            case 3:
                // 夜間訪問�U市町村独自加算２日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7304");
                break;
            case 4:
                // 夜間訪問�U市町村独自加算３日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7306");
                break;
            case 5:
                // 夜間訪問�U市町村独自加算４日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7308");
                break;
            case 6:
                // 夜間訪問�U市町村独自加算５日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7310");
                break;
            case 7:
                // 夜間訪問�U市町村独自加算６日割
                putSystemServiceCodeItem(sysSvcCdItems, "Z7312");
                break;
            }

            
        // 日割り以外の通常
        } else {
            
            // 基本夜間訪問�T市町村独自加算
            switch (_1710109) {
            case 1:
                break;
            case 2:
                // 基本夜間訪問�T市町村独自加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z7201");
                break;
            case 3:
                // 基本夜間訪問�T市町村独自加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z7203");
                break;
            case 4:
                // 基本夜間訪問�T市町村独自加算３
                putSystemServiceCodeItem(sysSvcCdItems, "Z7205");
                break;
            case 5:
                // 基本夜間訪問�T市町村独自加算４
                putSystemServiceCodeItem(sysSvcCdItems, "Z7207");
                break;
            case 6:
                // 基本夜間訪問�T市町村独自加算５
                putSystemServiceCodeItem(sysSvcCdItems, "Z7209");
                break;
            case 7:
                // 基本夜間訪問�T市町村独自加算６
                putSystemServiceCodeItem(sysSvcCdItems, "Z7211");
                break;
            }
            
            
            //  夜間訪問介護�U市町村独自加算
            switch (_1710110) {
            case 1:
                break;
            case 2:
                // 夜間訪問介護�U市町村独自加算１
                putSystemServiceCodeItem(sysSvcCdItems, "Z7301");
                break;
            case 3:
                // 夜間訪問介護�U市町村独自加算２
                putSystemServiceCodeItem(sysSvcCdItems, "Z7303");
                break;
            case 4:
                // 夜間訪問介護�U市町村独自加算３
                putSystemServiceCodeItem(sysSvcCdItems, "Z7305");
                break;
            case 5:
                // 夜間訪問介護�U市町村独自加算４
                putSystemServiceCodeItem(sysSvcCdItems, "Z7307");
                break;
            case 6:
                // 夜間訪問介護�U市町村独自加算５
                putSystemServiceCodeItem(sysSvcCdItems, "Z7309");
                break;
            case 7:
                // 夜間訪問介護�U市町村独自加算６
                putSystemServiceCodeItem(sysSvcCdItems, "Z7311");
                break;
            }
        }
        

        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        if (_1710101 == 1) {
            // 基本分
            sb.append(CODE_CHAR[_1710101]); // 施設区分
            sb.append(DEFAULT_CHAR); // サービス区分
            sb.append(DEFAULT_CHAR); // 対応人数
            sb.append(DEFAULT_CHAR); // 訪問の必要性
            sb.append(CODE_CHAR[_1710106]); // 日割
            sb.append(CODE_CHAR[2]); // 基本区分
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

            // ==================================
            // 加算部分
            // ==================================
            // 算定区分が「3-基本のみ」の場合はスキップする
            if (_9 != 3) {

                // 「定期巡回」「随時訪問�T」「随時訪問�U」のコードを
                // 回数分だけコードを追加する。
                sb = new StringBuilder();
                sb.append(CODE_CHAR[_1710101]); // 施設区分
                sb.append(CODE_CHAR[_1710102]); // サービス区分
                sb.append(CODE_CHAR[_1710104]); // 対応人数
                sb.append(CODE_CHAR[_1710111]); // 訪問の必要性
                sb.append(DEFAULT_CHAR); // 日割
                sb.append(DEFAULT_CHAR); // 基本区分
                putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

            }
        } else {
            sb.append(CODE_CHAR[_1710101]); // 施設区分
            sb.append(CODE_CHAR[_1710102]); // サービス区分
            sb.append(CODE_CHAR[_1710104]); // 対応人数
            sb.append(CODE_CHAR[_1710111]); // 訪問の必要性
            sb.append(CODE_CHAR[_1710106]); // 日割
            sb.append(DEFAULT_CHAR); // 基本区分
            putSystemServiceCodeItem(sysSvcCdItems, sb.toString());
        }

        return sysSvcCdItems;
    }
}
