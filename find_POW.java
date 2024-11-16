class Solution {
    public double myPow(double x, int n) {
        // Base case
        if (n == 0) return 1.0;

        long N = n; // Use long to handle edge case for Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x; // Take reciprocal
            N = -N;    // Make n positive
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        
        double half = fastPow(x, n / 2);
        
        // If n is even
        if (n % 2 == 0) return half * half;
        // If n is odd
        else return half * half * x;
    }
}
