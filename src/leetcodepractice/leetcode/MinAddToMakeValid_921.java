package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MinAddToMakeValid_921 {

    /**
     * 只有满足下面几点之一，括号字符串才是有效的：
     * <p>
     * 它是一个空字符串，或者
     * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
     * 它可以被写作 (A)，其中 A 是有效字符串。
     * 给定一个括号字符串 s ，在每一次操作中，你都可以在字符串的任何位置插入一个括号
     * <p>
     * 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
     * 返回 为使结果字符串 s 有效而必须添加的最少括号数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "())"
     * 输出：1
     * 示例 2：
     * <p>
     * 输入：s = "((("
     * 输出：3
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 1000
     * s 只包含 '(' 和 ')' 字符。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {
        char[] chars = s.toCharArray();
        int leftCount = 0;
        int need = 0;
        for (char c : chars) {
            if (c == '(') {
                leftCount++;
                continue;
            }

            if (c == ')') {
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    need++;
                }
            }

        }

        return need + leftCount;
    }
}
