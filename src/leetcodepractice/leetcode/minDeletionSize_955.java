package leetcodepractice.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dimmy
 */
public class minDeletionSize_955 {

    /**
     * 给定由 n 个字符串组成的数组 strs，其中每个字符串长度相等。
     * <p>
     * 选取一个删除索引序列，对于 strs 中的每个字符串，删除对应每个索引处的字符。
     * <p>
     * 比如，有 strs = ["abcdef", "uvwxyz"]，删除索引序列 {0, 2, 3}，删除后 strs 为["bef", "vyz"]。
     * <p>
     * 假设，我们选择了一组删除索引 answer，那么在执行删除操作之后，最终得到的数组的元素是按 字典序（strs[0] <= strs[1] <= strs[2] ... <= strs[n - 1]）排列的，然后请你返回 answer.length 的最小可能值。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：strs = ["ca","bb","ac"]
     * 输出：1
     * 解释：
     * 删除第一列后，strs = ["a", "b", "c"]。
     * 现在 strs 中元素是按字典排列的 (即，strs[0] <= strs[1] <= strs[2])。
     * 我们至少需要进行 1 次删除，因为最初 strs 不是按字典序排列的，所以答案是 1。
     * 示例 2：
     * <p>
     * 输入：strs = ["xc","yb","za"]
     * 输出：0
     * 解释：
     * strs 的列已经是按字典序排列了，所以我们不需要删除任何东西。
     * 注意 strs 的行不需要按字典序排列。
     * 也就是说，strs[0][0] <= strs[0][1] <= ... 不一定成立。
     * 示例 3：
     * <p>
     * 输入：strs = ["zyx","wvu","tsr"]
     * 输出：3
     * 解释：
     * 我们必须删掉每一列。
     *
     * @param strs
     * @return
     */
    public int minDeletionSize(String[] strs) {
        int length = strs.length;
        String[] subStrArr = new String[length];
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            String[] copy = new String[strs.length];
            System.arraycopy(subStrArr, 0, copy, 0, subStrArr.length);
            for (int j = 0; j < copy.length; j++) {
                copy[j] = copy[j] + strs[j].charAt(i);
            }

            if (sort(copy)) {
                subStrArr = copy;
            } else {
                count++;
            }
        }

        return count;
    }

    private boolean sort(String[] copy) {
        for (int i = 1; i < copy.length; i++) {
            if (copy[i].compareTo(copy[i - 1]) < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        List<String> abcdef = new LinkedList<>();
        abcdef.add("abcdef");
        abcdef.add("uvwxyz");
        abcdef.sort(String::compareTo);
        int i = 1;

    }
}
