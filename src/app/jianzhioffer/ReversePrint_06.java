package app.jianzhioffer;

import app.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class ReversePrint_06 {

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     *
     * 示例 1：
     *
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *  
     *
     * 限制：
     *
     * 0 <= 链表长度 <= 10000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if(head == null) return new int[]{};
        int l = 0;
        int[] values = new int[10000];
        ListNode pointer = head;
        while (pointer != null) {
            values[l++] = pointer.val;
            pointer = pointer.next;
        }

        int[] result = new int[l];
        for (int i = 0; i < l; i++) {
            result[i] = values[l - i - 1];
        }

        return result;
    }
}
