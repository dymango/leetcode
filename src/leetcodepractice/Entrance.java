package leetcodepractice;

import leetcodepractice.executor.MainMethodExecutor;
import leetcodepractice.twohundred.canFinish207;
import leetcodepractice.twohundred.nthUglyNumber264;
import leetcodepractice.twohundred.threeSum15;


/**
 * @author dimmy
 */
public class Entrance {
    static Class<?> target = nthUglyNumber264.class;

    public static void main(String[] args) {
        MainMethodExecutor mainMethodExecutor = new MainMethodExecutor();
        mainMethodExecutor.execute(target);
    }
}
