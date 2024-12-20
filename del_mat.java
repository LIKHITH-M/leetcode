/*You are given an m x n matrix grid consisting of positive integers.

Perform the following operation until grid becomes empty:

Delete the element with the greatest value from each row. If multiple such elements exist, delete any of them.
Add the maximum of deleted elements to the answer.
Note that the number of columns decreases by one after each operation.

Return the answer after performing the operations described above.

Example 1:
Input: grid = [[1,2,4],[3,3,1]]
Output: 8

Explanation: The diagram above shows the removed values in each step.
- In the first operation, we remove 4 from the first row and 3 from the second row (notice that, there are two cells with value 3 and we can remove any of them). We add 4 to the answer.
- In the second operation, we remove 2 from the first row and 3 from the second row. We add 3 to the answer.
- In the third operation, we remove 1 from the first row and 1 from the second row. We add 1 to the answer.
The final answer = 4 + 3 + 1 = 8.*/

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        // Step 1: Sort each row in ascending order
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        
        int result = 0;

        // Step 2: Iterate over columns from rightmost to leftmost
        int n = grid[0].length; // Number of columns
        for (int col = n - 1; col >= 0; col--) {
            int maxInColumn = 0;

            // Find the maximum in the current column
            for (int[] row : grid) {
                maxInColumn = Math.max(maxInColumn, row[col]);
            }

            // Add the maximum to the result
            result += maxInColumn;
        }

        return result;
    }
}

/* 
Time Complexity:

Sorting all rows: 
O(m⋅n⋅log(n)) (wherem is the number of rows and n is the number of columns).
Iterating over columns: 
O(m⋅n).
O(m⋅n⋅log(n)).

Space Complexity:
O(1) additional space (in-place operations).*/