package leetcodepractice.leetcode.tophundred;

/**
 * @author dimmy
 */
public class minDistance_72 {

    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
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
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= word1.length, word2.length <= 500
     * word1 和 word2 由小写英文字母组成
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int length = word1.length();
        int length2 = word2.length();
        int[][] stepArr = new int[length + 1][length2 + 1];
        for (int i = 0; i <= length; i++) {
            stepArr[i][0] = i;
        }

        for (int i = 0; i <= length2; i++) {
            stepArr[0][i] = i;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length2; j++) {
                char c = word1.charAt(i);
                char c2 = word2.charAt(j);
                stepArr[i + 1][j + 1] = c == c2 ? stepArr[i][j] : stepArr[i][j] + 1;
                stepArr[i + 1][j + 1] = Math.min(stepArr[i + 1][j + 1], Math.min(stepArr[i][j + 1] + 1, stepArr[i + 1][j] + 1));
            }
        }

        return stepArr[length][length2];
    }

    public static void main(String[] args) {
        System.out.println(new minDistance_72().minDistance("a", "ab"));
    }
}
