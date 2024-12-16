/*Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown

Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:
Input: rowIndex = 0
Output: [1]

Example 3:
Input: rowIndex = 1
Output: [1,1]
 
Constraints:
0 <= rowIndex <= 33
 */

 public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        // Initialize the first element as 1
        row.add(1);

        // Use a loop to build the row up to rowIndex
        for (int i = 1; i <= rowIndex; i++) {
            // Update row in reverse to maintain correctness
            for (int j = row.size() - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            // Add 1 to the end of the row
            row.add(1);
        }
        return row;
    }
}

/* 
Explanation:
Initialization: Start with [1] as the first row.
Iterative Update:
For each row, update elements from right to left to avoid overwriting the values needed for computation.
Add a new element 1 at the end of the row for each iteration.
Output: After rowIndex iterations, the row list contains the desired row.
Example Walkthrough:
Input: rowIndex = 3
Initial Row: [1]
Iteration 1:
Add 1 to the end → [1, 1]
Iteration 2:
Update: [1, (1+1)] → [1, 2]
Add 1 to the end → [1, 2, 1]
Iteration 3:
Update: [1, (2+1), (2+1)] → [1, 3, 3]
Add 1 to the end → [1, 3, 3, 1]
Output: [1, 3, 3, 1]

Complexity Analysis:
Time Complexity: 
𝑂(rowIndex2), as each row has approximately rowIndex updates.
Space Complexity: 
𝑂(rowIndex), as we maintain a single array of size rowIndex + 1.
This approach satisfies the follow-up requirement of using 
𝑂(rowIndex) extra space.
*/