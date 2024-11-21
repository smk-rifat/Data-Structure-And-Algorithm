package DailyChallenge.Trees.SymmetricTree.Approach2;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public boolean isSymmetric(TreeNode root){
        return traverse(root.left, root.right);
    }
    private boolean traverse(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if((left == null || right == null) ||(left.val != right.val)) return false;
        return traverse(left.left, right.right) && traverse(left.right, right.left);
    }
}
