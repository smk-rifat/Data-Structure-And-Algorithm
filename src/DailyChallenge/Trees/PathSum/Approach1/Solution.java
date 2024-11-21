package DailyChallenge.Trees.PathSum.Approach1;
// https://leetcode.com/problems/path-sum/
import DailyChallenge.Trees.TreeNode;
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return hasPathSum(root, targetSum, sum);
    }
    private boolean hasPathSum(TreeNode node, int targetSum, int sum){
      if(node == null) return false;
      if (node.left == null && node.right == null && sum+node.val == targetSum) return true;
      return hasPathSum(node.left, targetSum,sum+node.val) || hasPathSum(node.right, targetSum, sum+node.val);
    }
}