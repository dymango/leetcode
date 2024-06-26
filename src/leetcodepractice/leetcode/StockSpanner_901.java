package leetcodepractice.leetcode;

import java.util.Stack;

/**
 * @author dimmy
 */
public class StockSpanner_901 {

    /**
     * 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
     * <p>
     * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
     * <p>
     * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
     * 输出：[null,1,1,1,2,1,4,6]
     * 解释：
     * 首先，初始化 S = StockSpanner()，然后：
     * S.next(100) 被调用并返回 1，
     * S.next(80) 被调用并返回 1，
     * S.next(60) 被调用并返回 1，
     * S.next(70) 被调用并返回 2，
     * S.next(60) 被调用并返回 1，
     * S.next(75) 被调用并返回 4，
     * S.next(85) 被调用并返回 6。
     * <p>
     * 注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
     * (包括今天的价格 75) 小于或等于今天的价格。
     *  
     * <p>
     * 提示：
     * <p>
     * 调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。
     * 每个测试用例最多可以调用  10000 次 StockSpanner.next。
     * 在所有测试用例中，最多调用 150000 次 StockSpanner.next。
     * 此问题的总时间限制减少了 50%。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/online-stock-span
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static class Node {
        public int num;
        public int index;
        public int preCount;

        public Node(int num, int index, int preCount) {
            this.num = num;
            this.index = index;
            this.preCount = preCount;
        }
    }


    int index = -1;
    Stack<Node> stack = new Stack<>();

    public StockSpanner_901() {

    }

    public int next(int price) {
        index++;
        if (stack.isEmpty()) {
            stack.push(new Node(price, index, 0));
            return 1;
        }

        int length = 1;
        while (!stack.isEmpty()) {
            Node peek = stack.peek();
            if (peek.num <= price) {
                stack.pop();
                length = index - peek.index + 1 + peek.preCount;
            } else {
                stack.push(new Node(price, index, length - 1));
                return length;
            }
        }

        stack.push(new Node(price, index, length - 1));
        return length;
    }

    public static void main(String[] args) {
        /**
         * ["StockSpanner","next","next","next","next","next"]
         * [[],[31],[41],[48],[59],[79]]
         *
         * ["StockSpanner","next","next","next","next","next","next","next","next","next","next"]
         * [[],[28],[14],[28],[35],[46],[53],[66],[80],[87],[88]]
         */
        StockSpanner_901 stockSpanner_901 = new StockSpanner_901();
        stockSpanner_901.next(100);
        stockSpanner_901.next(80);
        stockSpanner_901.next(60);
        stockSpanner_901.next(70);
        stockSpanner_901.next(75);
    }
}
