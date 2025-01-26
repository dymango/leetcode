package leetcodepractice.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dimmy
 */
public class LongestStrChain_1048 {

    /**
     * 给出一个单词数组 words ，其中每个单词都由小写英文字母组成。
     * <p>
     * 如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 前身 。
     * <p>
     * 例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身
     * 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是 word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。
     * <p>
     * 从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：words = ["a","b","ba","bca","bda","bdca"]
     * 输出：4
     * 解释：最长单词链之一为 ["a","ba","bda","bdca"]
     * 示例 2:
     * <p>
     * 输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
     * 输出：5
     * 解释：所有的单词都可以放入单词链 ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
     * 示例 3:
     * <p>
     * 输入：words = ["abcd","dbqca"]
     * 输出：1
     * 解释：字链["abcd"]是最长的字链之一。
     * ["abcd"，"dbqca"]不是一个有效的单词链，因为字母的顺序被改变了。
     *
     * @param words
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new LongestStrChain_1048().longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}));
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] maxLen = new int[words.length];
        Arrays.fill(maxLen, 1);
        int max = 1;
        for (int i = 1; i < words.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(words[j].length() == words[i].length()) continue;
                if (words[j].length() < words[i].length() - 1) break;
                var compare = compare(words[j], words[i]);
                if (compare) {
                    maxLen[i] = Math.max(maxLen[i], maxLen[j] + 1);
                }

                max = Math.max(max, maxLen[i]);
            }
        }

        return max;
    }

    public static boolean compare(String a, String b) {
        int indexA = 0;
        int indexB = 0;
        while (indexA < a.length() & indexB < b.length()) {
            if (a.charAt(indexA) == b.charAt(indexB)) {
                indexA++;
                indexB++;
            } else {
                indexB++;
            }

            if (indexB - indexA > 1) return false;
        }

        return true;
    }
}
