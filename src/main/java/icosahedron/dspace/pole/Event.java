package icosahedron.dspace.pole;

import static icosahedron.dspace.pole.Tetray.Direction;

public final class Event {
    private final Location location;
    private final Inertia inertia;

    public Event(final Location location, final Inertia inertia) {
        this.location = InsistUtil.insistNotNull(location, "location");
        this.inertia = InsistUtil.insistNotNull(inertia, "inertia");
    }

    public Event(final Event event) {
        this.location = new Location(event.location);
        this.inertia = new Inertia(event.inertia);
    }

    public long coordinate(final Direction direction) {
        return location.coordinate(direction);
    }

    public long weight(final Direction direction) {
        return inertia.weight(direction);
    }

    public boolean canMove(final Direction direction) {
        return inertia.canAccelerateAwayFrom(direction);
    }

    public void move(final Direction direction, final Direction inertiaTo) {
        location.move(direction);
        inertia.accelerate(direction, inertiaTo);
    }

    public long totalWeight() {
        return inertia.totalWeight();
    }
}
