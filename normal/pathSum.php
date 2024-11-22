<?php
// Definition for a binary tree node.
class TreeNode {
    public $val;
    public $left;
    public $right;

    function __construct($val = 0, $left = null, $right = null) {
        $this->val = $val;
        $this->left = $left;
        $this->right = $right;
    }
}

class Solution {
    function hasPathSum($root, $targetSum) {
        if ($root === null) return false;

        // Check if it's a leaf node and the value matches the remaining targetSum.
        if ($root->left === null && $root->right === null && $root->val === $targetSum) {
            return true;
        }

        // Recurse for left and right subtrees with the updated targetSum.
        $targetSum -= $root->val;
        return $this->hasPathSum($root->left, $targetSum) || $this->hasPathSum($root->right, $targetSum);
    }
}
?>
