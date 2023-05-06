package app.timewheel;

import java.util.UUID;

/**
 * @author dimmy
 */
public class TaskImpl implements Task {
    public String id;
    public int round;
    public int position;
    public long executeTime;
    public Action action;

    public TaskImpl(int round, int position, long executeTime, Action action) {
        id = UUID.randomUUID().toString();
        this.round = round;
        this.position = position;
        this.executeTime = executeTime;
        this.action = action;
    }

    @Override
    public void execute() {
        action.execute();
    }

    @Override
    public int round() {
        return round;
    }

    @Override
    public int position() {
        return position;
    }

    @Override
    public String id() {
        return id;
    }
}
