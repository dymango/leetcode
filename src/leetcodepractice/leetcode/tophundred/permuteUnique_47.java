package leetcodepractice.leetcode.tophundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class permuteUnique_47 {
    List<List<Integer>> r = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        listAll(new ArrayList<>(), nums, new HashSet<>());
        return r;
    }

    private void listAll(List<Integer> list, int[] nums, Set<Integer> visited) {
        if (list.size() == nums.length) {
            r.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(i) || (i > 0 && nums[i] == nums[i - 1] && !visited.contains(i - 1))) continue;
            visited.add(i);
            list.add(nums[i]);
            listAll(list, nums, visited);
            list.remove(list.size() - 1);
            visited.remove(i);
        }
    }


    public static void main(String[] args) {
        new permuteUnique_47().permuteUnique(new int[]{1, 1, 2});
    }

}
