package app.leetcode.kmp;

/**
 * @author dimmy
 */
public class KMP {
    public int[] buildNextArr(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int[] next = new int[length];
        int i = 0, j = -1;
        next[0] = -1;
        while (i < length - 1) {
            if (j == -1 || chars[i] == chars[j]) {
                j++;
                i++;
                if (chars[i] != chars[j]) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                j = next[j];
            }
        }

        return next;
    }

    public boolean match(String s1, String s2) {
        int[] next = buildNextArr(s2);
        int s2Index = 0;
        for (char c : s1.toCharArray()) {
            while (s2.charAt(s2Index) != c) {
                    s2Index = next[s2Index];
            }
            if(++s2Index == s2.length()) return true;
        }

        return false;
    }
}
