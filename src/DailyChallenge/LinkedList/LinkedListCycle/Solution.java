package DailyChallenge.LinkedList.LinkedListCycle;
// https://leetcode.com/problems/linked-list-cycle/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    // follow up
    public int  hasCycleLength(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int length = 0;
                do{
                    slow = slow.next;
                    length++;
                } while(slow != fast);
                return length;
            }
        }
        return 0;
    }
}
