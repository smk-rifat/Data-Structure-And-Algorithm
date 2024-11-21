package DailyChallenge.Trees.FlattenBinaryTreeToLinkedList.Approach2;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(){}
    TreeNode(int val){ this. val = val;}
    TreeNode(int val , TreeNode left, TreeNode right){
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
class Solution {
    public void flatten(TreeNode root) {
         if(root == null ||(root.left == null && root.right == null)) return;
         List<TreeNode> nodes = new ArrayList<>();
         preOrder(nodes, root);

         for (int i = 0; i < nodes.size()-1; i++) {
            TreeNode current = nodes.get(i);
            current.left = null;
            current.right = nodes.get(i+1);
         }
         TreeNode lastNode = nodes.get(nodes.size()-1);
         lastNode.left = null;
         lastNode.right = null;
    }
    private void preOrder(List<TreeNode> nodes, TreeNode node){
       if(node == null) return;
       nodes.add(node);
       preOrder(nodes, node.left);
       preOrder(nodes, node.right);

    }
}
