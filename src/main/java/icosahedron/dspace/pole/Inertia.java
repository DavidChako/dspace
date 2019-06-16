package icosahedron.dspace.pole;

public final class Inertia extends Tetray<Double> {
    public Inertia(final double w, final double x, final double y, final double z) {
        super(
                InsistUtil.insistIsNotNegative(w),
                InsistUtil.insistIsNotNegative(x),
                InsistUtil.insistIsNotNegative(y),
                InsistUtil.insistIsNotNegative(z)
        );
    }

    public Inertia(final long w, final long x, final long y, final long z) {
        this((double)w, (double)x, (double)y, (double)z);
    }

    public Inertia(final Inertia inertia) {
        super(inertia);
    }

    public static Inertia scaled(final Inertia inertia, final double weight) {
        return new Inertia(weight*inertia.get(0), weight*inertia.get(1), weight*inertia.get(2), weight*inertia.get(3));
    }

    public void put(final int direction, final double value) {
        InsistUtil.insistIsNotNegative(value);
        super.put(direction, value);
    }
}
