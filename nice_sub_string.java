/*A string s is nice if, for every letter of the alphabet that s contains, it appears 
both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear.
 However, "abA" is not because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice. If there are multiple, 
return the substring of the earliest occurrence. If there are none, return an empty string.

Example 1:
Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.

Example 2:
Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.

Example 3:
Input: s = "c"
Output: ""
Explanation: There are no nice substrings.
 
Constraints:
1 <= s.length <= 100
s consists of uppercase and lowercase English letters*/

class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }
        
        // Convert the string to a set of characters
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        
        // Check for the split point
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(Character.toLowerCase(c)) || !set.contains(Character.toUpperCase(c))) {
                // Divide and Conquer: Split and recurse
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                // Return the longer of the two substrings
                return left.length() >= right.length() ? left : right;
            }
        }
        
        // If no split point was found, the entire string is nice
        return s;
    }
}

/* 
Explanation of Code
Set Construction:

Add all characters of the string into a Set. This allows easy checking of whether both cases of a character exist.
Split Point:

If a character c does not satisfy the "nice" condition, split the string into two substrings around c.
Recursive Calls:

Recursively process the left and right substrings to find the longest nice substring.
Base Case:

If the string's length is less than 2, return an empty string as it can't be nice.
Comparison:

Return the longer substring between the left and right parts.
Complexity
Time Complexity: 
𝑂(𝑛2) in the worst case due to multiple splits and substring operations.
Space Complexity: 
O(n) for the recursion stack.

Example Walkthrough
Input: "YazaAay"
First split occurs at 'z' (violates "nice" condition).
Left: "YazaA" -> split again.
Right: "ay" -> not nice.

Recursive calls on substrings find "aAa" as the longest nice substring.
Input: "Bb"
No violations, so the entire string is returned as "Bb".
Input: "c"
Single character, so return "".

This approach ensures correctness and leverages recursion efficiently.
*/