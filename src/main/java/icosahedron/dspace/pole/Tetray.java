package icosahedron.dspace.pole;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Tetray<T> {
    private final List<T> components = new ArrayList<>(4);

    public Tetray(final T w, final T x, final T y, final T z) {
        InsistUtil.insistNotNull(w, "w");
        InsistUtil.insistNotNull(x, "x");
        InsistUtil.insistNotNull(y, "y");
        InsistUtil.insistNotNull(z, "z");
        this.components.add(w);
        this.components.add(x);
        this.components.add(y);
        this.components.add(z);
    }

    public Tetray(final Tetray<T> tetray) {
        this.components.addAll(tetray.components);
    }

    public final T get(final int direction) {
        insistIndexIsInBounds(direction);
        return components.get(direction);
    }

    public void put(final int direction, final T value) {
        insistIndexIsInBounds(direction);
        InsistUtil.insistNotNull(value, "value");
        components.set(direction, value);
    }

    public final String asString(final String leftBracket, final String rightBracket, final String separator) {
        return leftBracket + StringUtils.join(components, separator) + rightBracket;
    }

    @Override
    public final boolean equals(final Object other) {
        if (this == other) {
            return true;
        }

        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }

        final Tetray that = (Tetray) other;
        return this.components.equals(that.components);
    }

    @Override
    public final int hashCode() {
        return this.components.hashCode();
    }

    @Override
    public String toString() {
        return asString("(", ",", ")");
    }

    private void insistIndexIsInBounds(final int index) {
        if (index < 0 || index > 3) {
            throw new IndexOutOfBoundsException("Index is not in [0,3]: " + index);
        }
    }
}
