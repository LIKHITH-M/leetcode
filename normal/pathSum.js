// Definition for a binary tree node.
function TreeNode(val, left, right) {
    this.val = val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
}

const hasPathSum = function(root, targetSum) {
    if (root === null) return false;

    // Check if it's a leaf node and the value matches the remaining targetSum.
    if (root.left === null && root.right === null && root.val === targetSum) {
        return true;
    }

    // Recurse for left and right subtrees with the updated targetSum.
    targetSum -= root.val;
    return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
};

module.exports = { TreeNode, hasPathSum }; // For testing in Node.js
