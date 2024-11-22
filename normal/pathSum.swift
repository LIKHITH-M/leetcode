// Definition for a binary tree node.
public class TreeNode {
    public var val: Int
    public var left: TreeNode?
    public var right: TreeNode?
    
    public init(_ val: Int) {
        self.val = val
        self.left = nil
        self.right = nil
    }
}

class Solution {
    func hasPathSum(_ root: TreeNode?, _ targetSum: Int) -> Bool {
        guard let root = root else { return false }

        // Check if it's a leaf node and the value matches the remaining targetSum.
        if root.left == nil && root.right == nil && root.val == targetSum {
            return true
        }

        // Recurse for left and right subtrees with the updated targetSum.
        let newTargetSum = targetSum - root.val
        return hasPathSum(root.left, newTargetSum) || hasPathSum(root.right, newTargetSum)
    }
}
