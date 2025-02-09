/*Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
  */

  /*Approach
Sort the array to make it easier to use a two-pointer technique.
Iterate through each element in the array (fixing one element at a time).
Use two pointers: One starting from the next element and one from the end.
Calculate the sum and update the closest sum if needed.
Adjust the pointers based on whether the sum is smaller or larger than the target.
 */

 import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);  // Step 1: Sort the array
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with the first three elements
        
        for (int i = 0; i < nums.length - 2; i++) {  // Step 2: Iterate over nums[i]
            int left = i + 1;  // Left pointer
            int right = nums.length - 1;  // Right pointer
            
            while (left < right) {  // Step 3: Two-pointer approach
                int sum = nums[i] + nums[left] + nums[right]; 
                
                // Step 4: Check if the current sum is closer to the target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                
                if (sum < target) {
                    left++;  // Move left pointer right to increase sum
                } else if (sum > target) {
                    right--;  // Move right pointer left to decrease sum
                } else {
                    return sum;  // Exact match found
                }
            }
        }
        
        return closestSum;
    }
}
/*Explanation
Sorting ensures that we can use two pointers effectively.
We initialize closestSum with the sum of the first three elements.
We iterate through the array and for each element, we:
Set two pointers (left and right).
Calculate the sum and update closestSum if it's closer to target.
Move the pointers accordingly.
The time complexity is O(n²) since we sort the array (O(n log n)) and use a nested loop (O(n²)).
 */