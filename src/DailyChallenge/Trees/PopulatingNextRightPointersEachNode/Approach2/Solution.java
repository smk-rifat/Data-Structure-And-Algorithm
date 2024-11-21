package DailyChallenge.Trees.PopulatingNextRightPointersEachNode.Approach2;
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
    public Node connect(Node root){
        if(root == null) return null;
        Node levelStart = root;
        while(levelStart.left != null){
            Node cur = levelStart;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }
}
