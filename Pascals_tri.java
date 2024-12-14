/*Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]
 
Constraints:
1 <= numRows <= 30*/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<>();

        // Base case: If no rows are needed, return an empty list
        if (numRows == 0) return tri;

        // Add the first row (always [1])
        List<Integer> row = new ArrayList<>();
        row.add(1);
        tri.add(row);

        // If only one row is needed, return immediately
        if (numRows == 1) return tri;

        // Generate the subsequent rows
        for (int i = 1; i < numRows; i++) {
            List<Integer> nxt = new ArrayList<>();

            // First element of the row is always 1
            nxt.add(1);

            // Compute middle elements using the previous row
            List<Integer> prevRow = tri.get(i - 1); // Fetch the previous row
            for (int j = 1; j < i; j++) {
                nxt.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            // Last element of the row is always 1
            nxt.add(1);

            // Add the current row to the triangle
            tri.add(nxt);
        }

        return tri;
    }
}
