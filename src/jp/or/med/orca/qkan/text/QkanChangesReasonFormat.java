package jp.or.med.orca.qkan.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

/**
 * 異動理由(編集済)を渡された場合、区分から名称に変換するフォーマットです。<br>
 * 利用者登録(QU002)で使用します。
 * <p>
 * Copyright (c) 2005 Nippon Computer Corporation. All Rights Reserved.
 * </p>
 * 
 * @author Kazuyoshi Kamitsukasa
 * @version 1.0 2006/01/20
 * @see Format
 */
public class QkanChangesReasonFormat extends Format{
    private static QkanChangesReasonFormat singleton;

    /**
     * コンストラクタです。
     * 
     * @deprecated #getInstanceを使用してください。
     */
    public QkanChangesReasonFormat() {
        super();
    }

    /**
     * インスタンスを返します。
     * 
     * @return インスタンス
     */
    public static QkanChangesReasonFormat getInstance() {
        if (singleton == null) {
            singleton = new QkanChangesReasonFormat();
        }
        return singleton;
    }

    public StringBuffer format(Object obj, StringBuffer toAppendTo,
            FieldPosition pos) {

        if (obj == null)
            return new StringBuffer();

        String code = String.valueOf(obj);

        // 異動理由の区分の判定を行う。
        // 11-非該当
        if ("11".equals(code)) {
            toAppendTo.append("非該当");
            // 12-介護施設
        } else if ("12".equals(code)) {
            toAppendTo.append("介護施設");
            // 13-医療機関入院
        } else if ("13".equals(code)) {
            toAppendTo.append("医療機関入院");
            // 14-死亡
        } else if ("14".equals(code)) {
            toAppendTo.append("死亡");
            // 15-その他
        } else if ("15".equals(code)) {
            toAppendTo.append("その他");
            // 21-居宅
        } else if ("21".equals(code)) {
            toAppendTo.append("居宅");
            // 22-介護施設
        } else if ("22".equals(code)) {
            toAppendTo.append("介護施設");
            // 23-医療機関入院
        } else if ("23".equals(code)) {
            toAppendTo.append("医療機関入院");
            // 24-死亡
        } else if ("24".equals(code)) {
            toAppendTo.append("死亡");
            // 25-その他
        } else if ("25".equals(code)) {
            toAppendTo.append("その他");
            // 31-居宅
        } else if ("31".equals(code)) {
            toAppendTo.append("居宅");
            // 32-介護施設
        } else if ("32".equals(code)) {
            toAppendTo.append("介護施設");
            // 33-医療機関入院
        } else if ("33".equals(code)) {
            toAppendTo.append("医療機関入院");
            // 34-死亡
        } else if ("34".equals(code)) {
            toAppendTo.append("死亡");
            // 35-その他
        } else if ("35".equals(code)) {
            toAppendTo.append("その他");
            // 41-軽快
        } else if ("41".equals(code)) {
            toAppendTo.append("軽快");
            // 42-施設
        } else if ("42".equals(code)) {
            toAppendTo.append("施設");
            // 43-医療機関
        } else if ("43".equals(code)) {
            toAppendTo.append("医療機関");
            // 44-死亡
        } else if ("44".equals(code)) {
            toAppendTo.append("死亡");
            // 45-その他
        } else if ("45".equals(code)) {
            toAppendTo.append("その他");
        }

        return toAppendTo;
    }

    public Object parseObject(String source, ParsePosition pos) {

        if (source == null)
            return null;

        String result = null;

        // 異動理由の区分の判定を行う。
        // 11-非該当
        if ("非該当".equals(source)) {
            result = "11";
            // 12-介護施設
        } else if ("介護施設".equals(source)) {
            result = "12";
            // 13-医療機関入院
        } else if ("医療機関入院".equals(source)) {
            result = "13";
            // 14-死亡
        } else if ("死亡".equals(source)) {
            result = "14";
            // 15-その他
        } else if ("その他".equals(source)) {
            result = "15";
            // 21-居宅
        } else if ("居宅".equals(source)) {
            result = "21";
            // 22-介護施設
        } else if ("介護施設".equals(source)) {
            result = "22";
            // 23-医療機関入院
        } else if ("医療機関入院".equals(source)) {
            result = "23";
            // 24-死亡
        } else if ("死亡".equals(source)) {
            result = "24";
            // 25-その他
        } else if ("その他".equals(source)) {
            result = "25";
            // 31-居宅
        } else if ("居宅".equals(source)) {
            result = "31";
            // 32-介護施設
        } else if ("介護施設".equals(source)) {
            result = "32";
            // 33-医療機関入院
        } else if ("医療機関入院".equals(source)) {
            result = "33";
            // 34-死亡
        } else if ("死亡".equals(source)) {
            result = "34";
            // 35-その他
        } else if ("その他".equals(source)) {
            result = "35";
            // 41-軽快
        } else if ("軽快".equals(source)) {
            result = "41";
            // 42-施設
        } else if ("施設".equals(source)) {
            result = "42";
            // 43-医療機関
        } else if ("医療機関".equals(source)) {
            result = "43";
            // 44-死亡
        } else if ("死亡".equals(source)) {
            result = "44";
            // 45-その他
        } else if ("その他".equals(source)) {
            result = "45";
        }

        return result;
    }

}
