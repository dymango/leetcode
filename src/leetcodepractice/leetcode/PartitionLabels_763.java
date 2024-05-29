package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class PartitionLabels_763 {
    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
     * <p>
     * 示例：
     * <p>
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     *  
     * <p>
     * 提示：
     * <p>
     * S的长度在[1, 500]之间。
     * S只包含小写字母 'a' 到 'z' 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-labels
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * test case "qiejxqfnqceocmy"
     */
    static String originStr;
    static List<Integer> result = new ArrayList<>();
    public static List<Integer> partitionLabels(String S) {
        originStr = S;
        splitStr(S);
        return result;
    }

    private static void splitStr(String str) {
        int lastIndex = str.lastIndexOf(str.charAt(0));
        String tempString = str.substring(0, lastIndex + 1);
        boolean[] marked = new boolean[130];
        for (int i = 0; i < tempString.length(); i++) {
            char c = tempString.charAt(i);
            if(marked[c]) continue;
            marked[c] = true;
            int charIndex = str.lastIndexOf(c);
            if(charIndex > lastIndex) {
                lastIndex = charIndex;
                tempString = str.substring(0, lastIndex + 1);
            }
        }

        if(lastIndex == str.length() - 1) {
            result.add(str.length());
            return;
        }

        splitStr(str.substring(0, lastIndex + 1));
        splitStr(str.substring(lastIndex + 1));
    }

    public static void main(String[] args) {
//        partitionLabels("ababcbacadefegdehijhklij");
        partitionLabels("qiejxqfnqceocmy");
    }
}
