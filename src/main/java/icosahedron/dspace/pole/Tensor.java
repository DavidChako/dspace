package icosahedron.dspace.pole;

public final class Tensor extends Tetray<Inertia> {
    public Tensor(final Inertia rowInertia, final Inertia columnInertia) {
        super(
                Inertia.scaled(columnInertia, rowInertia.get(0)),
                Inertia.scaled(columnInertia, rowInertia.get(1)),
                Inertia.scaled(columnInertia, rowInertia.get(2)),
                Inertia.scaled(columnInertia, rowInertia.get(3))
        );
    }

    @Override
    public String toString() {
        return asString("***\n", "\n***", "\n");
    }
}
