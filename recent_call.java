/*Q)You have a RecentCounter class which counts the number of recent requests within a certain time frame.

Implement the RecentCounter class:

RecentCounter() Initializes the counter with zero recent requests.
int ping(int t) Adds a new request at time t, where t represents some time in milliseconds,
and returns the number of requests that has happened in the past 3000 milliseconds (including the new request).
Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.

Example 1:
Input
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]
Output
[null, 1, 2, 3, 3]

Explanation
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // requests = [1], range is [-2999,1], return 1
recentCounter.ping(100);   // requests = [1, 100], range is [-2900,100], return 2
recentCounter.ping(3001);  // requests = [1, 100, 3001], range is [1,3001], return 3
recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
 
Constraints:
1 <= t <= 109
Each test case will call ping with strictly increasing values of t.
At most 104 calls will be made to ping. */

/**Q)
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        // Add the new request timestamp
        requests.add(t);

        // Remove requests that are outside the 3000ms range
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }

        // Return the count of valid requests
        return requests.size();
    }
}
/* 
Execution
Initialization:
requests = [].
ping(1):
Add 1 to the queue.
No removals, as the range is [-2999,1].
Return 1.
requests = [1].
ping(100):
Add 100 to the queue.
No removals, as the range is [−2900,100].
Return 2.
requests = [1, 100].
ping(3001):
Add 3001 to the queue.
No removals, as the range is [1,3001].
Return 3.
requests = [1, 100, 3001].
ping(3002):
Add 3002 to the queue.
Remove 1 from the queue (outside the range [2,3002]).
Return 3.
requests = [100, 3001, 3002].
Output
plaintext
Copy code
[null, 1, 2, 3, 3]

Complexity Analysis

Time Complexity:
Each ping operation takes O(n) in the worst case to remove old requests, where n is the number of requests in the queue.

Space Complexity:
O(n), as the queue stores at most n timestamps.
This efficient implementation ensures that we handle up to 10^4
  requests as required by the problem constraints.*/