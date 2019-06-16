package icosahedron.dspace.pole;

import icosahedron.dspace.Particle;

import java.util.Arrays;

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

    public static double insistIsNotNegative(final double candidate) {
        if (candidate < 0) {
            throw new IllegalArgumentException("candidate is negative: " + candidate);
        }

        return candidate;
    }

    public static boolean particlesHaveSameTiming(final Particle... particles) {
        if (particles == null || particles.length < 2) {
            return true;
        }

        for (int n = 0; n < particles.length-1; ++n) {
            if (particles[n].timing() != particles[n+1].timing()) {
                return false;
            }
        }

        return true;
    }

    public static void insistParticlesHaveSameTiming(final Particle ... particles) {
        if (!particlesHaveSameTiming(particles)) {
            throw new IllegalArgumentException("Particles do not have same timing: " + Arrays.asList(particles));
        }
    }

    public static boolean particlesHaveSameFrequency(final Particle ... particles) {
        if (particles == null || particles.length < 2) {
            return true;
        }

        for (int n = 0; n < particles.length-1; ++n) {
            if (particles[n].frequency() != particles[n+1].frequency()) {
                return false;
            }
        }

        return true;
    }

    public static void insistParticlesHaveSameFrequency(final Particle ... particles) {
        if (!particlesHaveSameFrequency(particles)) {
            throw new IllegalArgumentException("Particles do not have same frequency: " + Arrays.asList(particles));
        }
    }

    public static boolean particlesAreSynchronized(final Particle ... particles) {
        return particlesHaveSameTiming(particles) && particlesHaveSameFrequency(particles);
    }

    public static void insistParticlesAreSynchronized(final Particle ... particles) {
        insistParticlesHaveSameTiming(particles);
        insistParticlesHaveSameFrequency(particles);
    }
}
