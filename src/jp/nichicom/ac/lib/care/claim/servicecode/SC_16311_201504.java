package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 介護予防訪問看護
 * 
 * @since V7.0.0
 * @author Yoichiro.Kamei
 * 
 */
public class SC_16311_201504 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "介護予防訪問看護";
    }

    public String getServiceCodeKind() {
        return "63";
    }

    public String getSystemServiceKindDetail() {
        return "16311";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 明らかに要介護度がおかしい場合は空を返す
        switch (_1) {
        case 1: // 自立
        case 2: // 経過的要介護
        case 5: // 要介護１
        case 6: // 要介護２
        case 7: // 要介護３
        case 8: // 要介護４
        case 9: // 要介護５
            return new ArrayList<HashMap<String, String>>();
        }

        // 1630101 施設等の区分　1-指定訪問看護ステーション 2-病院又は診療所
        int _1630101 = getIntValue(map, "1630101", 1);

        // 1630102 職員区分　1-正看等 2-准看 3-PT、OT、ST
        int _1630102 = getIntValue(map, "1630102", 1);

        // 1630107 時間区分　1-20分未満 2-30分未満 3-30分以上、1時間未満 4-1時間以上、1時間半未満
        int _1630107 = getIntValue(map, "1630107", 1);

        // 1630110 長時間訪問看護加算
        int _1630110 = getIntValue(map, "1630110", 1);

        // 1630104 時間帯　1-通常 2-早朝 3-夜間 4-深夜
        // 変換→1-通常 2-夜間早朝 3-深夜
        int _1630104 = getIntValue(map, "1630104", 1);
        // マスタに合わせ、値を変換
        switch (_1630104) {
        case 1: // 1-通常 => 1-通常
            _1630104 = 1;
            break;
        case 2: // 2-早朝 => 2-夜間早朝 
            _1630104 = 2;
            break;
        case 3: // 3-夜間 => 2-夜間早朝
            _1630104 = 2;
            break;
        case 4: // 4-深夜 => 3-深夜
            _1630104 = 3;
            break;
        }

        // 1630105 緊急時訪問看護加算　1-なし 2-あり
        int _1630105 = getIntValue(map, "1630105", 1);

        // 1630106 特別管理加算　1-なし 2-あり
        int _1630106 = getIntValue(map, "1630106", 1);

        // 2 特別地域加算
        int _2 = getIntValue(map, "2");

        // 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 中山間地域等小規模事業所加算
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 1630108 訪問者の人数
        int _1630108 = getIntValue(map, "1630108");
        
        // 1630109 サービス提供体制強化加算
        int _1630109 = getIntValue(map, "1630109");

        // 1630111 2人目の訪問時間
        int _1630111 = getIntValue(map, "1630111", 1);
        

        // 1630112 初回加算
        int _1630112 = getIntValue(map, "1630112", 1);

        // 1630113 退院時共同指導加算
        int _1630113 = getIntValue(map, "1630113", 1);
        
        // 1630116 1日に2回を越えて実施
        int _1630116 = getIntValue(map, "1630116", 1);
        
        // 看護体制強化加算
        int _1630117 = getIntValue(map, "1630117", 1);
        
        
        // 16 同一建物居住者へのサービス提供
        int _16 = getIntValue(map, "16", 1);
        
        // 加算のみ(退院時共同指導加算対応)
        int _9 = getIntValue(map,"9");
        
        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if(_9 == 2){
            sysSvcCdItems = new ArrayList<HashMap<String, String>>();
            // 予防訪問看護退院時共同指導加算
            if (_1630113 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
            }
            
            return sysSvcCdItems;
        }


        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 施設等の区分　1-指定訪問看護ステーション 2-病院又は診療所
        sb.append(CODE_CHAR[_1630101]);

        // 時間区分　1-20分未満 2-30分未満 3-30分以上、1時間未満 4-1時間以上、1時間半未満
        sb.append(CODE_CHAR[_1630107]);

        // 職員区分　1-正看等 2-准看 3-PT、OT、ST
        sb.append(CODE_CHAR[_1630102]);
        
        // 同一建物居住者へのサービス提供
        sb.append(CODE_CHAR[_16]);
        
        // 時間帯　変換→1-夜間早朝 2-深夜 3-通常
        sb.append(CODE_CHAR[_1630104]);
        
        // 訪問者の人数
        sb.append(CODE_CHAR[_1630108]);
        
        // 2人目の訪問時間
        sb.append(CODE_CHAR[_1630111]);
        
        // 1630110 長時間訪問看護加算
        sb.append(CODE_CHAR[_1630110]);
        
        // 1日に2回を越えて実施
        sb.append(CODE_CHAR[_1630116]);
        
        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================

        // 特別地域加算
        if (_2 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8000");
        }
        
        // 8100 予防訪問看護小規模事業所加算
        if (_13 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8100");
        }
        
        // 8110 予防訪問看護中山間地域等提供加算
        if (_12 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z8110");
        }
        
        // 緊急時訪問看護加算　1-なし 2-あり
        if (_1630105 > 1) {
            switch (_1630101) {
            case 1: // 指定訪問看護ステーション
                putSystemServiceCodeItem(sysSvcCdItems, "Z3100");
                break;
            case 2: // 病院又は診療所
                putSystemServiceCodeItem(sysSvcCdItems, "Z3200");
                break;
            default:
                break;
            }
        }
        
        // 特別管理加算
        switch(_1630106) {
        case 2:
            // 予防訪問看護特別管理加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z4000");
            break;
        case 3:
            // 予防訪問看護特別管理加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
            break;
        }

        // 初回加算
        if (_1630112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
        }

        // 予防訪問看護退院時共同指導加算
        if (_1630113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
        }
        
        // 看護体制強化加算
        if (_1630117 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z4005");//TODO:コード値確認
        }
        
        // 6101 予防訪問看護サービス提供体制加算
        if (_1630109 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6101");
        }
        
        
        return sysSvcCdItems;
    }
}
