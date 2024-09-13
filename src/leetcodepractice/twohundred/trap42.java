package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class trap42 {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * 示例 1：
     * <p>
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     * <p>
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     *
     * @param height
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new trap42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        var length = height.length;
        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        int rightMax = height[length - 1];
        int sum = 0;
        for (int i = length - 2; i > 0; i--) {
            int l = leftMax[i];
            if (l > height[i] && rightMax > height[i]) {
                sum += Math.min(l, rightMax) - height[i];
            }

            rightMax = Math.max(rightMax, height[i]);
        }

        return sum;
    }


    public int trapV2(int[] height) {
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
            if (height[i] < min) sum += (min - height[i]);
        }

        return sum;
    }
}
