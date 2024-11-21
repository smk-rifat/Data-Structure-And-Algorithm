package DailyChallenge.LinkedList.Middle_of_the_LinkedList;
// https://leetcode.com/problems/middle-of-the-linked-list/

 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
  }
  class Solution {
    public ListNode naiveApproach(ListNode head) {
        ListNode node = head;
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        int index = (count/2)+1;
        index = index - 1;
        node = head;
        while(index != 0){
            node = node.next;
            index--;
        }
        return node;
    }
    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        // for odd numbers of node fast will go till before null
        // for even number of node fast will go to null
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
