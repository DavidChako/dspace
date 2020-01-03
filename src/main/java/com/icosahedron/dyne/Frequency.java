package com.icosahedron.dyne;

public final class Frequency {
    private long size;

    public Frequency(final long size) {
        assert(size > 1);
        this.size = size;
    }

    public long size() {
        return size;
    }
}
