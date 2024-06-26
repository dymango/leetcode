package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class ExpressiveWords_809 {

    /**
     * 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
     * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。
     * 扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
     * 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。
     * 此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 S = "helllllooo"，
     * 那么查询词 "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = S。
     * <p>
     * 输入一组查询单词，输出其中可扩张的单词数量。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：
     * S = "heeellooo"
     * words = ["hello", "hi", "helo"]
     * 输出：1
     * 解释：
     * 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
     * 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= len(S) <= 100。
     * 0 <= len(words) <= 100。
     * 0 <= len(words[i]) <= 100。
     * S 和所有在 words 中的单词都只由小写字母组成。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/expressive-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param words
     * @return
     */
    public static int expressiveWords(String s, String[] words) {
        if(s.length() == 0) return 0;
        int count = 0;
        List<Node> sNodeList = buildList(s);
        for (String word : words) {
            int size = 0;
            int start = 0, end = 0;
            boolean find = true;
            while (end < word.length()) {
                if(size >= sNodeList.size()) {
                    find = false;
                    break;
                }
                while (end + 1 < word.length() && word.charAt(end + 1) == word.charAt(end)) {
                    end++;
                }

                Node wNode = new Node(word.charAt(end), end - start + 1);
                Node sNode = sNodeList.get(size);
                if (sNode.c != wNode.c) {
                    find = false;
                    break;
                }

                if (sNode.count == wNode.count) {
                    end += 1;
                    start = end;
                    size++;
                    continue;
                }
                if (sNode.count < wNode.count || sNode.count < 3) {
                    find = false;
                    break;
                }

                end += 1;
                start = end;
                size++;
            }


            if (sNodeList.size() == size && find) count++;
        }

        return count;
    }

    public static class Node {
        public char c;
        public int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    private static List<Node> buildList(String s) {
        List<Node> list = new ArrayList<>();
        int start = 0, end = 0;
        while (end < s.length()) {
            while (end + 1 < s.length() && s.charAt(end + 1) == s.charAt(end)) {
                end++;
            }

            list.add(new Node(s.charAt(end), end - start + 1));
            end += 1;
            start = end;
        }

        return list;
    }

}
