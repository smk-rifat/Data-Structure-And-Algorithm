package DailyChallenge.LinkedList.ReorderList.Approach1;
// https://leetcode.com/problems/reorder-list/submissions/1206055774/
import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val,ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode node = head;
        Stack<ListNode> st = new Stack<>();
        int size = 0;
        while (node != null){
            st.push(node);
            node = node.next;
            size++;
        }
        node = head;
        while(size > 1){
            ListNode stNode = st.pop();
            ListNode temp = node.next;
            node.next = stNode;
            stNode.next = temp;
            node = temp;
            size -= 2;
        }
        if(node != null){
            node.next = null;
        }
    }
}