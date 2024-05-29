package leetcodepractice.tencent;

import leetcodepractice.leetcode.base.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author dimmy
 */
public class MergeKLists_23 {

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *  
     *
     * 示例 1：
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     *
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：lists = [[]]
     * 输出：[]
     *  
     *
     * 提示：
     *
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     * 通过次数289,095提交次数520,064
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                list.add(listNode.val);
                listNode = listNode.next;
            }
        }

        list.sort(Comparator.comparingInt(o -> o));
        ListNode head = new ListNode(-1);
        ListNode pointer = head;
        for (Integer integer : list) {
            ListNode n = new ListNode(integer);
            pointer.next = n;
            pointer = pointer.next;
        }

        return head.next;
    }

    public ListNode mergeKListsV2(ListNode[] lists) {
        ListNode[] ps = new ListNode[lists.length];
        for (int i = 0; i < ps.length; i++) {
            ListNode p = lists[i];
            ps[i] = p;
        }


        ListNode head = new ListNode(-1);
        ListNode pointer = head;
        while (true) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            boolean haveValue = false;
            for (int i = 0; i < ps.length; i++) {
                if(ps[i] == null) continue;
                haveValue = true;
                if(ps[i].val < min)
                {
                    min = ps[i].val;
                    index = i;
                }
            }

            if(!haveValue) break;
            ListNode n = new ListNode(min);
            pointer.next = n;
            pointer = pointer.next;
            ps[index] = ps[index].next;
        }

        return head.next;
    }
}
