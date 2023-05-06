package app.timewheel;

/**
 * @author dimmy
 */
public interface Task {
    void execute();

    int round();

    int position();

    String id();
}
