package DailyChallenge.LinkedList.RemoveDuplicates;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        return head = recursion(head);
   }
   private ListNode recursion(ListNode node){
         if(node == null || node.next == null){
            return node;
         }
         node.next = recursion(node.next);
         if (node.val == node.next.val) {
            return node.next;
         } else {
            return node;
         }
   }
   public ListNode iterative(ListNode head){
        ListNode node = head;

        while(node != null){
            if(node.next == null) break;
            if(node.val == node.next.val){
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
   }
}
