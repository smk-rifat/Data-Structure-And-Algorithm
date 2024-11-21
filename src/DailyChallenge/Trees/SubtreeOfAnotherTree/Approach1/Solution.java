package DailyChallenge.Trees.SubtreeOfAnotherTree.Approach1;
// leetcode.com/problems/subtree-of-another-tree/
import DailyChallenge.Trees.TreeNode;

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        String main = sb.toString();
        sb = new StringBuilder();
        preOrder(subRoot, sb);
        String subTree = sb.toString();
        return main.contains(subTree);
    }
    private void preOrder(TreeNode node, StringBuilder sb){
        if (node == null) {
            sb.append("null");
            return;
        }
        sb.append(",").append(node.val);
        preOrder(node.left,sb);
        preOrder(node.right, sb);
    }
}