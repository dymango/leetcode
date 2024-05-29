package leetcodepractice.leetcode;

import java.util.Stack;

/**
 * @author dimmy
 */
public class DailyTemperatures_739 {

    /**
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/daily-temperatures
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Node> nodes = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if(nodes.isEmpty()) {
                nodes.push(new Node(T[i], i));
                continue;
            }

            while (!nodes.isEmpty() && nodes.peek().temp < T[i]) {
                Node pop = nodes.pop();
                result[pop.day] = i - pop.day;
            }

            nodes.push(new Node(T[i], i));
        }

        while (!nodes.isEmpty()){
            Node pop = nodes.pop();
            result[pop.day] = 0;
        }

        return result;
    }

    public class Node {
        public int temp;
        public int day;

        public Node(int temp, int day) {
            this.temp = temp;
            this.day = day;
        }
    }
}
