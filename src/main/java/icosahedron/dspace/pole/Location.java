package icosahedron.dspace.pole;

import static icosahedron.dspace.pole.Tetray.Direction;

public final class Location {
    private final Tetray tetray;

    public Location (final long w, final long x, final long y, final long z) {
        this.tetray = new Tetray(w, x, y, z);
    }

    public Location(final Location location) {
        this.tetray = location.tetray.copy();
    }

    public long coordinate(final Direction direction) {
        return tetray.get(direction);
    }

    public void move(final Direction direction) {
        tetray.increment(direction);
    }

    public long displacement() {
        return tetray.totalOffset();
    }
}
