class Solution {
    public boolean hasAllCodes(String s, int k) {
        // Step 1: Calculate the total number of binary codes of length k
        int totalCodes = 1 << k; // 2^k
        
        // Step 2: Use a HashSet to store unique substrings of length k
        HashSet<String> seen = new HashSet<>();
        
        // Step 3: Loop through the string with a sliding window of size k
        for (int i = 0; i <= s.length() - k; i++) {
            String substring = s.substring(i, i + k); // Extract substring of length k
            seen.add(substring);
            
            // If we've seen all possible codes, return true early
            if (seen.size() == totalCodes) {
                return true;
            }
        }
        
        // Step 4: Check if we've found all codes
        return seen.size() == totalCodes;
    }
}
