package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class reorderList143 {

    /**
     * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
     * <p>
     * L0 → L1 → … → Ln - 1 → Ln
     * 请将其重新排列后变为：
     * <p>
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        var pointer = head;
        List<ListNode> nodes = new ArrayList<>();
        while (pointer != null) {
            nodes.add(pointer);
            pointer = pointer.next;
        }

        while (!nodes.isEmpty() && nodes.size() > 1) {
            var cur = nodes.get(0);
            var last = nodes.getLast();
            nodes.removeLast();
            var last2 = nodes.getLast();
            last2.next = null;
            last.next = cur.next;
            cur.next = last;
            nodes.removeFirst();
        }
    }
}
