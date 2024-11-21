package DailyChallenge.LinkedList.RotateList.Approach1;

// https://leetcode.com/problems/rotate-list/
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode rotateRight(ListNode head, int k){
        if ( k <= 0|| head == null || head.next == null){
            return head;
        }
        ListNode lastNode = head;
        int length = 1;
        while (lastNode.next != null){
            lastNode = lastNode.next;
            length++;
        }
        lastNode.next = head;
        int rotations = k % length;
        ListNode newLast = head;
        int skip = length - rotations;
        for (int i = 0; i < skip-1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;
        return head;
    }
}