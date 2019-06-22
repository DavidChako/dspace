package icosahedron.dspace.pole;

import java.util.concurrent.ThreadLocalRandom;

import static icosahedron.dspace.pole.Tetray.Direction;

public final class Pole {
    private final Event event0;
    private final Event event1;

    public Pole(final Event event0, final Event event1) {
        InsistUtil.insistNotNull(event0, "event0");
        InsistUtil.insistNotNull(event1, "event1");
        this.event0 = new Event(event0);
        this.event1 = new Event(event1);
    }

    public boolean canMove(final Direction direction0, final Direction direction1) {
        return event0.canMove(direction0) && event1.canMove(direction1);
    }

    public void move(final Direction direction0, final Direction direction1) {
        event0.move(direction0, direction1);
        event1.move(direction1, direction0);
    }

    public final class Change {
        private final Direction direction0;
        private final Direction direction1;

        public Change(final Direction direction0, final Direction direction1) {
            this.direction0 = direction0;
            this.direction1 = direction1;
        }
    }

    public boolean canMove(final Change change) {
        return canMove(change.direction0, change.direction1);
    }

    public void move(final Change change) {
        move(change.direction0, change.direction1);
    }

    public boolean pickAndExecuteMove() {
        final long bound = event0.totalWeight() * event1.totalWeight();
        final long discriminant = ThreadLocalRandom.current().nextLong(bound);
        final Change change = chooseChange(discriminant);

        if (!canMove(change)) {
            return false;
        }

        move(change);
        return true;
    }

    public Change chooseChange(long discriminant) {
        for (final Direction direction0 : Direction.values()) {
            for (final Direction direction1 : Direction.values()) {
                discriminant -= event0.weight(direction0) * event1.weight(direction1);

                if (discriminant <= 0) {
                    return new Change(direction0, direction1);
                }
            }
        }

        throw new IllegalArgumentException("Discriminant is too large: " + discriminant);
    }

}
