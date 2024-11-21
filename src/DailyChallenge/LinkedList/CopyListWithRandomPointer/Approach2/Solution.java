package DailyChallenge.LinkedList.CopyListWithRandomPointer.Approach2;
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
 class Solution {
     public Node copyRandomList(Node head){
         Node node = head;
         Node dummy = new Node(-1);

         // connecting the deep copy with the original copy so that we won't need extra space to store deep copy corresponding to original object
         while (node != null){
             Node newNode = new Node(node.val);
             newNode.next = node.next;
             node.next = newNode;
             node = node.next.next;
         }
         // Pointing random pointer in the deep copy
         node = head;
         while (node != null){
             node.next.random = (node.random != null) ? node.random.next: null;
             node = node.next.next;
         }
         Node slow = head;
         Node fast = head;
         Node temp = dummy;
         // pointing next pointer in deep copy
         while (slow != null) {
             fast = fast.next.next;
             temp.next = slow.next;
             slow.next = fast;
             temp = temp.next;
             slow = fast;
         }
         return dummy.next;
     }
}
// time complexity O(N)
// space complexity O(1)
// creating new doesn't consider for extra space .