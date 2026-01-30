package leetcodepractice.leetcode;

import leetcodepractice.leetcode.base.ListNode;

/**
 * @author dimmy
 */
public class MinimumPairRemoval_3507 {

    /**
     * 给你一个数组 nums，你可以执行以下操作任意次数：
     * <p>
     * 选择 相邻 元素对中 和最小 的一对。如果存在多个这样的对，选择最左边的一个。
     * 用它们的和替换这对元素。
     * 返回将数组变为 非递减 所需的 最小操作次数 。
     * <p>
     * 如果一个数组中每个元素都大于或等于它前一个元素（如果存在的话），则称该数组为非递减。
     *
     * @param nums
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new MinimumPairRemoval_3507().minimumPairRemoval(new int[]{5, 2, 3, 1}));
    }

    public int minimumPairRemoval(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (int i = 0; i < nums.length - 1; i++) {
            ListNode newNode = new ListNode(nums[i] + nums[i + 1]);
            p.next = newNode;
            p = newNode;
        }

        int count = 0;
        while (!isIncreaseList(dummy)) {
            int min = Integer.MAX_VALUE;
            ListNode minNode = dummy.next;
            ListNode start = dummy.next;
            while (start.next != null) {
                if (start.val < min) {
                    minNode = start;
                    min = start.val;
                }

                start = start.next;
            }

            if (minNode != dummy && minNode.next != null) {
                minNode.next = minNode.next.next;
                minNode.val = min;
            }
            count++;
        }

        return count;
    }

    private boolean isIncreaseList(ListNode dummy) {
        var start = dummy.next;
        while (start.next != null) {
            if (start.val > start.next.val) return false;
            start = start.next;
        }

        return true;
    }
}
