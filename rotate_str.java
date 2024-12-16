/*Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.
For example, if s = "abcde", then it will be "bcdea" after one shift.
 
Example 1:
Input: s = "abcde", goal = "cdeab"
Output: true

Example 2:
Input: s = "abcde", goal = "abced"
Output: false
 
Constraints:
1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.*/

class Solution {
    public boolean rotateString(String s, String goal) {
        // If lengths are not equal, s cannot be rotated to become goal
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Concatenate s with itself
        String doubledS = s + s;
        
        // Check if goal is a substring of the concatenated string
        return doubledS.contains(goal);
    }
}

// Notice that if you concatenate s with itself (i.e., "abcdeabcde"), any rotation of s would appear as a substring within this concatenated string.
