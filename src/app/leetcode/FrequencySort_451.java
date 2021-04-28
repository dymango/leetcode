package app.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dimmy
 */
public class FrequencySort_451 {

    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     *
     * 示例 1:
     *
     * 输入:
     * "tree"
     *
     * 输出:
     * "eert"
     *
     * 解释:
     * 'e'出现两次，'r'和't'都只出现一次。
     * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
     * 示例 2:
     *
     * 输入:
     * "cccaaa"
     *
     * 输出:
     * "cccaaa"
     *
     * 解释:
     * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
     * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
     * 示例 3:
     *
     * 输入:
     * "Aabb"
     *
     * 输出:
     * "bbAa"
     *
     * 解释:
     * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
     * 注意'A'和'a'被认为是两种不同的字符。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        int[] charArr = new int[256];
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            charArr[s.charAt(i)]++;
        }

        for (int i = 0; i < charArr.length; i++) {
            if(charArr[i] != 0) list.add(new Data((char)(i), charArr[i]));

        }

        Collections.sort(list, (o1, o2) -> o1.num > o2.num ? -1 : 1);

        StringBuilder sb = new StringBuilder();
        for (Data d : list) {
            for (int i = 0; i < d.num; i++) {
                sb.append(d.c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        frequencySort("eeeee");
    }

    public static class Data {
        public char c;
        public int num;

        public Data(char c, int n) {
            this.c = c;
            this.num = n;
        }

    }
}
