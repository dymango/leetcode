package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author dimmy
 */
public class LetterCasePermutation_784 {

    /**
     * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
     *
     * 示例：
     * 输入：S = "a1b2"
     * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
     *
     * 输入：S = "3z4"
     * 输出：["3z4", "3Z4"]
     *
     * 输入：S = "12345"
     * 输出：["12345"]
     *  
     *
     * 提示：
     *
     * S 的长度不超过12。
     * S 仅由数字和字母组成。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-case-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param S
     * @return
     */
    public static List<String> letterCasePermutation(String S) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);
        Set<String> set = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if(!set.add(poll)) continue;
                int index = 0;
                while (index < poll.length()) {
                    char c = poll.charAt(index);
                    if(c >= 97 && c <= 122) {
                        String newStr = poll.substring(0, index) + String.valueOf(c).toUpperCase() + poll.substring(index + 1);
                        queue.offer(newStr);
                    } else if(c >= 65 && c <= 90) {
                        String newStr = poll.substring(0, index) + String.valueOf(c).toLowerCase() + poll.substring(index + 1);
                        queue.offer(newStr);
                    }

                    index++;
                }
            }
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        letterCasePermutation("a1b2");
    }
}
