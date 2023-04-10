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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            if (l2.val >= 10) {
                int curr = l2.val - 10;
                if (l2.next == null) {
                    return new ListNode(curr, new ListNode(1));
                } else {
                    l2.next.val += 1;
                    return new ListNode(curr, addTwoNumbers(l1, l2.next));
                }
            } else {
                return l2;
            }
        } else if (l2 == null) {
            if (l1.val >= 10) {
                int curr = l1.val - 10;
                if (l1.next == null) {
                    return new ListNode(curr, new ListNode(1));
                } else {
                    l1.next.val += 1;
                    return new ListNode(curr, addTwoNumbers(l1.next, l2));
                }
            } else {
                return l1;
            }
        } else {
            int sum = l1.val + l2.val;
            if (sum >= 10) {
                sum -= 10;
                if (l1.next == null) {
                    l1.next = new ListNode(1);
                    return new ListNode(sum, addTwoNumbers(l1.next, l2.next));
                } else {
                    l1.next.val += 1;
                    return new ListNode(sum, addTwoNumbers(l1.next, l2.next));
                }
            } else {
                return new ListNode(sum, addTwoNumbers(l1.next, l2.next));
            }
        }
        return null;
    }
}