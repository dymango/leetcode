package app.leetcode.tophundred;

/**
 * @author dimmy
 */
public class countAndSay_38 {

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String str = "1";
        for (int i = 2; i <= n; i++) {
            char[] charArray = str.toCharArray();
            StringBuilder newStr = new StringBuilder();
            int start = 0;
            int end = start;
            while (start < str.length()) {
                while (end < str.length() && charArray[end] == charArray[start]) end++;
                newStr.append((end - start)).append(charArray[start]);
                start = end;
            }

            str = newStr.toString();
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.println(new countAndSay_38().countAndSay(2));
        System.out.println(new countAndSay_38().countAndSay(3));
        System.out.println(new countAndSay_38().countAndSay(4));
    }

}
