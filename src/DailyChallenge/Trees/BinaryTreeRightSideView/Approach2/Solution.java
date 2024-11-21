package DailyChallenge.Trees.BinaryTreeRightSideView.Approach2;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root,result);
        return result;
    }
    private void dfs(TreeNode node,List<Integer> result){
      if (node.right == null) {
        result.add(node.val);
        return;
      }
      result.add(node.val);
      dfs(node.right, result);
      dfs(node.left, result);
    }
}
