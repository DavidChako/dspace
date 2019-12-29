package icosahedron.dspace.pole;

public final class Location {
    private final Tetray coordinates;

    public Location (final Tetray coordinates) {
        this.coordinates = coordinates;
    }

    public long get(final Direction direction) {
        return coordinates.get(direction);
    }

    public void move(final Direction direction) {
        coordinates.increment(direction);
    }

    public long tick() {
        return coordinates.sum();
    }
}
