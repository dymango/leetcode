package app.leetcode;

import app.executor.MainMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class pancakeSort_969 {

    /**
     * 给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
     * <p>
     * 一次煎饼翻转的执行过程如下：
     * <p>
     * 选择一个整数 k ，1 <= k <= arr.length
     * 反转子数组 arr[0...k-1]（下标从 0 开始）
     * 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
     * <p>
     * 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断为正确。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[3,2,4,1]
     * 输出：[4,2,4,3]
     * 解释：
     * 4231
     * 1324
     * 3124
     * 2134
     * 1234
     * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
     * 初始状态 arr = [3, 2, 4, 1]
     * 第一次翻转后（k = 4）：arr = [1, 4, 2, 3]
     * 第二次翻转后（k = 2）：arr = [4, 1, 2, 3]
     * 第三次翻转后（k = 4）：arr = [3, 2, 1, 4]
     * 第四次翻转后（k = 3）：arr = [1, 2, 3, 4]，此时已完成排序。
     * 示例 2：
     * <p>
     * 输入：[1,2,3]
     * 输出：[]
     * 解释：
     * 输入已经排序，因此不需要翻转任何内容。
     * 请注意，其他可能的答案，如 [3，3] ，也将被判断为正确。
     *
     * @param arr
     * @return
     */
    @MainMethod
    public List<Integer> pancakeSort(int[] arr) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }

        List<Integer> result = new ArrayList<>();
        int targetNum = arr.length;
        while (targetNum > 0) {
            Integer i = indexMap.get(targetNum);
            if (i == targetNum - 1) {
                targetNum--;
                continue;
            }

            if(i == 0) {
                result.add(targetNum);
                reverse(arr, 0, targetNum - 1, indexMap);
                targetNum--;
                continue;
            }

            result.add(i + 1);
            reverse(arr, 0, i, indexMap);
            result.add(targetNum);
            reverse(arr, 0, targetNum - 1, indexMap);
            targetNum--;
        }

        return result;
    }

    private void reverse(int[] arr, int start, int end, Map<Integer, Integer> indexMap) {
        int s = start;
        int e = end;
        while (s < e) {
            int t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;
            indexMap.put(arr[s], s);
            indexMap.put(arr[e], e);
            s++;
            e--;
        }
    }
}
