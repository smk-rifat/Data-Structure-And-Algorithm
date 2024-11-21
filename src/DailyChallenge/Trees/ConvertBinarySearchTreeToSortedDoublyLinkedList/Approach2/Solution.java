package DailyChallenge.Trees.ConvertBinarySearchTreeToSortedDoublyLinkedList.Approach2;
import java.util.Stack;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
    }
}
class Solution {
    Stack<Node> stack = new Stack<>();
    public Node treeToDoublyList(Node root){
        if(root == null) return null;
        helper(root);
        if (stack.isEmpty()) return  null;
        Node head = stack.pop();
        Node tail = head;
        while (stack.isEmpty()){
            Node node = stack.pop();
            tail.right = node;
            node.left = tail;
            tail = node;
        }
        tail.right = head;
        head.left = tail;
        return head;
    }
    private void helper(Node node){
        if(node == null) return;
        helper(node.left);
        stack.push(node);
        helper(node.right);
    }
}
