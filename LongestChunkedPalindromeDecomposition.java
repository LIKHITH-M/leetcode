class Solution {
    public int longestDecomposition(String text) {
        int n = text.length();
        int left = 0, right = n - 1;
        int chunkCount = 0;
        String leftChunk = "", rightChunk = "";

        while (left <= right) {
            // Add characters to the current chunks
            leftChunk += text.charAt(left++);
            rightChunk = text.charAt(right--) + rightChunk;

            // If chunks match, count them and reset
            if (leftChunk.equals(rightChunk)) {
                chunkCount++;
                leftChunk = "";
                rightChunk = "";
            }
        }

        return chunkCount;
    }
}
