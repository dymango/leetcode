package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class SortColors_75 {

    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * 示例 2：
     * <p>
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == nums.length
     * 1 <= n <= 300
     * nums[i] 为 0、1 或 2
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int index0 = -1, index1 = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i >= index1) break;
            for (; ; ) {
                if (nums[i] == 0) {
                    int next = index0 + 1;
                    if (next == i) {
                        index0++;
                        break;
                    }

                    change(nums, i, next);
                    index0++;
                } else if (nums[i] == 2) {
                    int next = index1 - 1;
                    if (next == i) {
                        index1--;
                        break;
                    }

                    change(nums, i, next);
                    index1--;
                } else break;
            }
        }

        int i = 1;
    }

    public static void main(String[] args) {
        new SortColors_75().sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    private void change(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
