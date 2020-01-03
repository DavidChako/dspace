package com.icosahedron.dyne;

public final class Phase {
    private final long cycle;
    private final Counter offset = new Counter();

    public Phase(final long cycle, long offset) {
        assert(cycle > offset);
        this.cycle = cycle;
    }

    public Phase(final long cycle) {
        this(cycle, 0);
    }

    public boolean isZero() {
        return offset.count() == 0;
    }

    public void increment() {
        offset.increment();

        if (offset.count() == cycle) {
            offset.reset();
        }
    }
}
