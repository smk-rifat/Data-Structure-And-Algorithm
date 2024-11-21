package DailyChallenge.DP.HouseRobber_III.BruteForce;
// https://leetcode.com/problems/house-robber-iii/

  public class TreeNode {
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
  public int rob(TreeNode root) {
    int[] result = helper(root);
    // Maximum amount is the best of robbing or not robbing the root node.
    return Math.max(result[0], result[1]);
  }

  // Helper function returns an array with two values:
  // result[0] -> Max money if we don't rob the current node
  // result[1] -> Max money if we rob the current node
  private int[] helper(TreeNode node) {
    if (node == null)
      return new int[] { 0, 0 };

    // Recursively solve for left and right children
    int[] left = helper(node.left);
    int[] right = helper(node.right);

    // If we rob this node, we cannot rob its children
    int rob = node.val + left[0] + right[0];

    // If we don't rob this node, we take the best of robbing or not robbing the
    // children
    int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

    return new int[] { notRob, rob };
  }
}
