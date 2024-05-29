package leetcodepractice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dimmy
 */
public class EquationsPossible_990 {

    /**
     * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
     * <p>
     * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
     * <p>
     * 示例 1：
     * <p>
     * 输入：["a==b","b!=a"]
     * 输出：false
     * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
     * 示例 2：
     * <p>
     * 输入：["b==a","a==b"]
     * 输出：true
     * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
     * 示例 3：
     * <p>
     * 输入：["a==b","b==c","a==c"]
     * 输出：true
     * 示例 4：
     * <p>
     * 输入：["a==b","b!=c","c==a"]
     * 输出：false
     * 示例 5：
     * <p>
     * 输入：["c==c","b==d","x!=z"]
     * 输出：true
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= equations.length <= 500
     * equations[i].length == 4
     * equations[i][0] 和 equations[i][3] 是小写字母
     * equations[i][1] 要么是 '='，要么是 '!'
     * equations[i][2] 是 '='
     *
     * @param equations
     * @return
     */

    public static void main(String[] args) {
        System.out.println(new EquationsPossible_990().equationsPossibleV2(new String[]{"b!=a", "a==e", "a!=f", "d==f", "a!=c"}));
        System.out.println(new EquationsPossible_990().equationsPossibleV2(new String[]{"a==b", "b!=a"}));
        System.out.println(new EquationsPossible_990().equationsPossibleV2(new String[]{"a==b","e==c","b==c","a!=e"}));
        System.out.println(new EquationsPossible_990().equationsPossibleV2(new String[]{"b!=f","c!=e","f==f","d==f","b==f","a==f"}));
    }

    public boolean equationsPossible(String[] equations) {
        Map<Character, List<Character>> map = new HashMap<>();
        for (String equation : equations) {
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            if (equation.contains("==")) {
                if (a == b) continue;
                if (a > b) {
                    map.putIfAbsent(a, new ArrayList<>());
                    map.get(a).add(b);
                } else {
                    map.putIfAbsent(b, new ArrayList<>());
                    map.get(b).add(a);
                }
            } else {
                if (a == b) return false;
            }
        }

        for (String equation : equations) {
            if (equation.contains("!=")) {
                char a = equation.charAt(0);
                char b = equation.charAt(3);
                if (!map.containsKey(a) && !map.containsKey(b)) continue;
                if (map.containsKey(a) && map.get(a).stream().noneMatch(character -> character == b)) return false;
                if (map.containsKey(b) && map.get(b).stream().noneMatch(character -> character == a)) return false;
                if (check(new HashSet<>(), map, a, b)) return false;
            }
        }

        return true;
    }

    private boolean check(Set<Character> set, Map<Character, List<Character>> map, char a, char b) {
        if (!set.add(a)) return false;
        List<Character> characters = map.get(a);
        if (characters.stream().anyMatch(character -> character == b)) return true;
        for (Character character : characters) {
            boolean check = check(set, map, character, b);
            if (check) return true;
        }

        set.remove(a);
        return false;
    }

    int[] carr;

    public boolean equationsPossibleV2(String[] equations) {
        carr = new int[26];
        for (int i = 0; i < 26; i++) {
            carr[i] = i;
        }

        for (String equation : equations) {
            if (equation.contains("==")) {
                int n = 'a';
                char a = equation.charAt(0);
                char b = equation.charAt(3);
                if(a <= b) {
                    combine(a - n, b - n);
                } else {
                    combine(b - n, a - n);
                }

            }
        }

        for (String equation : equations) {
            if (equation.contains("!=")) {
                int n = 'a';
                char a = equation.charAt(0);
                char b = equation.charAt(3);
                int root = findRoot(a - n);
                int root2 = findRoot(b - n);
                if (root == root2) return false;
            }
        }

        return true;
    }

    private int findRoot(int x) {
        if (carr[x] == x) return carr[x];
        return findRoot(carr[x]);
    }

    private void combine(int x, int y) {
        int root = findRoot(x);
        int root2 = findRoot(y);
        if (root == root2) return;
        carr[root] = root;
        carr[root2] = root;
    }
}
