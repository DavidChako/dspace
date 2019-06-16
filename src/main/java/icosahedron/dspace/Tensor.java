package icosahedron.dspace;

import icosahedron.dspace.pole.InsistUtil;

public final class Tensor {
    public final TensorType type;
    public final Tetray lhs;
    public final Tetray rhs;

    private final Tetray[] matrix;

    public Tensor(final TensorType type, final Tetray lhs, final Tetray rhs) {
        this.type = InsistUtil.insistNotNull(type, "Tensor type");
        this.lhs = InsistUtil.insistNotNull(lhs, "LHS tetray");
        this.rhs = InsistUtil.insistNotNull(lhs, "RHS tetray");
        this.matrix = type.computeMatrix(lhs, rhs);
    }
}
