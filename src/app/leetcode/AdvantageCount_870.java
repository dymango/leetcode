package app.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dimmy
 */
public class AdvantageCount_870 {

    /**
     * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
     * 返回 A 的任意排列，使其相对于 B 的优势最大化。
     * <p>
     * <p>
     * 示例 1：
     * 输入：A = [2,7,11,15], B = [1,10,4,11]
     * 输出：[2,11,7,15]
     * 示例 2：
     * <p>
     * 输入：A = [12,24,8,32], B = [13,25,32,11]
     * 输出：[24,32,8,12]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length = B.length <= 10000
     * 0 <= A[i] <= 10^9
     * 0 <= B[i] <= 10^9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/advantage-shuffle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums1
     * @param nums2
     * @return order array B, and get number from A mapping every number on B
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        List<Integer> list = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        int[] r = new int[nums2.length];
        list.sort(Integer::compareTo);
        for (int i = 0; i < nums2.length; i++) {
            int index = findTargetIndex(list, nums2[i]);
            if (index != -1) {
                r[i] = list.get(index);
                list.remove(index);
            } else {
                r[i] = -1;
            }
        }

        int index = 0;
        for (int i = 0; i < r.length; i++) {
            if(r[i] == -1) {
                r[i] = list.get(index++);
            }
        }

        return r;
    }

    private int findTargetIndex(List<Integer> list, int n) {
        int start = 0;
        int end = list.size() - 1;
        boolean find = false;
        while (start < end) {
            int middle = start + (end - start) / 2;
            Integer num = list.get(middle);
            if (num > n) {
                end = middle;
                find = true;
            } else {
                start = middle + 1;
            }
        }

        if(start == end) {
            if(list.get(end) > n) return end;
            return -1;
        }
        return find ? end : -1;
    }

    public static void main(String[] args) {
        //[12,24,8,32], B = [13,25,32,11]
//        new AdvantageCount_870().advantageCount(new int[]{12,24,8,32}, new int[]{13,25,32,11});
        new AdvantageCount_870().advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11});
    }
}
