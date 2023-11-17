package app.leetcode.tophundred;

/**
 * @author dimmy
 */
public class myAtoi_8 {

    public int myAtoi(String s) {
        if (s.isEmpty()) return 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '-' || c == '+' || isNum(c)) {
                start = i;
                break;
            }
            if (!isNum(c)) return 0;
        }

        long result = 0;
        int tag = 0;
        if (s.charAt(start) == '-') tag = 1;
        if (s.charAt(start) == '+') tag = 2;
        int begin = tag != 0 ? start + 1 : start;
        for (int i = begin; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') break;
            if (!isNum(c)) break;
            long newR = 0;
            newR = result * 10 + (c - 48);
            long temp = tag == 1 ? -newR : newR;
            if (temp > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (temp < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            result = newR;
        }

        return (int) (tag == 1 ? -result : result);
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new myAtoi_8().myAtoi("21474836460"));
    }

    private boolean isNum(char c) {
        return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9';
    }
}
