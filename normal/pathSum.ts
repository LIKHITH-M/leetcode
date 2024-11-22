// Definition for a binary tree node.
class TreeNode {
    val: number;
    left: TreeNode | null;
    right: TreeNode | null;

    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = val === undefined ? 0 : val;
        this.left = left === undefined ? null : left;
        this.right = right === undefined ? null : right;
    }
}

function hasPathSum(root: TreeNode | null, targetSum: number): boolean {
    if (root === null) return false;

    // Check if it's a leaf node and the value matches the remaining targetSum.
    if (root.left === null && root.right === null && root.val === targetSum) {
        return true;
    }

    // Recurse for left and right subtrees with the updated targetSum.
    targetSum -= root.val;
    return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
}

export { TreeNode, hasPathSum }; // For testing or usage in other files
