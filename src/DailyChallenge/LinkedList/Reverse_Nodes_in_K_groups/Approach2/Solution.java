package DailyChallenge.LinkedList.Reverse_Nodes_in_K_groups.Approach2;
// https://leetcode.com/problems/reverse-nodes-in-k-group/description/DescriptionGivenalinkedlist/
class ListNode {
    int val;
    ListNode next;
    ListNode(){

    }
    ListNode (int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode fake = new ListNode();
       fake.next = head;
       ListNode prev = fake;

       while (head != null){
           ListNode start = head;
           int range = k;
           // determine if there is k amount of node available or not
           while( range > 0 && head != null){
               head = head.next;
               range--;
           }
           if (range != 0){
               prev.next = start;
               break;
           }
           prev.next = reverse(start, k);
           prev = start;
       }
       return fake.next; // fake is not the part of the list
    }
    static ListNode reverse(ListNode head, int k){
       ListNode node = head;
       ListNode prev = null;
       while(k > 0){
           ListNode next = node.next;
           node.next = prev;
           prev = node;
           node = next;
           k--;
       }
       return prev;
    }
}
// TC -> O(n)
// SC -> O(1)