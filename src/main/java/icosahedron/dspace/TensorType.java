package icosahedron.dspace;

public enum TensorType {
    MOTION_POTENTIAL {
        public Tetray[] computeMatrix(final Tetray lhs, final Tetray rhs) {
            return new Tetray[] { rhs.scaleBy(lhs.w), rhs.scaleBy(lhs.x), rhs.scaleBy(lhs.y), rhs.scaleBy(lhs.z) };
        }
    },

    RADIAL_POTENTIAL {
        public Tetray[] computeMatrix(final Tetray lhs, final Tetray rhs) {
            return new Tetray[] { rhs.scaleBy(lhs.w), rhs.scaleBy(lhs.x), rhs.scaleBy(lhs.y), rhs.scaleBy(lhs.z) };
        }
    };


    protected abstract Tetray[] computeMatrix(final Tetray lhs, final Tetray rhs);
}
