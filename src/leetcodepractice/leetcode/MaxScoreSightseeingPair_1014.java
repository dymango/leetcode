package leetcodepractice.leetcode;

import leetcodepractice.executor.MainMethod;
import leetcodepractice.executor.MainParam;

import java.util.Stack;

/**
 * @author dimmy
 */
public class MaxScoreSightseeingPair_1014 {

    /**
     * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
     * <p>
     * 一对景点（i < j）组成的观光组合的得分为 values[i] + i + values[j]- j ，也就是景点的评分之和 减去 它们两者之间的距离。
     * <p>
     * 返回一对观光景点能取得的最高分。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * // 8 + 2- 3 = 7
     * // 2右边的景点评分更低，完全不用选
     * <p>
     * 输入：values = [8,1,5,2,6]
     * <p>
     * 1 5 6
     * <p>
     * 输出：11
     * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
     * 示例 2：
     * <p>
     * 输入：values = [1,2]
     * 输出：2
     * <p>
     * <p>
     * 提示：
     * <p>
     * 2 <= values.length <= 5 * 104
     * 1 <= values[i] <= 1000
     *
     * @param values
     * @return 我们考虑从前往后遍历 j 来统计答案，对于每个观光景点 j 而言，我们需要遍历 [0,j−1] 的观光景点 i 来计算组成观光组合 (i,j) 得分的最大值 cnt
     * j
     * ​
     * 来作为第 j 个观光景点的值，那么最后的答案无疑就是所有观光景点值的最大值，即 max
     * j=0..n−1
     * ​
     * {cnt
     * j
     * ​
     * }。但是遍历 j 需要 O(n) 的时间复杂度，遍历 [0,j−1] 的观光景点 i 也需要 O(n) 的时间复杂度，因此该方法总复杂度为 O(n
     * 2
     * )，不能通过所有测试用例，我们需要进一步优化时间复杂度。
     * <p>
     * 我们回过头来看得分公式，我们可以将其拆分成 values[i]+i 和 values[j]−j 两部分，这样对于统计景点 j 答案的时候，由于 values[j]−j 是固定不变的，因此最大化 values[i]+i+values[j]−j 的值其实就等价于求 [0,j−1] 中 values[i]+i 的最大值 mx，景点 j 的答案即为 mx+values[j]−j 。而 mx 的值我们只要从前往后遍历 j 的时候同时维护即可，这样每次遍历到景点 j 的时候，寻找使得得分最大的 i 就能从 O(n) 降至 O(1) 的时间复杂度，总时间复杂度就能从 O(n
     * 2
     * ) 降至 O(n)。
     * <p>
     * <p>
     * 1 / 9
     * C++
     * Java
     * Golang
     * C#
     * <p>
     * <p>
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/best-sightseeing-pair/solutions/291380/zui-jia-guan-guang-zu-he-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    //1, 3, 5
    //8,1,5,2,6
    //2,10,9,3,2
//[9,7,6,7,6,9]
    //6,3,7,4,7,6,6,4,9
    //6,3,7,4,7,6,6,4,9
    @MainParam
    int[] arr = {1,3,5};

    @MainMethod
    public int cal(int[] values) {
        var length = values.length;
        int maxj = values[length - 1] - (length - 1);
        int max = Integer.MIN_VALUE;
        for (int i = length - 2; i >= 0; i--) {
            int sumi = values[i] + i;
            max = Math.max(max, sumi + maxj);
            maxj = Math.max(maxj, values[i] - i);
        }

        return max;
    }



    public int maxScoreSightseeingPair(int[] values) {
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            max = Math.max(values[i] + values[i - 1] - 1, max);
            var value = values[i];
            if (stack.isEmpty()) {
                stack.push(i);
                max = Math.max(max, values[0] + value - i);
                continue;
            }

            max = Math.max(max, values[stack.peek()] + value + stack.peek() - i);
            if (values[stack.peek()] > value) continue;
            stack.push(i);
        }

        int index = 0;

        while (!stack.isEmpty()) {
            var i = stack.peek();
            if (index >= i) break;
            var sum = values[i] + values[index] + index - i;
            if (sum >= max) {
                max = sum;
                stack.pop();
            } else {
                index++;
            }
        }

        return max;
    }


    public int maxScoreSightseeingPairV2(int[] values) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < values.length; i++) {
            var value = values[i];
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            if (values[stack.peek()] > value) continue;
            stack.push(i);
        }

        int max = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            var pop = stack.pop();
            var pv = values[pop];
            for (int i = 0; i < pop; i++) {
                max = Math.max(max, values[i] + pv + i - pop);
            }
        }

        return max;
    }
}
