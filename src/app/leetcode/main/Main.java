package app.leetcode.main;

import app.leetcode.kmp.KMP;

/**
 * @author dimmy
 */
public class Main {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.match("cdeabcdeab", "abcde"));
        System.out.println(kmp.match("ceebbbbacddceebbbbacdd", "bbbacddceeb"));
    }
}
