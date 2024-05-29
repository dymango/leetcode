package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class FindSubsequences_491 {

    /**
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     *
     * 示例:
     *
     * 输入: [4, 6, 7, 7]
     * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
     * 说明:
     *
     * 给定数组的长度不会超过15。
     * 数组中的整数范围是 [-100,100]。
     * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/increasing-subsequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    static Set<String> set = new HashSet<>();
    static List<List<Integer>> result = new ArrayList<>();
    public static List<List<Integer>> findSubsequences(int[] nums) {
        return result;
    }

    public static  List<List<Integer>> memorizationRecursion(int[] nums, int index) {
        List<List<Integer>> increasingList = new ArrayList<>();
        for (int i = index; i < nums.length; i++) {
            increasingList.addAll(memorizationRecursion(nums, index));
        }

        return increasingList;
    }

    public static void main(String[] args) {
        findSubsequences(new int[]{4, 6, 7, 7});
    }
}
