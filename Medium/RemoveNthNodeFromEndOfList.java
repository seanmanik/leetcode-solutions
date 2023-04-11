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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode toRemove = head;
        for (int i = 0; i < n; i++) {
            toRemove = toRemove.next;
        }
        if (toRemove == null) {
            return head.next;
        }
        ListNode front = head;
        while (toRemove.next != null) {
            front = front.next;
            toRemove = toRemove.next;
        }       
        front.next = front.next.next;
        return head;

    }
}