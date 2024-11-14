class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols]; // Array to store the height of bars in the histogram
        int maxArea = 0;
        
        // Iterate over each row
        for (int i = 0; i < rows; i++) {
            // Update the heights array based on the current row
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0; // Reset height to 0 if the current element is '0'
                }
            }
            // Calculate the maximal rectangle area for the current row's histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
    }

    // Helper function to calculate the largest rectangle in a histogram
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : heights[i]);
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }
}
/*The heights array is calculated with respect to each column in the matrix. Specifically, for each column in a given row, heights[j] represents the number of consecutive 1s vertically from the current row upwards*/

//Area=a[i]×(right smallest−left smallest+1)