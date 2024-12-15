/* Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 
Follow-up: Could you solve the problem in linear time and in O(1) space?*/

class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        // Step 1: Find the candidate for the majority element
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Step 2: Since the problem guarantees a majority element, return the candidate
        return candidate;
    }

}

// 1. brute force  2.sorting  3.hash table  4.moore's voting.

/*
Explanation:
Step 1: Finding the candidate:

Iterate through the array and maintain a count variable.
When count is zero, update the candidate to the current number.
Increment count if the current number equals the candidate, otherwise decrement it.
The idea is that the majority element will dominate the count.

Step 2: Return the candidate:

Since the problem guarantees a majority element, the candidate obtained from the first step will be the majority element.
Example Walkthrough:
Example 1: nums = [3, 2, 3]
Start with candidate = 3 and count = 0.
Process:
3: count = 1 (matches candidate)
2: count = 0 (does not match candidate)
3: count = 1 (matches candidate)
Final candidate = 3.
Example 2: nums = [2, 2, 1, 1, 1, 2, 2]
Start with candidate = 2 and count = 0.
Process:
2: count = 1 (matches candidate)
2: count = 2 (matches candidate)
1: count = 1 (does not match candidate)
1: count = 0 (does not match candidate)
1: count = -1 (does not match candidate)
2: count = 0 (candidate changes to 2)
2: count = 1 (matches candidate)
Final candidate = 2.
Complexity:
Time Complexity: O(n)
Single pass through the array.
Space Complexity: O(1)
Only a few variables are used.
*/