package app.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 *
 * 给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，同时满足以下条件：
 *
 * ① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
 *
 * ② 如果存在多种答案，你只需实现并返回其中任意一种.
 *
 * 示例 1:
 *
 * 输入: n = 3, k = 1
 * 输出: [1, 2, 3]
 * 解释: [1, 2, 3] 包含 3 个范围在 1-3 的不同整数， 并且 [1, 1] 中有且仅有 1 个不同整数 : 1
 *  
 *
 * 示例 2:
 *
 * 输入: n = 3, k = 2
 * 输出: [1, 3, 2]
 * 解释: [1, 3, 2] 包含 3 个范围在 1-3 的不同整数， 并且 [2, 1] 中有且仅有 2 个不同整数: 1 和 2
 *  
 *
 * 提示:
 *
 *  n 和 k 满足条件 1 <= k < n <= 104.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/beautiful-arrangement-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructArray_667 {

    static int dif;
    static int num;
    static List<Integer> result;

    public static int[] constructArray(int n, int k) {
        dif = k;
        num = n;
        result = null;
        backTracking(new boolean[n + 1], new ArrayList<>(), new int[n + 1], 0);
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = result.get(i);
        }

        return r;
    }

    public static void backTracking(boolean[] marked, List<Integer> list, int[] difMarked, int c) {
        if (result != null) return;
        if (c > dif) return;
        if (list.size() == num) {
            if (c != dif) return;
            else {
                result = new ArrayList<>(list);
                return;
            }
        }

        for (int i = 1; i <= num; i++) {
            if (marked[i]) continue;
            marked[i] = true;
            int size = list.size();
            int curDif = Math.abs(i - (size != 0 ? list.get(list.size() - 1) : 0));
            if (size > 0) {
                difMarked[curDif]++;
                if (difMarked[curDif] == 1) c++;
            }

            list.add(i);
            backTracking(marked, list, difMarked, c);
            if (result != null) return;
            if (list.size() > 1) {
                difMarked[curDif]--;
                if (difMarked[curDif] == 0) c--;
            }

            list.remove(list.size() - 1);
            marked[i] = false;
        }
    }

    public static void main(String[] args) {
        constructArray(92, 80);
    }

    public int[] constructArrayV2(int n, int k) {
        int[] result = new int[n];
        result[0] = n;
        for (int i = k + 1, temp = n - k - 1; i < n; i++, temp--)
            result[i] = temp;
        for (int i = 1, flag = -1, temp = k; i < k + 1; i++) {
            result[i] = result[i - 1] + temp * flag;
            flag = -1 * flag;
            temp--;
        }
        return result;
    }

    public int[] constructArrayV3(int n, int k) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) res[i] = i + 1;  //产生1~n个数
        if (k == 1) return res;  //k==1直接返回
        //k != 1就要翻转k - 1次，每次翻转保留前m个数
        for (int m = 1; m < k; m++)
            reverse(res, m, n - 1);
        return res;
    }

    //翻转数组[i,j]之间的数
    void reverse(int[] res, int i, int j) {
        while (i < j) {
            int t = res[i];
            res[i] = res[j];
            res[j] = t;
            i++;
            j--;
        }
    }
}
