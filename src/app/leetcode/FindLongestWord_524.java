package app.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author dimmy
 */
public class FindLongestWord_524 {

    /**
     * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
     *
     * 示例 1:
     *
     * 输入:
     * s = "abpcplea", d = ["ale","apple","monkey","plea"]
     *
     * 输出:
     * "apple"
     * 示例 2:
     *
     * 输入:
     * s = "abpcplea", d = ["a","b","c"]
     *
     * 输出:
     * "a"
     * 说明:
     *
     * 所有输入的字符串只包含小写字母。
     * 字典的大小不会超过 1000。
     * 所有输入的字符串长度不会超过 1000。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param d
     * @return
     */
    public static String findLongestWord(String s, List<String> d) {
        int maxLength = Integer.MIN_VALUE;
        String result = null;
        for (String str : d) {
            if(isSequenceString(s, str)) {
                if(str.length() > maxLength) {
                    maxLength = str.length();
                    result = str;
                } else if(str.length() == maxLength) {
                    if(result == null) result = str;
                    else result = result.compareTo(str) > 0 ? str : result;
                }
            }
        }

        return result == null ? "" : result;
    }

    public static void main(String[] args) {
//        System.out.println(isSequenceString("abpcplea", "monkey"));
        System.out.println(findLongestWord("abpcplea", List.of("ale","apple","monkey","plea")));
    }

    public static boolean isSequenceString(String origin, String target) {
        int opoint = 0;
        int tpoint = 0;
        int tl = target.length();
        while(tpoint < tl) {
            if(opoint >= origin.length()) break;
            if(origin.charAt(opoint) == target.charAt(tpoint)) {
                opoint++;
                tpoint++;
            } else {
                opoint++;
            }
        }

        return tpoint == target.length();
    }
}
