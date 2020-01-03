package com.icosahedron.dyne;

public final class Action<T> {
    private final Phase phase;
    private T pose = null;

    public Action(final long cycle, final long offset, final T pose) {
        this.phase = new Phase(cycle, offset);
        this.pose = pose;
    }

    public Action(final long cycle, final T pose) {
        this(cycle, 0, pose);
    }

    public Action(final long cycle) {
        this(cycle, 0, null);
    }

    public boolean isPending() {
        return phase.isZero();
    }

    public boolean isIndisposed() {
        return pose == null;
    }

    public void repose(final T pose) {
        this.pose = pose;
    }

    public void increment() {
        phase.increment();
    }
}
