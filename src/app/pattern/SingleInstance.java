package app.pattern;

/**
 * @author dimmy
 */
public class SingleInstance {

    private SingleInstance() {
    }

    public static SingleInstance get() {
        return Holder.singleInstance;
    }

    public static class Holder {
        private static final SingleInstance singleInstance = new SingleInstance();
    }

    private void output() {
        System.out.println(1);
    }
}
