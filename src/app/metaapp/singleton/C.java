package app.metaapp.singleton;

/**
 * @author dimmy
 */
public enum C {
    INSTANCE;

    public String name = "name-c";

    public int out() {
        return 1;
    }

    public String getName() {
        return name;
    }
}
