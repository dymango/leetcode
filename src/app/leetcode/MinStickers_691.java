package app.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimmy
 */
public class MinStickers_691 {

    /**
     * 我们给出了 N 种不同类型的贴纸。每个贴纸上都有一个小写的英文单词。
     * 你希望从自己的贴纸集合中裁剪单个字母并重新排列它们，从而拼写出给定的目标字符串 target。
     * 如果你愿意的话，你可以不止一次地使用每一张贴纸，而且每一张贴纸的数量都是无限的。
     * 拼出目标 target 所需的最小贴纸数量是多少？如果任务不可能，则返回 -1。
     * <p>
     * 规律：尽可能把一张贴纸上的英文字母利用
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * <p>
     * ["with", "example", "science"], "thehat"
     * 输出：
     * <p>
     * 3
     * 解释：
     * <p>
     * 我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
     * 把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
     * 此外，这是形成目标字符串所需的最小贴纸数量。
     * 示例 2：
     * <p>
     * 输入：
     * <p>
     * ["notice", "possible"], "basicbasic"
     * 输出：
     * <p>
     * -1
     * 解释：
     * <p>
     * 我们不能通过剪切给定贴纸的字母来形成目标“basicbasic”。
     *  
     * <p>
     * 提示：
     * <p>
     * stickers 长度范围是 [1, 50]。
     * stickers 由小写英文单词组成（不带撇号）。
     * target 的长度在 [1, 15] 范围内，由小写字母组成。
     * 在所有的测试案例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选取的，目标是两个随机单词的串联。
     * 时间限制可能比平时更具挑战性。预计 50 个贴纸的测试案例平均可在35ms内解决。
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/stickers-to-spell-word
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param stickers
     * @param target
     * @return
     */
    public static void main(String[] args) {
//        minStickers(new String[]{"with", "example", "science"}, "thehat");
//        minStickers(new String[]{"notice", "possible"}, "basicbasic");
        minStickers(new String[]{"control","heart","interest","stream","sentence","soil"
            , "wonder","them","month","slip","table","miss","boat","speak","figure","no"
            ,"perhaps","twenty","throw","rich","capital","save","method","store","meant"
            ,"life","oil","string","song","food","am","who","fat","if","put","path","come"
            ,"grow","box","great","word","object","stead","common","fresh","the","operate"
            ,"where","road","mean"}, "stoodcrease");
    }

    static int min = Integer.MAX_VALUE;
    public static int minStickers(String[] stickers, String target) {
        long st = System.currentTimeMillis();
        //["with", "example", "science"], "thehat"
        int[] targetCharCountArr = new int[26];
        for (char c : target.toCharArray()) {
            targetCharCountArr[c - 97]++;
        }

        List<int[]> charCountList = new ArrayList<>();
        int[] sum = new int[26];
        for (String sticker : stickers) {
            int[] charArr = new int[26];
            for (char c : sticker.toCharArray()) {
                charArr[c - 97]++;
                sum[c - 97]++;
            }

            charCountList.add(charArr);
        }

        for (int i = 0; i < 26; i++) {
            if(targetCharCountArr[i] != 0 && sum[i] == 0) return -1;
        }

        match(charCountList, targetCharCountArr, 0);
        System.out.println(System.currentTimeMillis() - st);
        System.out.println(min);
        return min;
    }

    private static void match(List<int[]> charCountList, int[] targetCharCountArr, int n) {
        if(check(targetCharCountArr)) {
            min = Math.min(n, min);
            return;
        }

        List<Integer> idxs = new ArrayList<>();
        int maxMatch = 0;
        for (int i = 0; i < charCountList.size(); i++) {
            int[] ints = charCountList.get(i);
            int t = 0;
            for (int j = 0; j < 26; j++) {
                if (targetCharCountArr[j] > 0 && ints[j] > 0) {
                    t += ints[j] >= targetCharCountArr[j] ? targetCharCountArr[j] : ints[j];
                }
            }

            if (t == maxMatch) idxs.add(i);
            else if(t > maxMatch) {
                idxs.clear();
                idxs.add(i);
                maxMatch = t;
            }
        }

        for (int i = 0; i < idxs.size(); i++) {
            int index = idxs.get(i);
            int[] ints = charCountList.get(index);
            int[] newTargetCharCountArr= new int[26];
            for (int j = 0; j < 26; j++) {
                newTargetCharCountArr[j] = targetCharCountArr[j] - (ints[j] >= targetCharCountArr[j] ? targetCharCountArr[j] : ints[j]);
            }

            match(charCountList, newTargetCharCountArr, n + 1);
        }
    }

    private static void matchV2(List<int[]> charCountList, int[] targetCharCountArr, int n) {
        if(n >= min) return;
        if(check(targetCharCountArr)) {
            min = Math.min(n, min);
            return;
        }

        for (int i = 0; i < charCountList.size(); i++) {
            int[] ints = charCountList.get(i);
            int[] newTargetCharCountArr= new int[26];
            for (int j = 0; j < 26; j++) {
                newTargetCharCountArr[j] = targetCharCountArr[j] - (ints[j] >= targetCharCountArr[j] ? targetCharCountArr[j] : ints[j]);
            }

            match(charCountList, newTargetCharCountArr, n + 1);
        }
    }

    private static boolean check(int[] targetCharCountArr){
        for (int i : targetCharCountArr) {
            if(i != 0) return false;
        }

        return true;
    }
}
