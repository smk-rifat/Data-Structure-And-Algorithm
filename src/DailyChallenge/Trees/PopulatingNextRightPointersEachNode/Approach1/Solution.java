package DailyChallenge.Trees.PopulatingNextRightPointersEachNode.Approach1;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node cNode = q.poll();
                if (cNode.left != null) {
                    q.offer(cNode.left);
                }
                if (cNode.right != null) {
                    q.offer(cNode.right);
                }
                if (i+1 == levelSize) {
                    cNode.next = null;
                } else {
                    cNode.next = q.peek();
                }
            }
        }
        return root;
    }
}
