package leetcodepractice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author dimmy
 */
public class KSimilarity_854 {

    /**
     * 如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
     * 给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。
     * <p>
     * 示例 1：
     * 输入：A = "ab", B = "ba"
     * 输出：1
     * 示例 2：
     * 输入：A = "abc", B = "bca"
     * 输出：2
     * 示例 3：
     * <p>
     * 输入：A = "abac", B = "baca"
     * 输出：2
     * 示例 4：
     * <p>
     * 输入：A = "aabc", B = "abca"
     * 输出：2
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= A.length == B.length <= 20
     * A 和 B 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/k-similar-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s1
     * @param s2
     * @return
     */
    public static void main(String[] args) {
        KSimilarity_854 kSimilarity_854 = new KSimilarity_854();
        System.out.println(kSimilarity_854.kSimilarity("abac", "baca"));
    }

    public int kSimilarity(String s1, String s2) {
        if (s1.equals(s2)) return 0;
        Queue<char[]> queue = new LinkedList<>();
        char[] chars = s1.toCharArray();
        queue.offer(chars);
        int count = 0;
        Set<String> visited = new HashSet<>();
        visited.add(s1);
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] poll = queue.poll();
                for (int j = 0; j < poll.length; j++) {
                    for (int k = j + 1; k < poll.length; k++) {
                        char[] newC = new char[poll.length];
                        for (int l = 0; l < newC.length; l++) {
                            if (l == j) newC[l] = poll[k];
                            else if (l == k) newC[l] = poll[j];
                            else newC[l] = poll[l];
                        }

                        String cs = String.valueOf(newC);
                        boolean match = cs.equals(s2);
                        if (match) return count;
                        if (visited.add(cs)) queue.add(newC);
                    }
                }
            }
        }

        return -1;
    }

    public int kSimilarity2(String A, String B) {
        Queue<String> queue = new ArrayDeque();
        queue.offer(A);

        Map<String, Integer> dist = new HashMap();
        dist.put(A, 0);

        while (!queue.isEmpty()) {
            String S = queue.poll();
            if (S.equals(B)) return dist.get(S);
            for (String T: neighbors(S, B)) {
                if (!dist.containsKey(T)) {
                    dist.put(T, dist.get(S) + 1);
                    queue.offer(T);
                }
            }
        }

        throw null;
    }

    public List<String> neighbors(String S, String target) {
        List<String> ans = new ArrayList();
        int i = 0;
        for (; i < S.length(); ++i) {
            if (S.charAt(i) != target.charAt(i)) break;
        }

        char[] T = S.toCharArray();
        for (int j = i+1; j < S.length(); ++j)
            if (S.charAt(j) == target.charAt(i)) {
                swap(T, i, j);
                ans.add(new String(T));
                swap(T, i, j);
            }

        return ans;
    }

    public void swap(char[] T, int i, int j) {
        char tmp = T[i];
        T[i] = T[j];
        T[j] = tmp;
    }
}
