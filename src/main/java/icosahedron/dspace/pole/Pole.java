package icosahedron.dspace.pole;

public final class Pole {
    private final Location anchorLocation = new Location(0, 0, 0, 0);
    private final Location extentLocation;
    private final Tensor tensor;
    private long radius;

    public Pole(final Location extentLocation, final Inertia anchorInertia, final Inertia extentInertia) {
        InsistUtil.insistNotNull(extentLocation, "extent location");
        InsistUtil.insistNotNull(anchorInertia, "anchor inertia");
        InsistUtil.insistNotNull(extentInertia, "extent inertia");
        this.extentLocation = new Location(extentLocation);
        this.tensor = new Tensor(anchorInertia, extentInertia);
        this.radius = extentLocation.stepCount();
    }

    public long getRadius() {
        return radius;
    }

    public void move(final double cumulativeProbability) {
        double sum = 0.0;

        for (int anchorDirection = 0; anchorDirection < 4; ++anchorDirection) {
            final Inertia rowInertia = tensor.get(anchorDirection);

            for (int extentDirection = 0; extentDirection < 4; ++extentDirection) {
                sum += rowInertia.get(extentDirection);

                if (sum >= cumulativeProbability) {
                    move(anchorDirection, extentDirection);
                    return;
                }
            }
        }

        throw new IllegalArgumentException(String.format("cumulative probability of %f is greater than sum of inertial weights: %f", cumulativeProbability, sum));
    }

    public void move(final int anchorDirection, final int extentDirection) {

    }
//
//    public double getWeight(final int anchorDirection, final int extentDirection) {
//        return tensor.get(anchorDirection).get(extentDirection);
//    }
//
//    public void putWeight(final int anchorDirection, final int extentDirection, final double weight) {
//        tensor.get(anchorDirection).put(extentDirection, weight);
//    }
//
//    public void scaleWeight(final int anchorDirection, final int extentDirection, final double weight) {
//        final Inertia rowInertia = tensor.get(anchorDirection);
//        final double scaledWeight = weight * rowInertia.get(extentDirection);
//        rowInertia.put(extentDirection, scaledWeight);
//    }
}
