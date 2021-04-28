package app.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class CanPartitionKSubsets_698 {

    /**
     * 给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
     * <p>
     * 示例 1：
     * <p>
     * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
     * 输出： True
     * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= k <= len(nums) <= 16
     * 0 < nums[i] < 10000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
//    public boolean canPartitionKSubsets(int[] nums, int k) {
//        return false;
//    }

    public static void main(String[] args) {
//        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        long s = System.currentTimeMillis();
        System.out.println(canPartitionKSubsets(new int[]{605,454,322,218,8,19,651,2220,175,710,2666,350,252,2264,327,1843}, 4));

        System.out.println(canPartitionKSubsets(new int[]{18,20,39,73,96,99,101,111,114,190,207,295,471,649,700,1037}, 4));
        System.out.println((System.currentTimeMillis() - s));
//        canPartitionKSubsetsV2(new int[]{3, 3, 2, 5, 5, 2, 1}, 4);
    }

    public static boolean canPartitionKSubsetsV2(int[] nums, int k) {
        K = k;
        l = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int target = sum / k;
        for (int num : nums) {
            if(num > target) return false;
        }
        boolean[] marked = new boolean[nums.length];
        find(nums, marked, target, 0);
        check(marks, new ArrayList<>(), 0);
        return find;
    }

    static List<boolean[]> marks = new ArrayList<>();
    static int l;
    static int K;
    static boolean find = false;
    private static void find(int[] nums, boolean[] marked, int need, int index) {
        if(index >= nums.length) return;
        for (int i = index; i < nums.length; i++) {
            if(marked[i] || nums[i] > need) continue;
            marked[i] = true;
            if(nums[i] == need) marks.add(marked.clone());
            else find(nums, marked, need - nums[i], i + 1);
            marked[i] = false;
        }
    }

    private static void check(List<boolean[]> marks, List<Integer> indexes, int index) {
        if(find) return;
        if(indexes.size() == K) {
            int[] count = new int[l];
            for (int i = 0; i < K; i++) {
                boolean[] booleans = marks.get(indexes.get(i));
                for (int j = 0; j < booleans.length; j++) {
                    if(booleans[j]) count[j]++;
                    if(count[j] > 1) return;
                }
            }

            find = true;
            return;
        }

        for (int i = index; i < marks.size(); i++) {
            indexes.add(i);
            check(marks, indexes, i + 1);
            indexes.remove(indexes.size() - 1);
        }
    }

    private static boolean backTracking(int[] nums, boolean[] marked, int target, int need, int k) {
        if(k == 0) return true;
        boolean split = false;
        for (int i = 0; i < nums.length; i++) {
            if(marked[i]) continue;
            if(nums[i] == need) {
                marked[i] = true;
                split = split || backTracking(nums, marked, target, target, k - 1);
                if(split) return true;
                marked[i] = false;
            } else if(nums[i] < need) {
                marked[i] = true;
                split = split || backTracking(nums, marked, target, need - nums[i], k);
                if(split) return true;
                marked[i] = false;
            }
        }

        return split;
    }


    public static boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
            if (groups[i] == 0) {
                break;
            }
        }
        return false;
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }

}
