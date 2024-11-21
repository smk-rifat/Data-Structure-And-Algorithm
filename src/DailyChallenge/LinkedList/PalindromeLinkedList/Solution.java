package DailyChallenge.LinkedList.PalindromeLinkedList;
// https://leetcode.com/problems/palindrome-linked-list/submissions/1205505304/
import java.util.Stack;
//Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public static void main(String[] args) {
        //
    }
    public boolean bruteForce(ListNode head) {
        ListNode node = head;
        Stack<Integer> st = new Stack<>();
        while(node != null){
            st.push(node.val);
            node = node.next;
        }
        node = head;
        while(node != null){
            if(node.val != st.pop()){
                return false;
            } else {
                node = node.next;
            }
        }
        return true;
        // TC -> O(N), SC-> O(N)
    }
    // in place algorithm
    public boolean isPalindrome(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = head;
        ListNode newHead = reverse1(slow.next);
        while(newHead != null){
            if (newHead.val != node.val){
                return false;
            } else {
                node = node.next;
                newHead = newHead.next;
            }
        }
        return true;
    }
    static ListNode reverse1(ListNode head){ // iterative approach
       ListNode prev = null;
        ListNode node = head;
        while(node != null){
            ListNode front = node.next;
            node.next = prev;
            prev = node;
            node = front;
        }
        return prev;
    }
    static ListNode reverse(ListNode head){ // recursive reverse
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null; // break the circle
        return newHead;
    }
    // in summary recursive approach needs to call multiple recursive function and keeps track in stack
    // on the other hand iterative approach takes constant amount of space and doesn't need to call multiple function
    // so in terms of performance iterative approach is faster
   
}
