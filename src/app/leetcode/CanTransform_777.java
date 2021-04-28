package app.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author dimmy
 */
public class CanTransform_777 {

    /**
     * 在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回True。
     * <p>
     * 示例 :
     * <p>
     * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
     * 输出: True
     * 解释:
     * 我们可以通过以下几步将start转换成end:
     * RXXLRXRXL ->
     * XRXLRXRXL ->
     * XRLXRXRXL ->
     * XRLXXRRXL ->
     * XRLXXRRLX
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= len(start) = len(end) <= 10000。
     * start和end中的字符串仅限于'L', 'R'和'X'。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-adjacent-in-lr-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param
     * @param
     * @return
     */
    public static void main(String[] args) {
//        System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
//        System.out.println(c2("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(canTransform("RXXXLXXLXXRXXLXLXRXLXXRLXRLLXLLXXRXLLXLL", "XRLLXXXXRXLXXLRLRXLXRXXLXXLLXXXLXRLXLLLX"));
        System.out.println(c2("RXXXLXXLXXRXXLXLXRXLXXRLXRLLXLLXXRXLLXLL", "XRLLXXXXRXLXXLRLRXLXRXXLXXLLXXXLXRLXLLLX"));
    }

    static String globalEnd;
    static boolean find;
    static int wl = 2;

    public static boolean canTransform(String start, String end) {
        long s = System.currentTimeMillis();
        globalEnd = end;
        HashSet<String> set = new HashSet<>();
        dfs(start, set);
        System.out.println(System.currentTimeMillis() - s);
        return find;
    }

    public static boolean c2(String start, String end) {
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if(poll.equals(end)) {
                    return true;
                }
                int s = 0;
                while (s < poll.length() - wl + 1) {
                    if (poll.charAt(s) == 'X' && poll.charAt(s + 1) == 'L') {
                        String newStr = poll.substring(0, s) + "LX" + poll.substring(s + 2);
                        if(set.add(newStr)) {
                            queue.offer(newStr);
                        }
                    } else if (poll.charAt(s) == 'R' && poll.charAt(s + 1) == 'X') {
                        String newStr = poll.substring(0, s) + "XR" + poll.substring(s + 2);
                        if(set.add(newStr)) {
                            queue.offer(newStr);
                        }
                    }

                    s++;
                }
            }
        }
        return false;
    }

    public static void dfs(String str, Set<String> set) {
        if (find || set.contains(str)) return;
        if (str.equals(globalEnd)) {
            find = true;
            return;
        }

        set.add(str);
        int start = 0;
        while (start < str.length() - wl + 1) {
            if (str.charAt(start) == 'X' && str.charAt(start + 1) == 'L') {
                String newStr = str.substring(0, start) + "LX" + str.substring(start + 2);
                dfs(newStr, set);
            } else if (str.charAt(start) == 'R' && str.charAt(start + 1) == 'X') {
                String newStr = str.substring(0, start) + "XR" + str.substring(start + 2);
                dfs(newStr, set);
            }

            start++;
        }
    }
}
