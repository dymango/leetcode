package leetcodepractice.leetcode.base;

/**
 * @author dimmy
 */
public class StopWatch {
    private long start;

    public StopWatch() {
        reset();
    }

    public void reset() {
        start = System.currentTimeMillis();
    }

    public long elapsed() {
        long end = System.currentTimeMillis();
        return end - start;
    }
}
