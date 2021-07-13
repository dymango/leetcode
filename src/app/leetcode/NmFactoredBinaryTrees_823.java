package app.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class NmFactoredBinaryTrees_823 {

    /**
     * 给出一个含有不重复整数元素的数组，每个整数均大于 1。
     * <p>
     * 我们用这些整数来构建二叉树，每个整数可以使用任意次数。
     * <p>
     * 其中：每个非叶结点的值应等于它的两个子结点的值的乘积。
     * <p>
     * 满足条件的二叉树一共有多少个？返回的结果应模除 10 ** 9 + 7。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: A = [2, 4]
     * 输出: 3
     * 解释: 我们可以得到这些二叉树: [2], [4], [4, 2, 2]
     * 示例 2:
     * <p>
     * 输入: A = [2, 4, 5, 10]
     * 输出: 7
     * 解释: 我们可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
     *  
     * <p>
     * 提示:
     * <p>
     * 1 <= A.length <= 1000.
     * 2 <= A[i] <= 10 ^ 9.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-trees-with-factors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public Set<Integer> sets = new HashSet<>();
    public int[] nodes;
    public Map<Integer, Long> cache = new HashMap<>();
    public int mod = 1000000007;

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        nodes = arr;
        for (int a : arr) {
            sets.add(a);
        }

        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            count += recursion(a, i);
            count %= mod;
        }

        return (int) count + arr.length;
    }

    private long recursion(int parentNode, int index) {
        if (cache.containsKey(parentNode)) return cache.get(parentNode);
        long count = 0;
        for (int i = 0; i <= index; i++) {
            int childNode = nodes[i];
            if (parentNode % childNode != 0) continue;
            int remainder = parentNode / childNode;
            if (sets.contains(remainder)) {
                count++;
                long leftNodeNum = recursion(childNode, i);
                long rightNodeNum = recursion(remainder, i);
                count += leftNodeNum + rightNodeNum + leftNodeNum * rightNodeNum;
                count %= mod;
            }
        }

        cache.put(parentNode, count);
        return count;
    }
}
