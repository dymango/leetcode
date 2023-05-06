package app.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author dimmy
 */
public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> s = new HashSet<>();
        while (in.hasNextInt()) {
            int n = in.nextInt();

            for (int i = 0; i < n; i++) {
                s.add(in.nextInt());
            }
        }

        s.stream().sorted(Integer::compare).forEach(System.out::println);
    }
}
