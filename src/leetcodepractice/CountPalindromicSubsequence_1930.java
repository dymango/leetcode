package leetcodepractice;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dimmy
 */
public class CountPalindromicSubsequence_1930 {

    /**
     * 给你一个字符串 s ，返回 s 中 长度为 3 的不同回文子序列 的个数。
     * <p>
     * 即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。
     * <p>
     * 回文 是正着读和反着读一样的字符串。
     * <p>
     * 子序列 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。
     * <p>
     * 例如，"ace" 是 "abcde" 的一个子序列。
     *
     * @param s
     * @return
     */
    public int countPalindromicSubsequence(String s) {
        boolean[] visited = new boolean[200];
        var charArray = s.toCharArray();
        var sum = 0;
        for (int i = 0; i < charArray.length; i++) {
            var c = charArray[i];
            if (visited[c]) continue;
            visited[c] = true;
            for (int j = s.length() - 1; j >= 0; j--) {
                var end = charArray[j];
                if (c == end) {
                    Set<Character> set = new HashSet<>();
                    for (int k = i + 1; k <= j - 1; k++) {
                        set.add(charArray[k]);
                    }

                    sum += set.size();
                    break;
                }
            }
        }

        return sum;
    }
}
