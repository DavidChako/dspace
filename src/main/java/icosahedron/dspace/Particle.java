package icosahedron.dspace;

import icosahedron.dspace.pole.InsistUtil;

public final class Particle {
    public final Tetray location;
    public final Tetray inertia;

    public Particle(final Tetray location, final Tetray inertia) {
        this.location = InsistUtil.insistNotNull(location, "Location");
        this.inertia = InsistUtil.insistNotNull(inertia, "Inertia");
    }

    public long timing() {
        return this.location.measure;
    }

    public long frequency() {
        return this.inertia.measure;
    }

    public long weight(final Direction direction) {
        return this.inertia.projection(direction);
    }

    public long weight(final int index) {
        return this.inertia.projection(index);
    }

    @Override
    public String toString() {
        return "Particle{" + "location=" + location + ", inertia=" + inertia + '}';
    }
}
