class Solution {
    public int longestPalindrome(String s) {
        int[] charCounts = new int[128];

        // Step 1: Count each character
        for (char c : s.toCharArray()) {
            charCounts[c]++;
        }

        int result = 0;
        boolean hasOdd = false;

        // Step 2: Calculate the longest palindrome length
        for (int charCount : charCounts) {
            result += (charCount & ~1); // Add the largest even part of the count
            if (charCount % 2 == 1) {
                hasOdd = true; // Track that there's at least one odd count
            }
        }

        // Step 3: If there’s any odd frequency, add 1 for the center character
        if (hasOdd) {
            result += 1;
        }

        return result;
    }
}
