package DailyChallenge.LinkedList.RemoveNthNode.Approach1;
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || (head.next == null && n <= 1)){
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode node = dummy;
        int length = 1;
        while(node.next != null){
            node = node.next;
            length++;
        }
        ListNode first = dummy;
        for(int i = 0; i < length -n -1; i++){
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}