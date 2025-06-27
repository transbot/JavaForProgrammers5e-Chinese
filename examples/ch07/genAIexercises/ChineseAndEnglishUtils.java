import java.util.regex.Pattern;
 
/**
 * @Description: 判断中文（汉字和标点符号）与英文工具类
 * @Date: 2020-04-24 15:43
 * @Version: V1.0
 */
public class ChineseAndEnglishUtils {
    private ChineseAndEnglishUtils() {
    }
 
    /**
     * 使用UnicodeBlock方法判断是否存在中文（包括汉字， 标点符号判断）
     *
     * @param str
     * @return true-存在，false-不存在
     */
    public static boolean checkChinesePunctuationByScript(String str) {
        if (str == null) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (isChineseByScript(aChar)) {
                return true;
            }
        }
        return false;
    }
 
    /**
     * 使用UnicodeScript方法判断是否存在中文（包括汉字， 标点符号判断）
     *
     * @param str
     * @return true-存在，false-不存在
     */
    public static boolean checkChinesePunctuationByBlock(String str) {
        if (str == null) {
            return false;
        }
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (isChineseByBlock(aChar)) {
                return true;
            }
        }
        return false;
    }
 
    /**
     * 使用Unicode编码范围来判断是否存在汉字， 标点符号不做判断
     *
     * @param str
     * @return true-存在，false-不存在
     */
    public static boolean checkChineseByUnicodeRange(String str) {
        if (str == null) {
            return false;
        }
        String regEx = "[\\u4e00-\\u9fa5]+";
        Pattern pattern = Pattern.compile(regEx);
        return pattern.matcher(str.trim()).find();
    }
 
    /**
     * 使用UnicodeBlock方法判断是否存在汉字， 标点符号不做判断
     *
     * @param c
     * @return true-存在，false-不存在
     */
    public static boolean isChineseByBlock(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_C
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_D
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) {
            return true;
        } else {
            return false;
        }
    }
 
    /**
     * 使用UnicodeScript方法判断是否存在汉字， 标点符号不做判断
     *
     * @param c
     * @return true-存在，false-不存在
     */
    public static boolean isChineseByScript(char c) {
        Character.UnicodeScript sc = Character.UnicodeScript.of(c);
        if (sc == Character.UnicodeScript.HAN) {
            return true;
        }
        return false;
    }
 
    /**
     * 根据UnicodeBlock方法判断中文标点符号
     *
     * @param c
     * @return true-存在，false-不存在
     */
    public static boolean isChinesePunctuation(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS) {
            return true;
        } else {
            return false;
        }
    }
 
 
    public static void main(String[] args) {
        System.out.println("=====使用Unicode编码范围来判断是否存在汉字， 标点符号不做判断======");
        System.out.println("abc中国,.d==" + checkChineseByUnicodeRange("abc中国,.d"));
        System.out.println("abc中d==" + checkChineseByUnicodeRange("abc中d"));
        System.out.println("abc，.d==" + checkChineseByUnicodeRange("abc，.d"));
 
        System.out.println("=====使用UnicodeBlock方法判断是否存在中文（包括汉字， 标点符号判断）=====");
        System.out.println("abc中国,.d==" + checkChinesePunctuationByBlock("abc中国,.d"));
        System.out.println("abc中d==" + checkChinesePunctuationByBlock("abc中d"));
        System.out.println("abc，.d==" + checkChinesePunctuationByBlock("abc，.d"));
 
        System.out.println("=====使用UnicodeScript方法判断是否存在中文（包括汉字， 标点符号判断）=====");
        System.out.println("abc中国,.d==" + checkChinesePunctuationByScript("abc中国,.d"));
        System.out.println("abc中d==" + checkChinesePunctuationByScript("abc中d"));
        System.out.println("abc，.d==" + checkChinesePunctuationByScript("abc，.d"));
 
        System.out.println("=====根据UnicodeBlock方法判断中文标点符号=====");
        System.out.println(".==" + isChinesePunctuation('.'));
        System.out.println("。==" + isChinesePunctuation('。'));
    }
 
}