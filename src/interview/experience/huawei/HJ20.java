package interview.experience.huawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author dimmy
 */
public class HJ20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> s = new HashSet<>();
        while (in.hasNext()) {
            String s1 = in.nextLine();
            if (s1.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            char[] chars = s1.toCharArray();
            int hasA = 0;
            int hasB = 0;
            int hasN = 0;
            int hasX = 0;
            for (char aChar : chars) {
                Integer integer = Integer.valueOf(aChar);
                if (65 <= integer && integer <= 90) {
                    hasA = 1;
                } else if (97 <= integer && integer <= 122) {
                    hasB = 1;
                } else if (48 <= integer && integer <= 57) {
                    hasN = 1;
                } else {
                    hasX = 1;
                }
            }

            if (hasA + hasB + hasN + hasX < 3) {
                System.out.println("NG");
                continue;
            }

            Map<String, Integer> map = new HashMap<>();
            boolean repeat = false;
            for (int i = 3; i < s1.length(); i++) {
                for (int j = 0; j < s1.length(); j++) {
                    if (j + i > s1.length()) continue;
                    String substring = s1.substring(j, j + i);
                    Integer merge = map.merge(substring, 1, Integer::sum);
                    if (merge > 1) {
                        repeat = true;
                    }
                }

                map.clear();
            }

            if (repeat) System.out.println("NG");
            else System.out.println("OK");
        }
    }

}
