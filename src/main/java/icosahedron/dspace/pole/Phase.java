package icosahedron.dspace.pole;

public final class Phase {
    private final long cycle;
    private final Counter offset;

    public Phase(final long cycle, final long offset) {
        this.cycle = cycle;
        this.offset = new Counter(offset);
    }

    public boolean isMidCycle() {
        return offset.count() > 0;
    }

    public Phase increment() {
        offset.increment();

        if (offset.count() == cycle) {
            offset.reset();
        }

        return this;
    }
}
