package app.jianzhioffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author dimmy
 */
public class TranslateNum_46 {

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    public static void main(String[] args) {
        System.out.println(new TranslateNum_46().translateNum(25));
//        System.out.println(new TranslateNum_46().translateNum(12258));
    }

    String[] map;
    int[] numArr;
    Set<String> set = new HashSet<>();

    public int translateNum(int num) {
        if (num < 10) return 1;
        map = new String[26];
        for (int i = 0; i < 26; i++) {
            map[i] = String.valueOf((char) ('a' + i));
        }

        int n = num;
        int length = String.valueOf(num).length();
        numArr = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            numArr[i] = n % 10;
            n /= 10;
        }

        find(new ArrayList<>(), 0, 1);
        find(new ArrayList<>(), 0, 2);
        return set.size();
    }

    private void find(List<String> strings, int index, int window) {
        if (index >= numArr.length) return;
        if (window == 1) {
            strings.add(map[numArr[index]]);
            int nextIndex = index + 1;
            if (index + window == numArr.length) {
                set.add(String.join("", strings));
            } else {
                find(strings, nextIndex, 1);
                find(strings, nextIndex, 2);
            }

            strings.remove(strings.size() - 1);
        } else {
            if (numArr[index] == 0 || index + window > numArr.length) return;
            int n = numArr[index] * 10 + numArr[index + 1];
            if (n > 25) return;
            strings.add(map[n]);
            if (index + window == numArr.length) {
                set.add(String.join("", strings));
            } else {
                find(strings, index + 2, 1);
                find(strings, index + 2, 2);
            }

            strings.remove(strings.size() - 1);
        }
    }
}
