//sliding window solution
public int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int minLength = Integer.MAX_VALUE; // Initialize minimum length to a large value
    int sum = 0; // Tracks the sum of the current window
    int start = 0; // Start of the window

    for (int end = 0; end < n; end++) {
        sum += nums[end]; // Expand the window by including nums[end]

        // Shrink the window as long as the sum is >= target
        while (sum >= target) {
            minLength = Math.min(minLength, end - start + 1); // Update the minimum length
            sum -= nums[start]; // Exclude nums[start] from the window
            start++; // Move the start pointer forward
        }
    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength; // Return result
}
