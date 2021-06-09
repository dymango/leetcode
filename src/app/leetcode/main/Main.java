package app.leetcode.main;

import app.leetcode.BestRotation_798;
import app.leetcode.kmp.KMP;

/**
 * @author dimmy
 */
public class Main {
    public static void main(String[] args) {
        KMP kmp = new KMP();
//        System.out.println(kmp.match("cdeabcdeab", "abcde"));
//        System.out.println(kmp.match("ceebbbbacddceebbbbacdd", "bbbacddceeb"));
//        System.out.println(kmp.match("cdeabcdeab", "abcde"));

        BestRotation_798 bestRotation_798 = new BestRotation_798();
        System.out.println(bestRotation_798.bestRotation(new int[]{2, 3, 1, 4, 0}));
        System.out.println(bestRotation_798.bestRotation(new int[]{1, 3, 0, 2, 4}));
    }
}
