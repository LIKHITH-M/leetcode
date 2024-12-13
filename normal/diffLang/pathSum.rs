// Definition for a binary tree node.
#[derive(PartialEq, Eq, Clone)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Box<TreeNode>>,
    pub right: Option<Box<TreeNode>>,
}

impl Solution {
    pub fn has_path_sum(root: Option<Box<TreeNode>>, target_sum: i32) -> bool {
        if let Some(node) = root {
            // Check if it's a leaf node and the value matches the remaining targetSum.
            if node.left.is_none() && node.right.is_none() && node.val == target_sum {
                return true;
            }
            
            // Recurse for left and right subtrees with the updated targetSum.
            let new_target_sum = target_sum - node.val;
            return Solution::has_path_sum(node.left, new_target_sum) || 
                   Solution::has_path_sum(node.right, new_target_sum);
        }
        false
    }
}
