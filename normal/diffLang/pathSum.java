class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false; // If tree is empty, no path exists.

        // If the current node is a leaf and its value equals the targetSum, return true.
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }

        // Subtract the current node's value from targetSum and recurse for left and right subtrees.
        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}