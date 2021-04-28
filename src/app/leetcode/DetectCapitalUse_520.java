package app.leetcode;

/**
 * @author dimmy
 */
public class DetectCapitalUse_520 {
    /**
     * 给定一个单词，你需要判断单词的大写使用是否正确。
     *
     * 我们定义，在以下情况时，单词的大写用法是正确的：
     *
     * 全部字母都是大写，比如"USA"。
     * 单词中所有字母都不是大写，比如"leetcode"。
     * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
     * 否则，我们定义这个单词没有正确使用大写字母。
     *
     * 示例 1:
     *
     * 输入: "USA"
     * 输出: True
     * 示例 2:
     *
     * 输入: "FlaG"
     * 输出: False
     * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/detect-capital
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1) return true;
        char first = word.charAt(0);
        if(first >= 65 && first <=90 && word.charAt(1) >= 97 && word.charAt(1) <= 122) {
            for (int i = 1; i < word.length(); i++) {
                char c = word.charAt(i);
                if(c >= 65 && c <=90) return false;
            }
        } else {
            int bn = 0;
            int ln = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(c >= 65 && c <=90)  bn++;
                else ln++;
                if(ln != 0 && bn != 0) return false;
            }
        }

        return true;
    }
}
