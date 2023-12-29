package app.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class largestTimeFromDigits_949 {

    /**
     * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
     * <p>
     * 24 小时格式为 "HH:MM" ，其中 HH 在 00 到 23 之间，MM 在 00 到 59 之间。最小的 24 小时制时间是 00:00 ，而最大的是 23:59 。从 00:00 （午夜）开始算起，过得越久，时间越大。
     * <p>
     * 以长度为 5 的字符串，按 "HH:MM" 格式返回答案。如果不能确定有效时间，则返回空字符串。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [1,2,3,4]
     * 输出："23:41"
     * 解释：有效的 24 小时制时间是 "12:34"，"12:43"，"13:24"，"13:42"，"14:23"，"14:32"，"21:34"，"21:43"，"23:14" 和 "23:41" 。这些时间中，"23:41" 是最大时间。
     * 示例 2：
     * <p>
     * 输入：arr = [5,5,5,5]
     * 输出：""
     * 解释：不存在有效的 24 小时制时间，因为 "55:55" 无效。
     * 示例 3：
     * <p>
     * 输入：arr = [0,0,0,0]
     * 输出："00:00"
     * 示例 4：
     * <p>
     * 输入：arr = [0,0,1,0]
     * 输出："10:00"
     *
     * @param arr
     * @return
     */

    public String largestTimeFromDigits(int[] arr) {
        Arrays.sort(arr);
        List<Integer> generate = generate(arr, new boolean[arr.length], 0, 0);
        if (generate.size() < 4) return "";
        return "" + generate.get(0) + generate.get(1) + ":" + generate.get(2) + generate.get(3);
    }

    private List<Integer> generate(int[] arr, boolean[] visited, int index, int pre) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (visited[i]) continue;
            if (index == 0) {
                if (arr[i] >= 0 && arr[i] <= 2) {
                    visited[i] = true;
                    List<Integer> generate = generate(arr, visited, index + 1, arr[i]);
                    if (!generate.isEmpty()) {
                        generate.add(0, arr[i]);
                        return generate;
                    }
                    visited[i] = false;
                }
            } else if (index == 1) {
                if ((pre == 1 || pre == 0) && arr[i] >= 0 && arr[i] <= 9 || pre == 2 && arr[i] >= 0 && arr[i] <= 3) {
                    visited[i] = true;
                    List<Integer> generate = generate(arr, visited, index + 1, arr[i]);
                    if (!generate.isEmpty()) {
                        generate.add(0, arr[i]);
                        return generate;
                    }
                    visited[i] = false;
                }
            } else if (index == 2) {
                if (arr[i] >= 0 && arr[i] <= 5) {
                    visited[i] = true;
                    List<Integer> generate = generate(arr, visited, index + 1, arr[i]);
                    if (!generate.isEmpty()) {
                        generate.add(0, arr[i]);
                        return generate;
                    }
                    visited[i] = false;
                }
            } else if (index == 3) {
                if (arr[i] >= 0 && arr[i] <= 9) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    return list;
                }
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println(new largestTimeFromDigits_949().largestTimeFromDigits(new int[]{1, 2, 3, 4}));
    }
}
