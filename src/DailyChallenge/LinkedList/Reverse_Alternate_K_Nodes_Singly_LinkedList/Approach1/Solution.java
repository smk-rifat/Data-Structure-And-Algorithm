package DailyChallenge.LinkedList.Reverse_Alternate_K_Nodes_Singly_LinkedList.Approach1;
// https://www.codingninjas.com/studio/problems/reverse-alternate-k-nodes_893077
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
         if (k <= 1 || head == null){
			 return head;
		 }
		 Node current = head;
		 Node prev = null;

		 while(current != null){
			 Node last = prev;
			 Node newEnd = current;

			 // reverse between left and right

			 for (int i = 0; current != null && i <k ; i++) {
				 Node next = current.next;
				 current.next = prev;
				 prev = current;
				 current = next;
			 }
			 if (last != null){
				 last.next = prev;
			 } else {
				 head = prev;
			 }
			 newEnd.next = current;
			// skip the k nodes
			 for (int i = 0; current != null &&i < k; i++) {
                 prev = current;
				 current = current.next;
			 }
		 }
		 return head;
	}
}