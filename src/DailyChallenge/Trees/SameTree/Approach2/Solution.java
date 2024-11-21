package DailyChallenge.Trees.SameTree.Approach2;
import DailyChallenge.Trees.TreeNode;
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        preOrder(p, sb1);
        preOrder(q, sb2);
        return sb1.toString().contentEquals(sb2);
    }
    private void preOrder(TreeNode node, StringBuilder sb){
        if (node == null){
            sb.append("N");
            return;
        }
        sb.append(node.val);
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }
}
