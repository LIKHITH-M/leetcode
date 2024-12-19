/*Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true

Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:
Input: n = 2
Output: false
 
Constraints:
1 <= n <= 231 - 1*/

import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        
        while (n != 1) {
            int current = n;
            int sum = 0;
            
            // Calculate the sum of the squares of digits
            while (current != 0) {
                int digit = current % 10;
                sum += digit * digit;
                current /= 10;
            }
            
            if (seen.contains(sum)) {
                return false; // Cycle detected
            }
            seen.add(sum);
            n = sum; // Update n to the new sum
        }
        
        return true; // Reached 1
    }
}
/* 
This code is efficient with time complexity O(logn) for summing the squares of the digits
 and space complexity O(logn) due to the HashSet. */