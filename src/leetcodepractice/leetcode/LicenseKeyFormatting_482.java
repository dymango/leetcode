package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class LicenseKeyFormatting_482 {

    /**
     * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
     *
     * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
     *
     * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：S = "5F3Z-2e-9-w", K = 4
     * 输出："5F3Z-2E9W"
     * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
     *      注意，两个额外的破折号需要删掉。
     * 示例 2：
     *
     * 输入：S = "2-5g-3-J", K = 2
     * 输出："2-5G-3J"
     * 解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
     *  
     *
     * 提示:
     *
     * S 的长度可能很长，请按需分配大小。K 为正整数。
     * S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-'
     * S 非空
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/license-key-formatting
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static String licenseKeyFormatting(String S, int K) {
        String result = "";
        String str = "";
        for (int i = S.length() - 1; i >= 0 ; i--) {
            if(S.charAt(i) == '-') continue;
            str = S.charAt(i) + str;
            if(str.length() == K) {
                result = str.toUpperCase() + "-" + result;
                str = "";
            }
        }

        if(str.length() != 0) {
            result = str.toUpperCase() + "-" + result;
        }

        return result.length() > 0 ? result.substring(0, result.length() - 1) : result;
    }

    public static void main(String[] args) {
//        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
//        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(licenseKeyFormatting("---", 3));

    }

}
