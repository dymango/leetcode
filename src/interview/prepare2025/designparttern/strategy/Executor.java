package interview.prepare2025.designparttern.strategy;

/**
 * @author dimmy
 */
public class Executor {

    public void exec(Action action) {
        action.execute();
    }
}
