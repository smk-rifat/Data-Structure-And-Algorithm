package DailyChallenge.Trees.DiameterOfBinaryTree;
// https://leetcode.com/problems/diameter-of-binary-tree/
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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }
    private int height(TreeNode root){
        if(root == null) return 0;
        int lhs = height(root.left);
        int rhs = height(root.right);
        int dia = lhs+rhs;
        diameter = Math.max(dia, diameter);
        return Math.max(lhs, rhs)+1;
    }
}
