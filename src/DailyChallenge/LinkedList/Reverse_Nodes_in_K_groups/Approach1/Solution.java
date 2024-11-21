package DailyChallenge.LinkedList.Reverse_Nodes_in_K_groups.Approach1;
//https://leetcode.com/problems/reverse-nodes-in-k-group/

 // Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // base condition
        ListNode check = head;
        for (int i = 0; i <k ; i++) {
            if (check == null) return head;
            check = check.next;
        }
        // recursive call
        ListNode newHead = reverse(head, k);
        head.next = reverseKGroup(check, k);
        return newHead;
    }
    static ListNode reverse(ListNode head, int k){
        ListNode node = head;
        ListNode prev = null;

        while (k >0){
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            k--;
        }
        return prev;
    }
}
// time complexity is O(N), Space complexity is O(n/k)