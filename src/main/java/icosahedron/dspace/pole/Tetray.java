package icosahedron.dspace.pole;

import java.util.function.Function;

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

    public final long get(final Direction direction) {
        return counter(direction).count();
    }

    public final void increment(final Direction direction) {
        counter(direction).increment();
        ++sum;
    }

    public final void decrement(final Direction direction) {
        counter(direction).decrement();
        --sum;
    }

    public long sum() {
        return sum;
    }

    public static Function<Tetray,Counter> counterExtractor(final Direction direction) {
        switch (direction) {
            case W: return tetray -> tetray.w;
            case X: return tetray -> tetray.x;
            case Y: return tetray -> tetray.y;
            case Z: return tetray -> tetray.z;
            default: throw new IllegalArgumentException("Direction not supported: " + direction);
        }
    }

    private Counter counter(final Direction direction) {
        return direction.extractCounter(this);
    }
}
