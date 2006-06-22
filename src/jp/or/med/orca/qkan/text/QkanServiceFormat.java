package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * システムサービス種類コードを渡された場合、コードから名称に変換するフォーマットです。<br>
 * 利用者登録(QU002)で使用します。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanServiceFormat extends Format{
    private static QkanServiceFormat singleton;

    /**
     * コンストラクタです。
     * 
     * @deprecated #getInstanceを使用してください。
     */
    public QkanServiceFormat() {
        super();
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanServiceFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanServiceFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);

        // システムサービス種類コードの判定を行う。
        if ("11101".equals(code)||"11111".equals(code)) {
            // 11101-訪問介護
            toAppendTo.append("訪問介護");
        } else if ("11201".equals(code)||"11211".equals(code)) {
            // 11201-訪問入浴介護
            toAppendTo.append("訪問入浴介護");
        } else if ("11301".equals(code)||"11311".equals(code)) {
            // 11301-訪問看護(介護保険)
            toAppendTo.append("訪問看護(介護保険)");
        } else if ("20101".equals(code)||"20111".equals(code)) {
            // 20101-訪問看護(医療保険)
            toAppendTo.append("訪問看護(医療保険)");
        } else if ("11401".equals(code)||"11411".equals(code)) {
            // 11401-訪問リハ
            toAppendTo.append("訪問リハ");
        } else if ("11501".equals(code)||"11511".equals(code)) {
            // 11501-通所介護
            toAppendTo.append("通所介護");
        } else if ("11601".equals(code)||"11611".equals(code)) {
            // 11601-通所リハ
            toAppendTo.append("通所リハ");
        } else if ("11701".equals(code)||"11711".equals(code)) {
            // 11701-福祉用具貸与
            toAppendTo.append("福祉用具貸与");
        } else if ("12101".equals(code)||"12111".equals(code)) {
            // 12101-短期入所生活介護
            toAppendTo.append("短期入所生活介護");
        } else if ("12201".equals(code)||"12211".equals(code)) {
            // 12201-短期入所療養介護(老健施設)
            toAppendTo.append("短期入所療養介護(老健施設)");
        } else if ("12301".equals(code)||"12311".equals(code)) {
            // 12301-短期入所療養介護(病院療養型)
            toAppendTo.append("短期入所療養介護(病院療養型)");
        } else if ("12302".equals(code)||"12312".equals(code)) {
            // 12302-短期入所療養介護(診療所療養型)
            toAppendTo.append("短期入所療養介護(診療所療養型)");
        } else if ("12303".equals(code)||"12313".equals(code)) {
            // 12303-短期入所療養介護(認知症疾患型)
            toAppendTo.append("短期入所療養介護(認知症疾患型)");
        } else if ("12304".equals(code)||"12314".equals(code)) {
            // 12304-短期入所療養介護(基準適合診療所型)
            toAppendTo.append("短期入所療養介護(基準適合診療所型)");
        } else if ("13101".equals(code)||"13111".equals(code)) {
            // 13101-居宅療養管理指導
            toAppendTo.append("居宅療養管理指導");
        } else if ("13201".equals(code)||"13211".equals(code)) {
            // 13201-認知症対応型共同生活介護
            toAppendTo.append("認知症対応型共同生活介護");
        } else if ("13301".equals(code)||"13311".equals(code)) {
            // 13301-特定施設入所者生活介護
            toAppendTo.append("特定施設入所者生活介護");
        } else if ("13611".equals(code)) {
            // 13611-地域密着型特定施設入居者生活介護
            toAppendTo.append("地域密着型特定施設入居者生活介護");
        } else if ("13811".equals(code)) {
            // 13811-認知症対応型共同生活介護(短期利用)
            toAppendTo.append("認知症対応型共同生活介護(短期利用)");
        } else if ("14301".equals(code)||"14311".equals(code)) {
            // 14301-居宅介護支援
            toAppendTo.append("居宅介護支援");
        } else if ("15101".equals(code)||"15111".equals(code)) {
            // 15101-介護老人福祉施設
            toAppendTo.append("介護老人福祉施設");
        } else if ("15201".equals(code)||"15211".equals(code)) {
            // 15201-介護老人保健施設
            toAppendTo.append("介護老人保健施設");
        } else if ("15301".equals(code)||"15311".equals(code)) {
            // 15301-介護療養型医療施設(療養型病院)
            toAppendTo.append("介護療養型医療施設(療養型病院)");
        } else if ("15302".equals(code)||"15312".equals(code)) {
            // 15302-介護療養型医療施設(診療所型)
            toAppendTo.append("介護療養型医療施設(診療所型)");
        } else if ("15303".equals(code)||"15313".equals(code)) {
            // 15303-介護療養型医療施設(認知症疾患型)
            toAppendTo.append("介護療養型医療施設(認知症疾患型)");
        } else if ("15411".equals(code)) {
            // 15411-地域密着型介護福祉施設
            toAppendTo.append("地域密着型介護福祉施設");
        } else if ("17111".equals(code)) {
            // 17111-夜間対応型訪問介護
            toAppendTo.append("夜間対応型訪問介護");
        } else if ("17211".equals(code)) {
            // 17211-認知症対応型通所介護
            toAppendTo.append("認知症対応型通所介護");
        } else if ("17311".equals(code)) {
            // 17311-小規模多機能型居宅介護
            toAppendTo.append("小規模多機能型居宅介護");        
        } else if ("90101".equals(code)) {
            // 90101-その他
            toAppendTo.append("その他");
        } else if ("90201".equals(code)) {
            // 90201-主な日常生活上の活動
            toAppendTo.append("主な日常生活上の活動");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        // システムサービス種類コードの判定を行う。
        // 11101-訪問介護
        if ("訪問介護".equals(source)) {
            result = "11101";
            // 11201-訪問入浴介護
        } else if ("訪問入浴介護".equals(source)) {
            result = "11201";
            // 11301-訪問看護(介護保険)
        } else if ("訪問看護(介護保険)".equals(source) || "訪問看護（介護保険）".equals(source)) {
            result = "11301";
            // 20101-訪問看護(医療保険)
        } else if ("訪問看護(医療保険)".equals(source) || "訪問看護（医療保険）".equals(source)) {
            result = "20101";
            // 11401-訪問リハ
        } else if ("訪問リハ".equals(source)) {
            result = "11401";
            // 11501-通所介護
        } else if ("通所介護".equals(source)) {
            result = "11501";
            // 11601-通所リハ
        } else if ("通所リハ".equals(source)) {
            result = "11601";
            // 11701-福祉用具貸与
        } else if ("福祉用具貸与".equals(source)) {
            result = "11701";
            // 12101-短期入所生活介護
        } else if ("短期入所生活介護".equals(source)) {
            result = "12101";
            // 12201-短期入所療養介護(老健施設)
        } else if ("短期入所療養介護(老健施設)".equals(source) || "短期入所療養介護（老健施設）".equals(source)) {
            result = "12201";
            // 12301-短期入所療養介護(病院療養型)
        } else if ("短期入所療養介護(病院療養型)".equals(source) || "短期入所療養介護（病院療養型）".equals(source)) {
            result = "12301";
            // 12302-短期入所療養介護(診療所療養型)
        } else if ("短期入所療養介護(診療所療養型)".equals(source) || "短期入所療養介護（診療所療養型）".equals(source)) {
            result = "12302";
            // 12303-短期入所療養介護(認知症疾患型)
        } else if ("短期入所療養介護(認知症疾患型)".equals(source) || "短期入所療養介護（認知症疾患型）".equals(source)) {
            result = "12303";
            // 12304-短期入所療養介護(基準適合診療所型)
        } else if ("短期入所療養介護(基準適合診療所型)".equals(source) || "短期入所療養介護（基準適合診療所型）".equals(source)) {
            result = "12304";
            // 13101-居宅療養管理指導
        } else if ("居宅療養管理指導".equals(source)) {
            result = "13101";
            // 13201-認知症対応型共同生活介護
        } else if ("認知症対応型共同生活介護".equals(source)) {
            result = "13201";
            // 13301-特定施設入所者生活介護
        } else if ("特定施設入所者生活介護".equals(source)) {
            result = "13301";
            // 14301-居宅介護支援
        } else if ("居宅介護支援".equals(source)) {
            result = "14301";
            // 15101-介護老人福祉施設
        } else if ("介護老人福祉施設".equals(source)) {
            result = "15101";
            // 15201-介護老人保健施設
        } else if ("介護老人保健施設".equals(source)) {
            result = "15201";
            // 15301-介護療養型医療施設(療養型病院)
        } else if ("介護療養型医療施設(療養型病院)".equals(source) || "介護療養型医療施設（療養型病院）".equals(source)) {
            result = "15301";
            // 15302-介護療養型医療施設(診療所型)
        } else if ("介護療養型医療施設(診療所型)".equals(source) || "介護療養型医療施設（診療所型）".equals(source)) {
            result = "15302";
            // 15303-介護療養型医療施設(認知症疾患型)
        } else if ("介護療養型医療施設(認知症疾患型)".equals(source) || "介護療養型医療施設（認知症疾患型）".equals(source)) {
            result = "15303";
            // 90101-その他
        } else if ("その他".equals(source)) {
            result = "90101";
            // 90201-主な日常生活上の活動
        } else if ("主な日常生活上の活動".equals(source)) {
            result = "90201";
        }

        return result;
    }

}
