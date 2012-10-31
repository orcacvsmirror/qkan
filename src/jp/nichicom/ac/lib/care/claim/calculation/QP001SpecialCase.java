
/*
 * Project code name "ORCA"
 * 給付管理台帳ソフト QKANCHO（JMA care benefit management software）
 * Copyright(C) 2002 JMA (Japan Medical Association)
 *
 * This program is part of "QKANCHO (JMA care benefit management software)".
 *
 * This program is distributed in the hope that it will be useful
 * for further advancement in medical care, according to JMA Open
 * Source License, but WITHOUT ANY WARRANTY.
 * Everyone is granted permission to use, copy, modify and
 * redistribute this program, but only under the conditions described
 * in the JMA Open Source License. You should have received a copy of
 * this license along with this program. If not, stop using this
 * program and contact JMA, 2-28-16 Honkomagome, Bunkyo-ku, Tokyo,
 * 113-8621, Japan.
 *****************************************************************
 * アプリ: QKANCHO
 * 開発者: 藤原　伸
 * 作成日: 2006/01/24  日本コンピューター株式会社 藤原　伸 新規作成
 * 更新日: ----/--/--
 * システム 給付管理台帳 (Q)
 * サブシステム 請求書出力 (P)
 * プロセス 請求処理 (001)
 * プログラム 請求書特例処理クラス (QP001SpecialCase)
 *
 *****************************************************************
 */

package jp.nichicom.ac.lib.care.claim.calculation;

import jp.nichicom.ac.lang.ACCastUtilities;
import jp.nichicom.ac.text.ACTextUtilities;
import jp.nichicom.vr.bind.VRBindPathParser;
import jp.nichicom.vr.util.VRMap;

public class QP001SpecialCase {
    
    //生保限度額
    private static final int SEIHO_SELF_PAY = 15000;
    
    //明細情報レコードシリアル番号
    private static int DETAIL_SERIAL = 0;
    
    /**
     * 指定された識別番号が施設系の請求であるか判別する。
     * @param discriminationNo 様式識別番号
     * @return true:施設系である(様式第八、第九、第十) false:施設系ではない
     * @throws Exception
     */
    public static boolean isShisetsuDiscriminationNo(String discriminationNo) throws Exception {
        //以下のいずれかの交換識別番号が含まれていれば、施設系の請求とみなす。
        if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * 指定された識別番号の帳票に居宅サービス計画作成区分が必要であるか。
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isServicePlanMakerLiving(String discriminationNo) throws Exception {
        //7171,7173,7183,7193,71A3(様式第六、六の三、八、九、十の場合)は、
        //居宅サービス計画作成区分は必要ない。
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_201204.equals(discriminationNo)) {
            return false;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(discriminationNo)) {
            return false;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(discriminationNo)) {
            return false;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return false;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        
        return true;
    	
    }
    
    
    /**
     * 指定された識別番号は入所(院)前の状態コードの前回情報引継ぎを行うか
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isAdmissionStatusCodeTakeover(String discriminationNo) throws Exception {
        //様式が第六〜六の四、八、九、十に限る
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        
        return false;
    }
    
    
    /**
     * 指定された識別番号は、特定診療費を含むか
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isIncludingDiagnosis(String discriminationNo) throws Exception {
        //様式が第四、四の二、五、五の二、九、十の場合
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        return false;
    }
    
    /**
     * 指定された識別番号は、ショートステイであるか
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isShortStay(String discriminationNo) throws Exception {
        //■様式第三、第四、第五、第六の五、六の六、六の七の場合
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204.equals(discriminationNo)) {
            return true;
        }
        
        return false;
    }
    
    /**
     * 指定された識別番号は、施設であるか
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isLongStay(String discriminationNo) throws Exception {
        //■様式第六と第六の三、様式八から十の場合
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_8_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_9_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_10_201204.equals(discriminationNo)) {
            return true;
        }
        
        return false;
    }
    
    
    /**
     * 様式第二から様式第十の識別番号を返す
     * @return
     */
    public static String getPerformanceCodes() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_3_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_4_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_5_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_7_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_7_2_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_8_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_9_201204);
        sb.append(",");
        sb.append(QP001StyleAbstract.IDENTIFICATION_NO_10_201204);
        
