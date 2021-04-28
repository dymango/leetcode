package app.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * @author dimmy
 */
public class Makesquare_473 {
    /**
     * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
     * <p>
     * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,1,2,2,2]
     * 输出: true
     * <p>
     * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
     * 示例 2:
     * <p>
     * 输入: [3,3,3,3,4]
     * 输出: false
     * <p>
     * 解释: 不能用所有火柴拼成一个正方形。
     * 注意:
     * <p>
     * 给定的火柴长度和在 0 到 10^9之间。
     * 火柴数组的长度不超过15。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/matchsticks-to-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * 1 1 3 1 4 2 3 2 2 1
     * @return
     */
    static boolean[] marked;
    public static boolean makesquare(int[] nums) {
        if(nums.length < 4) return false;
        Arrays.sort(nums);
        marked = new boolean[nums.length];
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
        }

        if (sum % 4 != 0) return false;
        int lengthOfSide = sum / 4;
        for (int i = 0; i < 4; i++) {
            if (!match(nums, 0, lengthOfSide)) return false;
        }

        return true;
    }

    public static boolean match(int[] nums, int sum, int lengthOfSide) {
        if (sum > lengthOfSide) return false;
        if (sum == lengthOfSide) return true;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (marked[i]) continue;
            marked[i] = true;
            if (match(nums, sum + nums[i], lengthOfSide)) {
                return true;
            } else {
                marked[i] = false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(makesquare(new int[]{1, 1, 3, 1, 4, 2, 3, 2, 2,2}));
        System.out.println(makesquare(new int[]{3,3,3,3,4}));
        System.out.println( makesquare(new int[]{1,1,2,2,2}));

    }
}
