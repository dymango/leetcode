package app.leetcode;

/**
 * @author dimmy
 */
public class TotalHammingDistance_477 {
    public int totalHammingDistance(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            for (int j = 0; j < len; j++) {
                one += (nums[j] & 1);
                nums[j] >>= 1;
            }
            ans += one * (len - one);
        }
        return ans;
    }

}
