/*There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

Example 1:
Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

Example 2:
Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.
 

Constraints:

1 <= n <= 2 * 105
0 <= edges.length <= 2 * 105
edges[i].length == 2
0 <= ui, vi <= n - 1
ui != vi
0 <= source, destination <= n - 1
There are no duplicate edges.
There are no self edges.*/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Step 1: Initialize Union-Find structure
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        // Initially, each node is its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        // Function to find the root of a node with path compression
        int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]); // Path compression
            }
            return parent[node];
        }
        
        // Function to unite two nodes
        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            
            if (root1 != root2) {
                // Attach the smaller tree under the larger one
                if (rank[root1] > rank[root2]) {
                    parent[root2] = root1;
                } else if (rank[root1] < rank[root2]) {
                    parent[root1] = root2;
                } else {
                    parent[root2] = root1;
                    rank[root1]++;
                }
            }
        }
        
        // Step 2: Process all edges to build connected components
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        
        // Step 3: Check if source and destination are in the same component
        return find(source) == find(destination);
    }
}

/* 
Explanation of Code:
Initialization:

The parent array keeps track of the root of each node.
The rank array ensures balanced tree formation to improve efficiency.
Union:

Combines two nodes into the same connected component by linking their roots.
Find:

Retrieves the root of a node and applies path compression to reduce the depth of the tree.
Path Query:

After processing all edges, check if the source and destination share the same root.
Complexity:
Time Complexity:
Union and Find operations are nearly constant time, 
O(α(n)), where α is the inverse Ackermann function.
Total time is O(E⋅α(n)), where E is the number of edges.
Space Complexity: O(n) for the parent and rank arrays.*/