package icosahedron.dspace;

import icosahedron.dspace.pole.InsistUtil;

public final class Interaction {
    public final Particle a;
    public final Particle b;
    public final Tensor motionPotential;
    public final Tensor radialPotential;

    public Interaction(final Particle a, final Particle b) {
        this.a = InsistUtil.insistNotNull(a, "Particle a");
        this.b = InsistUtil.insistNotNull(a, "Particle b");
        InsistUtil.insistParticlesAreSynchronized(a, b);
        this.motionPotential = new Tensor(TensorType.RADIAL_POTENTIAL, a.inertia, b.inertia);
        this.radialPotential = new Tensor(TensorType.RADIAL_POTENTIAL, a.location, b.location);
    }
}
