package app.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class canReorderDoubled_954 {

    /**
     * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [3,1,3,6]
     * 输出：false
     * 示例 2：
     * <p>
     * 输入：arr = [2,1,2,6]
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：arr = [4,-2,2,-4]
     * 输出：true
     * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= arr.length <= 3 * 104
     * arr.length 是偶数
     * -105 <= arr[i] <= 105
     *
     * @param arr
     * @return
     */
    public boolean canReorderDoubled(int[] arr) {
        Set<Integer> visited = new HashSet<>();
        Arrays.sort(arr);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if(visited.contains(i)) continue;
            int a = arr[i];
            if (a > 0 && a % 2 != 0) return false;
            int target = a >= 0 ? a / 2 : a * 2;
            List<Integer> list = map.get(target);
            if (list == null || list.isEmpty()) return false;
            Integer index = list.get(list.size() - 1);
            visited.add(index);
            list.remove(list.size() - 1);
        }

        return true;
    }

    //[-1,2,4,2,4,2,-2,4]
    public boolean canReorderDoubledV2(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            if (set.contains(i)) continue;
            int a = arr[i];
            if (a > 0 && a % 2 != 0) return false;
            int target = a >= 0 ? a / 2 : a * 2;
            int targetIndex = i - 1;
            while (targetIndex >= 0 && arr[targetIndex] > target || set.contains(targetIndex)) targetIndex--;
            if (targetIndex < 0 || arr[targetIndex] != target) return false;
            set.add(i);
            set.add(targetIndex);
        }

        return true;
    }
}
