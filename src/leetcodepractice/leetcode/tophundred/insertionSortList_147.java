package leetcodepractice.leetcode.tophundred;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class insertionSortList_147 {

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
     * 列表中的节点数在 [1, 5000]范围内
     * -5000 <= Node.val <= 5000
     * <p>
     * head = [4,2,1,3]
     * 输出: [1,2,3,4]
     * 示例 2：
     * <p>
     * [-1,5,3,4,0]
     * 输出: [-1,0,3,4,5]
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode p = head;
        ListNode sortNodePreNode = null;
        int sortLength = 0;
        while (p != null) {
            boolean move = false;
            ListNode tempNext = p.next;
            if (sortLength != 0) {
                ListNode index = head;
                ListNode pre = null;
                int step = 0;
                while (index != null && step < sortLength) {
                    if (p.val < index.val) {
                        sortNodePreNode.next = tempNext;
                        p.next = index;
                        if (index != head) {
                            pre.next = p;
                        } else {
                            head = p;
                        }

                        move = true;
                        break;
                    }

                    pre = index;
                    index = index.next;
                    step++;
                }
            }

            if(!move) {
                sortNodePreNode = p;
                p = p.next;
            } else {
                p = tempNext;
            }

            sortLength++;
        }

        return head;
    }
}
