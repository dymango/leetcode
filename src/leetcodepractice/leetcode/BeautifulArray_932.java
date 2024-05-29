package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class BeautifulArray_932 {

    /**
     * 如果长度为 n 的数组 nums 满足下述条件，则认为该数组是一个 漂亮数组 ：
     * nums 是由范围 [1, n] 的整数组成的一个排列。
     * 对于每个 0 <= i < j < n ，均不存在下标 k（i < k < j）使得 2 * nums[k] == nums[i] + nums[j] 。
     * 给你整数 n ，返回长度为 n 的任一 漂亮数组 。本题保证对于给定的 n 至少存在一个有效答案。
     * <p>
     *  
     * <p>
     * 示例 1 ：
     * <p>
     * 输入：n = 4
     * 输出：[2,1,4,3]
     * 示例 2 ：
     * <p>
     * 输入：n = 5
     * 输出：[3,1,2,5,4]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 1000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/beautiful-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static void main(String[] args) {
        new BeautifulArray_932().beautifulArray(5);
    }

    int N;
    boolean[] visited;
    boolean finish = false;
    List<Integer> result;

    public int[] beautifulArray(int n) {
        N = n;
        visited = new boolean[N + 1];
        backTracking(new ArrayList<>(), new HashMap<>());
        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }

        return r;
    }

    private void backTracking(List<Integer> list, Map<Integer, Integer> indexMap) {
        if (finish) return;
        if (list.size() == N) {
            finish = true;
            result = new ArrayList<>(list);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            list.add(i);
            visited[i] = true;
            int size = list.size();
            indexMap.put(i, size - 1);
            if (size >= 3) {
                boolean check = true;
                tag:
                for (int j = size - 1; j >= 2; j--) {
                    for (int k = j - 1; k >= 0; k--) {
                        Integer jv = list.get(j);
                        Integer jk = list.get(k);
                        int target = jk * 2;
                        int find = target - jv;
                        Integer index = indexMap.get(find);
                        if (index == null || index >= k) continue;
                        check = false;
                        break tag;
                    }
                }

                if (check) {
                    backTracking(list, indexMap);
                }
            } else {
                backTracking(list, indexMap);
            }

            list.remove(size - 1);
            visited[i] = false;
            indexMap.remove(i);
        }
    }
}
