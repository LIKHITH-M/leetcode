/*Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and 
inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]
 
Constraints:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
 */

import java.util.HashMap;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map to store the index of each value in inorder for quick lookup
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        // Recursive function to build the tree
        return constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode constructTree(int[] preorder, int preStart, int preEnd,
                                   int[] inorder, int inStart, int inEnd,
                                   HashMap<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null; // Base case: no elements to construct
        }

        // Root value is the first element in preorder
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of root in inorder
        int rootIndex = inorderMap.get(rootVal);

        // Number of elements in the left subtree
        int leftSize = rootIndex - inStart;

        // Recursively build the left and right subtrees
        root.left = constructTree(preorder, preStart + 1, preStart + leftSize,
                                  inorder, inStart, rootIndex - 1, inorderMap);
        root.right = constructTree(preorder, preStart + leftSize + 1, preEnd,
                                   inorder, rootIndex + 1, inEnd, inorderMap);

        return root; // Return the constructed tree
    }
}

/* Example Walkthrough
Input
plaintext
Copy code
preorder = [3, 9, 20, 15, 7]
inorder = [9, 3, 15, 20, 7]
Execution Steps
Root: 3 (first element of preorder).
In inorder: 3 splits into [9] (left subtree) and [15, 20, 7] (right subtree).
Left subtree of 3: Constructed from preorder = [9] and inorder = [9].
Root: 9. No left or right children as the arrays are of size 1.
Right subtree of 3: Constructed from preorder = [20, 15, 7] and inorder = [15, 20, 7].
Root: 20.
Left subtree: preorder = [15], inorder = [15] → Root: 15.
Right subtree: preorder = [7], inorder = [7] → Root: 7.
Output Tree
plaintext
Copy code
        3
       / \
      9   20
         /  \
        15   7
Complexity
Time Complexity:
O(n), where n is the number of nodes. The map lookup and recursion handle each node once.
Space Complexity: 
O(n) for the recursion stack and the hashmap*/