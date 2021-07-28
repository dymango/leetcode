package app.tencent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class Permute_46 {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出：[[1]]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    int[] globalNums;
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        globalNums = nums;
        result = new ArrayList<>();
        backTracking(new ArrayList<>(), new HashSet<>());
        return result;
    }

    private void backTracking(List<Integer> list, Set<Integer> visited) {
        if(list.size() == globalNums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < globalNums.length; i++) {
            if(!visited.add(globalNums[i]))continue;
            list.add(globalNums[i]);
            backTracking(list, visited);
            visited.remove(globalNums[i]);
            list.remove(list.size() - 1);
        }
    }
}
