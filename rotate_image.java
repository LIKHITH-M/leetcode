/*You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 DO NOT allocate another 2D matrix and do the rotation.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 
Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000*/

class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                // Save the top element in temp
                int temp = matrix[i][j];

                // Move the left element to the top
                matrix[i][j] = matrix[len - 1 - j][i];

                // Move the bottom element to the left
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];

                // Move the right element to the bottom
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];

                // Assign temp to the right
                matrix[j][len - 1 - i] = temp;
            }
        }
    }
}
/* 

Algorithm
For an element matrix[i][j]:

Save matrix[i][j] in temp.
Move the left element matrix[n−1−j][i]) to matrix[i][j].
Move the bottom element matrix[n−1−i][n−1−j]) to matrix[n−1−j][i].
Move the right element matrix[j][n−1−i]) to matrix[n−1−i][n−1−j].
Assign temp to matrix[j][n−1−i].*/