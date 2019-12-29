package icosahedron.dspace.pole;

import java.util.function.Function;

public enum Direction {
    W, X, Y, Z;

    private final Function<Tetray,Counter> counterExtractor;

    Direction() {
        this.counterExtractor = Tetray.counterExtractor(this);
    }

    public final Counter extractCounter(final Tetray tetray) {
        return counterExtractor.apply(tetray);
    }
}
