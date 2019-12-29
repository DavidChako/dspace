package icosahedron.dspace.pole;

public final class Disposition<T> {
    private T value;

    public Disposition() {
        this(null);
    }

    public Disposition(T disposition) {
        this.value = disposition;
    }

    public T get() {
        return value;
    }

    public void set(final T disposition) {
        this.value = disposition;
    }
}