        return sb.toString();
    }
    
    /**
     * 様式第十一の識別番号を返す
     * @return
     */
    public static String getBenefitManagementCodes() {
        return "8222,8221";
    }
    
    /**
     * 指定された識別番号は、サービス実日数を出力するか
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isOutRealDay(String discriminationNo) throws Exception {
        //様式第二、第二の二、第三、第三の二、第四、第四の二、第五、第五の二、第六の五、第六の六
        //return ("7131,7132,7143,7144,7153,7154,7164,7165,7175,7176,7155,7156".indexOf(discriminationNo) != -1);
        if (QP001StyleAbstract.IDENTIFICATION_NO_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204.equals(discriminationNo)) {
            return true;
        }
        return false;
    }
    
    
    /**
     * 指定された識別番号は、限度額管理対象外単位数を出力するか
     * @param discriminationNo
     * @return
     * @throws Exception
     */
    public static boolean isOutLimitUncontrolledUnit(String discriminationNo) throws Exception {
        //様式第二、二の二、三、三の二、四、四の二、五、五の二
        //return ("7131,7132,7143,7144,7153,7154,7164,7165,7155,7156".indexOf(discriminationNo) != -1);
        if (QP001StyleAbstract.IDENTIFICATION_NO_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_2_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_3_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_4_2_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_5_2_201204.equals(discriminationNo)) {
            return true;
        }
        
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_3_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_4_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_5_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_6_201204.equals(discriminationNo)) {
            return true;
        }
        if (QP001StyleAbstract.IDENTIFICATION_NO_6_7_201204.equals(discriminationNo)) {
            return true;
        }
        return false;
    }
    
    
    /**
     * 引数に指定された被保険者番号から生保単独受給者であるか判断する。
     * @param insurerdNo 被保険者番号
     * @return true:生保単独 false:生保単独ではない
     * @throws Exception
     */
    public static boolean isSeihoOnly(String insurerdNo) throws Exception {
        if(insurerdNo == null){
            return false;
        }
        //被保険者番号がHから始まっていれば生保単独とみなす。
        return insurerdNo.toUpperCase().startsWith("H");
        
    }
    
    /**
     * サービスの種類を判断する。
     * @param serviceCode　サービスコード
     * @return
     * 1:食費<br>
     * 2:ユニット型個室<br>
     * 3:ユニット型準個室<br>
     * 4:従来型個室(特養等)<br>
     * 5:従来型個室(老健・療養等)<br>
     * 6:多床室
     * @throws Exception
     */
    public static int getServiceKind(VRMap serviceCode) throws Exception {
        int result = 0;
        
        if(serviceCode == null){
            return result;
        }
        
        //病室区分
        
        //加算種別で分岐
        switch(ACCastUtilities.toInt(serviceCode.get("SERVICE_ADD_TYPE"), 0)) {
        //食費
        case 2:
            result = 1;
            break;
            
        //居住費
        case 3:
            //居住費の場合は、病室区分を取得
            switch(ACCastUtilities.toInt(serviceCode.get("ROOM_TYPE"), 0)) {
            case 1: // 1-従来型個室（特養等）
                result = 4;
                break;
            case 2: // 2-従来型個室（老健・療養等）
                result = 5;
                break;
            case 3: // 3-多床室
                result = 6;
                break;
            case 4: // 4-ユニット型個室
                result = 2;
                break;
            case 5: // 5-ユニット型準個室
                result = 3;
                break;
            }
            
            break;
        
        }
        
        return result;
    }
    
    /**
     * サービスの種類を判断する。
     * @param serviceCodeItem 
     * @return
     * 1:食費<br>
     * 2:ユニット型個室<br>
     * 3:ユニット型準個室<br>
     * 4:従来型個室(特養等)<br>
     * 5:従来型個室(老健・療養等)<br>
     * 6:多床室
     * @throws Exception
     */
    /*
    public static int getServiceKind(int serviceCodeItem) throws Exception {
        int result = 0;
        //サービスコード種類で対象サービスを判定する。
        switch(serviceCodeItem){
            //食費
            case 2111:
            case 2211:
            case 2311:
            case 5111:
            case 5211:
            case 5311:
            case 5411:
            //予防対応開始
            case 2411:
            case 2511:
            case 2611:
            //予防対応終了
                result = 1;
                break;
                
            //ユニット型個室
            case 2121:
            case 2221:
            case 2321:
            case 5121:
            case 5221:
            case 5321:
            case 5421:
            //予防対応開始
            case 2421:
            case 2521:
            case 2621:
            //予防対応終了
                result = 2;
                break;
                
            //ユニット型準個室
            case 2122:
            case 2222:
            case 2322:
            case 5122:
            case 5222:
            case 5322:
            case 5422:
            //予防対応開始
            case 2422:
            case 2522:
            case 2622:
            //予防対応終了
                result = 3;
                break;
                
            //従来型個室(特養等)
            case 2123:
            case 5123:
            //[ID:0000645][Shin Fujihara] 2011/04/20 add begin 2010年度対応
            //地域密着型介護福祉施設-従来型個室を
            //従来型個室(老健・療養等)から従来型個室(特養等)へ移動
            case 5423:
            //[ID:0000645][Shin Fujihara] 2011/04/20 add end 2010年度対応
            //予防対応開始
            case 2423:
            //予防対応終了
                result = 4;
                break;
                
            //従来型個室(老健・療養等)
            case 2223:
            case 2323:
            case 5223:
            case 5323:
            //[ID:0000645][Shin Fujihara] 2011/04/20 edit begin 2010年度対応
            //地域密着型介護福祉施設-従来型個室は従来型個室(特養等)が正しい
            //case 5423:
            //[ID:0000645][Shin Fujihara] 2011/04/20 edit end 2010年度対応
            //予防対応開始
            case 2523:
            case 2623:
            //予防対応終了
                result = 5;
                break;
            //多床室
            case 2124:
            case 2224:
            case 2324:
            case 5124:
            case 5224:
            case 5324:
            case 5424:
            //予防対応開始
            case 2424:
            case 2524:
            case 2624:
            //予防対応終了
                result = 6;
                break;
        }
        
        return result;
    }
    */
    
    /**
     * 公費自己負担額で実際に使用可能な金額を取得する。<BR>
     * <br>
     * 施設系サービスの場合、被保険者である被保護者にかかる介護券による本人支払額は、<br>
     * 15,000までを本体報酬にかかる公費本人負担額に充当し、残額がある場合にはその額を特定入所者<br>
     * 介護サービス費における公費本人負担額に充当する。<br>
     * なお、生活保護単独受給者においては、介護保険施設の特定入所者介護サービス費は、<br>
     * 全額公費負担となる。<br>
     * （ただし、居住費にかかる特定入所者介護サービス費は、居室区分が多床室のみ対象となる）
     * 
     * @param discriminationNo 識別番号
     * @param insurerdNo 被保険者番号
     * @param selfPay 公費自己負担額
     * @return 使用可能な自己負担額
     * @throws Exception
     */
    public static int convertSelfPay(String discriminationNo,String insurerdNo,int selfPay,String kohi,int kohiCost) throws Exception {
        //様式第八、第九、第十でなければ公費自己負担額を返却する。
        if(!isShisetsuDiscriminationNo(discriminationNo)){
            return selfPay;
        }
        //生保単独であれば公費自己負担額を返却する。
        if(isSeihoOnly(insurerdNo)){
            return selfPay;
        }
        //add start 2006.9.12 fujihara shin
        /* 
         * > Sent: Monday, September 11, 2006 2:07 PM
         * > Subject: Re: 【給管鳥】公費分本人負担に上限を設ける法令について
         * 
         * > �@生保単独の場合(被保険者番号がHから始まる場合)
         * > 　→上限を設けない
         * 
         * 問題ありません。
         * 
         * > �A施設系サービス以外の場合
         * > 　→上限を設けない
         * 
         * 問題ありません。
         * 
         * > �B公費として生保が含まれない場合
         * > 　→上限を設けない
         * 
         * 基本的には生保受給者のみ適用になるようです。
         * しかし、他の受給者で同様の取扱をしても、特に返戻にはならないようです。
         * とりあえず、「生保」のみ15000円の上限を設ける形を給管鳥では
         * 採用し、編集したい場合は「明細書情報編集画面」で修正をしてもらう
         * という方法にしましょう。
         * 
         * > �C上記3件に該当せずかつ特定入居者介護サービス費がかかる場合
         * > 　→上限15,000円を設ける
         * 
         * これは具体的にはどういうことでしょうか。
         * 
         * 別件になるかと思いますが、生保受給者で特定入所者介護サービス費が
         * かからない場合については上限を設けないという事でお願いします。 
         */
        if((kohi != null) && (kohi.startsWith("12"))){
        	//公費併用受給者
        	//特定入所者介護サービス費がかかる場合
        	if(kohiCost > 0){
                //問答無用で15000を返却する。
                if(selfPay > SEIHO_SELF_PAY){
                    return SEIHO_SELF_PAY;
                }
        	}
        }
        //add end 2006.9.12 fujihara shin
        
//        //問答無用で15000を返却する。
//        if(selfPay < SEIHO_SELF_PAY){
//            return selfPay;
//        }
//        return SEIHO_SELF_PAY;
        return selfPay;
    }
    
    /**
     * 単位数を計上しないサービスであるか確認する。
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isUnitNoCountService(String serviceCodeKind, String serviceCodeItem) throws Exception {
        int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        int item = ACCastUtilities.toInt(serviceCodeItem,0);
        return isUnitNoCountService(kind,item);
    }
    
    /**
     * 単位数を計上しないサービスであるか確認する。
     * @param serviceCodeKind サービスコード種類
     * @param serviceCodeItem サービスコード項目
     * @return true : 単位数を記載しない false : 単位数を記載する
     * @throws Exception
     */
    public static boolean isUnitNoCountService(int kind, int item) throws Exception {
        
        //[ID:0000714] 平成24年4月法改正に伴い、全修正
        
        boolean result = false;
        
        switch(kind){
        case 13: //訪問看護
            switch(item){
            case 3111: //定期巡回訪看
            case 3113: //定期巡回訪看・准１
            case 3115: //定期巡回訪看・介５
            case 3117: //定期巡回訪看・准１・介５
            case 6102: //訪問看護サービス提供体制加算２
            case 8001: //特別地域訪問看護加算２
            case 8101: //訪問看護小規模事業所加算２
            case 8111: //訪問看護中山間地域等提供加算２
                result = true;
                break;
            }
            break;
            
        case 17: //福祉用具貸与
            //福祉用具系列は一律単位数を出力しない。
            result = true;
            break;
            
        case 33: //特定施設入居者生活介護
            switch(item){
            case 2001: //外部車いす貸与
            case 2002: //外部車いす付属品貸与
            case 2003: //外部特殊寝台貸与
            case 2004: //外部特殊寝台付属品貸与
            case 2005: //外部床ずれ防止用具貸与
            case 2006: //外部体位変換器貸与
            case 2007: //外部手すり貸与
            case 2008: //外部スロープ貸与
            case 2009: //外部歩行器貸与
            case 2010: //外部歩行補助つえ貸与
            case 2011: //外部徘徊感知機器貸与
            case 2012: //外部移動用リフト貸与
            case 2013: //外部自動排泄処理装置貸与
                result = true;
                break;
            }
            break;
            
        case 35: //介護予防特定施設入居者生活介護
            switch(item){
            case 1311: //予防外部訪問介護�T
            case 1321: //予防外部訪問介護�U
            case 1332: //予防外部訪問介護�V
            case 1711: //予防外部通所介護１
            case 1712: //予防外部通所介護２
            case 1722: //予防外部通所介護運動器加算
            case 1723: //予防外部通所介護栄養改善加算
            case 1724: //予防外部通所介護口腔機能加算
            case 1725: //予防外部通介複数サービス加算�T１
            case 1726: //予防外部通介複数サービス加算�T２
            case 1727: //予防外部通介複数サービス加算�T３
            case 1728: //予防外部通介複数サービス加算�U
            case 1811: //予防外部通所リハ１１
            case 1812: //予防外部通所リハ１２
            case 1821: //予防外部通所リハ運動器加算
            case 1822: //予防外部通所リハ栄養改善加算
            case 1823: //予防外部通所リハ口腔機能加算
            case 1824: //予防外部通リ複数サービス加算�T１
            case 1825: //予防外部通リ複数サービス加算�T２
            case 1826: //予防外部通リ複数サービス加算�T３
            case 1827: //予防外部通リ複数サービス加算�U
            case 1831: //予防外部通所リハ２１
            case 1832: //予防外部通所リハ２２
            case 1901: //予防外部車いす貸与
            case 1902: //予防外部車いす付属品貸与
            case 1903: //予防外部特殊寝台貸与
            case 1904: //予防外部特殊寝台付属品貸与
            case 1905: //予防外部床ずれ防止用具貸与
            case 1906: //予防外部体位変換器貸与
            case 1907: //予防外部手すり貸与
            case 1908: //予防外部スロープ貸与
            case 1909: //予防外部歩行器貸与
            case 1910: //予防外部歩行補助つえ貸与
            case 1911: //予防外部徘徊感知機器貸与
            case 1912: //予防外部移動用リフト貸与
            case 1913: //予防外部自動排泄処理装置貸与
                result = true;
                break;
            }
            break;
            
        case 46: //介護予防支援
            result = true;
            break;
            
        case 61: //介護予防訪問看護
            switch(item){
            case 1111: //予防訪問介護�T
            case 1113: //予防訪問介護�T・２級
            case 1114: //予防訪問介護�T・同一
            case 1115: //予防訪問介護�T・２級・同一
            case 1211: //予防訪問介護�U
            case 1213: //予防訪問介護�U・２級
            case 1214: //予防訪問介護�U・同一
            case 1215: //予防訪問介護�U・２級・同一
            case 1321: //予防訪問介護�V
            case 1323: //予防訪問介護�V・２級
            case 1324: //予防訪問介護�V・同一
            case 1325: //予防訪問介護�V・２級・同一
            case 4001: //予防訪問介護初回加算
            case 4002: //予防訪問介護生活機能向上加算
            case 8000: //予防特別地域訪問介護加算
            case 8100: //予防訪問介護小規模事業所加算
            case 8110: //予防訪問介護中山間地域等提供加算
                result = true;
                break;
            }
            break;
            
        case 65: //介護予防通所介護
            switch(item){
            case 1111: //予防通所介護１
            case 1121: //予防通所介護２
            case 5002: //予防通所介護運動器機能向上加算
            case 5003: //予防通所介護栄養改善加算
            case 5004: //予防通所介護口腔機能向上加算
            case 5005: //予防通所介護事業所評価加算
            case 5006: //予防通介複数サービス実施加算�T１
            case 5007: //予防通介複数サービス実施加算�T２
            case 5008: //予防通介複数サービス実施加算�T３
            case 5009: //予防通介複数サービス実施加算�U
            case 5010: //予防通介生活向上グループ活動加算
            case 6101: //予防通所サービス提供体制加算�T１
            case 6102: //予防通所サービス提供体制加算�T２
            case 6103: //予防通所サービス提供体制加算�U１
            case 6104: //予防通所サービス提供体制加算�U２
            case 6105: //予防通所介護送迎減算１
            case 6106: //予防通所介護送迎減算２
            case 6109: //予防通所介護若年性認知症受入加算
            case 8001: //予防通所介護１・定超
            case 8011: //予防通所介護２・定超
            case 8110: //予防通所介護中山間地域等提供加算
            case 9001: //予防通所介護１・人欠
            case 9011: //予防通所介護２・人欠
                result = true;
                break;
            }
            break;
            
        case 66: //介護予防通所リハビリテーション
            switch(item){
            case 1111: //予防通所リハビリ１１
            case 1121: //予防通所リハビリ１２
            case 2111: //予防通所リハビリ２１
            case 2121: //予防通所リハビリ２２
            case 5002: //予防通所リハ運動器機能向上加算
            case 5003: //予防通所リハ栄養改善加算
            case 5004: //予防通所リハ口腔機能向上加算
            case 5005: //予防通所リハ事業所評価加算
            case 5006: //予通リハ複数サービス実施加算�T１
            case 5007: //予通リハ複数サービス実施加算�T２
            case 5008: //予通リハ複数サービス実施加算�T３
            case 5009: //予通リハ複数サービス実施加算�U
            case 6101: //予通リハサービス提供体制加算�T１
            case 6102: //予通リハサービス提供体制加算�T２
            case 6103: //予通リハサービス提供体制加算�U１
            case 6104: //予通リハサービス提供体制加算�U２
            case 6105: //予防通所リハ送迎減算１１
            case 6106: //予防通所リハ送迎減算１２
            case 6107: //予防通所リハ送迎減算２１
            case 6108: //予防通所リハ送迎減算２２
            case 6109: //予防通所リハ若年性認知症受入加算
            case 8001: //予防通所リハビリ１１・定超
            case 8011: //予防通所リハビリ１２・定超
            case 8110: //予防通所リハ中山間地域等提供加算
            case 8201: //予防通所リハビリ２１・定超
            case 8211: //予防通所リハビリ２２・定超
            case 9001: //予防通所リハビリ１１・人欠
            case 9011: //予防通所リハビリ１２・人欠
            case 9201: //予防通所リハビリ２１・人欠
            case 9211: //予防通所リハビリ２２・人欠
                result = true;
                break;
            }
            break;
            
        case 67: //介護予防福祉用具貸与
            result = true;
            break;
            
        case 71: //夜間対応型訪問介護サービス
            switch(item){
            case 1111: //夜間訪問介護�T基本
            case 2111: //夜間訪問介護�U
            case 2113: //夜間訪問介護�U・同一
            case 6102: //夜間訪問サービス提供体制加算�U
            case 6136: //夜間訪問介護２４時間通報対応加算
            case 7201: //基本夜間訪問�T市町村独自加算１
            case 7203: //基本夜間訪問�T市町村独自加算２
            case 7205: //基本夜間訪問�T市町村独自加算３
            case 7207: //基本夜間訪問�T市町村独自加算４
            case 7209: //基本夜間訪問�T市町村独自加算５
            case 7211: //基本夜間訪問�T市町村独自加算６
            case 7301: //夜間訪問介護�U市町村独自加算１
            case 7303: //夜間訪問介護�U市町村独自加算２
            case 7305: //夜間訪問介護�U市町村独自加算３
            case 7307: //夜間訪問介護�U市町村独自加算４
            case 7309: //夜間訪問介護�U市町村独自加算５
            case 7311: //夜間訪問介護�U市町村独自加算６
                result = true;
                break;
            }
            break;
            
        case 73: //小規模多機能型居宅介護
            switch(item){
            case 1111: //小規模多機能１
            case 1113: //小規模多機能１・過少
            case 1115: //小規模多機能１・同一
            case 1117: //小規模多機能１・同一・過少
            case 1121: //小規模多機能２
            case 1123: //小規模多機能２・過少
            case 1125: //小規模多機能２・同一
            case 1127: //小規模多機能２・同一・過少
            case 1131: //小規模多機能３
            case 1133: //小規模多機能３・過少
            case 1135: //小規模多機能３・同一
            case 1137: //小規模多機能３・同一・過少
            case 1141: //小規模多機能４
            case 1143: //小規模多機能４・過少
            case 1145: //小規模多機能４・同一
            case 1147: //小規模多機能４・同一・過少
            case 1151: //小規模多機能５
            case 1153: //小規模多機能５・過少
            case 1155: //小規模多機能５・同一
            case 1157: //小規模多機能５・同一・過少
            case 6101: //小多機能型サービス提供体制加算�T
            case 6102: //小多機能型サービス提供体制加算�U
            case 6103: //小多機能型サービス提供体制加算�V
            case 6128: //小規模多機能型認知症加算�T
            case 6129: //小規模多機能型認知症加算�U
            case 6137: //小規模多機能型看護職員配置加算�T
            case 6138: //小規模多機能型看護職員配置加算�U
            case 6139: //小規模多機能型事業開始支援加算
            case 7101: //小規模多機能型市町村独自加算１
            case 7103: //小規模多機能型市町村独自加算２
            case 7105: //小規模多機能型市町村独自加算３
            case 7107: //小規模多機能型市町村独自加算４
            case 7109: //小規模多機能型市町村独自加算５
            case 7111: //小規模多機能型市町村独自加算６
            case 7113: //小規模多機能型市町村独自加算７
            case 7115: //小規模多機能型市町村独自加算８
            case 7117: //小規模多機能型市町村独自加算９
            case 7119: //小規模多機能型市町村独自加算１０
            case 7121: //小規模多機能型市町村独自加算１１
            case 7123: //小規模多機能型市町村独自加算１２
            case 7125: //小規模多機能型市町村独自加算１３
            case 7127: //小規模多機能型市町村独自加算１４
            case 7129: //小規模多機能型市町村独自加算１５
            case 7131: //小規模多機能型市町村独自加算１６
            case 7133: //小規模多機能型市町村独自加算１７
            case 7135: //小規模多機能型市町村独自加算１８
            case 7137: //小規模多機能型市町村独自加算１９
            case 7139: //小規模多機能型市町村独自加算２０
            case 8011: //小規模多機能１・定超
            case 8013: //小規模多機能１・定超・過少
            case 8015: //小規模多機能１・定超・同一
            case 8017: //小規模多機能１・定超・同一・過少
            case 8021: //小規模多機能２・定超
            case 8023: //小規模多機能２・定超・過少
            case 8025: //小規模多機能２・定超・同一
            case 8027: //小規模多機能２・定超・同一・過少
            case 8031: //小規模多機能３・定超
            case 8033: //小規模多機能３・定超・過少
            case 8035: //小規模多機能３・定超・同一
            case 8037: //小規模多機能３・定超・同一・過少
            case 8041: //小規模多機能４・定超
            case 8043: //小規模多機能４・定超・過少
            case 8045: //小規模多機能４・定超・同一
            case 8047: //小規模多機能４・定超・同一・過少
            case 8051: //小規模多機能５・定超
            case 8053: //小規模多機能５・定超・過少
            case 8055: //小規模多機能５・定超・同一
            case 8057: //小規模多機能５・定超・同一・過少
            case 9011: //小規模多機能１・人欠
            case 9013: //小規模多機能１・人欠・過少
            case 9015: //小規模多機能１・人欠・同一
            case 9017: //小規模多機能１・人欠・同一・過少
            case 9021: //小規模多機能２・人欠
            case 9023: //小規模多機能２・人欠・過少
            case 9025: //小規模多機能２・人欠・同一
            case 9027: //小規模多機能２・人欠・同一・過少
            case 9031: //小規模多機能３・人欠
            case 9033: //小規模多機能３・人欠・過少
            case 9035: //小規模多機能３・人欠・同一
            case 9037: //小規模多機能３・人欠・同一・過少
            case 9041: //小規模多機能４・人欠
            case 9043: //小規模多機能４・人欠・過少
            case 9045: //小規模多機能４・人欠・同一
            case 9047: //小規模多機能４・人欠・同一・過少
            case 9051: //小規模多機能５・人欠
            case 9053: //小規模多機能５・人欠・過少
            case 9055: //小規模多機能５・人欠・同一
            case 9057: //小規模多機能５・人欠・同一・過少
                result = true;
                break;
            }
            break;
            
        case 75: //介護予防小規模多機能型居宅介護
            switch(item){
            case 1111: //予小規模多機能１
            case 1113: //予小規模多機能１・過少
            case 1115: //予小規模多機能１・同一
            case 1117: //予小規模多機能１・同一・過少
            case 1121: //予小規模多機能２
            case 1123: //予小規模多機能２・過少
            case 1125: //予小規模多機能２・同一
            case 1127: //予小規模多機能２・同一・過少
            case 6101: //予小多機能サービス提供体制加算�T
            case 6102: //予小多機能サービス提供体制加算�U
            case 6103: //予小多機能サービス提供体制加算�V
            case 6139: //予小多機能型事業開始支援加算
            case 8011: //予小規模多機能１・超
            case 8013: //予小規模多機能１・超・過少
            case 8015: //予小規模多機能１・超・同一
            case 8017: //予小規模多機能１・超・同一・過少
            case 8021: //予小規模多機能２・超
            case 8023: //予小規模多機能２・超・過少
            case 8025: //予小規模多機能２・超・同一
            case 8027: //予小規模多機能２・超・同一・過少
            case 9011: //予小規模多機能１・欠
            case 9013: //予小規模多機能１・欠・過少
            case 9015: //予小規模多機能１・欠・同一
            case 9017: //予小規模多機能１・欠・同一・過少
            case 9021: //予小規模多機能２・欠
            case 9023: //予小規模多機能２・欠・過少
            case 9025: //予小規模多機能２・欠・同一
            case 9027: //予小規模多機能２・欠・同一・過少
                result = true;
                break;
            }
            break;
            
        case 76: //定期巡回・随時対応型訪問看護介護
            switch(item){
            case 1111: //定期巡回随時�T１１
            case 1121: //定期巡回随時�T１２
            case 1131: //定期巡回随時�T１３
            case 1141: //定期巡回随時�T１４
            case 1151: //定期巡回随時�T１５
            case 1211: //定期巡回随時�T２１
            case 1213: //定期巡回随時�T２１・准看
            case 1221: //定期巡回随時�T２２
            case 1223: //定期巡回随時�T２２・准看
            case 1231: //定期巡回随時�T２３
            case 1233: //定期巡回随時�T２３・准看
            case 1241: //定期巡回随時�T２４
            case 1243: //定期巡回随時�T２４・准看
            case 1251: //定期巡回随時�T２５
            case 1253: //定期巡回随時�T２５・准看
            case 2111: //定期巡回随時�U１
            case 2121: //定期巡回随時�U２
            case 2131: //定期巡回随時�U３
            case 2141: //定期巡回随時�U４
            case 2151: //定期巡回随時�U５
            case 3100: //定期巡回緊急時訪問看護加算
            case 4000: //定期巡回特別管理加算�T
            case 4001: //定期巡回特別管理加算�U
            case 6100: //定期巡回ターミナルケア加算
            case 6101: //定期巡回サービス提供体制加算�T
            case 6102: //定期巡回サービス提供体制加算�U
            case 6103: //定期巡回サービス提供体制加算�V
            case 7101: //定期巡回市町村独自加算１
            case 7103: //定期巡回市町村独自加算２
            case 7105: //定期巡回市町村独自加算３
            case 7107: //定期巡回市町村独自加算４
            case 7109: //定期巡回市町村独自加算５
            case 7111: //定期巡回市町村独自加算６
            case 7113: //定期巡回市町村独自加算７
            case 7115: //定期巡回市町村独自加算８
            case 7117: //定期巡回市町村独自加算９
            case 7119: //定期巡回市町村独自加算１０
            case 8000: //定期巡回特別地域訪問看護加算
            case 8100: //定期巡回小規模事業所加算
            case 8110: //定期巡回中山間地域等提供加算
                result = true;
                break;
            }
            break;
            
        case 77: //複合型サービス
            switch(item){
            case 1111: //複合型サービス１
            case 1113: //複合型サービス１・過少
            case 1121: //複合型サービス２
            case 1123: //複合型サービス２・過少
            case 1131: //複合型サービス３
            case 1133: //複合型サービス３・過少
            case 1141: //複合型サービス４
            case 1143: //複合型サービス４・過少
            case 1151: //複合型サービス５
            case 1153: //複合型サービス５・過少
            case 3100: //複合型緊急時訪問看護加算
            case 4000: //複合型特別管理加算�T
            case 4001: //複合型特別管理加算�U
            case 6001: //複合型医療訪問看護減算１
            case 6003: //複合型医療訪問看護減算２
            case 6005: //複合型医療訪問看護減算３
            case 6007: //複合型医療訪問看護減算４
            case 6009: //複合型医療訪問看護減算５
            case 6100: //複合型ターミナルケア加算
            case 6101: //複合型サービス提供体制加算�T
            case 6102: //複合型サービス提供体制加算�U
            case 6103: //複合型サービス提供体制加算�V
            case 6128: //複合型認知症加算�T
            case 6129: //複合型認知症加算�U
            case 6139: //複合型事業開始支援加算
            case 7101: //複合型市町村独自加算１
            case 7103: //複合型市町村独自加算２
            case 7105: //複合型市町村独自加算３
            case 7107: //複合型市町村独自加算４
            case 7109: //複合型市町村独自加算５
            case 7111: //複合型市町村独自加算６
            case 7113: //複合型市町村独自加算７
            case 7115: //複合型市町村独自加算８
            case 7117: //複合型市町村独自加算９
            case 7119: //複合型市町村独自加算１０
            case 7121: //複合型市町村独自加算１１
            case 7123: //複合型市町村独自加算１２
            case 7125: //複合型市町村独自加算１３
            case 7127: //複合型市町村独自加算１４
            case 7129: //複合型市町村独自加算１５
            case 7131: //複合型市町村独自加算１６
            case 7133: //複合型市町村独自加算１７
            case 7135: //複合型市町村独自加算１８
            case 7137: //複合型市町村独自加算１９
            case 7139: //複合型市町村独自加算２０
            case 8011: //複合型サービス１・定超
            case 8013: //複合型サービス１・定超・過少
            case 8021: //複合型サービス２・定超
            case 8023: //複合型サービス２・定超・過少
            case 8031: //複合型サービス３・定超
            case 8033: //複合型サービス３・定超・過少
            case 8041: //複合型サービス４・定超
            case 8043: //複合型サービス４・定超・過少
            case 8051: //複合型サービス５・定超
            case 8053: //複合型サービス５・定超・過少
            case 9011: //複合型サービス１・人欠
            case 9013: //複合型サービス１・人欠・過少
            case 9021: //複合型サービス２・人欠
            case 9023: //複合型サービス２・人欠・過少
            case 9031: //複合型サービス３・人欠
            case 9033: //複合型サービス３・人欠・過少
            case 9041: //複合型サービス４・人欠
            case 9043: //複合型サービス４・人欠・過少
            case 9051: //複合型サービス５・人欠
            case 9053: //複合型サービス５・人欠・過少
                result = true;
                break;
            }
            break;
        }
        
        return result;
    }
    
    /**
     * 単位数を帳票に記載しないサービスであるか確認する。
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isUnitNotShowService(String serviceCodeKind, String serviceCodeItem) throws Exception {
        int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        int item = ACCastUtilities.toInt(serviceCodeItem,0);
        boolean result = false;
        
        switch(kind){
        //夜間対応型訪問介護
        case 71:
            switch(item){
            //夜間訪問介護１基本
            case 1111:
            //夜間訪問介護２
            case 2111:
                result = true;
                break;
            }
            break;
            
        //福祉用具
        case 17:
            result = true;
            break;
        default:
            result = isUnitNoCountService(kind,item);
            break;
        }
        
        return result;
    }
    
    
    /**
     * 提供回数を1回として計上するサービスであるか確認する。
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isSingleCountService(String serviceCodeKind, String serviceCodeItem) throws Exception {
        int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        int item = ACCastUtilities.toInt(serviceCodeItem,0);
        return isSingleNoCountService(kind,item);
    }
    
    /**
     * 提供回数を1回として計上するサービスであるか確認する。
     * @param serviceCodeKind サービスコード種類
     * @param serviceCodeItem サービスコード項目
     * @return true : 提供回数を1回として計上する false : 提供回数を計上する
     * @throws Exception
     */
    public static boolean isSingleNoCountService(int kind, int item) throws Exception {
        
        boolean result = false;
        
        switch(kind){
    	//福祉用具貸与
    	case 17:
    	//介護予防福祉用具貸与
    	case 67:
    		switch(item){
    		//車いす福祉用具貸与特地加算
    		case 8001:
    		//車いす付属品貸与特地加算
    		case 8002:
    		//特殊寝台貸与特地加算
    		case 8003:
    		//特殊寝台付属品貸与特地加算
    		case 8004:
    		//床ずれ防止用具貸与特地加算
    		case 8005:
    		//体位変換器貸与特地加算
    		case 8006:
    		//手すり貸与特地加算
    		case 8007:
    		//スロープ貸与特地加算
    		case 8008:
    		//歩行器貸与特地加算
    		case 8009:
    		//歩行補助つえ貸与特地加算
    		case 8010:
    		//徘徊感知機器貸与特地加算
    		case 8011:
    		//移動用リフト貸与特地加算
    		case 8012:
            //[ID:0000714][Shin Fujihara] 2012/03 add begin 平成24年4月法改正対応
            //自動排泄処理装置貸与特地加算
            case 8013:
            //[ID:0000714][Shin Fujihara] 2012/03 add end 平成24年4月法改正対応
			//[ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
			//車いす貸与小規模加算
    		case 8101:
			//車いす付属品貸与小規模加算
    		case 8102:
			//特殊寝台貸与小規模加算
    		case 8103:
			//特殊寝台付属品貸与小規模加算
    		case 8104:
			//床ずれ防止用具貸与小規模加算
    		case 8105:
			//体位変換器貸与小規模加算
    		case 8106:
			//手すり貸与小規模加算
    		case 8107:
			//スロープ貸与小規模加算
    		case 8108:
			//歩行器貸与小規模加算
    		case 8109:
			//歩行補助つえ貸与小規模加算
    		case 8110:
			//徘徊感知機器貸与小規模加算
    		case 8111:
			//移動用リフト貸与小規模加算
    		case 8112:
			//車いす貸与中山間地域加算
    		case 8201:
			//車いす付属品貸与中山間地域加算
    		case 8202:
			//特殊寝台貸与中山間地域加算
    		case 8203:
			//特殊寝台付属品貸与中山間地域加算
    		case 8204:
			//床ずれ防止用具貸与中山間地域加算
    		case 8205:
			//体位変換器貸与中山間地域加算
    		case 8206:
			//手すり貸与中山間地域加算
    		case 8207:
			//スロープ貸与中山間地域加算
    		case 8208:
			//歩行器貸与中山間地域加算
    		case 8209:
			//歩行補助つえ貸与中山間地域加算
    		case 8210:
			//徘徊感知機器貸与中山間地域加算
    		case 8211:
			//移動用リフト貸与中山間地域加算
    		case 8212:
			//[ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
    		//[ID:0000714][Shin Fujihara] 2012/03 add begin 平成24年4月法改正対応
    		//自動排泄装置貸与中山間地域加算
    		case 8213:
    		//[ID:0000714][Shin Fujihara] 2012/03 add end 平成24年4月法改正対応
    			result = true;
    			break;
    		}
    		break;
        
        
        //小規模多機能型居宅介護
        case 73:
            switch(item){
            //小規模多機能型居宅介護経
            case 1101:
            //小規模多機能型居宅介護１
            case 1111:
            //小規模多機能型居宅介護２
            case 1121:
            //小規模多機能型居宅介護３
            case 1131:
            //小規模多機能型居宅介護４
            case 1141:
            //小規模多機能型居宅介護５
            case 1151:
            //小多機能型居宅介護経・定超
            case 8001:
            //小多機能型居宅介１・定超
            case 8011:
            //小多機能型居宅介２・定超
            case 8021:
            //小多機能型居宅介３・定超
            case 8031:
            //小多機能型居宅介４・定超
            case 8041:
            //小多機能型居宅介５・定超
            case 8051:
            //小多機能型居宅介護経・人欠
            case 9001:
            //小多機能型居宅介護１・人欠
            case 9011:
            //小多機能型居宅介護２・人欠
            case 9021:
            //小多機能型居宅介護３・人欠
            case 9031:
            //小多機能型居宅介護４・人欠
            case 9041:
            //小多機能型居宅介護５・人欠
            case 9051:
            	
        	//[ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
        	//小規模多機能型居宅介護１・過少
        	case 1113:
        	//小規模多機能型居宅介護２・過少
        	case 1123:
        	//小規模多機能型居宅介護３・過少
        	case 1133:
        	//小規模多機能型居宅介護４・過少
        	case 1143:
        	//小規模多機能型居宅介護５・過少
        	case 1153:
        	//小多機能型居宅介護１・定超・過少
        	case 8013:
        	//小多機能型居宅介護２・定超・過少
        	case 8023:
        	//小多機能型居宅介護３・定超・過少
        	case 8033:
        	//小多機能型居宅介護４・定超・過少
        	case 8043:
        	//小多機能型居宅介護５・定超・過少
        	case 8053:
        	//小多機能型居宅介護１・人欠・過少
        	case 9013:
        	//小多機能型居宅介護２・人欠・過少
        	case 9023:
        	//小多機能型居宅介護３・人欠・過少
        	case 9033:
        	//小多機能型居宅介護４・人欠・過少
        	case 9043:
        	//小多機能型居宅介護５・人欠・過少
        	case 9053:
        	//[ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
        		
                result = true;
                break;
            }
            break;
        //介護予防小規模多機能型居宅介護
        case 75:
        	switch(item){
        	//予防小多機能型居宅介護１
        	case 1111:
        	//予防小多機能型居宅介護２
        	case 1121:
        	//予小多機能型居宅１・定超
        	case 8011:
        	//予小多機能型居宅２・定超
        	case 8021:
        	//予小多機能型居宅１・人欠
        	case 9011:
        	//予小多機能型居宅２・人欠
        	case 9021:
        		
    		//[ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
    		//予防小多機能型居宅介護１・過少
        	case 1113:
    		//予防小多機能型居宅介護２・過少
        	case 1123:
    		//予小多機能型事業開始支援加算�T
        	case 6139:
    		//予小多機能型事業開始支援加算�U
        	case 6140:
    		//予小多機能サービス提供体制加算�T
        	case 6101:
    		//予小多機能サービス提供体制加算�U
        	case 6102:
    		//予小多機能サービス提供体制加算�V
        	case 6103:
    		//予小多機能型居宅１・定超・過少k
        	case 8013:
    		//予小多機能型居宅２・定超・過少
        	case 8023:
    		//予小多機能型居宅１・人欠・過少
        	case 9013:
    		//予小多機能型居宅２・人欠・過少
        	case 9023:
    		//[ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
        		
        		result = true;
        		break;
        	}
        	break;
        }
        
        return result;
    }
    
    /**
     * サービス回数を月の日数に変更するサービスか確認する。
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isMaxCountService(String serviceCodeKind, String serviceCodeItem) throws Exception {
        int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        int item = ACCastUtilities.toInt(serviceCodeItem,0);
        return isMaxCountService(kind,item);
    }
    
    /**
     * サービス回数を月の日数に変更するサービスか確認する。
     * @param serviceCodeKind サービスコード種類
     * @param serviceCodeItem サービスコード項目
     * @return true : 単位数を記載しない false : 単位数を記載する
     * @throws Exception
     */
    public static boolean isMaxCountService(int kind, int item) throws Exception {
        
        boolean result = false;
        
        switch(kind){
        //特定施設入居者生活介護
        case 33:
            switch(item){
            //外部車椅子貸与
            case 2001:
            //外部車椅子付属品貸与
            case 2002:
            //外部特殊寝台貸与
            case 2003:
            //外部特殊寝台付属品貸与
            case 2004:
            //外部床ずれ防止用具貸与
            case 2005:
            //外部体位変換機貸与
            case 2006:
            //外部手すり貸与
            case 2007:
            //外部スロープ貸与
            case 2008:
            //外部歩行器貸与
            case 2009:
            //外部歩行補助つえ貸与
            case 2010:
            //外部俳諧感知器貸与
            case 2011:
            //外部移動用リフト貸与
            case 2012:
            //[ID:0000711][Shin Fujihara] 2012/03 add begin 平成24年4月法改正対応
            //外部自動排泄装置貸与
            case 2013:
            //[ID:0000711][Shin Fujihara] 2012/03 add end 平成24年4月法改正対応
                result = true;
                break;
            }
            break;
        //福祉用具貸与
        case 17:
            //福祉用具系列は一律単位数を出力しない。
            switch(item){
            //車椅子貸与
            case 1001:
            //車椅子付属品貸与
            case 1002:
            //特殊寝台貸与
            case 1003:
            //特殊寝台付属品貸与
            case 1004:
            //床ずれ防止用具貸与
            case 1005:
            //体位変換機貸与
            case 1006:
            //手すり貸与
            case 1007:
            //スロープ貸与
            case 1008:
            //歩行器貸与
            case 1009:
            //歩行補助つえ貸与
            case 1010:
            //徘徊探知機貸与
            case 1011:
            //移動用リフト貸与
            case 1012:
            //[ID:0000711][Shin Fujihara] 2012/03 add begin 平成24年4月法改正対応
            //自動排泄装置貸与
            case 1013:
            //[ID:0000711][Shin Fujihara] 2012/03 add end 平成24年4月法改正対応
                result = true;
                break;
            }
            break;
            
        //介護予防福祉用具貸与
        case 67:
        	//福祉用具系列は一律単位数を出力しない。
        	switch(item){
            //予防車椅子貸与
            case 1001:
            //予防車椅子付属品貸与
            case 1002:
            //予防特殊寝台貸与
            case 1003:
            //予防特殊寝台付属品貸与
            case 1004:
            //予防床ずれ防止用具貸与
            case 1005:
            //予防体位変換機貸与
            case 1006:
            //予防手すり貸与
            case 1007:
            //予防スロープ貸与
            case 1008:
            //予防歩行器貸与
            case 1009:
            //予防歩行補助つえ貸与
            case 1010:
            //予防徘徊探知機貸与
            case 1011:
            //予防移動用リフト貸与
            case 1012:
            //[ID:0000711][Shin Fujihara] 2012/03 add begin 平成24年4月法改正対応
            //予防自動排泄装置貸与
            case 1013:
            //[ID:0000711][Shin Fujihara] 2012/03 add end 平成24年4月法改正対応
                result = true;
                break;
        	}
        	break;
            
        //小規模多機能型居宅介護
        case 73:
            switch(item){
            //小規模多機能型居宅介護経
            case 1101:
            //小規模多機能型居宅介護１
            case 1111:
            //小規模多機能型居宅介護２
            case 1121:
            //小規模多機能型居宅介護３
            case 1131:
            //小規模多機能型居宅介護４
            case 1141:
            //小規模多機能型居宅介護５
            case 1151:
            //小多機能型居宅介護経・定超
            case 8001:
            //小多機能型居宅介１・定超
            case 8011:
            //小多機能型居宅介２・定超
            case 8021:
            //小多機能型居宅介３・定超
            case 8031:
            //小多機能型居宅介４・定超
            case 8041:
            //小多機能型居宅介５・定超
            case 8051:
            //小多機能型居宅介護経・人欠
            case 9001:
            //小多機能型居宅介護１・人欠
            case 9011:
            //小多機能型居宅介護２・人欠
            case 9021:
            //小多機能型居宅介護３・人欠
            case 9031:
            //小多機能型居宅介護４・人欠
            case 9041:
            //小多機能型居宅介護５・人欠
            case 9051:
            
            //[ID:0000497][Shin Fujihara] 2009/04/28 add begin 障害対応
            /*
        	//[ID:0000447][Shin Fujihara] 2009/02 add begin 平成21年4月法改正対応
        	//小規模多機能型認知症加算�T
        	case 6128:
        	//小規模多機能型認知症加算�U
        	case 6129:
        	//小規模多機能型看護職員配置加算�T
        	case 6137:
        	//小規模多機能型看護職員配置加算�U
        	case 6138:
        	//小規模多機能型事業開始支援加算�T
        	case 6139:
        	//小規模多機能型事業開始支援加算�U
        	case 6140:
        	//小多機能型サービス提供体制加算�T
        	case 6101:
        	//小多機能型サービス提供体制加算�U
        	case 6102:
        	//小多機能型サービス提供体制加算�V
        	case 6103:
        	//小規模多機能型市町村独自加算１
        	case 7001:
        	//小規模多機能型市町村独自加算２
        	case 7002:
        	//小規模多機能型市町村独自加算３
        	case 7003:
        	//小規模多機能型市町村独自加算４
        	case 7004:
        	//小規模多機能型市町村独自加算５
        	case 7005:
        	//小規模多機能型市町村独自加算６
        	case 7006:
        	//小規模多機能型市町村独自加算７
        	case 7007:
        	//小規模多機能型市町村独自加算８
        	case 7008:
        	//小規模多機能型市町村独自加算９
        	case 7009:
        	//小規模多機能型市町村独自加算１０
        	case 7010:
        	//[ID:0000447][Shin Fujihara] 2009/02 add end 平成21年4月法改正対応
            */
            //[ID:0000497][Shin Fujihara] 2009/04/28 add end 障害対応
                result = true;
                break;
            }
            break;
            
        //介護予防特定施設入居者生活介護
        case 35:
        	switch(item){
        	//予防外部車いす貸与
        	case 1901:
        	//予防外部車いす付属品貸与
        	case 1902:
        	//予防外部特殊寝台貸与
        	case 1903:
        	//予防外部特殊寝台付属品貸与
        	case 1904:
        	//予防外部床ずれ防止用具貸与
        	case 1905:
        	//予防外部体位変換器貸与
        	case 1906:
        	//予防外部手すり貸与
        	case 1907:
        	//予防外部スロープ貸与
        	case 1908:
        	//予防外部歩行器貸与
        	case 1909:
        	//予防外部歩行補助つえ貸与
        	case 1910:
        	//予防外部徘徊感知機器貸与
        	case 1911:
        	//予防外部移動用リフト貸与
        	case 1912:
            //[ID:0000711][Shin Fujihara] 2012/03 add begin 平成24年4月法改正対応
            //予防外部自動排泄装置貸与
            case 1913:
            //[ID:0000711][Shin Fujihara] 2012/03 add end 平成24年4月法改正対応
        		result = true;
        		break;
        	}
        	break;
        	
//        //介護予防小規模多機能型居宅介護
//        case 75:
//        	switch(item){
//        	//予防小規模多機能型居宅介護１
//        	case 1111:
//        	//予防小規模多機能型居宅介護２
//        	case 1121:
//        	//予小規模多機能型居宅１・定超
//        	case 8011:
//        	//予小規模多機能型居宅２・定超
//        	case 8021:
//        	//予小規模多機能型居宅１・人欠
//        	case 9011:
//        	//予小規模多機能型居宅２・人欠
//        	case 9021:
//        		result = true;
//        		break;
//        	}
//        	break;
        }
        
        return result;
    }
    
    /**
     * 利用者負担額を取得する。
     * @param serviceCode
     * @param patientState
     * @return
     * @throws Exception
     */
    public static int getRiyosyaFutan(VRMap serviceCode, QP001PatientState patientState) throws Exception {
        Object unit = null;
        
        switch(QP001SpecialCase.getServiceKind(serviceCode)){
        //食費
        case 1:
            unit = patientState.getShisetsuData("LIMIT_SHOKUHI");
            break;
        //ユニット型個
        case 2:
            unit = patientState.getShisetsuData("LIMIT_UNIT_KOSHITSU");
            break;
        //ユニット型準個室
        case 3:
            unit = patientState.getShisetsuData("LIMIT_UNIT_JUNKOSHITSU");
            break;
        //従来型個室(特養等)
        case 4:
            unit = patientState.getShisetsuData("LIMIT_JURAIGATA1");
            break;
        //従来型個室(老健・療養等)
        case 5:
            unit = patientState.getShisetsuData("LIMIT_JURAIGATA2");
            break;
        //多床室
        case 6:
            unit = patientState.getShisetsuData("LIMIT_TASHOSHITSU");
            break;
        }
        
        return ACCastUtilities.toInt(unit,0);
    }
    
    /**
     * 単価を取得する。
     * @param serviceDetail
     * @param serviceCode
     * @return
     * @throws Exception
     */
    public static int getUnit(VRMap serviceDetail, VRMap serviceCode,QP001Manager manager) throws Exception {
        int unit = 0;
        //[ID:0000641][Shin Fujihara] 2011/04/14 add begin
        int defaultUnit = Integer.MIN_VALUE;
        //[ID:0000641][Shin Fujihara] 2011/04/14 add end
        
        //サービスの種別を判定する
        //食費の場合は、サービスコードに設定されている単価を返却する。
        if(QP001SpecialCase.getServiceKind(serviceCode) == 1){
            unit = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode),0);
            
            //[ID:0000641][Shin Fujihara] 2011/04/14 add begin
            //マスタから食費の基準額を取得
            defaultUnit = manager.getDefaultFoodCost();
            //[ID:0000641][Shin Fujihara] 2011/04/14 add end
            
        //ホテルコストは事業所に登録されてる値を取得する。
        } else {
            unit = manager.getHotelUnit(String.valueOf(serviceDetail.get("PROVIDER_ID")),String.valueOf(serviceCode.get("SYSTEM_SERVICE_KIND_DETAIL")),String.valueOf(serviceCode.get("SERVICE_CODE_ITEM")));
            
            // [ID:0000641][Shin Fujihara] 2011/04/13 edit begin
            // 基準額と事業所詳細登録画面で入力された金額を比較し、金額の低いほうを採用するよう修正。
            defaultUnit = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode),0);
            
