package app.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author dimmy
 */
public class MyCalendar {

    /**
     * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。
     * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
     * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。
     * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
     *
     * 请按照以下步骤调用 MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
     *
     * 示例 1:
     *
     * MyCalendar();
     * MyCalendar.book(10, 20); // returns true
     * MyCalendar.book(15, 25); // returns false
     * MyCalendar.book(20, 30); // returns true
     * 解释:
     * 第一个日程安排可以添加到日历中.  第二个日程安排不能添加到日历中，因为时间 15 已经被第一个日程安排预定了。
     * 第三个日程安排可以添加到日历中，因为第一个日程安排并不包含时间 20 。
     * 说明:
     *
     * 每个测试用例，调用 MyCalendar.book 函数最多不超过 100次。
     * 调用函数 MyCalendar.book(start, end)时， start 和 end 的取值范围为 [0, 10^9]。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/my-calendar-i
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    List<Node> nodes = new ArrayList<>();
    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        boolean intersect = nodes.stream().allMatch(node -> isNotIntersect(node, start, end));
        if(intersect) nodes.add(new Node(start, end));
        return intersect;
    }

    private boolean isNotIntersect(Node node, int left, int right) {
        return node.right <= left || node.left >= right;
    }

    public class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }


    // 线段树的根
    private SegmentTreeNode root;

    /**
     * 线段树结构体
     */
    private static class SegmentTreeNode {
        int start;// 时间开始区间
        int end;// 时间结束区间

        SegmentTreeNode left;// 区间左孩子
        SegmentTreeNode right;// 区间右孩子

        SegmentTreeNode(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

//    public MyCalendar() {
//        root = new SegmentTreeNode(0,0);
//    }
//
//    public boolean book(int start, int end) {
//        return updateSegment(root,start,end);
//    }
//
//    /**
//     * 更新线段树节点
//     * @param root 线段树节点
//     * @param start 新插入的开始时间
//     * @param end 新插入的结束时间
//     * @return 是否合法
//     */
//    private boolean updateSegment(SegmentTreeNode root,int start,int end){
//        // 新节点，要么只能全在node.start往左，要么只能全在node.end往右
//        SegmentTreeNode node = root;
//        while (true){
//            // 因为start,end是前闭后开区间，所以end可以取等号
//            if (end <= node.start){
//                // 左子树为空，表示可以添加
//                if (node.left == null){
//                    node.left = new SegmentTreeNode(start,end);
//                    return true;
//                }
//                // 进入左子树线段树
//                node = node.left;
//            }else if (start >= node.end){
//                // 右子树为空，表示可以添加
//                if (node.right == null){
//                    node.right = new SegmentTreeNode(start, end);
//                    return true;
//                }
//                // 进入右子树的线段树
//                node = node.right;
//            }else {
//                // start或end在[node.start,node.end)中，产生了重复预定
//                return false;
//            }
//        }
//    }
}
