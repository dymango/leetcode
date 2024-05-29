package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class FindAndReplacePattern_890 {
    /**
     * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
     * <p>
     * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
     * <p>
     * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
     * <p>
     * 返回 words 中与给定模式匹配的单词列表。
     * <p>
     * 你可以按任何顺序返回答案。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
     * 输出：["mee","aqq"]
     * 解释：
     * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
     * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
     * 因为 a 和 b 映射到同一个字母。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= words.length <= 50
     * 1 <= pattern.length = words[i].length <= 20
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-and-replace-pattern
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param words
     * @param pattern
     * @return
     */
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.length() != pattern.length()) continue;
            Map<Character, Character> characterMap = new HashMap<>();
            int[] chars = new int[26];
            boolean[] visited = new boolean[26];
            int len = word.length();
            boolean match = true;
            for (int i = 0; i < len; i++) {
                char pChar = pattern.charAt(i);
                char wChar = word.charAt(i);
                if (characterMap.containsKey(pChar)) {
                    Character character = characterMap.get(pChar);
                    if (wChar != character) {
                        match = false;
                        break;
                    }
                } else {
                    int index = wChar - 97;
                    if (visited[index] && chars[index] != pChar) {
                        match = false;
                        break;
                    }

                    if (!visited[index]) {
                        visited[index] = true;
                        chars[index] = pChar;
                    }
                    characterMap.put(pChar, wChar);
                }
            }

            if (match) {
                result.add(word);
            }
        }

        return result;
    }
}
