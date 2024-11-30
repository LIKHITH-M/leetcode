class Solution {
    public String longestPalindrome(String s) {
        String longest = "";

        // Function to expand around the center 
        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes centered at i
            String oddPalindrome = expandAroundCenter(s, i, i);
            // Check for even-length palindromes centered between i and i+1
            String evenPalindrome = expandAroundCenter(s, i, i + 1);

            // Update the longest palindrome found
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }
        return longest;
    }

    //method to expand around the given left and right indices
    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
