using System;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public bool HasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // Check if it's a leaf node and the value matches the remaining targetSum.
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        // Recurse for left and right subtrees with the updated targetSum.
        targetSum -= root.val;
        return HasPathSum(root.left, targetSum) || HasPathSum(root.right, targetSum);
    }
}
