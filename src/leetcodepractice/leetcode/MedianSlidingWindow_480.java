package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dimmy
 */
public class MedianSlidingWindow_480 {

    /**
     * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
     *
     * 例如：
     *
     * [2,3,4]，中位数是 3
     * [2,3]，中位数是 (2 + 3) / 2 = 2.5
     * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
     *
     *  
     *
     * 示例：
     *
     * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
     *
     * 窗口位置                      中位数
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       1
     *  1 [3  -1  -3] 5  3  6  7      -1
     *  1  3 [-1  -3  5] 3  6  7      -1
     *  1  3  -1 [-3  5  3] 6  7       3
     *  1  3  -1  -3 [5  3  6] 7       5
     *  1  3  -1  -3  5 [3  6  7]      6
     *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
     *
     *  
     *
     * 提示：
     *
     * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
     * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sliding-window-median
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param k
     * @return
     */
    static List<Integer> sortList = new ArrayList<>();
    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] doubles = new double[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            doubles[i] = getCenterNum(nums, i, i + k, k);
        }

        return doubles;
    }

    public static double getCenterNum(int[] nums, int start, int end, int k) {
        if(start != 0) {
            List<Integer> list = new ArrayList<>();
            int remove =nums[start - 1];
            int newNum = nums[end - 1];
            boolean removeMark = false;
            boolean newNumMark = false;
            int i = 0;
            while(i < sortList.size()) {
                int num = sortList.get(i);
                if(num == remove && !removeMark)  {
                    removeMark = true;
                    i++;
                    continue;
                }

                if(newNum <= num && !newNumMark) {
                    list.add(newNum);
                    newNumMark = true;
                } else {
                    list.add(num);
                    i++;
                }
            }

            if(list.size() < sortList.size()) list.add(newNum);

            sortList = list;
            if(k%2 != 0) {
                return list.get(k/2);
            } else {
                double c = list.get(k/2);
                double c2 = list.get(k/2 - 1);
                return (c+c2)/2;
            }
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = start; i < end; i++) {
                list.add(nums[i]);
            }

            Collections.sort(list);
            sortList = list;
            if(k%2 != 0) {
                return list.get(k/2);
            } else {
                double c = list.get(k/2);
                double c2 = list.get(k/2 - 1);
                return (c+c2)/2;
            }
        }
    }

    public static void main(String[] args) {
//        medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        medianSlidingWindow(new int[]{1,4,2,3}, 4);
        medianSlidingWindow(new int[]{2147483647,2147483647}, 2);
        medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
}
