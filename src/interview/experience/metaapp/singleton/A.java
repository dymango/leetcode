package interview.experience.metaapp.singleton;

/**
 * @author dimmy
 */
public class A {
    private static volatile A a;

    public static A get() {
        if (a == null) {
            synchronized (A.class) {
                if (a == null) {
                    a = new A();
                }
            }
        }

        return a;
    }
}
