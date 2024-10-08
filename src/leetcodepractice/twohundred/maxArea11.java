package leetcodepractice.twohundred;

/**
 * @author dimmy
 */
public class maxArea11 {
    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     * <p>
     * 说明：你不能倾斜容器。
     * <p>
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,9,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例 2：
     * <p>
     * 输入：height = [1,1]
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        //(height[j] - height[i] )* (j - i)
        int left = 0;
        int right= height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            var l = height[left];
            var r = height[right];
            max = Math.max(max, Math.min(l, r) * (right - left));
            if(l > r) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }
}
