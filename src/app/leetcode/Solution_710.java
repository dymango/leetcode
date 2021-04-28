package app.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author dimmy
 */
public class Solution_710 {

    /**
     * 给定一个包含 [0，n ) 中独特的整数的黑名单 B，写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。
     *
     * 对它进行优化使其尽量少调用系统方法 Math.random() 。
     *
     * 提示:
     *
     * 1 <= N <= 1000000000
     * 0 <= B.length < min(100000, N)
     * [0, N) 不包含 N，详细参见 interval notation 。
     * 示例 1:
     *
     * 输入:
     * ["Solution","pick","pick","pick"]
     * [[1,[]],[],[],[]]
     * 输出: [null,0,0,0]
     * 示例 2:
     *
     * 输入:
     * ["Solution","pick","pick","pick"]
     * [[2,[]],[],[],[]]
     * 输出: [null,1,1,1]
     * 示例 3:
     *
     * 输入:
     * ["Solution","pick","pick","pick"]
     * [[3,[1]],[],[],[]]
     * Output: [null,0,0,2]
     * 示例 4:
     *
     * 输入:
     * ["Solution","pick","pick","pick"]
     * [[4,[2]],[],[],[]]
     * 输出: [null,1,3,1]
     * 输入语法说明：
     *
     * 输入是两个列表：调用成员函数名和调用的参数。Solution的构造函数有两个参数，N 和黑名单 B。pick 没有参数，输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/random-pick-with-blacklist
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param N
     * @param blacklist
     */
    Map<Integer, Integer> map = new HashMap<>();
    Random r = new Random();
    int length;

    public Solution_710(int n, int[] b) {
        length = n - b.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        for (int i : b) {
            set.remove(i);
        }

        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < b.length; i++) {
            if(b[i] < length) map.put(b[i], iterator.next());
        }
    }

    public int pick() {
        int random = r.nextInt(length);
        return map.getOrDefault(random, random);
    }

    Map<Integer, Integer> m;
    int wlen;

    public void solutionV2(int n, int[] b) {
        m = new HashMap<>();
        r = new Random();
        wlen = n - b.length;
        Set<Integer> w = new HashSet<>();
        for (int i = wlen; i < n; i++) w.add(i);
        for (int x : b) w.remove(x);
        Iterator<Integer> wi = w.iterator();
        for (int x : b)
            if (x < wlen) m.put(x, wi.next());
    }

    public int pickV2() {
        int k = r.nextInt(wlen);
        return m.getOrDefault(k, k);
    }

    public static void main(String[] args) {
        Solution_710 solution_710 = new Solution_710(5, new int[]{3,4});
        while (true) {
            System.out.println(solution_710.pick());
        }
    }
}
