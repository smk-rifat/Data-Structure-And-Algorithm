package DailyChallenge.Trees.LCA_BT.Approach1;
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
    }
}
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        return  traverse(root, p ,  q);
    }
    private TreeNode traverse(TreeNode node, TreeNode a, TreeNode b){
        if (node.val == a.val || node.val == b.val) {
            return node;
        }
        TreeNode left = lowestCommonAncestor(node.left, a, b);
        TreeNode right = lowestCommonAncestor(node.right, a, b);

        if ((left != null && (left.val == a.val || left.val == b.val)) && (right != null &&(right.val == a.val || right.val == b.val))) {
            return node;
        }
        return left == null? right: left;
    }
}
