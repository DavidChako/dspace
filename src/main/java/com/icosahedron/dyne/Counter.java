package com.icosahedron.dyne;

public final class Counter {
    private long count;

    public Counter() {
        this(0);
    }

    public Counter(final long count) {
        assert(count >= 0);
        this.count = count;
    }

    public long count() {
        return count;
    }

    public void reset() {
        count = 0;
    }

    public boolean increment() {
        if (count < Long.MAX_VALUE) {
            ++count;
            return true;
        }

        return false;
    }

    public boolean decrement() {
        if (count > 0) {
            --count;
            return true;
        }

        return false;
    }
}
