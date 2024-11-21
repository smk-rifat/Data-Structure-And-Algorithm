package DailyChallenge.Trees.ConvertBinarySearchTreeToSortedDoublyLinkedList.UltimateApproach_Morris;
class Node{
    Node left, right;
    int val;
    Node(int val){
        this.val = val;
    }
    Node(int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    Node head;
    Node tail;
    public Node treeToDoublyList(Node root){
        if (root == null) return null;
        Node cur = root;

        while(cur != null){
            Node leftNode = cur.left;
            if (leftNode == null){
                if (head == null) head = cur;
                if (tail != null){
                    tail.right = cur;
                    cur.left = tail;
                }
                tail = cur;
                cur = cur.right;
            } else {
                Node rightMostNode = getRightMostNode(leftNode, cur);
                if (rightMostNode.right == null){
                    rightMostNode.right = cur;
                    cur = cur.left;
                } else {
                    if (tail != null){
                        tail.right = cur;
                        cur.left = tail;
                    }
                    tail = cur;
                    cur = cur.right;
                }
            }
        }
        head.left = tail;
        tail.right = head;
        return head;
    }
    private Node getRightMostNode(Node leftNode, Node cur){
        while(leftNode.right != null && leftNode.right != cur){
            leftNode = leftNode.right;
        }
        return leftNode;
    }
}
