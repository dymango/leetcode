package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class jump45 {
    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     * <p>
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     * <p>
     * 0 <= j <= nums[i]
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     *
     * @param nums
     * @return
     */
    public static void main(String[] args) {
        new jump45().jump(new int[]{1, 1, 1, 1});
    }

    public int jump(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 0;
        int start = 0;
        var length = nums.length;
        while (true) {
            var right = nums[start] + start;
            if (right >= length - 1) return count + 1;
            int max = Integer.MIN_VALUE;
            int next = start;
            for (int i = start + 1; i <= right; i++) {
                if(nums[i] + i > max) {
                    next = i;
                    max = nums[i] + i;
                }
            }

            start = next;
            count++;
            if (start > length - 1) return count + 1;
        }
    }
}
