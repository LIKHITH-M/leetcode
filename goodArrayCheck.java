import java.util.*;

class Solution {
    public boolean isGoodArray(int[] nums) {
        // Start with the first element as the GCD
        int gcd = nums[0];
        
        // Compute the GCD of the array
        for (int num : nums) {
            gcd = gcd(gcd, num);
            // If at any point the GCD becomes 1, we can return true early
            if (gcd == 1) {
                return true;
            }
        }
        
        // If the final GCD is 1, the array is good
        return gcd == 1;
    }


    ////////
    
    // Helper function to compute GCD using Euclid's algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
