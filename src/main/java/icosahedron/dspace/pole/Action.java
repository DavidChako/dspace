package icosahedron.dspace.pole;

public final class Action<T> {
    private final Disposition<T> disposition;
    private final Phase phase;

    public Action(final long cycle) {
        this(new Disposition<>(), cycle, 0);
    }

    public Action(final Disposition<T> disposition, final long cycle) {
        this(disposition, cycle, 0);
    }

    public Action(final Disposition<T> disposition, final long cycle, final long offset) {
        this.disposition = disposition;
        this.phase = new Phase(cycle, offset);
    }

    public boolean isMidCycle() {
        return phase.isMidCycle();
    }

    public Action<T> increment() {
        phase.increment();
        return this;
    }

    public void redispose(final T value) {
        this.disposition.set(value);
    }
}
