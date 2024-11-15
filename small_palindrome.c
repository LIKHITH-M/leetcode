class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() == 0) return s; // Base case

        // Create the reversed string
        String reversed = new StringBuilder(s).reverse().toString();

        // Concatenate original string, a separator, and reversed string
        String combined = s + "#" + reversed;

        // Compute the LPS (Longest Prefix Suffix) array
        int[] lps = computeLPS(combined);

        // Length of the longest prefix that is also a suffix
        int prefixLength = lps[lps.length - 1];

        // Add the unmatched part of reversed string to the start of the original string
        String add = reversed.substring(0, reversed.length() - prefixLength);
        return add + s;
    }



    // Helper function to compute the LPS array for KMP algorithm

    private int[] computeLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int length = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
