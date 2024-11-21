package DailyChallenge.LinkedList.AddTwoNumber.Approach1;
// https://leetcode.com/problems/add-two-numbers/
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val, ListNode next){this.val = val; this.next = next;}
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode node1 = l1;
        ListNode node2 = l2;
        int carry = 0;

        while (node1 != null || node2 != null) {

            if (node2 == null && node1 != null) {
                int value = node1.val+carry;
                ListNode newNode = new ListNode(value %10);
                temp.next = newNode;
                temp = temp.next;
                node1 = node1.next;
                carry = value/10;
            } else if (node1 == null && node2 != null){
                int value = node2.val + carry;
                ListNode newNode = new ListNode(value%10);
                temp.next = newNode;
                temp = temp.next;
                node2 = node2.next;
                carry = value /10;
            } 
            else {
                int value = node1.val+node2.val+carry;
                ListNode newNode = new ListNode(value%10);
                temp.next = newNode;
                temp = temp.next;
                node1 = node1.next;
                node2 = node2.next;
                carry = value /10;
            }
        }
        if (node1 == null && carry > 0) {
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
        }
        return dummy.next;
    }
    // TC -> O(m+n)
}