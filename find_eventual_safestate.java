/* There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented 
by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i,
 meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting
 from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
Example 1:

Illustration of graph
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Explanation: The given graph is shown above.
Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.

Example 2:
Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
Output: [4]
Explanation:
Only node 4 is a terminal node, and every path starting at node 4 leads to node 4. 

Constraints:
n == graph.length
1 <= n <= 104
0 <= graph[i].length <= n
0 <= graph[i][j] <= n - 1
graph[i] is sorted in a strictly increasing order.
The graph may contain self-loops.
The number of edges in the graph will be in the range [1, 4 * 104]. */

import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] inDegree = new int[n];

        // Initialize the reverse graph
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        // Build the reverse graph and calculate in-degrees
        for (int i = 0; i < n; i++) {
            for (int neighbor : graph[i]) {
                reverseGraph.get(neighbor).add(i);
                inDegree[i]++;
            }
        }

        // Queue for processing nodes with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Perform topological sort
        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            for (int neighbor : reverseGraph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Sort the safe nodes
        Collections.sort(safeNodes);
        return safeNodes;
    }
}


/*
 To solve the problem of finding eventual safe nodes, we can use the reverse graph approach
  combined with topological sorting.Here's how we can solve it step by step:

Explanation:
Definitions:

A terminal node has no outgoing edges.
A safe node is a node from which all possible paths lead to terminal nodes or other safe nodes.
Approach:

Reverse the direction of all edges in the graph. For example, if there is an edge from 
u→v in the original graph, in the reversed graph, it will be v→u.
Count the in-degree (number of incoming edges) for each node in the reversed graph.
Perform a topological sort (using Kahn's Algorithm) on the reversed graph to identify the nodes that are terminal or lead to terminal nodes.
Nodes with an in-degree of 0 in the reversed graph are safe nodes.
Steps:

Build the reversed graph.
Use a queue to process nodes with an in-degree of 0.
Decrease the in-degree of neighboring nodes and add them to the queue if their in-degree becomes 0.
Sort the resulting safe nodes.


Explanation of the Code:
Reverse Graph Construction:

For each edge 
u→v in the original graph, add an edge 
v→u in the reversed graph.
Count the incoming edges for each node in the original graph to calculate the in-degree.
Topological Sort:

Start with nodes having in-degree 0 (no dependencies in the reversed graph).
For each node processed, reduce the in-degree of its neighbors in the reversed graph.
Result Collection:

The nodes processed in this way are guaranteed to be eventual safe nodes. Sort them to meet the problem's requirement.
Complexity Analysis:
Time Complexity:

Building the reverse graph: 
O(V+E), where 
V is the number of nodes and 
E is the number of edges.
Topological sorting: 
O(V+E).
Sorting the result: 
O(VlogV).
Total: 
O(V+E+VlogV).
Space Complexity:

Reverse graph storage: 
O(V+E).
In-degree array and queue: 
O(V).
Total: 
O(V+E).
Example Walkthrough:
For the input:

java
Copy code
graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Reverse Graph:

css
Copy code
reverseGraph = [ [3], [0], [0,1], [1], [], [2,4], [] ]
In-Degree:

css
Copy code
inDegree = [1, 2, 2, 1, 1, 0, 0]
Topological Sort:

Process nodes with in-degree 0: [5, 6].
After processing, nodes with in-degree 0: [2, 4].
Finally, nodes with in-degree 0: [0, 3].
Safe nodes: [0, 2, 3, 4, 5, 6].
Result:

makefile
Copy code
Output: [2, 4, 5, 6]
This approach is efficient and meets the problem constraints.
 */