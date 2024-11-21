/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // A tree is symmetric if its left and right subtrees are mirrors of each other.
        if (root == null)
            return true;
        return mirror(root.left, root.right);
    }

    public boolean mirror(TreeNode leftT, TreeNode rightT) {
        // Both nodes are null, symmetric at this level.
        if (leftT == null && rightT == null)
            return true;
        // One node is null while the other is not, not symmetric.
        if (leftT == null || rightT == null)
            return false;
        // Check if values match and subtrees are mirrors.
        return (leftT.val == rightT.val) 
            && mirror(leftT.left, rightT.right) // Left subtree of leftT with right subtree of rightT
            && mirror(leftT.right, rightT.left); // Right subtree of leftT with left subtree of rightT
    }
}
