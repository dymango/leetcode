package leetcodepractice.leetcode.tophundred;

import leetcodepractice.leetcode.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class removeNthFromEnd_19 {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * 示例 2：
     * <p>
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1,2], n = 1
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            ListNode newNode = p;
            map.put(count, newNode);
            p = p.next;
        }

        int index = count - n;
        if (index == 0) return head.next;
        ListNode listNode = map.get(index);
        listNode.next = listNode.next.next;
        return head;
    }

    public ListNode removeNthFromEndV2(ListNode head, int n) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }

        if(length == n) return head.next;
        p = head;
        int position = 1;
        while (p != null) {
            if (position == length - n) {
                p.next = p.next.next;
                break;
            }

            p = p.next;
            position++;
        }

        return head;
    }
}
