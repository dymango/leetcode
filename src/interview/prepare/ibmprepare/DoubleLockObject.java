package interview.prepare.ibmprepare;

/**
 * @author dimmy
 */
public class DoubleLockObject {
    private static DoubleLockObject o;

    public static DoubleLockObject getInstance() {
        if (o == null) {
            synchronized (DoubleLockObject.class) {
                if (o == null) {
                    o = new DoubleLockObject();
                }
            }
        }

        return o;
    }
}
