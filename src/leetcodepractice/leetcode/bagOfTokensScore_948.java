package leetcodepractice.leetcode;

import java.util.Arrays;

/**
 * @author dimmy
 */
public class bagOfTokensScore_948 {

    /**
     * 你的初始 能量 为 power，初始 分数 为 0，只有一包令牌 tokens 。其中 tokens[i] 是第 i 个令牌的值（下标从 0 开始）。
     * 令牌可能的两种使用方法如下：
     * 如果你至少有 token[i] 点 能量 ，可以将令牌 i 置为正面朝上，失去 token[i] 点 能量 ，并得到 1 分 。
     * 如果我们至少有 1 分 ，可以将令牌 i 置为反面朝上，获得 token[i] 点 能量 ，并失去 1 分 。
     * 每个令牌 最多 只能使用一次，使用 顺序不限 ，不需 使用所有令牌。
     * <p>
     * 在使用任意数量的令牌后，返回我们可以得到的最大 分数 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：tokens = [100], power = 50
     * 输出：0
     * 解释：无法使用唯一的令牌，因为能量和分数都太少了。
     * 示例 2：
     * <p>
     * 输入：tokens = [100,200], power = 150
     * 输出：1
     * 解释：令牌 0 正面朝上，能量变为 50，分数变为 1 。
     * 不必使用令牌 1 ，因为你无法使用它来提高分数。
     * 示例 3：
     * <p>
     * 输入：tokens = [100,200,300,400], power = 200
     * 输出：2
     * 解释：按下面顺序使用令牌可以得到 2 分：
     * 1. 令牌 0 正面朝上，能量变为 100 ，分数变为 1
     * 2. 令牌 3 正面朝下，能量变为 500 ，分数变为 0
     * 3. 令牌 1 正面朝上，能量变为 300 ，分数变为 1
     * 4. 令牌 2 正面朝上，能量变为 0 ，分数变为 2
     *
     * @param tokens
     * @param power
     * @return
     */
    Integer MAX = 0;

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        get(tokens, 0, tokens.length - 1, power, 0);
        return MAX;
    }

    private void get(int[] tokens, int left, int right, int power, int score) {
        if (left > right) return;
        if (power >= tokens[left]) {
            int sum = power - tokens[left];
            int nextScore = score + 1;
            MAX = Math.max(MAX, nextScore);
            int nextLeft = left + 1;
            get(tokens, nextLeft, right, sum, nextScore);
        } else if (score >= 1) {
            int sum = power + tokens[right];
            int nextScore = score - 1;
            get(tokens, left, right - 1, sum, nextScore);
        }
    }

    private void backtrace(int[] tokens, int power, int score, boolean[] visited) {
        for (int i = 0; i < tokens.length; i++) {
            if (visited[i]) continue;
            int token = tokens[i];
            if (power >= token) {
                int remain = power - token;
                visited[i] = true;
                int nextScore = score + 1;
                MAX = Math.max(MAX, nextScore);
                backtrace(tokens, remain, nextScore, visited);
                visited[i] = false;
            }

            if (score >= 1) {
                int remain = power + token;
                visited[i] = true;
                backtrace(tokens, remain, score - 1, visited);
                visited[i] = false;
            }
        }
    }
}
