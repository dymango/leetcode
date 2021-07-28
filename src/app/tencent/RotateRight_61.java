package app.tencent;

import app.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class RotateRight_61 {

    public ListNode rotateRight(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] nodes = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nodes[(i + k )% list.size()] = list.get(i);
        }

        ListNode h = new ListNode(-1);
        ListNode pointer = h;
        for (int i = 0; i < nodes.length; i++) {
            ListNode node = new ListNode(nodes[i]);
            pointer.next = node;
            pointer =pointer.next;
        }

        return h.next;
    }
}
