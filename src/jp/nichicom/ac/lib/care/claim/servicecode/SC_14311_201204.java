package jp.nichicom.ac.lib.care.claim.servicecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 居宅介護支援
 * 
 * @since V6.0.0
 * @author Masahiko.Higuchi
 * 
 */
public class SC_14311_201204 extends Qkan10011_ServiceUnitGetter {
    public String getServiceName() {
        return "居宅介護支援";
    }

    public String getServiceCodeKind() {
        return "43";
    }

    public String getSystemServiceKindDetail() {
        return "14311 ";
    }

    public ArrayList<HashMap<String, String>> getSystemServiceCodeItem(
            Map<String, String> map) {
        ArrayList<HashMap<String, String>> sysSvcCdItems = new ArrayList<HashMap<String, String>>();

        // パラメータ抽出
        // =========================================================================
        // 1430103 区分
        int _1430103 = getIntValue(map, "1430103");

        // 1 要介護度
        int _1 = convertYokaigodo(getIntValue(map, "1"));

        // 1430101 運営基準減算
        int _1430101 = getIntValue(map, "1430101", 1);

        // 2 特別地域加算
        int _2 = getIntValue(map, "2", 1);

        // 13 中山間地域等における小規模事業所
        int _13 = getIntValue(map,
                Qkan10011_ServiceUnitGetter.CHUSANKANCHIIKI_KASAN, 1);

        // 1430104 特定事業所集中減算
        int _1430104 = getIntValue(map, "1430104", 1);

        // 1430108 初回加算
        int _1430108 = getIntValue(map, "1430108", 1);

        // 1430113 退院・退所時加算
        int _1430113 = getIntValue(map, "1430113", 1);

        // 1430106 特定事業所加算
        int _1430106 = getIntValue(map, "1430106", 1);

        // 1430110 認知症加算
        int _1430110 = getIntValue(map, "1430110", 1);

        // 1430111 独居高齢者加算
        int _1430111 = getIntValue(map, "1430111", 1);

        // 1430112 小規模多機能型居宅介護事業所連携加算
        int _1430112 = getIntValue(map, "1430112", 1);

        // 12 中山間地域等でのサービス提供加算
        int _12 = getIntValue(map, "12", 1);

        // 1430114 在宅患者緊急時カンファレンス加算
        int _1430114 = getIntValue(map, "1430114", 1);
        
        // 1430115 入院時情報連携加算
        int _1430115 = getIntValue(map, "1430115", 1);
        
        // 1430116 複合型サービス事業所連携加算
        int _1430116 = getIntValue(map, "1430116", 1);
        
        // [ID:0000702][Masahiko.Higuchi] 2012/03 平成24年4月法改正対応 add begin
        // 単独加算
        int _9 = getIntValue(map, "9");

        // 単独加算のみ---------------------------------------------------------------
        // 単独加算サービス
        if (_9 == 2) {
            // 居宅支援退院退所加算
            if (_1430113 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6132");
            }
            
            // 在宅患者緊急時カンファレンス加算
            if (_1430114 > 1) {
                putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
            }
            
            return sysSvcCdItems;
        }
        // [ID:0000702][Masahiko.Higuchi] 2012/03 add end
        
        // 独自コード生成
        // ===========================================================================
        StringBuilder sb = new StringBuilder();

        // 区分
        sb.append(CODE_CHAR[_1430103]);

        // 要介護度
        sb.append(CODE_CHAR[_1]);

        // 運営基準減算
        sb.append(CODE_CHAR[_1430101]);

        // 1-なし 2-特別地域加算 3-中山間地域等の小規模事業所
        // 特別地域加算チェック
        if (_2 > 1) {
            // 特別地域加算
            sb.append(CODE_CHAR[2]);
            
        } else if (_13 > 1) {
            // 中山間地域等の小規模事業所
            sb.append(CODE_CHAR[3]);
            
        } else {
            sb.append(DEFAULT_CHAR);
            
        }

        // 12 中山間地域等でのサービス提供加算
        sb.append(CODE_CHAR[_12]);

        // 特定事業所集中減算
        sb.append(CODE_CHAR[_1430104]);

        putSystemServiceCodeItem(sysSvcCdItems, sb.toString());

        // 加算
        // ============================================================================
        switch (_1430108) {
        case 2:
            // 居宅支援初回加算
            putSystemServiceCodeItem(sysSvcCdItems, "Z4001");
            break;
        }
        
        switch (_1430106) {
        case 2:
            // 居宅支援特定事業所加算I
            putSystemServiceCodeItem(sysSvcCdItems, "Z4002");
            break;
        case 3:
            // 居宅支援特定事業所加算II
            putSystemServiceCodeItem(sysSvcCdItems, "Z4003");
            break;
        }
        
        // 入院時情報連携加算
        switch(_1430115) {
        case 2: // I型
            putSystemServiceCodeItem(sysSvcCdItems, "Z6125");
            break;
        case 3: // II型
            putSystemServiceCodeItem(sysSvcCdItems, "Z6129");
            break;
        }
        
        // 居宅支援退院退所加算
        if (_1430113 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6132");
        }
        
        // 居宅支援認知症加算
        if (_1430110 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6128");
        }
        
        // 居宅支援独居高齢者加算
        if (_1430111 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6130");
        }
        
        // 居宅支援小規模多機能型連携加算
        if (_1430112 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6131");
        }
        
        // 複合型サービス事業所連携加算
        if (_1430116 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6134");
        }
        
        // 在宅患者緊急時カンファレンス加算
        if (_1430114 > 1) {
            putSystemServiceCodeItem(sysSvcCdItems, "Z6133");
        }

        return sysSvcCdItems;
    }
}
