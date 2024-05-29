package leetcodepractice.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class FindContinuousSequence_57 {

    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * <p>
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：target = 9
     * 输出：[[2,3,4],[4,5]]
     * 示例 2：
     * <p>
     * 输入：target = 15
     * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
     *  
     * <p>
     * 限制：
     * <p>
     * 1 <= target <= 10^5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        if(target == 0) return new int[0][0];
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int max = 0;
        int num = 1;
        int sum = 0;
        while (num <= target) {
            if (sum == target) {
                r.add(new ArrayList<>(list));
                max = Math.max(max, list.size());
                sum -= list.get(0);
                list.remove(0);
            } else if (sum > target) {
                sum -= list.get(0);
                list.remove(0);
            } else {
                sum += num;
                list.add(num);
                num++;
            }
        }

        int[][] ints = new int[r.size()][];
        for (int i = 0; i < r.size(); i++) {
            List<Integer> list1 = r.get(i);
            ints[i] = new int[list1.size()];
            for (int j = 0; j < list1.size(); j++) {
                ints[i][j] = list1.get(j);
            }
        }

        return ints;
    }
}
