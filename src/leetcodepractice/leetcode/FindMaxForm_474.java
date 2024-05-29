package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class FindMaxForm_474 {

    /**
     * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     *
     * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
     *
     * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
     * 输出：4
     * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
     * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
     * 示例 2：
     *
     * 输入：strs = ["10", "0", "1"], m = 1, n = 1
     * 输出：2
     * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ones-and-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param strs
     * @param m
     * @param n
     * @return
     */
    static boolean[] marked;
    static int zeroMax;
    static int oneMax;
    static int maxLength = 0;
    static int[][] numCount;
    public static int findMaxForm(String[] strs, int m, int n) {
        long l;
        System.out.println(l = System.currentTimeMillis());
        zeroMax = m;
        oneMax = n;
        marked = new boolean[strs.length];
        numCount = new int[strs.length][2];
        int zc = 0;
        int oc = 0;
        for (int i = 0; i < strs.length; i++) {
            numCount[i][1] = countOneNumber(strs[i]);
            numCount[i][0] = strs[i].length() - numCount[i][1];
            oc += numCount[i][1];
            zc += numCount[i][0];
        }

        if(oc <= n && zc <=m) return strs.length;
        dfs(strs, 0, 0, 0, 0);
        System.out.println(System.currentTimeMillis() - l);
        return maxLength;
    }


    public static void dfs(String[] strs, int oneNum, int zeroNum, int count, int index) {
        if(oneNum > oneMax || zeroNum > zeroMax) {
            maxLength = Math.max(maxLength, count - 1);
            return;
        } else if(oneNum == oneMax && zeroNum == zeroMax) {
            maxLength = Math.max(maxLength, count);
            return;
        } else if(count >= strs.length) {
            maxLength = strs.length;
            return;
        } else if(index >= strs.length) {
            maxLength = Math.max(maxLength, count);
            return;
        }

        for (int i = index; i < strs.length; i++) {
            if(marked[i]) continue;
            marked[i] = true;
            int on = numCount[i][1];
            int zn = numCount[i][0];
            dfs(strs, oneNum + on, zeroNum + zn, count + 1, i + 1);
            marked[i] = false;
        }
    }

    public static int countOneNumber(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') count++;
        }

        return count;
    }

    public static void main(String[] args) {
//        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
//        System.out.println(findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
//        System.out.println(findMaxForm(new String[]{"0", "0", "1", "1"}, 2, 2));
//        System.out.println(findMaxForm(new String[]{"10","0001","111001","1","0"}, 50, 50));
//        System.out.println(findMaxForm(new String[]{"0","1101","01","00111","1","10010","0","0","00","1","11","0011"}, 63, 36));
//        System.out.println(findMaxForm(new String[]{"00","000"}, 1, 10));
        System.out.println(findMaxForm(new String[]{"011","1","11","0","010","1","10","1","1","0","0","0","01111","011","11","00","11","10","1","0","0","0","0","101","001110","1","0","1","0","0","10","00100","0","10","1","1","1","011","11","11","10","10","0000","01","1","10","0"},
                44, 39));
//        System.out.println(findMaxForm(new String[]{"0","11","1000","01","0","101","1","1","1","0","0","0","0","1","0z","0110101","0","11","01","00","01111","0011","1","1000","0","11101","1","0","10","0111"}, 9, 80));
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String s: strs) {
            int[] count = countzeroesones(s);
            for (int zeroes = m; zeroes >= count[0]; zeroes--)
                for (int ones = n; ones >= count[1]; ones--)
                    dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
        }
        return dp[m][n];
    }
    public int[] countzeroesones(String s) {
        int[] c = new int[2];
        for (int i = 0; i < s.length(); i++) {
            c[s.charAt(i)-'0']++;
        }
        return c;
    }
}
