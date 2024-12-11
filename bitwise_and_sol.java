
/* Q) Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: left = 5, right = 7
Output: 4
Example 2:

Input: left = 0, right = 0
Output: 0
Example 3:

Input: left = 1, right = 2147483647
Output: 0
 
Constraints:
0 <= left <= right <= 231 - 1
*/

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0; // Counter for the number of shifts
        while (left < right) {
            // Shift both left and right one bit to the right
            left >>= 1;
            right >>= 1;
            shift++;
        }
        // Shift the common prefix back to its original position
        return left << shift;
    }
}
/* 
Example 2: left = 12, right = 15
Binary Representation:
12 in binary: 1100
13 in binary: 1101
14 in binary: 1110
15 in binary: 1111
Step-by-Step Process:
Compare left and right:
Bits differ at positions 1100 vs. 1111.
Perform right shift:
left = 12 >> 1 = 6 (110), right = 15 >> 1 = 7 (111).
Repeat the process:
Bits still differ:
left = 6 >> 1 = 3 (11), right = 7 >> 1 = 3 (11).
Now left == right, so the common prefix is 11 in binary.
Restore the result by left-shifting back:
3 << 2 = 12.
Final Answer:
The bitwise AND of numbers from 12 to 15 is 12.
*/