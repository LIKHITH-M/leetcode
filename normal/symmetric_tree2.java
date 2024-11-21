import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // A null tree is symmetric.

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            // Both nodes are null, continue to next pair.
            if (t1 == null && t2 == null) continue;

            // One node is null or values don't match, not symmetric.
            if (t1 == null || t2 == null || t1.val != t2.val) return false;

            // Enqueue children in the required mirrored order.
            queue.add(t1.left); // Left child of t1 with
            queue.add(t2.right); // Right child of t2
            queue.add(t1.right); // Right child of t1 with
            queue.add(t2.left); // Left child of t2
        }

        return true; // If we exhaust the queue without finding asymmetry, the tree is symmetric.
    }
}
