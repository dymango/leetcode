package leetcodepractice.twohundred;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class deleteNode_237 {

    /**
     * 有一个单链表的 head，我们想删除它其中的一个节点 node。
     * <p>
     * 给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
     * <p>
     * 链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。
     * <p>
     * 删除给定的节点。注意，删除节点并不是指从内存中删除它。这里的意思是：
     * <p>
     * 给定节点的值不应该存在于链表中。
     * 链表中的节点数应该减少 1。
     * node 前面的所有值顺序相同。
     * node 后面的所有值顺序相同。
     * 自定义测试：
     * <p>
     * 对于输入，你应该提供整个链表 head 和要给出的节点 node。node 不应该是链表的最后一个节点，而应该是链表中的一个实际节点。
     * 我们将构建链表，并将节点传递给你的函数。
     * 输出将是调用你函数后的整个链表。
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
