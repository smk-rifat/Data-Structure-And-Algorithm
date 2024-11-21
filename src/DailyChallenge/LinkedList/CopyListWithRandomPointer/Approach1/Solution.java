package DailyChallenge.LinkedList.CopyListWithRandomPointer.Approach1;
import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/copy-list-with-random-pointer/
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
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;

        // populate the map
        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }
        // add next and random pointer to the newly created Node

        Node t = head;
        while(t != null){
            Node node = map.get(t);
            node.next = (t.next != null) ? map.get(t.next) : null;
            node.random = (t.random != null) ? map.get(t.random) : null;
            t = t.next;
        }
        return map.get(head);
    }
    // TC -> O(N)
    // SC -> O(N)
}