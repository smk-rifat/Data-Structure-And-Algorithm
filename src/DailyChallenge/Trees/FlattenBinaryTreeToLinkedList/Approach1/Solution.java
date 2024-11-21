package DailyChallenge.Trees.FlattenBinaryTreeToLinkedList.Approach1;
// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
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
         if (root == null) {
          return;
         }
         TreeNode left = root.left;
         TreeNode right = root.right;
          if (left == null) {
            flatten(right);
          } else {
            root.right = left;
            root.left = null;
            insertAtRight(left, right);
            flatten(left);
          }
         
    }
    private TreeNode insertAtRight(TreeNode left, TreeNode right){
      if(left == null){
        return right;
      }
      left.right = insertAtRight(left.right, right);
      return left;
    }
}
