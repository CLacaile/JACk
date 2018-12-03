package model;

public class JACkModel {
    private Clock clock;

    public JACkModel() {
        clock = new Clock();
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }
}
