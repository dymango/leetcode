package leetcodepractice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class NumSpecialEquivGroups_893 {

    /**
     * 给你一个字符串数组 words。
     * 一步操作中，你可以交换字符串 words[i] 的任意两个偶数下标对应的字符或任意两个奇数下标对应的字符。
     * 对两个字符串 words[i] 和 words[j] 而言，如果经过任意次数的操作，words[i] == words[j] ，那么这两个字符串是 特殊等价 的。
     * 例如，words[i] = "zzxy" 和 words[j] = "xyzz" 是一对 特殊等价 字符串，因为可以按 "zzxy" -> "xzzy" -> "xyzz" 的操作路径使 words[i] == words[j] 。
     * 现在规定，words 的 一组特殊等价字符串 就是 words 的一个同时满足下述条件的非空子集：
     * 该组中的每一对字符串都是 特殊等价 的
     * 该组字符串已经涵盖了该类别中的所有特殊等价字符串，容量达到理论上的最大值（也就是说，如果一个字符串不在该组中，那么这个字符串就 不会 与该组内任何字符串特殊等价）
     * 返回 words 中 特殊等价字符串组 的数量。
     * <p>
     * 示例 1：
     * 输入：words = ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
     * 输出：3
     * 解释：
     * 其中一组为 ["abcd", "cdab", "cbad"]，因为它们是成对的特殊等价字符串，且没有其他字符串与这些字符串特殊等价。
     * 另外两组分别是 ["xyzz", "zzxy"] 和 ["zzyx"]。特别需要注意的是，"zzxy" 不与 "zzyx" 特殊等价。
     * <p>
     * 示例 2：
     * 输入：words = ["abc","acb","bac","bca","cab","cba"]
     * 输出：3
     * 解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
     * <p>
     * 提示：
     * 1 <= words.length <= 1000
     * 1 <= words[i].length <= 20
     * 所有 words[i] 都只由小写字母组成。
     * 所有 words[i] 都具有相同的长度。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/groups-of-special-equivalent-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words
     * @return
     */
    public int numSpecialEquivGroups(String[] words) {
        int result = 0;
        boolean[] visited = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            String word = words[i];
            int[] sign = new int[26];
            Map<Character, Integer> oodNumMap = new HashMap<>();
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                sign[c - 97] += 1;
                if (j % 2 == 1) oodNumMap.merge(c, 1, Integer::sum);
            }

            for (int j = 0; j < words.length; j++) {
                if(visited[j]) continue;
                String word2 = words[j];
                Map<Character, Integer> word2oodNumMap = new HashMap<>();
                int[] word2Sign = new int[26];
                for (int k = 0; k < word2.length(); k++) {
                    char c = word2.charAt(k);
                    word2Sign[c - 97] += 1;
                    if (k % 2 == 1) word2oodNumMap.merge(c, 1, Integer::sum);
                }

                boolean match = true;
                for (int k = 0; k < 26; k++) {
                    if (sign[k] != word2Sign[k]) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    for (Map.Entry<Character, Integer> characterIntegerEntry : oodNumMap.entrySet()) {
                        if (!word2oodNumMap.containsKey(characterIntegerEntry.getKey()) || word2oodNumMap.get(characterIntegerEntry.getKey()) != characterIntegerEntry.getValue()) {
                            match = false;
                            break;
                        }
                    }
                }

                if (match) {
                    visited[j] = true;
                }
            }

            result++;
        }

        return result;
    }
}
