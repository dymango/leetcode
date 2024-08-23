package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class searchRange34 {

    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     *
     * @param nums
     * @param target
     * @return
     */
    public static void main(String[] args) {
        new searchRange34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 1 && nums[0] == target) return new int[]{0, 0};
        while (start <= end) {
            var mid = start + (end - start) / 2;
            int l = mid;
            var r = mid;
            if (nums[mid] == target) {
                int s = start;
                int e = mid - 1;
                while (s <= e) {
                    var m = s + (e - s) / 2;
                    if (nums[m] == target) {
                        e = m - 1;
                        l = m;
                    } else {
                        s = m + 1;
                    }
                }

                s = mid + 1;
                e = end;
                while (s <= e) {
                    var m = s + (e - s) / 2;
                    if (nums[m] == target) {
                        s = m + 1;
                        r = m;
                    } else {
                        e = m - 1;
                    }
                }


                return new int[]{l, r};

            } else {
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return new int[]{-1, -1};
    }

}
