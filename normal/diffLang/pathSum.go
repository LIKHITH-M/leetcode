package main

// Definition for a binary tree node.
type TreeNode struct {
    Val   int
    Left  *TreeNode
    Right *TreeNode
}

func hasPathSum(root *TreeNode, targetSum int) bool {
    if root == nil {
        return false // Base case: empty tree.
    }

    // Check if it's a leaf node and the value matches the remaining targetSum.
    if root.Left == nil && root.Right == nil && root.Val == targetSum {
        return true
    }

    // Recurse for left and right subtrees with the updated targetSum.
    targetSum -= root.Val
    return hasPathSum(root.Left, targetSum) || hasPathSum(root.Right, targetSum)
}
