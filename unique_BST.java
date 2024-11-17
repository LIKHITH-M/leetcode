/*
number of unique trees formed by the n nodes is:
first, for one node as root =number of nodes that are to left * number of nodes that are to right
second, add for all the nodes considering every nodes at root.
*/

public class Solution {
    public int numTrees(int n) {
      int[] G = new int[n + 1]; // Array to store the results for each number of nodes
      G[0] = 1; // Base case: 1 way to form an empty tree
      G[1] = 1; // Base case: 1 way to form a tree with 1 node
  
      // Loop through all numbers of nodes from 2 to n
      for (int i = 2; i <= n; ++i) {
        // For each number of nodes, consider each node as the root
        for (int j = 1; j <= i; ++j) {
          // Calculate G[i] by summing the products of left and right subtrees
          G[i] += G[j - 1] * G[i - j];
        }
      }
  
      return G[n]; // Return the result for 'n' nodes
    }
  }
  
