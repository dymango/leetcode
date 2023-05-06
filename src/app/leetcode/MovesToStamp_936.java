package app.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dimmy
 */
public class MovesToStamp_936 {

    /**
     * 你想要用小写字母组成一个目标字符串 target。 
     * <p>
     * 开始的时候，序列由 target.length 个 '?' 记号组成。而你有一个小写字母印章 stamp。
     * <p>
     * 在每个回合，你可以将印章放在序列上，并将序列中的每个字母替换为印章上的相应字母。你最多可以进行 10 * target.length  个回合。
     * <p>
     * 举个例子，如果初始序列为 "?????"，而你的印章 stamp 是 "abc"，那么在第一回合，你可以得到 "abc??"、"?abc?"、"??abc"。（请注意，印章必须完全包含在序列的边界内才能盖下去。）
     * <p>
     * 如果可以印出序列，那么返回一个数组，该数组由每个回合中被印下的最左边字母的索引组成。如果不能印出序列，就返回一个空数组。
     * <p>
     * 例如，如果序列是 "ababc"，印章是 "abc"，那么我们就可以返回与操作 "?????" -> "abc??" -> "ababc" 相对应的答案 [0, 2]；
     * <p>
     * 另外，如果可以印出序列，那么需要保证可以在 10 * target.length 个回合内完成。任何超过此数字的答案将不被接受。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：stamp = "abc", target = "ababc"
     * 输出：[0,2]
     * （[1,0,2] 以及其他一些可能的结果也将作为答案被接受）
     * 示例 2：
     * <p>
     * 输入：stamp = "abca", target = "aabcaca"
     * 输出：[3,0,1]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= stamp.length <= target.length <= 1000
     * stamp 和 target 只包含小写字母。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/stamping-the-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param stamp
     * @param target
     * @return
     */
    public static void main(String[] args) {
        new MovesToStamp_936().movesToStamp("abca", "aabcaca");
        new MovesToStamp_936().movesToStamp("abcd", "ababc");
        new MovesToStamp_936().movesToStamp("qxq", "qxqxqxqqxqxqqxqxqxqqxqxqqqxqqxqqqxqqxxqxqqxqqqxqqq");
    }

    int limit;
    List<Integer> finallySteps;

    public int[] movesToStamp(String stamp, String target) {
        finallySteps = new ArrayList<>();
        limit = target.length() * 10;
        preStr(stamp, target.toCharArray(), 0, new ArrayList<>(), 0);
        int[] stepArr = new int[finallySteps.size()];
        Collections.reverse(finallySteps);
        for (int i = 0; i < finallySteps.size(); i++) {
            stepArr[i] = finallySteps.get(i);
        }

        return stepArr;
    }

    private void preStr(String stamp, char[] targetCharArr, int tier, List<Integer> steps, int c) {
        if (!finallySteps.isEmpty()) return;
        if (tier > limit) return;
        if (c == targetCharArr.length) {
            finallySteps = new ArrayList<>(steps);
            return;
        }

        for (int i = 0; i < targetCharArr.length - stamp.length() + 1; i++) {
            boolean find = true;
            int count = 0;
            for (int j = 0; j < stamp.length(); j++) {
                if (targetCharArr[i + j] == '?') count++;
                if (targetCharArr[i + j] == '?' || targetCharArr[i + j] == stamp.charAt(j)) continue;
                find = false;
                break;
            }

            if (count == stamp.length()) find = false;
            if (find) {
                if(c <= i - 1) return;
                int tc = 0;
                char[] store = new char[stamp.length()];
                for (int j = i; j < i + stamp.length(); j++) {
                    store[j - i] = targetCharArr[j];
                    if (targetCharArr[j] != '?') tc++;
                    targetCharArr[j] = '?';
                }

                steps.add(i);
                preStr(stamp, targetCharArr, tier + 1, steps, c + tc);
                steps.remove(steps.size() - 1);
                System.arraycopy(store, 0, targetCharArr, i, i + stamp.length() - i);
            }
        }
    }
}
