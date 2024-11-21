package DailyChallenge.LinkedList.ReverseLinkedList;


// Definition for singly-linked list.
class ListNode {
int val;
ListNode next;
ListNode() {}
ListNode(int val) { this.val = val; }
ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class Solution {
    ListNode iterative(ListNode head){
        ListNode prev = null;
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    // recursive way
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null; // avoid for cycle
        return newHead;
    }
}