package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MinDistance_583 {

    /**
     * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
     *
     *  
     *
     * 示例：
     *
     * 输入: "sea", "eat"
     * 输出: 2
     * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
     *  
     *
     * 提示：
     *
     * 给定单词的长度不超过500。
     * 给定单词中的字符只含有小写字母。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = i + j;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
