package leetcodepractice.leetcode;

/**
 * @author dimmy
 */
public class BackspaceCompare_844 {

    /**
     * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
     * 如果相等，返回 true ；否则，返回 false 。
     * 注意：如果对空文本输入退格字符，文本继续为空。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ab#c", t = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     * 示例 2：
     * <p>
     * 输入：s = "ab##", t = "c#d#"
     * 输出：true
     * 解释：s 和 t 都会变成 “”。
     * 示例 3：
     * <p>
     * 输入：s = "a##c", t = "#a#c"
     * 输出：true
     * 解释：s 和 t 都会变成 “c”。
     * 示例 4：
     * <p>
     * 输入：s = "a#c", t = "b"
     * 输出：false
     * 解释：s 会变成 “c”，但 t 仍然是 “b”。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length, t.length <= 200
     * s 和 t 只含有小写字母以及字符 '#'
     * <p>
     * <p>
     * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
     * <p>
     * "bxj##tw"
     * "bxo#j##tw"
     * <p>
     * "nzp#o#g"
     * "b#nzp#o#g"
     *
     * "c#a#c"
     * "c"
     */
    public static void main(String[] args) {
        BackspaceCompare_844 backspaceCompare_844 = new BackspaceCompare_844();
        System.out.println(backspaceCompare_844.backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare_844.backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare_844.backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare_844.backspaceCompare("a#c", "b"));
        System.out.println(backspaceCompare_844.backspaceCompare("bxj##tw", "bxo#j##tw"));
        System.out.println(backspaceCompare_844.backspaceCompare("nzp#o#g", "b#nzp#o#g"));
        System.out.println(backspaceCompare_844.backspaceCompare("c#a#c", "c"));
    }

    public boolean backspaceCompare(String s, String t) {
        int sp = s.length() - 1;
        int tp = t.length() - 1;
        while (sp >= 0 && tp >= 0) {
            sp = getNextPosition(s, sp);
            tp = getNextPosition(t, tp);
            if (sp >= 0 && tp >= 0) {
                if (s.charAt(sp) == t.charAt(tp)) {
                    sp--;
                    tp--;
                    continue;
                } else return false;
            }

            if (sp < 0 && tp < 0) return true;
            if (sp < 0 && tp >= 0) return false;
            if (tp < 0 && sp >= 0) return false;
        }

        if (sp < 0 && tp >= 0) {
            return getNextPosition(t, tp) == -1;
        }

        if (tp < 0 && sp >= 0) {
            return getNextPosition(s, sp) == -1;
        }


        return sp == tp;
    }

    private int getNextPosition(String str, int i) {
        if (str.charAt(i) != '#') return i;
        int index = i;
        int repeatCount = 0;
        while (true) {
            if (str.charAt(index) == '#') {
                repeatCount++;
            } else {
                repeatCount--;
            }

            index--;
            if (index < 0) break;
            if (repeatCount == 0 && str.charAt(index) != '#') break;
        }

        return index;
    }
}
