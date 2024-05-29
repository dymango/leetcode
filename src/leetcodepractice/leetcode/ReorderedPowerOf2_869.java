package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class ReorderedPowerOf2_869 {

    /**
     * 定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
     * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
     * <p>
     * 示例 1：
     * <p>
     * 输入：1
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：10
     * 输出：false
     * 示例 3：
     * <p>
     * 输入：16
     * 输出：true
     * 示例 4：
     * <p>
     * 输入：24
     * 输出：false
     * 示例 5：
     * <p>
     * 输入：46
     * 输出：true
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= N <= 10^9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reordered-power-of-2
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public boolean reorderedPowerOf2(int n) {
        if (n == 1) return true;
        String ns = String.valueOf(n);
        int[] sign = new int[10];
        for (char c : ns.toCharArray()) {
            sign[c - 48]++;
        }

        final int max = findMax(n);
        int number = 2;
        while (number <= max) {
            String numbers = String.valueOf(number);
            int[] numberArr = new int[10];
            for (char c : numbers.toCharArray()) {
                numberArr[c - 48]++;
            }

            boolean match = true;
            for (int i = 0; i < 10; i++) {
                if (sign[i] != numberArr[i]) {
                    match = false;
                    break;
                }
            }

            if (match) return true;
            number *= 2;
        }

        return false;
    }

    private int findMax(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int[] na = new int[10];
        for (char aChar : chars) {
            na[aChar - 48]++;
        }

        StringBuilder r = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < na[i]; j++) {
                r.append(i);
            }
        }

        return Integer.parseInt(r.toString());
    }

    public static void main(String[] args) {
//        System.out.println(new ReorderedPowerOf2_869().reorderedPowerOf2(1));
//        System.out.println(new ReorderedPowerOf2_869().reorderedPowerOf2(10));
//        System.out.println(new ReorderedPowerOf2_869().reorderedPowerOf2(16));
//        System.out.println(new ReorderedPowerOf2_869().reorderedPowerOf2(24));
        System.out.println(new ReorderedPowerOf2_869().reorderedPowerOf2(678092987));
    }

}
