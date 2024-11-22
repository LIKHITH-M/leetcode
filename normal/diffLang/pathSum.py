class Solution:
    def hasPathSum(self, root, targetSum):
        if root is None:
            return False  # Base case: empty tree.

        # Check if it's a leaf node and the value matches the remaining targetSum.
        if root.left is None and root.right is None and root.val == targetSum:
            return True

        # Recurse for left and right subtrees with the updated targetSum.
        targetSum -= root.val
        return self.hasPathSum(root.left, targetSum) or self.hasPathSum(root.right, targetSum)
