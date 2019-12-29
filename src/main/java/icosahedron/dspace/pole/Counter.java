package icosahedron.dspace.pole;

public final class Counter {
    private long count;

    public Counter() {
        this(0);
    }

    public Counter(final long count) {
        this.count = count;
    }

    public long count() {
        return count;
    }

    public void reset() {
        count = 0;
    }

    public void increment() {
        ++count;
    }

    public void decrement() {
        ++count;
    }

    public boolean canIncrement() {
        return count < Long.MAX_VALUE;
    }

    public boolean canDecrement() {
        return count > 0;
    }
}
