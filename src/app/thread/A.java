package app.thread;

/**
 * @author dimmy
 */
public class A {
    private A()
    {

    }

    public static A getInstance() {
        return Holder.a;
    }

    private static class Holder {
        private static final A a = new A();
    }

    public int out() {
        return 1;
    }
}
