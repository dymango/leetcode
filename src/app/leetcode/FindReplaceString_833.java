package app.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class FindReplaceString_833 {

    /**
     * 某个字符串 S 需要执行一些替换操作，用新的字母组替换原有的字母组（不一定大小相同）。
     * 每个替换操作具有 3 个参数：起始索引 i，源字 x 和目标字 y。规则是：如果 x 从原始字符串 S 中的位置 i 开始，那么就用 y 替换出现的 x。如果没有，则什么都不做。
     * 举个例子，如果 S = “abcd” 并且替换操作 i = 2，x = “cd”，y = “ffff”，那么因为 “cd” 从原始字符串 S 中的位置 2 开始，所以用 “ffff” 替换它。
     * 再来看 S = “abcd” 上的另一个例子，如果一个替换操作 i = 0，x = “ab”，y = “eee”，以及另一个替换操作 i = 2，x = “ec”，y = “ffff”，
     * 那么第二个操作将不会执行，因为原始字符串中 S[2] = 'c'，与 x[0] = 'e' 不匹配。
     * 所有这些操作同时发生。保证在替换时不会有任何重叠： S = "abc", indexes = [0, 1], sources = ["ab","bc"] 不是有效的测试用例。
     * <p>
     * 示例 1：
     * 输入：S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
     * 输出："eeebffff"
     * 解释：
     * "a" 从 S 中的索引 0 开始，所以它被替换为 "eee"。
     * "cd" 从 S 中的索引 2 开始，所以它被替换为 "ffff"。
     * 示例 2：
     * <p>
     * 输入：S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
     * 输出："eeecd"
     * 解释：
     * "ab" 从 S 中的索引 0 开始，所以它被替换为 "eee"。
     * "ec" 没有从原始的 S 中的索引 2 开始，所以它没有被替换。
     *  
     * <p>
     * 提示：
     * <p>
     * 0 <= S.length <= 1000
     * S 仅由小写英文字母组成
     * 0 <= indexes.length <= 100
     * 0 <= indexes[i] < S.length
     * sources.length == indexes.length
     * targets.length == indexes.length
     * 1 <= sources[i].length, targets[i].length <= 50
     * sources[i] 和 targets[i] 仅由小写英文字母组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-and-replace-in-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param indices
     * @param sources
     * @param targets
     * @return
     * @test "vmokgggqzp"
     * [3,5,1]
     * ["kg","ggq","mo"]
     * ["s","so","bfr"]
     * <p>
     * 输出：
     * "vmosso"
     * 预期结果：
     * "vbfrssozp"
     */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        int scan = 0;
        Map<Integer, String> sourceMap = new HashMap<>();
        Map<Integer, String> targetMap = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            sourceMap.put(indices[i], sources[i]);
            targetMap.put(indices[i], targets[i]);
        }

        while (scan < chars.length) {
            if (!sourceMap.containsKey(scan)) {
                stringBuilder.append(chars[scan]);
            } else {
                String source = sourceMap.get(scan);
                boolean eq = true;
                for (int i = 0; i < source.length(); i++) {
                    if (chars[scan + i] != source.charAt(i)) {
                        eq = false;
                        break;
                    }
                }

                if (eq) {
                    stringBuilder.append(targetMap.get(scan));
                    scan += source.length() - 1;
                } else {
                    stringBuilder.append(chars[scan]);
                }
            }

            scan++;
        }

        return stringBuilder.toString();
    }

    class Node {
        public int index;
        public String source;
        public String target;

        public Node(int index, String source, String target) {
            this.index = index;
            this.source = source;
            this.target = target;
        }
    }
}
