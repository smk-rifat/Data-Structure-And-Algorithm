package DailyChallenge.LinkedList.ReverseLinkedList_II;
// https://leetcode.com/problems/reverse-linked-list-ii/

// Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode lPrev = dummy;
        ListNode cur = head;
        // phase 1
        for (int i = 0; i < left-1; i++) {
            lPrev = cur;
            cur = cur.next;
        }
        // reverse part
        ListNode prev = null;
        for (int i = 0; i < right-left+1; i++) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        // fix the pointer
        ListNode carry = lPrev.next;
        lPrev.next = prev;
        carry.next = cur;

        // now get rid of dummy Node
        ListNode newHead = dummy.next;

        return newHead;
    }
}