package app.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author dimmy
 */
public class HJ10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String next = in.next();
            Set<Integer> s = new HashSet<>();
            char[] chars = next.toCharArray();
            for (char aChar : chars) {
                s.add((int) aChar);
            }

            System.out.println(s.size());
        }

    }
}
