# Definition for a binary tree node.
defmodule TreeNode do
  defstruct val: 0, left: nil, right: nil
end

defmodule Solution do
  def has_path_sum(nil, _target_sum), do: false

  def has_path_sum(%TreeNode{val: val, left: nil, right: nil}, target_sum) do
    val == target_sum
  end

  def has_path_sum(%TreeNode{val: val, left: left, right: right}, target_sum) do
    new_target_sum = target_sum - val
    has_path_sum(left, new_target_sum) or has_path_sum(right, new_target_sum)
  end
end
