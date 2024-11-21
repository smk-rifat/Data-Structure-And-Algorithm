package DailyChallenge.LinkedList.Reverse_Alternate_K_Nodes_Singly_LinkedList.Approach2;

class Node {
	public int data;
	public Node next;
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class Solution {
	public static Node reverseAlternateKNodes(Node head, int k) {
		if(head == null){
			return null;
		}
		Node cur = head;
		Node prev = null;
        // reverse k nodes
		for (int i = 0; cur != null &&i < k; i++) {
			Node next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		head.next = cur;
		// skipping k nodes
		for (int i = 0;cur != null &&i < k-1; i++){
			cur = cur.next;
		}
		if (cur != null){
			cur.next = reverseAlternateKNodes(cur.next, k);
		}
		return prev;
	}
}