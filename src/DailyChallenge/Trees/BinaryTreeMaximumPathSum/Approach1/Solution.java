package DailyChallenge.Trees.BinaryTreeMaximumPathSum.Approach1;
import DailyChallenge.Trees.TreeNode;
// https://leetcode.com/problems/binary-tree-maximum-path-sum/
class Solution {
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        maxSum(root);
        return sum;
    }
    private int maxSum(TreeNode node){
        if (node == null) return 0;
        int left = maxSum(node.left);
        int right = maxSum(node.right);
        if (left < 0) left = 0;
        if (right < 0) right = 0;
        int currentNodeSum = node.val+left+right;
        sum = Math.max(sum, currentNodeSum);
        return Math.max(left, right)+node.val;
    }
}