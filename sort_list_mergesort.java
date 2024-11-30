/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: if the list is empty or has only one element, it is sorted
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Split the linked list into two halves using slow and fast pointers
        ListNode mid = getMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; // Break the list into two halves
        
        // Step 2: Recursively sort each half
        left = sortList(left);
        right = sortList(right);
        
        // Step 3: Merge the two sorted halves
        return merge(left, right);
    }
    
    // Function to find the middle of the linked list using slow and fast pointers
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Move fast by two steps and slow by one step to find the middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow; // Slow pointer will be at the middle
    }
    
    // Function to merge two sorted linked lists
    private ListNode merge(ListNode left, ListNode right) {
        // Dummy node to build the sorted list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Compare the nodes from both lists and merge them in sorted order
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        
        // If any elements are left in either of the lists, append them
        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }
        
        return dummy.next; // The merged list is after the dummy node
    }
}
