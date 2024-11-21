package DailyChallenge.Trees.MaximumDepthOfBinaryTree.Approach1;
// https://leetcode.com/problems/maximum-depth-of-binary-tree/
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
    public int maxDepth(TreeNode root) {
        int ans = height(root);
        return ans;
    }
    private int height(TreeNode node){
        if (node == null) {
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right)+1;
    }
}
