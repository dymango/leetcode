package app.executor;

import app.leetcode.MinDominoRotations_1007;
import app.leetcode.NumPairsDivisibleBy60_1010;
import app.leetcode.bstFromPreorder_1008;


/**
 * @author dimmy
 */
public class Entrance {
    static Class<?> target = NumPairsDivisibleBy60_1010.class;

    public static void main(String[] args) {
        MainMethodExecutor mainMethodExecutor = new MainMethodExecutor();
        mainMethodExecutor.execute(target);
    }
}
