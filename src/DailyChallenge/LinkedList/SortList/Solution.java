package DailyChallenge.LinkedList.SortList;
// https://leetcode.com/problems/sort-list/

 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

 }

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = getMid(head);
        ListNode mid = prev.next;
        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
    static ListNode merge(ListNode left, ListNode right){
        if(left == null) return right;
        if(right == null) return left;
        if (left.val < right.val){
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }
    static ListNode getMid(ListNode head){
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }
}
