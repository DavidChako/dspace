package icosahedron.dspace.pole;

public final class InsistUtil {
    private InsistUtil() {}

    public static boolean isNull(final Object candidate) {
        return candidate == null;
    }

    public static <T> T insistNotNull(final T candidate, final String label) {
        if (isNull(candidate)) {
            throw new IllegalArgumentException(label + " is null");
        }

        return candidate;
    }

    public static long insistIsNotZero(final long candidate) {
        if (candidate == 0) {
            throw new IllegalArgumentException("candidate is zero: " + candidate);
        }

        return candidate;
    }

    public static long insistIsPositive(final long candidate) {
        if (candidate <= 0) {
            throw new IllegalArgumentException("candidate is not positive: " + candidate);
        }

        return candidate;
    }

    public static long insistIsNotNegative(final long candidate) {
        if (candidate < 0) {
            throw new IllegalArgumentException("candidate is negative: " + candidate);
        }

        return candidate;
    }
}
