package DailyChallenge.Trees.InvertABinaryTree.Approach1;
// https://leetcode.com/problems/invert-binary-tree/
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        return traverse(root);
    }
    private TreeNode traverse(TreeNode node){
        if (node == null) {
            return null;
        }
        TreeNode left =node.left;
        TreeNode right = node.right;
        node.left = right;
        node.right = left;
        traverse(left);
        traverse(right);
        return node;
    }
}
