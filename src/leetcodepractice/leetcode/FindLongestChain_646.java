package leetcodepractice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dimmy
 */
public class FindLongestChain_646 {

    /**
     * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
     *
     * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
     *
     * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
     *
     *  
     *
     * 示例：
     *
     * 输入：[[1,2], [2,3], [3,4]]
     * 输出：2
     * 解释：最长的数对链是 [1,2] -> [3,4]
     *  
     *
     * 提示：
     *
     * 给出数对的个数在 [1, 1000] 范围内。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-pair-chain
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param pairs
     * @return
     */
    static Map<Integer, Integer> cache;
    public static int findLongestChain(int[][] pairs) {
        cache = new HashMap<>();
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        return dfs(pairs, 0, new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE});
    }

    public static int dfs(int[][] pairs, int index, int[] preSelect) {
        if(cache.containsKey(index)) return cache.get(index);
        int maxLength = 0;
        for (int i = index; i < pairs.length; i++) {
            int[] pair = pairs[i];
            if(pair[0] > preSelect[1]) {
                int t = i + 1;
                while(t < pairs.length && pairs[t][0] < pair[1]){
                    t++;
                }

                int l = dfs(pairs, t, pair);
                cache.put(t, l);
                maxLength = Math.max(1 + l, maxLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
//        System.out.println(findLongestChain(new int[][]{{1,2},{2,3},{3,4}}));
        System.out.println(findLongestChain(new int[][]{{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}}));
//        [[-6,9],[1,6],[8,10],[-1,4],[-6,-2],[-9,8],[-5,3],[0,3]]

//        System.out.println(findLongestChain(new int[][]{{1,2},{2,3},{3,4}}));

    }
}
