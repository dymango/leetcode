package app.leetcode.tophundred;

/**
 * @author dimmy
 */
public class addBinary__67 {

    /**
     * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        int t = 0;
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < a.length() && index < b.length()) {
            char ac = a.charAt(a.length() - index - 1);
            char bc = b.charAt(b.length() - index - 1);
            if (ac == '0' && bc == '0') {
                if (t == 0) stringBuilder.insert(0, '0');
                else {
                    stringBuilder.insert(0, '1');
                    t = 0;
                }
            } else if (ac == '1' && bc == '1') {
                if (t == 0) {
                    stringBuilder.insert(0, '0');
                }
                else stringBuilder.insert(0, '1');
                t = 1;
            } else {
                if (t == 0) stringBuilder.insert(0, '1');
                else stringBuilder.insert(0, '0');
            }

            index++;
        }

        if (index < a.length()) {
            while (index < a.length()) {
                char ac = a.charAt(a.length() - index - 1);
                if (ac == '0') {
                    if (t == 0) stringBuilder.insert(0, '0');
                    else {
                        stringBuilder.insert(0, '1');
                        t = 0;
                    }
                } else {
                    if (t == 0) stringBuilder.insert(0, '1');
                    else {
                        stringBuilder.insert(0, '0');
                    }
                }

                index++;
            }
        }

        if (index < b.length()) {
            while (index < b.length()) {
                char ac = b.charAt(b.length() - index - 1);
                if (ac == '0') {
                    if (t == 0) stringBuilder.insert(0, '0');
                    else {
                        stringBuilder.insert(0, '1');
                        t = 0;
                    }
                } else {
                    if (t == 0) stringBuilder.insert(0, '1');
                    else {
                        stringBuilder.insert(0, '0');
                    }
                }

                index++;
            }
        }

        if(t == 1) stringBuilder.insert(0, '1');
        return stringBuilder.toString();
    }
}
