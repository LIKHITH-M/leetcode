#include <stdbool.h>
#include <stdlib.h>

// Definition for a binary tree node.
struct TreeNode {
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};

// Function to check if there exists a root-to-leaf path with the target sum.
bool hasPathSum(struct TreeNode* root, int targetSum) {
    if (root == NULL) {
        return false; // Base case: empty tree.
    }

    // Check if it's a leaf node and the value matches the remaining targetSum.
    if (root->left == NULL && root->right == NULL && root->val == targetSum) {
        return true;
    }

    // Recurse for left and right subtrees with the updated targetSum.
    targetSum -= root->val;
    return hasPathSum(root->left, targetSum) || hasPathSum(root->right, targetSum);
}
