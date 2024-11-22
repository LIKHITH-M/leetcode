# Definition for a binary tree node.
class TreeNode
    attr_accessor :val, :left, :right
    def initialize(val = 0, left = nil, right = nil)
      @val = val
      @left = left
      @right = right
    end
  end
  
  class Solution
    def has_path_sum(root, target_sum)
      return false if root.nil?
  
      # Check if it's a leaf node and the value matches the remaining targetSum.
      if root.left.nil? && root.right.nil? && root.val == target_sum
        return true
      end
  
      # Recurse for left and right subtrees with the updated targetSum.
      target_sum -= root.val
      has_path_sum(root.left, target_sum) || has_path_sum(root.right, target_sum)
    end
  end
  