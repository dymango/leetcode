package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dimmy
 */
public class AtMostNGivenDigitSet_902 {
    /**
     * 给定一个按 非递减顺序 排列的数字数组 digits 。你可以用任意次数 digits[i] 来写的数字。例如，如果 digits = ['1','3','5']，我们可以写数字，如 '13', '551', 和 '1351315'。
     * 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。
     * <p>
     * 示例 1：
     * 输入：digits = ["1","3","5","7"], n = 100
     * 输出：20
     * 解释：
     * 可写出的 20 个数字是：
     * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
     * <p>
     * 示例 2：
     * 输入：digits = ["1","4","9"], n = 1000000000
     * 输出：29523
     * 解释：
     * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
     * 81 个四位数字，243 个五位数字，729 个六位数字，
     * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
     * 总共，可以使用D中的数字写出 29523 个整数。
     * <p>
     * 示例 3:
     * 输入：digits = ["7"], n = 8
     * 输出：1
     * <p>
     * 提示：
     * <p>
     * 1 <= digits.length <= 9
     * digits[i].length == 1
     * digits[i] 是从 '1' 到 '9' 的数
     * digits 中的所有值都 不同 
     * digits 按 非递减顺序 排列
     * 1 <= n <= 109
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/numbers-at-most-n-given-digit-set
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param digits
     * @param n
     * @return
     */
    public static class Node {
        int val;
        List<Node> sons;

        public Node(int val) {
            this.val = val;
            sons = new ArrayList<>();
        }
    }

    int N;
    int count = 0;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        Arrays.sort(digits);
        int[] nums = new int[digits.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(digits[i]);
        }
        N = n;

        for (int i = 0; i < nums.length; i++) {
            Node node = new Node(nums[i]);
            if (node.val <= N) count++;
            buildTree(node, nums, node.val);
        }

        return count;
    }

    private void buildTree(Node node, int[] nums, int total) {
        if (total > N) return;
        for (int num : nums) {
            Node n = new Node(num);
            int sum = total * 10 + num;
            if (sum <= N) count++;
            buildTree(n, nums, sum);
            node.sons.add(node);
        }
    }

    public static void main(String[] args) {
        new AtMostNGivenDigitSet_902().atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100);
    }
}
