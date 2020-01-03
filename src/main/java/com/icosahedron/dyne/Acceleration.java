package com.icosahedron.dyne;

public class Acceleration {
    private final Direction from;
    private final Direction to;

    public Acceleration(final Direction from, final Direction to) {
        this.from = from;
        this.to = to;
    }

    public boolean applyTo(final Tetray inertia) {
        final boolean decrementedFrom = inertia.decrement(from);
        final boolean incrementedTo = inertia.increment(to);

        if (decrementedFrom && incrementedTo) {
            return true;
        }

        if (decrementedFrom) {
            inertia.increment(from);
        } else {
            inertia.decrement(to);
        }

        return false;
    }
}
