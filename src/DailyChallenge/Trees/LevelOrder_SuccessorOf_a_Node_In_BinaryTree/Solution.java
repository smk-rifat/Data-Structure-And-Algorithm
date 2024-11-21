package DailyChallenge.Trees.LevelOrder_SuccessorOf_a_Node_In_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(){}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
 public TreeNode findSuccessor(TreeNode root, int key){
    if (root == null) {
      return null;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        TreeNode currentNode = queue.poll();
        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
        if (currentNode.val == key) {
          break;
        }
    }
    return queue.peek(); 
  }    
}
