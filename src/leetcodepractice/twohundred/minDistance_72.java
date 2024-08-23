package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class minDistance_72 {

    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例 2：
     * <p>
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     *
     * @param word1
     * @param word2
     * @return
     */
    public static void main(String[] args) {
        new minDistance_72().minDistance("horse", "ros");
        new minDistance_72().minDistance("a", "ab");
    }

    public int minDistance(String word1, String word2) {
        int[][] min = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            min[i][0] = i;
        }

        for (int i = 1; i <= word2.length(); i++) {
            min[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                var c1 = word1.charAt(i - 1);
                var c2 = word2.charAt(j - 1);
                if (c1 == c2) {
//                    var minTrans = min[i - 1][j - 1];
                    min[i][j] = min[i - 1][j - 1];
                } else {
                    min[i][j] = min[i - 1][j - 1] + 1;
                    min[i][j]  = Math.min(min[i][j], min[i - 1][j] + 1);
                    min[i][j]  = Math.min(min[i][j], min[i][j - 1] + 1);
                }
            }
        }

        return min[word1.length()][word2.length()];
    }
}
