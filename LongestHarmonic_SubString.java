/*  We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious 
subsequence
 among all its possible subsequences.

Example 1:

Input: nums = [1,3,2,2,5,2,3,7]

Output: 5

Explanation:

The longest harmonious subsequence is [3,2,2,2,3].

Example 2:

Input: nums = [1,2,3,4]

Output: 2

Explanation:

The longest harmonious subsequences are [1,2], [2,3], and [3,4], all of which have a length of 2.

Example 3:

Input: nums = [1,1,1,1]

Output: 0

Explanation:

No harmonic subsequence exists.*/
import java.util.HashMap;

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count frequencies of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int maxLength = 0;
        
        // Check for harmonious subsequences
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.containsKey(key + 1)) {
                int currentLength = frequencyMap.get(key) + frequencyMap.get(key + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        return maxLength;
    }
}

/* 1. frequencyMap.getOrDefault(num, 0):
 frequencyMap.get(num): This retrieves the value associated with the key num in the HashMap.
 If num is already in the map, it returns the frequency (the number of times num has appeared so far).
getOrDefault(num, 0): If the num is not already in the map, it will return 0 instead of null.
 This ensures that for a new number, we start counting from 0.
So, this part is essentially checking if num exists in the map. 
If it exists, it gets its current frequency; otherwise, it assumes the frequency is 0.*/