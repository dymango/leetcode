package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class insertionSortList147 {

    /**
     * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
     * <p>
     * 插入排序 算法的步骤:
     * <p>
     * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
     * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
     * 重复直到所有输入数据插入完为止。
     * 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
     * <p>
     * 对链表进行插入排序。
     *
     * 算法概括： 从前往后插入， 如果当前节点大于前一个节点， 不用插入，窗口后移一位. 如果当前节点小于前一个节点， 就遍历窗口，插入
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        var vir = new ListNode(-1);
        vir.next = head;
        var lastSortedNode = head;
        var cur = head.next;
        while (cur != null) {
            if (cur.val > lastSortedNode.val) {
                lastSortedNode = cur;
                cur = cur.next;
                continue;
            }

            var p = vir;
            while (p.next.val < cur.val) {
                p = p.next;
            }

            lastSortedNode.next = cur.next;
            cur.next = p.next;
            p.next = cur;
            cur = lastSortedNode.next;
        }

        return vir.next;
    }
}
