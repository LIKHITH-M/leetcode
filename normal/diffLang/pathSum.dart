// Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode? left;
  TreeNode? right;

  TreeNode(this.val, [this.left, this.right]);
}

class Solution {
  bool hasPathSum(TreeNode? root, int targetSum) {
    if (root == null) return false;

    // Check if it's a leaf node and the value matches the remaining targetSum.
    if (root.left == null && root.right == null && root.val == targetSum) {
      return true;
    }

    // Recurse for left and right subtrees with the updated targetSum.
    targetSum -= root.val;
    return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
  }
}
