package com.icosahedron.dyne;

public final class Location {
    private final Tetray coordinates;
    private final Counter tick;

    public Location(final long frequency, final Tetray coordinates) {
        this.coordinates = coordinates;
        this.tick = new Counter(coordinates.sum());
    }

    public long frequency() {
        return frequency.size();
    }

    public long tick() {
        return tick.count();
    }

    public long offset(final Direction direction) {
        return coordinates.count(direction);
    }

    public boolean move(final Direction direction) {
        return coordinates.increment(direction);
    }
}
