package app.leetcode.main;

import app.leetcode.LargestIsland_827;
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

//        BestRotation_798 bestRotation_798 = new BestRotation_798();
//        System.out.println(bestRotation_798.bestRotation(new int[]{2, 3, 1, 4, 0}));
//        System.out.println(bestRotation_798.bestRotation(new int[]{1, 3, 0, 2, 4}));

//        NmFactoredBinaryTrees_823 nmFactoredBinaryTrees_823 = new NmFactoredBinaryTrees_823();
//        System.out.println(nmFactoredBinaryTrees_823.numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
//        System.out.println(nmFactoredBinaryTrees_823.numFactoredBinaryTrees(new int[]{2, 4}));

        LargestIsland_827 l = new LargestIsland_827();
//        System.out.println(l.largestIsland(new int[][]{{1, 0}, {0, 1}}));
        System.out.println(l.largestIsland(new int[][]{{1, 0, 1, 0, 1},
            {0, 1, 1, 0, 1},
            {1, 1, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {0, 0, 1, 1, 0}}));
    }
}
