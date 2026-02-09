package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class MinimumDeletions_1653 {

    /**
     * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
     * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
     * 请你返回使 s 平衡 的 最少 删除次数。
     *
     * @param s
     * @return AAAA    BBBBBBB
     * aaabaabaabbababaaa
     * bbaa
     */
    public int minimumDeletions(String s) {
        var charArray = s.toCharArray();
        int countA = 0;
        for (char c : charArray) {
            if (c == 'a') countA++;
        }

        if (countA == s.length() || countA == 0) return 0;
        int leftA = 0;
        int leftB = 0;
        int min = Integer.MAX_VALUE;
        for (char c : charArray) {
            if (c == 'a') {
                leftA++;
            } else {
                leftB++;
            }

            var removeCount = leftB + (countA - leftA);
            min = Math.min(min, removeCount);
        }

        min = Math.min(min, countA);
        min = Math.min(min, s.length() - countA);
        return min;
    }
}
