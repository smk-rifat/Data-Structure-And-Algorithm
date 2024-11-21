package DailyChallenge.LinkedList.LinkdedListCycle_II;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode slow2 = head;

        while(fast != null && fast.next != null){
             fast = fast.next.next;
             slow = slow.next;

             if(fast == slow){
                while(slow2 != slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
             }
        }
        return null;
    }
}
