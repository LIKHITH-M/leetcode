// Definition for a binary tree node.
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false

        // Check if it's a leaf node and the value matches the remaining targetSum.
        if (root.left == null && root.right == null && root.`val` == targetSum) {
            return true
        }

        // Recurse for left and right subtrees with the updated targetSum.
        val newTargetSum = targetSum - root.`val`
        return hasPathSum(root.left, newTargetSum) || hasPathSum(root.right, newTargetSum)
    }
}
