package app.metaapp.singleton;

/**
 * @author dimmy
 */
public class B {
    private B() {

    }

    public static B getInstance() {
        return BHolder.b;
    }

    private static class BHolder {
        private static final B b = new B();
    }

    public int out() {
        return 1;
    }
}
