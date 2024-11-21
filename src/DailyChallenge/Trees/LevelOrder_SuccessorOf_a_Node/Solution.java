package DailyChallenge.Trees.LevelOrder_SuccessorOf_a_Node;
//https://www.geeksforgeeks.org/level-order-successor-of-a-node-in-binary-tree/
import java.util.LinkedList;
import java.util.Queue;
class Node{
    int value;
    Node left, right;
    Node(){}
    Node(int val){this.value = val;}
    Node(int val, Node left, Node right){
        this.value = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public Node successor(Node node, int key){
        if (node == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            if (currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.value == key) break;
        }
        return queue.peek();
    }
}
