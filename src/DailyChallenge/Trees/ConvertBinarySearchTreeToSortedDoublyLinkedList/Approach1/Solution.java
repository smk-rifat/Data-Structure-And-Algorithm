package DailyChallenge.Trees.ConvertBinarySearchTreeToSortedDoublyLinkedList.Approach1;
//https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/submissions/1240085170/
class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
    }
}
class Solution {
    Node head, tail;
    public Node treeToDoublyList(Node root){
         if(root == null) return null;
         head.left = tail;
         tail.right = head;
         return head;
    }
}
