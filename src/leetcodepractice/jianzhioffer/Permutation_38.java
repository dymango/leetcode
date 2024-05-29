package leetcodepractice.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class Permutation_38 {

    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     *
     *
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     *
     *
     * 示例:
     *
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     *
     * 限制：
     *
     * 1 <= s 的长度 <= 8
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param
     * @return
     */
    public static void main(String[] args) {
        String[] abcs = new Permutation_38().permutation("abc");
        int i =1;
    }

    char[] chars;
    boolean[] visited;
    int length;
    List<String> result = new ArrayList<>();
    public String[] permutation(String s) {
        if(s.length() == 0) return new String[0];
        chars = s.toCharArray();
        length = s.length();
        visited = new boolean[chars.length];
        backtracking(0, new char[length],0);
        return result.stream().distinct().toArray(String[]::new);
    }

    private void backtracking(int start, char[] charArr, int l) {
        if(l == length) {
            result.add(new String(charArr));
            return;
        }
        for (int i = 0; i < length; i++) {
            if(!visited[i]) {
                charArr[l++] = chars[i];
                visited[i] = true;
                backtracking(i + 1, charArr, l);
                visited[i] = false;
                l--;
            }
        }
    }
}
