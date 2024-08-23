package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class removeDuplicates80 {

    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int deleted = 0;
        for (int i = 1; i < nums.length; i++) {
            var num = nums[i];
            if (count == 2 && num == nums[i - 1]) {
                deleted++;
                continue;
            }

            if (num == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            nums[i - deleted] = nums[i];
        }

        return nums.length - deleted;
    }

    void move(int[] nums, int start) {
        for (int i = start; i < nums.length - 1; i++) {
            nums[start] = nums[start + 1];
        }
    }
}
