//Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.

import java.util.Arrays;

class Solution {
  public int findGCD(int[] nums) {
        int n = Integer.MAX_VALUE;
        int m = 0;
        for(int i=0;i<nums.length;i++){ //APPROACH 2
            if(nums[i]<n)n = nums[i]; // APPROACH 2
            if(nums[i]>m)m = nums[i];// APPROACH 2
        }

        return gcd(n, m);

    }
    // Helper method to calculate GCD using the Euclidean algorithm
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
