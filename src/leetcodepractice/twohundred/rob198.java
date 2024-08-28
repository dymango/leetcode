package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class rob198 {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     * @param nums
     * @return
     *
     * 2,1,1,2
     */
    public int rob(int[] nums) {
        int[][] max = new int[nums.length][2];
        max[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i][1] = nums[i] + max[i - 1][0];
            max[i][0] = Math.max(max[i - 1][1], max[i - 1][0]);
        }

        return Math.max(max[nums.length - 1][0], max[nums.length - 1][1]);
    }
}
