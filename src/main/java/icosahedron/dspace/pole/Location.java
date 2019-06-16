package icosahedron.dspace.pole;

public final class Location extends Tetray<Long> {
    public Location(final long w, final long x, final long y, final long z) {
        super(w, x, y, z);
        InsistUtil.insistIsNotNegative(w);
        InsistUtil.insistIsNotNegative(x);
        InsistUtil.insistIsNotNegative(y);
        InsistUtil.insistIsNotNegative(z);
    }

    public Location(final Location location) {
        super(location);
    }

    public long stepCount() {
        return get(0) + get(1) + get(2) + get(3);
    }

    public void put(final int direction, final long value) {
        InsistUtil.insistIsNotNegative(value);
        super.put(direction, value);
    }
}
