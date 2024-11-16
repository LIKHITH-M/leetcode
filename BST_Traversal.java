import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>(); // To store the final level-order traversal

        if (root == null) {
            return result; // If the tree is empty, return an empty list
        }

        Queue<TreeNode> queue = new LinkedList<>(); // Queue to help traverse level by level
        queue.offer(root); // Start with the root node

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at the current level
            List<Integer> currentLevel = new ArrayList<>(); // List to store nodes at the current level

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // Get the front node from the queue
                currentLevel.add(currentNode.val); // Add the node's value to the current level

                // Add the left and right children to the queue if they exist
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel); // Add the current level to the result
        }

        return result; // Return the level-order traversal
    }
}
