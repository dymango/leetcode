package app.leetcode.tophundred;

/**
 * @author dimmy
 */
public class removeDuplicates_80 {

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int repeatCount = 0;
        int length = nums.length;
        int duplicated = 1;
        int last = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - repeatCount - 1]) {
                duplicated++;
            } else {
                duplicated = 1;
            }

            if (duplicated > 2) repeatCount++;
            if (duplicated <= 2) {
                exchange(nums, i, i - repeatCount);
                last = i - repeatCount;
            }
        }

        return last + 1;
    }

    private void exchange(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(new removeDuplicates_80().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
//        System.out.println(new removeDuplicates_80().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }
}
