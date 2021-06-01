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
        for (int k = 0; k < s1.length(); k++) {
            int i = k, j = 0;
            while (i < s1.length()) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                    if (j == -1) {
                        i++;
                        j = 0;
                    }
                }

                if (j >= s2.length()) return true;
            }
        }

        return false;
    }
}
