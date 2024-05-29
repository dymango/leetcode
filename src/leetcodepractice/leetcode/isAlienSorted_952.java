package leetcodepractice.leetcode;

import java.util.Arrays;
import java.util.Objects;

public class isAlienSorted_952 {

    /**
     * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
     * <p>
     * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
     *
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArr = new int[26];
        for (int i = 0; i < 26; i++) {
            orderArr[order.charAt(i) - 97] = i;
        }

        String[] copy = new String[words.length];
        System.arraycopy(words, 0, copy, 0, words.length);
        Arrays.sort(copy, (o1, o2) -> {
            int index = 0;
            while (index < o1.length() && index < o2.length()) {
                if (orderArr[o1.charAt(index) - 97] < orderArr[o2.charAt(index) - 97]) return -1;
                else if (orderArr[o1.charAt(index) - 97] > orderArr[o2.charAt(index) - 97]) return 1;
                index++;
            }

            return o1.length() > o2.length() ? 1 : -1;
        });

        for (int i = 0; i < words.length; i++) {
            if (!Objects.equals(words[i], copy[i])) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        new isAlienSorted_952().isAlienSorted(new String[]{"mtkwpj","wlaees"}, "evhadxsqukcogztlnfjpiymbwr");
    }
}
