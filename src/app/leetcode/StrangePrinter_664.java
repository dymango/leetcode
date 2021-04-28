package app.leetcode;

/**
 * @author dimmy
 * 有台奇怪的打印机有以下两个特殊要求：
 *
 * 打印机每次只能打印同一个字符序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。
 *
 * 示例 1:
 *
 * 输入: "aaabbb"
 * 输出: 2
 * 解释: 首先打印 "aaa" 然后打印 "bbb"。
 * 示例 2:
 *
 * 输入: "aba"
 * 输出: 2
 * 解释: 首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 * 提示: 输入字符串的长度不会超过 100。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strange-printer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrangePrinter_664 {

    /**
     * 方法：动态规划
     * dp(i, j) 指的是打印 S[i], S[i+1], ..., S[j] 所需的次数。我们需要按以下顺序进行推断：
     * 无论在第几次打印字母 S[i]，可能在第一次被打印，也可能单独打印，因为在间隔 [i，k] 上的任何后续打印都可以在 [i+1，k] 上完成。
     * 假设第一次打印在 [i, k] 上，则有 s[i]==s[k]，因为如果不是，我们可以打印 [i，k] 中最后出现的 s[i] 以获得相同的结果。
     * 当在 [i，k] 中正确打印所有内容时（s[i]==s[k]），它将采取与在 [i，k-1] 中正确打印所有内容相同的步骤。
     * 算法：
     *
     * 通过以上的推导，算法很简单。
     * 计算 dp(i, j) ，对于 S[i] == S[k] 的每个 i <= k <= j，我们有一些候选答案 dp(i, k-1) + dp(k+1, j)，我们取这些候选答案中的最小值。当 k=i 时，候选答案只有 1 + dp(i+1, j)。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/strange-printer/solution/qi-guai-de-da-yin-ji-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     *
     * 思路
     * 动态规划, dp[left][right]代表打印left到right的最少打印次数，然后我们要理解一点：dp[left][right] 其实只可能有两个取值，dp[left][right-1]或者dp[left][right-1]+1，我们求最小打印次数其实就是希望增加一个字符后打印次数不变
     *
     * eg: abc b 这个最后的b就可以连同前面的bc一起顺带打印出来，打印次数不变
     *
     * 枚举所有的区间[left,right]，然后枚举区间[left,right-1]内的字符，如果区间[left,right-1]内的某个字符i和right相等，那么right就可以跟随[i,right-1]一起顺带打印出来，这样该区间的
     *
     * dp[left][right]=dp[left][i-1]+dp[i][right-1]
     * 这样就有可能让打印次数不变，我们求一下所有情况的最小值就可以了
     *
     * 作者：resolmi
     * 链接：https://leetcode-cn.com/problems/strange-printer/solution/java-qu-jian-dp-by-im1gw0/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * dp[i][j]表示打印从i到j位置的子串，需要的最少的打印次数。
     * 状态转移方程是
     * dp[i][j] = min{dp[i+1][nextIndex-1] + dp[nextIndex][j], nextIndex是指与s[i]相同的下一个字符的index，遍历所有这样的位置}
     * 所以我们需要预先计算好一个next数组
     *
     * 实际编程中有一个小trick，就是我们可以先找到第一个与s[i]不同的字符，以它作为起点进行遍历操作
     *
     * 作者：jackie-tien
     * 链接：https://leetcode-cn.com/problems/strange-printer/solution/javaban-chun-dpbu-shi-dai-ji-yi-de-hui-su-by-jacki/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    /**
     * 动态规划
     * 很容易想到状态定义为: f[i][j] 表示最少需要几次能打印出 s 的 [i, j] 区间的子串. 而一个状态的决策就是我们在 [i, j] 这段区间内, 选择哪一段子区间打印哪一个字符
     *
     * 不过进一步想: 这段区间的第一个字符 s[i] 迟早要被正确打印, 所以决策可以改成打印多少个 s[i]
     * 即枚举 k, 我们在 [i, k] 的范围内打印 s[i], 然后转移到子问题.
     *
     * 再进一步, 参考 LeetCode 官方题解的巧妙写法:
     *
     *
     * f[i][j] = f[i+1][j] + 1  (单独打印 s[i])
     * f[i][j] = min{ f[i][k-1] + f[k+1][j] }  i < k <= j 且 s[i] == s[k]
     * 可以这么理解这个写法: 当 s[i] == s[k] 时, 我们令 k 的字符与 i 的字符在同一次打印, 所以打印 [i, k] 需要的次数就等价于打印 [i, k-1], 就是子问题 f[i][k-1], 再加上剩下的 f[k+1][j], 就构成了这个状态转移方程
     *
     * 使用记忆化搜索实现
     *
     * 作者：MMMMMMoSky
     * 链接：https://leetcode-cn.com/problems/strange-printer/solution/644-qi-guai-de-da-yin-ji-java-dong-tai-gui-hua-ji-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    /**
     * 解题思路
     * 打印是以区间为范围的，所以解也应该也区间为考虑点
     * 当区间根据长度划分时，可以使得短长度的数据 被 长长度的数据复用，就吻合了动态规划的思想
     * 当区间长度为0时，结果自然是0
     * 当区间长度为1时，结果自然是1
     * 当区间长度为2时：
     * 当两个字符相等时，为1（一次完成）：
     * 这里理解为当s[0] == s[1]时，[1,1]的打印次数可忽略，于是结果就是[0,0]的打印次数
     * 否则1 + 1（可以理解为[0,1]先打印，再打印[1,1];也可以理解为[0,0],[1,1]各自打印
     * 当区间长度为3时：
     * 当三个字符相等时，可首先忽略[2,2]的打印次数，然后就变成来[0,1]的打印次数；也可以先忽略[1,1]的打印次数，然后就变成了[0,0] + [2,2]的打印次数，显然次数多余前者；不过这几种情况取最小值的话，结果还是对的
     * 当三个字符都不同时，结果可以通过[0,2] = [0,0] + [1,2] 来得到
     * 当有两个字符相同时，情况有:
     * [0,1] + [2,2] = [0,0] + [2,2] (这里认为s[0] == s[1],忽略[1,1])
     * [0,2] + [1,1] = [0,0] + [1,1] (这里认为s[0] == s[2],忽略[2,2])
     * [0,0] + [1,2] = [0,0] + [1,1] (这里认为s[1] == s[2],忽略[2,2])
     * 综上，可以发现，结果总能分为小的区间
     * 整理规律，首先定每次都首先打印s[0]:
     * 如果其他字符都为s[0],则我们的切割为[0,0] + [1,len]
     * 如果其他字符有为s[0]，假设这个位置为k，则为了效益大一点，可以切割为[0,k] + [k+1,len] = [0,k-1] + [k+1,len]
     * 用"aaaa"来验证分析5：
     * k可取值为1，2，3；
     * 当k = 1时，[0,3] = [0,0] + [2,3]
     * 当k = 2时，[0,3] = [0,1] + [3,3]
     * 当k = 3时，[0,3] = [0,2],然后对[0,2]分解，最后转为了[0,0] = 1
     * 代码
     *
     * 作者：li-lu-yue
     * 链接：https://leetcode-cn.com/problems/strange-printer/solution/si-lu-by-li-lu-yue-264/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    /**
     * 有台奇怪的打印机有以下两个特殊要求：
     *
     * 打印机每次只能打印同一个字符序列。
     * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
     * 给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。
     *
     * 示例 1:
     *
     * 输入: "aaabbb"
     * 输出: 2
     * 解释: 首先打印 "aaa" 然后打印 "bbb"。
     * 示例 2:
     *
     * 输入: "aba"
     * 输出: 2
     * 解释: 首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
     * 提示: 输入字符串的长度不会超过 100。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/strange-printer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int strangePrinter(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[][] dp = new int[n + 1][n + 1];

        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }

        for(int len = 2; len <= n; len++){
            for(int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;
                dp[i][j] = dp[i + 1][j] + 1; //i为新字符
                for(int k = i + 1; k <= j; k++){
                    // aabcda
                    if(s.charAt(i) == s.charAt(k)) dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }

        return dp[0][n - 1];
    }

    //"abcabc"
    public static int strangePrinter3(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = dp[i + 1][j] + 1;
                for (int k = i + 1; k <= j; k++) {
                    if(s.charAt(i) == s.charAt(k)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        strangePrinter3("abcabc");
    }
}
