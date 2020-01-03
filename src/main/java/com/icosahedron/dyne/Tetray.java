package com.icosahedron.dyne;

public final class Tetray {
    private final Counter w;
    private final Counter x;
    private final Counter y;
    private final Counter z;
    private long sum;

    public Tetray(final long w, final long x, final long y, final long z) {
        this.w = new Counter(w);
        this.x = new Counter(x);
        this.y = new Counter(y);
        this.z = new Counter(z);
        this.sum = w + x + y + z;
    }

    public long sum() {
        return sum;
    }

    public long count(final Direction direction) {
        return counter(direction).count();
    }

    public boolean increment(final Direction direction) {
        if (counter(direction).increment()) {
            ++sum;
            return true;
        }

        return false;
    }

    public boolean decrement(final Direction direction) {
        if (counter(direction).decrement()) {
            --sum;
            return true;
        }

        return false;
    }

    private Counter counter(final Direction direction) {
        switch (direction) {
            case W: return w;
            case X: return x;
            case Y: return y;
            case Z: return z;
            default: return new Counter();
        }
    }
}
