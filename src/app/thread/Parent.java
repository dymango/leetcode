package app.thread;

import java.util.UUID;

/**
 * @author dimmy
 */
public class Parent {

    @Override
    public int hashCode() {
        return UUID.randomUUID().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() == obj.hashCode();
    }
}
