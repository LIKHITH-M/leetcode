/*
 There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
 The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
 The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 
Constraints:
1 <= m, n <= 100
 */

 /*
 Dynamic Programming Approach
Intuition:
Use a 2D array dp where dp[i][j] represents the number of unique paths to reach cell (i,j).
The robot can only come from the top (dp[i−1][j]) or left (dp[i][j−1]).
Transition equation: dp[i][j]=dp[i−1][j]+dp[i][j−1]
Base case:
dp[0][j] = 1 for all j (only one way to reach the first row: keep moving right).
dp[i][0] = 1 for all i (only one way to reach the first column: keep moving down).
 */

 class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize base cases
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1; // Only one way to move down the first column
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1; // Only one way to move right in the first row
        }

        // Fill the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1]; // Bottom-right corner
    }
}

/*Combinatorics Approach
Intuition:
To reach the bottom-right corner of an m×n grid, the robot takes exactly (m−1) down moves and (n−1) right moves.
The problem boils down to finding the number of ways to arrange (m−1) downs and (n−1) rights in a sequence of (m+n−2) moves.
The number of unique paths is given by the binomial coefficient : C(m+n−2,m−1)= 
(m−1)!⋅(n−1)!
(m+n−2)!
 */

 class Solution {
    public int uniquePaths(int m, int n) {
        long result = 1;

        // Compute C(m+n-2, m-1) or C(m+n-2, n-1)
        int smaller = Math.min(m - 1, n - 1);
        for (int i = 1; i <= smaller; i++) {
            result = result * (m + n - 1 - i) / i;
        }

        return (int) result;
    }
}
