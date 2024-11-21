package DailyChallenge.Trees.ValidateBinarySearchTree.Approach1;

import java.util.Stack;

// https://leetcode.com/problems/validate-binary-search-tree/
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
    public boolean isValidBST(TreeNode root) {
     if(root == null) return false;
     Stack<TreeNode> st = new Stack<>();
     TreeNode pre = null;

     while(root != null || !st.isEmpty()){
         while(root != null){
          st.push(root);
          root = root.left;     
        }
        root = st.pop();
        if (pre != null && root.val <= pre.val) return false;
        pre = root;
        root = root.right;
     }
     return true;
    }
}
