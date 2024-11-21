package DailyChallenge.LinkedList.RemoveNthNode.Approach2;

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
        ListNode second = dummy;
        ListNode first = dummy;
        int length = 1;
        // make distance n between first and slow pointer, so that at the end their distance will be n
        while (second.next != null){
            if (length > n){
                first = first.next;
            }
            second = second.next;
            length ++;
        }
        first.next = first.next.next;
        return dummy.next;
    }
    // here solved just one pass
    // TC - O(n)
}