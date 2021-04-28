package app.leetcode;

/**
 * @author dimmy
 */
public class SplitListToParts_725 {


    /**
     * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
     * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
     * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
     * 返回一个符合上述规则的链表的列表。
     *
     * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
     *
     * 示例 1：
     *
     * 输入:
     * root = [1, 2, 3], k = 5
     * 输出: [[1],[2],[3],[],[]]
     * 解释:
     * 输入输出各部分都应该是链表，而不是数组。
     * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
     * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
     * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
     * 示例 2：
     *
     * 输入:
     * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
     * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
     * 解释:
     * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
     *  
     *
     * 提示:
     *
     * root 的长度范围： [0, 1000].
     * 输入的每个节点的大小范围：[0, 999].
     * k 的取值范围： [1, 50].
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/split-linked-list-in-parts
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        int k2 = k;
        int size = size(root);
        int partSize = 0;
        int time = 0;
        if(size >= k) {
            partSize = size / k;
            time = size % k;
        } else {
            partSize = 1;
            time = k - size;
        }

        ListNode[] result = new ListNode[k];
        while (k > 0) {
            if(root == null) {
                result[k2 - k] = null;
                time--;
                k--;
                continue;
            }

            int curPartSize = partSize + (k <= size ? (time > 0 ? 1 : 0) : 0);
            result[k2 - k] = getNodes(root, curPartSize);
            time--;
            while (curPartSize-- > 0) {
                if(root == null) break;
                root = root.next;
            }

            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
//        ListNode n6 = new ListNode(6);
//        ListNode n7 = new ListNode(7);
//        ListNode n8 = new ListNode(8);
//        ListNode n9 = new ListNode(9);
//        ListNode n10 = new ListNode(10);
//        n9.next = n10;
//        n8.next = n9;
//        n7.next = n8;
//        n6.next = n7;
//        n5.next = n6;
//        n4.next = n5;
//        n3.next = n4;
        n2.next = n3;
        n1.next = n2;
        splitListToParts(n1, 5);
    }

    private static ListNode getNodes(ListNode node, int size) {
        if(size == 0) return null;
        ListNode newNode = new ListNode(node.val);
        newNode.next = getNodes(node.next, size - 1);
        return newNode;
    }

    private static int size(ListNode node) {
        if(node == null) return 0;
        return 1 + size(node.next);
    }
}
