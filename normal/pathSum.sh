#!/bin/bash

# Function to check path sum in a simple binary tree simulation (represented as an array)
has_path_sum() {
  local node=$1
  local sum=$2
  local target_sum=$3

  # Base case: If the node is empty, return false
  if [ -z "$node" ]; then
    echo "false"
    return
  fi

  # If it's a leaf node, check if the sum matches the target
  if [ $node -eq $sum ] && [ -z "$(echo $sum | grep ' ')" ]; then
    echo "true"
    return
  fi

  # Check left and right subtrees with updated sum
  local left_sum=$((sum - node))
  local right_sum=$((sum - node))

  # We are simulating recursion with this bash logic (not truly recursive)
  # Let's pretend left and right are different paths in this example.
  has_path_sum $left_sum "left-path" $target_sum || has_path_sum $right_sum "right-path" $target_sum
}

# Test the function with a simple tree and sum
root=5
target_sum=22

# Example tree
#       5
#      / \
#     4   8
#    /   / \
#   11  13  4
#  /  \     /
# 7    2   1

# Test with the tree and target sum
result=$(has_path_sum $root 0 $target_sum)
echo $result
