package com.icosahedron.dyne;

import com.icosahedron.dyne.Acceleration;
import com.icosahedron.dyne.Action;
import com.icosahedron.dyne.Direction;
import com.icosahedron.dyne.Tetray;

public final class Inertia {
    private final Tetray weights;
    private final Action<Direction> step;

    public Inertia(final Tetray weights) {
        this(new Action<>(weights.sum()), weights);
    }

    public Inertia(final Action<Direction> step, final Tetray weights) {
        this.step = step;
        this.weights = weights;
    }

    public long weight(final Direction direction) {
        return weights.get(direction);
    }

    public void accelerate(final Acceleration acceleration) {
        acceleration.applyTo(weights);
    }

    public long mass() {
        return weights.sum();
    }
}