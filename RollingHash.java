public class RollingHash {
    private static final int BASE = 256; // Base for character calculations (ASCII range)
    private static final int MOD = 101; // A prime number for modulus to reduce collisions

    // Function to calculate rolling hash
    public static int rollingHash(String str, int start, int len, int prevHash, int highestBasePower) {
        if (start == 0) {
            // Compute initial hash for the first window
            int hash = 0;
            for (int i = 0; i < len; i++) {
                hash = (hash * BASE + str.charAt(i)) % MOD;
            }
            return hash;
        }

        // Compute rolling hash for subsequent windows
        int hash = prevHash;
        // Subtract the contribution of the leftmost character
        hash = (hash + MOD - (str.charAt(start - 1) * highestBasePower) % MOD) % MOD;
        // Add the contribution of the new rightmost character
        hash = (hash * BASE + str.charAt(start + len - 1)) % MOD;

        return hash;
    }

    // Function to precompute the highest base power for the window size
    public static int computeHighestBasePower(int len) {
        int power = 1;
        for (int i = 1; i < len; i++) {
            power = (power * BASE) % MOD;
        }
        return power;
    }
}
