package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class Trap_42 {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * 示例 1：
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     * <p>
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *  
     * <p>
     * 提示：
     * <p>
     * n == height.length
     * 0 <= n <= 3 * 104
     * 0 <= height[i] <= 105
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];
        for (int i = 1; i < length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }

        for (int i = length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            int leftValue = left[i];
            int rightValue = right[i];
            int min = Math.min(leftValue, rightValue);
            if(height[i] < min) sum += (min - height[i]);
        }

        return sum;
    }


    public int trap2(int[] height) {
        int sum = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(height[left] < height[right]) {
                sum += leftMax - height[left];
                left++;
            } else {
                sum += rightMax - height[right];
                right--;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Trap_42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
