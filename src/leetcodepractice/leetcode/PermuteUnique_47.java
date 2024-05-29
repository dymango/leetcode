package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class PermuteUnique_47 {

    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     * 通过次数453,335提交次数692,103
     *
     * @param nums
     * @return
     */
    List<List<Integer>> result = new ArrayList<>();
    int size;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        size = nums.length;
        backTracking(new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backTracking(List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == size) {
            result.add(new ArrayList<>(list));
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (!set.add(nums[i])) continue;
            visited[i] = true;
            list.add(nums[i]);
            backTracking(list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    boolean[] vis;

    public List<List<Integer>> permuteUniqueV2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    //要解决重复问题，我们只要设定一个规则，保证在填第 \textit{idx}idx 个数的时候重复数字只会被填入一次即可。而在本题解中，我们选择对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」，即如下的判断条件：
    //
    //C++
    //
    //if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
    //    continue;
    //}
    //这个判断条件保证了对于重复数的集合，一定是从左往右逐个填入的。
    //
    //假设我们有 33 个重复数排完序后相邻，那么我们一定保证每次都是拿从左往右第一个未被填过的数字，即整个数组的状态其实是保证了 [未填入，未填入，未填入][未填入，未填入，未填入] 到 [填入，未填入，未填入][填入，未填入，未填入]，再到 [填入，填入，未填入][填入，填入，未填入]，最后到 [填入，填入，填入][填入，填入，填入] 的过程的，因此可以达到去重的目标。
    //
    //作者：LeetCode-Solution
    //链接：https://leetcode.cn/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        // 2 1 1 1 2
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
