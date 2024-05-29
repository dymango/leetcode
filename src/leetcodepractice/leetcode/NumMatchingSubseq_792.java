package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class NumMatchingSubseq_792 {

    /**
     * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
     * <p>
     * 示例:
     * 输入:
     * S = "abcde"
     * words = ["a", "bb", "acd", "ace"]
     * 输出: 3
     * 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
     * 注意:
     * <p>
     * 所有在words和 S 里的单词都只由小写字母组成。
     * S 的长度在 [1, 50000]。
     * words 的长度在 [1, 5000]。
     * words[i]的长度在[1, 50]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-matching-subsequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param words
     * @return
     */
    public static int numMatchingSubseq(String s, String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            String start = word.substring(0, 1);
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(word);
        }

       int count = 0;
        int index = 0;
        while (index < s.length()) {
            String startStr = s.substring(index, index + 1);
            List<String> list = map.get(startStr);
            if (list != null) {
                map.remove(startStr);
                for (int i = 0; i < list.size(); i++) {
                    String word = list.get(i);
                    if (word.length() > 1) {
                        String newStr = word.substring(1);
                        String start = newStr.substring(0, 1);
                        map.putIfAbsent(start, new ArrayList<>());
                        map.get(start).add(newStr);
                    } else {
                        count++;
                    }
                }
            }

            index++;
        }

        return count;
    }

    public int numMatchingSubseqV2(String s, String[] words) {
        Map<Character, List<Node>> map = new HashMap<>();
        for (String word : words) {
            char start = word.charAt(0);
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(new Node(word, 0));
        }

        int count = 0;
        int index = 0;
        while (index < s.length()) {
            char startStr = s.charAt(index);
            List<Node> list = map.get(startStr);
            if (list != null) {
                map.remove(startStr);
                for (int i = 0; i < list.size(); i++) {
                    Node word = list.get(i);
                    if (word.index < word.word.length() - 1) {
                        word.index += 1;
                        char key = word.word.charAt(word.index);
                        map.putIfAbsent(key, new ArrayList<>());
                        map.get(key).add(word);
                    } else {
                        count++;
                    }
                }
            }

            index++;
        }

        return count;
    }

    private class Node {
        public String word;
        public int index;

        public Node(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        numMatchingSubseq("abcde", new String[]{"a", "b"});
    }
}
