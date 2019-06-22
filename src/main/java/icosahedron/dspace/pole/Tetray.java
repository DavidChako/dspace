package icosahedron.dspace.pole;

public final class Tetray {
    public enum Direction { W, X, Y, Z;
        private long getOffset(final long[] offsets) {
            return offsets[ordinal()];
        }

        private void setOffset(final long[] offsets, final long offset) {
            offsets[ordinal()] = InsistUtil.insistIsNotNegative(offset);
        }

        private void incrementOffset(final long[] offsets) {
            offsets[ordinal()] += 1;
        }

        private void decrementOffset(final long[] offsets) {
            offsets[ordinal()] -= 1;
        }

        private boolean canDecrementOffset(final long[] offsets) {
            return offsets[ordinal()] != 0;
        }
    }

    private final long[] offsets = new long[4];

    public Tetray() {}

    public Tetray(final long w, final long x, final long y, final long z) {
        offsets[0] = InsistUtil.insistIsNotNegative(w);
        offsets[1] = InsistUtil.insistIsNotNegative(x);
        offsets[2] = InsistUtil.insistIsNotNegative(y);
        offsets[3] = InsistUtil.insistIsNotNegative(z);
    }

    public Tetray copy() {
        final Tetray tetray = new Tetray();
        tetray.offsets[0] = offsets[0];
        tetray.offsets[1] = offsets[1];
        tetray.offsets[2] = offsets[2];
        tetray.offsets[3] = offsets[3];
        return tetray;
    }

    public long get(final Direction direction) {
        return direction.getOffset(offsets);
    }

    public void set(final Direction direction, final long offset) {
        direction.setOffset(offsets, offset);
    }

    public void increment(final Direction direction) {
        direction.incrementOffset(offsets);
    }

    public void decrement(final Direction direction) {
        direction.decrementOffset(offsets);
    }

    public boolean canDecrement(final Direction direction) {
        return direction.canDecrementOffset(offsets);
    }

    public long totalOffset() {
        return offsets[0] + offsets[1] + offsets[2] + offsets[3];
    }
}
