package icosahedron.dspace.pole;

import static icosahedron.dspace.pole.Tetray.Direction;

public final class Inertia {
    private final Tetray tetray;

    public Inertia(final long w, final long x, final long y, final long z) {
        this.tetray = new Tetray(w, x, y, z);
    }

    public Inertia(final Inertia inertia) {
        this.tetray = inertia.tetray.copy();
    }

    public long weight(final Direction direction) {
        return tetray.get(direction);
    }

    public boolean canAccelerateAwayFrom(final Direction direction) {
        return tetray.canDecrement(direction);
    }

    public void accelerate(final Direction awayFrom, final Direction towards) {
        tetray.decrement(awayFrom);
        tetray.increment(towards);
    }

    public long totalWeight() {
        return tetray.totalOffset();
    }
}