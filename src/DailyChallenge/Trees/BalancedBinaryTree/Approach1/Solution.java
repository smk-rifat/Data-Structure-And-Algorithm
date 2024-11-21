package DailyChallenge.Trees.BalancedBinaryTree.Approach1;
import DailyChallenge.Trees.TreeNode;
class Solution {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(5);
        TreeNode node3 = new TreeNode(5);
        TreeNode node5 = new TreeNode(5);
        node4.left = node3;
        node5.right = node5;
        System.out.println(isBalanced(node4));
    }
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left-right) >1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
    private static int helper(TreeNode node){
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        return Math.max(left, right)+1;
    }
}