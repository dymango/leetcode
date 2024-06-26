package leetcodepractice.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author dimmy
 */
public class MyCalendarThree {

    /**
     * 当 k 个日程安排有一些时间上的交叉时（例如 k 个日程安排都在同一时间内），就会产生 k 次预订。
     * 给你一些日程安排 [start, end) ，请你在每个日程安排添加后，返回一个整数 k ，表示所有先前日程安排会产生的最大 k 次预订。
     * 实现一个 MyCalendarThree 类来存放你的日程安排，你可以一直添加新的日程安排。
     * MyCalendarThree() 初始化对象。
     * int book(int start, int end) 返回一个整数 k ，表示日历中存在的 k 次预订的最大值。
     *  
     *
     * 示例：
     *
     * 输入：
     * ["MyCalendarThree", "book", "book", "book", "book", "book", "book"]
     * [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
     * 输出：
     * [null, 1, 1, 2, 3, 3, 3]
     *
     * 解释：
     * MyCalendarThree myCalendarThree = new MyCalendarThree();
     * myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
     * myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
     * myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
     * myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
     * myCalendarThree.book(5, 10); // 返回 3
     * myCalendarThree.book(25, 55); // 返回 3
     *  
     *
     * 提示：
     *
     * 0 <= start < end <= 109
     * 每个测试用例，调用 book 函数最多不超过 400次
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/my-calendar-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    TreeMap<Integer, Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.merge(start, 1, Integer::sum);
        map.merge(end, -1, Integer::sum);
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue();
            max = Math.max(max, sum);
        }

        return max;
    }


    class TreeNode {
        // 区间
        int start, end;
        // 最大预订次数
        int maxTime;
        // 当前区间延迟更新次数（即子区间未更新）
        int delayTime;
        // 子节点
        TreeNode left, right;

        TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }

        private int getMid() {
            return (start + end) / 2;
        }

        private TreeNode left() {
            if (this.left == null) this.left = new TreeNode(start, getMid());
            return this.left;
        }

        private TreeNode right() {
            if (this.right == null) this.right = new TreeNode(getMid(), end);
            return this.right;
        }

        public int insert(int s, int e) {
            // 包含，更新区间
            if (this.start >= s && this.end <= e) {
                this.delayTime++;
                this.maxTime++;
            }
            // 相交
            else if (this.end > s && this.start < e) {
                // 自上向下延迟更新
                this.left().maxTime += this.delayTime;
                this.left().delayTime += this.delayTime;
                this.right().maxTime += this.delayTime;
                this.right().delayTime += this.delayTime;
                // 延迟更新完成，清空
                this.delayTime = 0;

                // 自下向上更新最大次数
                this.maxTime = Math.max(this.maxTime, Math.max(this.left().insert(s, e), this.right().insert(s, e)));
            }

            return this.maxTime;
        }
    }
}
