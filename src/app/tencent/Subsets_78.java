package app.tencent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class Subsets_78 {

    /**
     * 你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subsets
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    int[] globalNums;
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        globalNums = nums;
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            backTracking(i, new ArrayList<>(), new HashSet<>(), 0);
        }

        return result;
    }

    private void backTracking(int n, List<Integer> list, Set<Integer> set, int index) {
        if (list.size() == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < globalNums.length; i++) {
            if (!set.add(globalNums[i])) continue;
            list.add(globalNums[i]);
            backTracking(n, list, set, i + 1);
            set.remove(globalNums[i]);
            list.remove(list.size() - 1);
        }
    }
}
