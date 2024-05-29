package interview.prepare.ibmprepare;

/**
 * @author dimmy
 */
public class Lock {
    private int a = 1;

    private static class LockHolder {
        private static final Lock lock = new Lock();

    }

    public static Lock getInstance() {
        return LockHolder.lock;
    }
}