//            if(unit == Integer.MIN_VALUE){
//                unit = ACCastUtilities.toInt(VRBindPathParser.get("SERVICE_UNIT",serviceCode),0);
//            }
            // [ID:0000641][Shin Fujihara] 2011/04/13 edit end

        }
        
        //[ID:0000641][Shin Fujihara] 2011/04/14 add begin
        //基準額以上の値が設定されていれば、基準額に戻す
        if((unit == Integer.MIN_VALUE) || (defaultUnit < unit)) {
            unit = defaultUnit;
        }
        //[ID:0000641][Shin Fujihara] 2011/04/14 add end
        
        return unit;
    }
    
    /**
     * 地域密着型サービスであるかを取得する。
     * @param serviceCodeKind
     * @return
     * @throws Exception
     */
    public static boolean isRegionStickingService(String serviceCodeKind) throws Exception {
        int kind = ACCastUtilities.toInt(serviceCodeKind,0);
        return isRegionStickingService(kind);
    }
    /**
     * 地域密着型サービスであるかを取得する。
     * @param kind
     * @return
     * @throws Exception
     */
    public static boolean isRegionStickingService(int kind) throws Exception {
        boolean result = false;
        
        switch(kind){
        //認知症対応型
        case 32:
        //地域特定施設
        case 36:
        //予防認知症
        case 37:
        //認知症短期
        case 38:
        //予防認知短期
        case 39:
        //地域福祉施設
        case 54:
        //夜間訪問介護
        case 71:
        //認知症通所
        case 72:
        //小規模多機能
        case 73:
        //予防認知通所
        case 74:
        //予防小規模
        case 75:
            result = true;
            break;
        }
        return result;
    }
    
    //[ID:0000523][Shin Fujihara] 2009/07 add begin 2009年度対応
    /**
     * 
     * @param discriminationNo
     * @param insurerdNo
     * @param selfPay
     * @param usedSelfPay
     * @param kohi
     * @param nursing
     * @return
     * @throws Exception
     */
    public static int getApplicationIndividualPayment(
    		String discriminationNo,
    		String insurerdNo,
    		int selfPay,
    		int usedSelfPay,
    		String kohi,
    		QP001RecordNursing nursing) throws Exception {
    	
    	
    	int nursingKohiCost = 0;
    	
    	if ((nursing != null)
    		&& (nursing.get_801007() == 99)){
    		nursingKohiCost = nursing.get_801026();
    	}
    	
    	
    	return getApplicationIndividualPayment(discriminationNo, insurerdNo, selfPay, usedSelfPay, kohi, nursingKohiCost);
    }

    /**
     * 
     * @param discriminationNo
     * @param insurerdNo
     * @param selfPay
     * @param usedSelfPay
     * @param kohi
     * @param nursing
     * @return
     * @throws Exception
     */
    public static int getApplicationIndividualPayment(
    		String discriminationNo,
    		String insurerdNo,
    		int selfPay,
    		int usedSelfPay,
    		String kohi,
    		VRMap nursing) throws Exception {
    	
    	
    	int nursingKohiCost = 0;
    	
    	if ((nursing != null)
        	&& (ACCastUtilities.toInt(nursing.get("801007"), 0) == 99)){
        	nursingKohiCost = ACCastUtilities.toInt(nursing.get("801026"), 0);
        }
    	
    	return getApplicationIndividualPayment(discriminationNo, insurerdNo, selfPay, usedSelfPay, kohi, nursingKohiCost);
    }
    //[ID:0000523][Shin Fujihara] 2009/07 add end 2009年度対応
    
    /**
     * 特定診療費への公費自己負担額を取得する。
     * @param discriminationNo 様式番号
     * @param insurerdNo 被保険者番号 
     * @param selfPay 自己負担額
     * @param usedSelfPay 既に使用済みの公費自己負担額
     * @return 特定診療費に適用可能な公費自己負担額
     * @throws Exception
     */
    //[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009年度対応
    //public static int getApplicationIndividualPayment(String discriminationNo,String insurerdNo,int selfPay,int usedSelfPay, String kohi) throws Exception {
    public static int getApplicationIndividualPayment(String discriminationNo,String insurerdNo,int selfPay,int usedSelfPay, String kohi, int nursingKohiCost) throws Exception {
    //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009年度対応
        //様式第八、第九、第十でなければ適用可能
        if(!isShisetsuDiscriminationNo(discriminationNo)){
            return selfPay;
        }
        //生保単独であれば適用可能
        if(isSeihoOnly(insurerdNo)){
            return selfPay;
        }
        
        //[ID:0000523][Shin Fujihara] 2009/07 edit begin 2009年度対応
        /*
        if(SEIHO_SELF_PAY < (selfPay + usedSelfPay)){
            return SEIHO_SELF_PAY - usedSelfPay;
        }
        */
        if((kohi != null) && (kohi.startsWith("12"))){
        	
        	if (nursingKohiCost > 0) {
	            if(SEIHO_SELF_PAY < (selfPay + usedSelfPay)){
	                return SEIHO_SELF_PAY - usedSelfPay;
	            }
        	}
        }
        //[ID:0000523][Shin Fujihara] 2009/07 edit end 2009年度対応
        
        return selfPay;
    }

    // add sta 2006.05.20 fujihara.shin
    /**
     * 緊急時治療情報レコードの値として妥当であるか判定する。
     * @param map 検証を行うデータ
     * @return true:妥当である　false:妥当でない
     * @throws Exception
     */
    public static boolean isValidRecordEmergency(VRMap map) throws Exception {
    	
    	if(map == null){
    		return false;
    	}
    	
    	//＜必須項目＞
    	//いづれかひとつでも入力されていればOK
    	//緊急時傷病名1 40桁
    	if(!ACTextUtilities.isNullText(map.get("401008"))){
    		return true;
    	}
    	//緊急時傷病名2 40桁
    	if(!ACTextUtilities.isNullText(map.get("401009"))){
    		return true;
    	}
    	//緊急時傷病名3 40桁
    	if(!ACTextUtilities.isNullText(map.get("401010"))){
    		return true;
    	}
    	//緊急時治療開始年月日1 8桁(YYYYMMDD)
    	if(!ACTextUtilities.isNullText(map.get("401011"))){
    		return true;
    	}
    	//緊急時治療開始年月日2 8桁(YYYYMMDD)
    	if(!ACTextUtilities.isNullText(map.get("401012"))){
    		return true;
    	}
    	//緊急時治療開始年月日3 8桁(YYYYMMDD)
    	if(!ACTextUtilities.isNullText(map.get("401013"))){
    		return true;
    	}
    	//摘要1 64桁
    	if(!ACTextUtilities.isNullText(map.get("401026"))){
    		return true;
    	}
    	//摘要2 64桁
    	if(!ACTextUtilities.isNullText(map.get("401027"))){
    		return true;
    	}
    	//摘要3 64桁
    	if(!ACTextUtilities.isNullText(map.get("401028"))){
    		return true;
    	}
    	//摘要4 64桁
    	if(!ACTextUtilities.isNullText(map.get("401029"))){
    		return true;
    	}
    	//摘要5 64桁
    	if(!ACTextUtilities.isNullText(map.get("401030"))){
    		return true;
    	}
    	//摘要6 64桁
    	if(!ACTextUtilities.isNullText(map.get("401031"))){
    		return true;
    	}
    	//摘要7 64桁
    	if(!ACTextUtilities.isNullText(map.get("401032"))){
    		return true;
    	}
    	//摘要8 64桁
    	if(!ACTextUtilities.isNullText(map.get("401033"))){
    		return true;
    	}
    	//摘要9 64桁
    	if(!ACTextUtilities.isNullText(map.get("401034"))){
    		return true;
    	}
    	//摘要10 64桁
    	if(!ACTextUtilities.isNullText(map.get("401035"))){
    		return true;
    	}
    	//摘要11 64桁
    	if(!ACTextUtilities.isNullText(map.get("401036"))){
    		return true;
    	}
    	//摘要12 64桁
    	if(!ACTextUtilities.isNullText(map.get("401037"))){
    		return true;
    	}
    	//摘要13 64桁
    	if(!ACTextUtilities.isNullText(map.get("401038"))){
    		return true;
    	}
    	//摘要14 64桁
    	if(!ACTextUtilities.isNullText(map.get("401039"))){
    		return true;
    	}
    	//摘要15 64桁
    	if(!ACTextUtilities.isNullText(map.get("401040"))){
    		return true;
    	}
    	//摘要16 64桁
    	if(!ACTextUtilities.isNullText(map.get("401041"))){
    		return true;
    	}
    	//摘要17 64桁
    	if(!ACTextUtilities.isNullText(map.get("401042"))){
    		return true;
    	}
    	//摘要18 64桁
    	if(!ACTextUtilities.isNullText(map.get("401043"))){
    		return true;
    	}
    	//摘要19 64桁
    	if(!ACTextUtilities.isNullText(map.get("401044"))){
    		return true;
    	}
    	//摘要20 64桁
    	if(!ACTextUtilities.isNullText(map.get("401045"))){
    		return true;
    	}
    	
    	//＜ペアで必須な項目＞
    	//往診日数2桁 - 往診医療機関名40桁
    	if((ACCastUtilities.toInt(map.get("401014"),0) != 0) &&  !ACTextUtilities.isNullText(map.get("401015"))){
    		return true;
    	}
    	//通院日数2桁 -通院医療機関名40桁 
    	if((ACCastUtilities.toInt(map.get("401016"),0) != 0) &&  !ACTextUtilities.isNullText(map.get("401017"))){
    		return true;
    	}
    	
    	return false;
    }
    // add end 2006.05.20 fujihara.shin
    
    
    /**
     * 緊急時治療情報レコードの値として妥当であるか判定する。
     * @param map 検証を行うデータ
     * @return true:妥当である　false:妥当でない
     * @throws Exception
     */
    public static boolean isValidRecordEmergencyOwnFacility(VRMap map) throws Exception {
        
        if(map == null){
            return false;
        }
        
        //＜必須項目＞
        //いづれかひとつでも入力されていればOK
        String[] needsList = new String[]{
                "1701008",        //緊急時傷病名1 40桁
                "1701009",        //緊急時傷病名2 40桁
                "1701010",        //緊急時傷病名3 40桁
                "1701011",        //緊急時治療開始年月日1 8桁(YYYYMMDD)
                "1701012",        //緊急時治療開始年月日2 8桁(YYYYMMDD)
                "1701013",        //緊急時治療開始年月日3 8桁(YYYYMMDD)
                "1701026",        //摘要1 64桁
                "1701027",        //摘要2 64桁
                "1701028",        //摘要3 64桁
                "1701029",        //摘要4 64桁
                "1701030",        //摘要5 64桁
                "1701031",        //摘要6 64桁
                "1701032",        //摘要7 64桁
                "1701033",        //摘要8 64桁
                "1701034",        //摘要9 64桁
                "1701035",        //摘要10 64桁
                "1701036",        //摘要11 64桁
                "1701037",        //摘要12 64桁
                "1701038",        //摘要13 64桁
                "1701039",        //摘要14 64桁
                "1701040",        //摘要15 64桁
                "1701041",        //摘要16 64桁
                "1701042",        //摘要17 64桁
                "1701043",        //摘要18 64桁
                "1701044",        //摘要19 64桁
                "1701045",        //摘要20 64桁
                "1701047",        //自施設療養費傷病名1 40桁
                "1701048",        //自施設療養費傷病名2 40桁
                "1701049",        //自施設療養費傷病名3 40桁
                "1701050",        //自施設療養費開始年月日1 8桁(YYYYMMDD)
                "1701051",        //自施設療養費開始年月日2 8桁(YYYYMMDD)
                "1701052"        //自施設療養費開始年月日3 8桁(YYYYMMDD)
                };
        
        for (String needs : needsList) {
            if(!ACTextUtilities.isNullText(map.get(needs))){
                return true;
            }
        }
        
        //＜ペアで必須な項目＞
        //往診日数2桁 - 往診医療機関名40桁
        if((ACCastUtilities.toInt(map.get("1701014"),0) != 0) &&  !ACTextUtilities.isNullText(map.get("1701015"))){
            return true;
        }
        //通院日数2桁 -通院医療機関名40桁 
        if((ACCastUtilities.toInt(map.get("1701016"),0) != 0) &&  !ACTextUtilities.isNullText(map.get("1701017"))){
            return true;
        }
        
        return false;
    }
    
    /**
     * 該当のサービスの多床室にチェックが付いているか判定する。
     * @return
     * @throws Exception
     */
    public static boolean isMultiFloorRoom(VRMap serviceCode) throws Exception {
    	boolean result = false;
    	/*
    	if (serviceDetail.containsKey("1210103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1210103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1220102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1220102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1220119")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1220119"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230113")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230113"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230203")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230203"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230212")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230212"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230303")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230303"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230311")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230311"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230401")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230401"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1230411")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1230411"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1240102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1240102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1250102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1250102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1260103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1260103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1260203")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1260203"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1260304")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1260304"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1260401")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1260401"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1510102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1510102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1520102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1520102"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1530103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1530103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1530203")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1530203"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1530303")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1530303"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1540103")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1540103"), 0) == 2) {
				result = true;
			}
		} else if (serviceDetail.containsKey("1590102")) {
			if (ACCastUtilities.toInt(serviceDetail.get("1590102"), 0) == 5) {
				result = true;
			}
		}
		*/
    	if (ACCastUtilities.toInt(serviceCode.get("ROOM_TYPE"), 0) == 3) {
    	    result = true;
    	}
    	return result;
    }
    
    /**
     * 明細情報レコードのシリアル番号に付加する値を取得する。
     * @param serviceDetail
     * @param serviceCode
     * @return
     * @throws Exception
     */
    public static String getDetailSerial(VRMap serviceDetail,VRMap serviceCode) throws Exception {
    	
    	String result = "";
    	
        // サービス種類コード
        String serviceCodeKind = ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_KIND", serviceCode),"");
        //システム内サービス項目コード
        String systemServiceCodeItem = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_CODE_ITEM", serviceCode),"");
        
        //福祉用具の適用設定
        if("17".equals(serviceCodeKind) || "67".equals(serviceCodeKind)){
	        if(serviceDetail.containsKey("1170104")){
	            //システム内サービス種類コードが2から始まっている場合は、
	            //特別地域加算のレコード
	        	//[ID:0000447][Shin Fujihara] 2009/04 add begin 平成21年4月法改正対応
	            //if(!systemServiceCodeItem.startsWith("2")){
	        	//判断基準を変更
	        	//サービス項目コードが8で始まっていれば、特別地域・中山間の加算
	        	//if(!systemServiceCodeItem.startsWith("2")){
	        	String serviceCodeItem = ACCastUtilities.toString(VRBindPathParser.get("SERVICE_CODE_ITEM", serviceCode),"");
	        	if(!serviceCodeItem.startsWith("8")){
	            //[ID:0000447][Shin Fujihara] 2009/04 add end 平成21年4月法改正対応
	                //画面上の福祉用具摘要欄に入力がある場合
	                if(!ACTextUtilities.isNullText(serviceDetail.get("1170104"))){
	                    //摘要欄に福祉用具の摘要欄に入力された値を入力する。
	                	result = String.valueOf(DETAIL_SERIAL++);
	                }
	            }
	        }
        }
        
        /*
         * ■特定施設入居者生活介護、介護予防特定施設入居者生活介護
         * ・外部サービス利用型における福祉用具貸与、介護予防福祉用具貸与
         * 【プログラム中の解釈】
         * 画面上に入力された値を参照
         * 
         * ※※※注意※※※
         * システム内サービス種類コードを使用して、判定しています。
         */
        //サービス種類コードが33であり
        if("33".equals(serviceCodeKind)){
            //システム内サービス種類コードが27から始まり
            if(systemServiceCodeItem.startsWith("27")){
                //摘要欄に入力されている項目がある場合
                if(serviceDetail.containsKey("1330120")){
                    //摘要欄に外部利用福祉用具の摘要欄に入力された値を設定する。
                	result = String.valueOf(DETAIL_SERIAL++);
                }
            }
        }
        
        //※※※注意※※※
        //システム内サービス種類コードを使用して、判定しています。
        
        //サービス種類コードが35であり
        if("35".equals(serviceCodeKind)){
            //システム内サービス種類コードが27から始まり
            if(systemServiceCodeItem.startsWith("27")){
                //摘要欄に入力されている項目がある場合
                if(serviceDetail.containsKey("1170104")){
                    //摘要欄に外部利用福祉用具の摘要欄に入力された値を設定する。
                	result = String.valueOf(DETAIL_SERIAL++);
                }
            }
        }
        
        return result;
    }
    
    /**
     * 様式第二の二において、予防訪問介護１と予防訪問介護１・３級がサービスに登録されていた<br>
     * 場合、予防訪問介護１・３級のみ請求を行なう。<br>
     * 介護予防訪問看護サービス（日割を除く）であれば、trueを返却する。
     * @param serviceCodeKind
     * @param serviceCodeItem
     * @return
     * @throws Exception
     */
    public static boolean isArrangementData(String serviceCodeKind, String serviceCodeItem) throws Exception {
    	boolean result = false;
    	int kind = ACCastUtilities.toInt(serviceCodeKind,0);
    	int item = ACCastUtilities.toInt(serviceCodeItem,0);
    	
		//サービス種類コードの確認
		if(kind == 61){
			switch(item){
			//予防訪問介護１
			case 1111:
			//予防訪問介護１・３級
			case 1112:
			//予防訪問介護２
			case 1211:
			//予防訪問介護２・３級
			case 1212:
			//予防訪問介護３
			case 1321:
			//予防訪問介護３・３級
			case 1322:
				result = true;
				break;
			}
		}
		return result;
    }
    
    //[ID:0000529][Shin Fujihara] 2009/07 add begin 2009年度対応
    /**
     * 対象のサービスが実日数として計上すべきか判定する
     * @param serviceDetail
     * @param serviceCode
     * @return
     * @throws Exception
     */
    //[ID:0000586][Shin Fujihara] 2010/01 edit begin 2009年度対応
    //public static boolean isRealDay(VRMap serviceDetail) throws Exception {
    public static boolean isRealDay(VRMap serviceDetail, VRMap serviceCode) throws Exception {
    //[ID:0000586][Shin Fujihara] 2010/01 edit end 2009年度対応
    	if (serviceDetail.containsKey("DUMMY")) {
    		return false;
    	}
    	
    	// 本票に印字するのキーがない場合はサービス提供データとして扱う
    	// 予防特定入居者生活介護のみ異なるバインドパス
    	String[] checkBindPath = { "15", "1350129", "1350130", "1350131" };

    	for (int i = 0; i < checkBindPath.length; i++) {
    	    // 本票に印字するチェックが存在する場合
    	    if (ACCastUtilities.toInt(serviceDetail.getData(checkBindPath[i]), 0) == 1) {
    	        // チェックがない場合のみ提供日以外のデータとする
    	        return false;
    	    }
    	}
    	
    	//[ID:0000586][Shin Fujihara] 2010/01 add begin 2009年度対応
    	String systemServiceKindDetail = ACCastUtilities.toString(VRBindPathParser.get("SYSTEM_SERVICE_KIND_DETAIL", serviceCode),"");
    	//小規模多機能型居宅介護、または予防小規模多機能型居宅介護である場合
    	if ("17311".equals(systemServiceKindDetail) || "17511".equals(systemServiceKindDetail)) {
    		//初期加算が加算のみで算定されている場合は、実日数として計上しない
    		if (serviceDetail.containsKey("9")) {
    			if (ACCastUtilities.toInt(serviceDetail.get("9"), 0) == 2) {
    				return false;
    			}
    		}
    	}
    	//[ID:0000586][Shin Fujihara] 2010/01 add end 2009年度対応
    	
    	return true;
    }
    //[ID:0000529][Shin Fujihara] 2009/07 add end 2009年度対応
    
    //[ID:0000720][Shin Fujihara] 2012/04 add start 2012年度対応
    // QP001RecordDetailの処理を移動
    /**
     * サービスの提供回数を取得する(看取り看護対応)
     * @param serviceCodeKind サービス種類コード
     * @param serviceCodeItem サービス項目コード
     * @param serviceDetail サービス詳細
     * @return 提供回数
     * @throws Exception
     */
    public static int getServiceCount(String serviceCodeKind, String serviceCodeItem, VRMap serviceDetail) throws Exception {
        
        int count = 1;
        
        
        //認知症対応型共同生活介護（短期利用以外）
        if ("32".equals(serviceCodeKind)) {
            
            //6142:認知症対応型看取り看護加算１ 6143:認知症対応型看取り看護加算２
            if("6142".equals(serviceCodeItem) || "6143".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1320115"),1);
            }
            
        
        //介護福祉施設
        } else if ("51".equals(serviceCodeKind)) {
            
            //6276:福祉施設看取り介護加算１ 6277:福祉施設看取り介護加算２
            if("6276".equals(serviceCodeItem) || "6277".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1510132"),1);
            }
            
            
        //介護保健施設
        } else if ("52".equals(serviceCodeKind)) {
            
            //6600:保健施設ターミナルケア加算１１ 6001:保健施設ターミナルケア加算１２
            //6602:保健施設ターミナルケア加算２１ 6002:保健施設ターミナルケア加算２２
            if ("6600".equals(serviceCodeItem)
                || "6001".equals(serviceCodeItem)
                || "6602".equals(serviceCodeItem)
                || "6002".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1520150"),1);
            }
            
            
        //地域密着型介護福祉施設
        } else if ("54".equals(serviceCodeKind)) {
            
            //6276:地福祉施設看取り介護加算１ 6277:地福祉施設看取り介護加算２
            if("6276".equals(serviceCodeItem) || "6277".equals(serviceCodeItem)){
                count = ACCastUtilities.toInt(serviceDetail.get("1540128"),1);
            }
        }
        
        return count;
    }
    //[ID:0000720][Shin Fujihara] 2012/04 add end 2012年度対応
    
    //[ID:0000720][Shin Fujihara] 2012/04 add start 2012年度対応
    /**
     * 看取り看護・ターミナルケア加算で死亡日をあらわすコードであるか
     * @param serviceCodeKind サービス種類コード
     * @param serviceCodeItem サービス項目コード
     * @return true:死亡日の加算 false:通常のサービスコード
     * @throws Exception
     */
    public static boolean isMitori(String serviceCodeKind, String serviceCodeItem) throws Exception {
        
        //訪問看護
        if ("13".equals(serviceCodeKind)) {
            //訪問看護ターミナルケア加算
            if ("7000".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //福祉施設
        if ("51".equals(serviceCodeKind)) {
            //福祉施設看取り介護加算３
            if ("6283".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //地福祉施
        if ("54".equals(serviceCodeKind)) {
            //地福祉施設看取り介護加算３
            if ("6283".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //保健施設
        if ("52".equals(serviceCodeKind)) {
            //保健施設ターミナルケア加算３１、保健施設ターミナルケア加算３２
            if ("6603".equals(serviceCodeItem)
             || "6003".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //認知症対応型
        if ("32".equals(serviceCodeKind)) {
            //認知症対応型看取り介護加算３
            if ("6144".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //特定施設
        if ("33".equals(serviceCodeKind)) {
            //特定施設看取り介護加算３
            if ("6127".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //地域特定施設
        if ("36".equals(serviceCodeKind)) {
            //地域特定施設看取り介護加算３
            if ("6127".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //定期巡回
        if ("76".equals(serviceCodeKind)) {
            //定期巡回ターミナルケア加算
            if ("6100".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        //複合型
        if ("77".equals(serviceCodeKind)) {
            //複合型ターミナルケア加算
            if ("6100".equals(serviceCodeItem)) {
                return true;
            }
        }
        
        return false;
    }
    //[ID:0000720][Shin Fujihara] 2012/04 add end 2012年度対応
    
}
