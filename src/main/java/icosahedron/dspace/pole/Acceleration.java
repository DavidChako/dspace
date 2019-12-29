package icosahedron.dspace.pole;

public class Acceleration {
    private final Direction from;
    private final Direction to;

    public Acceleration(final Direction from, final Direction to) {
        this.from = from;
        this.to = to;
    }

    public void applyTo(final Tetray weights) {
        weights.decrement(from);
        weights.increment(to);
    }
}
