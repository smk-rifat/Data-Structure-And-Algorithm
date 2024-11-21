package DailyChallenge.LinkedList.ReorderList.Approach2;
class ListNode {
    int val;
    ListNode next;
    ListNode (){}
    ListNode (int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public void reorderList(ListNode head){
        if (head == null || head.next == null){
            return;
        }
        ListNode mid = middle(head);
        ListNode nH = reverse(mid.next);
        while(nH != null){
            ListNode temp1 = head.next;
            head.next = nH;
            ListNode temp2 = nH.next;
            nH.next = temp1;
            nH = temp2;
            head = temp1;
        }
        if (head != null){
            head.next = null;
        }
    }
    static ListNode reverse(ListNode head){
       ListNode node = head;
       ListNode prev = null;

       while(node != null){
           ListNode temp = node.next;
           node.next = prev;
           prev = node;
           node = temp;
       }
       return prev;
    }
    static ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
