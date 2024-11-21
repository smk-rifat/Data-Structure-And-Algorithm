package DailyChallenge.Trees.BalancedBinaryTree.Approach2;
import DailyChallenge.Trees.TreeNode;
public class Solution {
    public boolean isBalance(TreeNode root){
        if (root == null) return true;
        return height(root) != -1;
    }
    public int height(TreeNode node){
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        if (left == -1 || right == -1 || Math.abs(left - right) >1) return -1;
        return Math.max(left, right) + 1;
    }
}
