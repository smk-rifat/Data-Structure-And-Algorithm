package DailyChallenge.LinkedList.MergeTwoSortedList;
// https://leetcode.com/problems/merge-two-sorted-lists/

 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  class Solution {
    // my simple iterative approach
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        ListNode node1 = list1;
        ListNode node2 = list2;

        while(node1 != null && node2 != null){
            if(node1.val < node2.val){
                if(head == null){
                    head = node1;
                } else {
                    head.next = node1;
                }
                node1 = node1.next;
            } else {
                if(head == null){
                    head = node2;
                } else {
                    head.next = node2;
                }
                node2 = node2.next; 
            }
            head = head.next;
        }

        while(node1 != null){
           if(head == null){
                head = node1;
            } else {
            head.next = node1;
             }
            node1 = node1.next;
            head = head.next;
        }
        while(node2 != null){
           if(head == null){
                head = node2;
            } else {
            head.next = node2;
             }
            node2 = node2.next;
            head = head.next;
        }
        return ans.next;
    }
    // now recursive approach
    public ListNode recursive(ListNode list1, ListNode list2){
        if (list1 == null) {
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = recursive(list1.next, list2);
            return list1;
        } else {
            list2.next = recursive(list1, list2.next);
            return list2;
        }
    }
}
