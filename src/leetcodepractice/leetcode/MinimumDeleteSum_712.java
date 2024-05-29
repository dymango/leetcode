package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MinimumDeleteSum_712 {
    /**
     * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
     *
     * 示例 1:
     *
     * 输入: s1 = "sea", s2 = "eat"
     * 输出: 231
     * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
     * 在 "eat" 中删除 "t" 并将 116 加入总和。
     * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
     * 示例 2:
     *
     * 输入: s1 = "delete", s2 = "leet"
     * 输出: 403
     * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
     * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
     * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
     * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
     * 注意:
     *
     * 0 < s1.length, s2.length <= 1000。
     * 所有字符串中的字符ASCII值在[97, 122]之间。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s1
     * @param s2
     * @return
     *
     * 我们用 dp[i][j] 表示字符串 s1[i:] 和 s2[j:]（s1[i:] 表示字符串 s1 从第 ii 位到末尾的子串，s2[j:] 表示字符串 s2 从第 jj 位到末尾的子串，字符串下标从 0 开始）达到相等所需删除的字符的 ASCII 值的最小和，最终的答案为 dp[0][0]。
     *
     * 当 s1[i:] 和 s2[j:] 中的某一个字符串为空时，dp[i][j] 的值即为另一个非空字符串的所有字符的 ASCII 值之和。例如当 s2[j:] 为空时，此时有 j = s2.length()，状态转移方程为
     *
     * dp[i][j] = s1.asciiSumFromPos(i)
     * 也可以写成递推的形式，即
     *
     * dp[i][j] = dp[i + 1][j] + s1.asciiAtPos(i)
     * 对于其余的情况，即两个字符串都非空时，如果有 s1[i] == s2[j]，那么当前位置的两个字符相同，它们不需要被删除，状态转移方程为
     *
     * dp[i][j] = dp[i + 1][j + 1]
     * 如果 s1[i] != s2[j]，那么我们至少要删除 s1[i] 和 s2[j] 两个字符中的一个，因此状态转移方程为
     *
     * dp[i][j] = min(dp[i + 1][j] + s1.asciiAtPos(i), dp[i][j + 1] + s2.asciiAtPos(j))
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings/solution/liang-ge-zi-fu-chuan-de-zui-xiao-asciishan-chu-he-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static int minimumDeleteSum(String s1, String s2) {
        if(s1.equals(s2)) return 0;
        char[] s1chars = s1.toCharArray();
        char[] s2chars = s2.toCharArray();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + s1chars[i - 1];
        }

        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = dp[0][i - 1] + s2chars[i - 1];
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(s1chars[i-1] == s2chars[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1chars[i - 1], dp[i][j - 1] + s2chars[j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        minimumDeleteSum("sea", "eat");
    }

}
