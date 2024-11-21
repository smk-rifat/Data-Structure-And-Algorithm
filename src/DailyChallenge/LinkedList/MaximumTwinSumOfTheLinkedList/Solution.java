package DailyChallenge.LinkedList.MaximumTwinSumOfTheLinkedList;

import java.util.Stack;

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
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
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(brute(node1));

    }
    static int brute(ListNode head){
        int ans = 0;
        Stack<ListNode> st = new Stack<>();
        ListNode node = head;
        int size = 0;
        while (node != null) {
            st.add(node);
            size++;
            node = node.next;
        }
        node = head;
        while(size != size/2) {
            int sum = (node.val)+(st.pop().val);
            ans = Math.max(ans, sum);
            size--;
            node = node.next;
        }
        return ans;
    }
    public int pairSum(ListNode head) {
        return 0;
    }
}