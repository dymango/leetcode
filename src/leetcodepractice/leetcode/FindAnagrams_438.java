package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class FindAnagrams_438 {

    /**
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     *
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     *
     * 说明：
     *
     * 字母异位词指字母相同，但排列不同的字符串。
     * 不考虑答案输出的顺序。
     * 示例 1:
     *
     * 输入:
     * s: "cbaebabacd" p: "abc"
     *
     * 输出:
     * [0, 6]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     *  示例 2:
     *
     * 输入:
     * s: "abab" p: "ab"
     *
     * 输出:
     * [0, 1, 2]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        if(s.length() == 0 || s.length() < p.length()) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int slen = s.length();
        int winLen = p.length();
        int[] pMarked = new int[26];
        int[] sMarked = init(s, 0, winLen);
        for (int i = 0; i < p.length(); i++) {
            pMarked[p.charAt(i) - 97]++;
        }

        int start = 0;
        int end = start + winLen - 1;
        while(end < slen) {
            if(start != 0) {
                sMarked[s.charAt(start - 1)-97]--;
                sMarked[s.charAt(end)-97]++;
                if(!p.contains(String.valueOf(s.charAt(end)))) {
                    start = end + 1;
                    end = start + winLen - 1;
                    if(end < slen) {
                        sMarked = init(s, start, end);
                    }

                    continue;
                }
            }

            boolean match = true;
            for (int j = 0; j < pMarked.length; j++) {
                if(sMarked[j] != pMarked[j]) {
                    match = false;
                    break;
                }
            }

            if(match) {
                result.add(start);
            }

            start++;
            end++;
        }

        return result;
    }

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
        findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa");
    }

    public static int[] init(String s, int start,  int l) {
        int[] marked = new int[26];
        for (int i = start; i < start + l; i++) {
            marked[s.charAt(i) - 97]++;
        }

        return marked;
    }

    public int[] countCharNum(String str) {
        int[] marked = new int[26];
        for (int i = 0; i < str.length(); i++) {
            marked[str.charAt(i) - 97]++;
        }

        return marked;
    }
}
