package icosahedron.dspace.pole;

public final class Event {
    private final Location location;
    private final Inertia inertia;

    public Event(final Location location, final Inertia inertia) {
        this.location = location;
        this.inertia = inertia;
    }

    public long tick() {
        return location.tick();
    }

    public long weight(final Direction direction) {
        return inertia.weight(direction);
    }

    public long mass() {
        return inertia.mass();
    }

    public void move(final Direction direction) {
        location.move(direction);
    }

    public void accelerate(final Acceleration acceleration) {
        inertia.accelerate(acceleration);
    }
}
