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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newTail = head;
        ListNode nextHead = head;
        if (head == null) {
            return null;
        }
        int temp = k;
        while (k > 1) {
            if (nextHead.next == null) {
                return head;
            }
            nextHead = nextHead.next;
            k--;
        }
        ListNode newHead = nextHead;

        nextHead = nextHead.next;
        newHead.next = null;
        reverse(head);
        newTail.next = reverseKGroup(nextHead, temp);
        return newHead;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr.next != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;
        return curr;
    }
}