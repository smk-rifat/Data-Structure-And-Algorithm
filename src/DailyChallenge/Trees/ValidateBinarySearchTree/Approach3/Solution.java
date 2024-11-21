package DailyChallenge.Trees.ValidateBinarySearchTree.Approach3;
class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.right = right;
        this.left = left;
    }
}
class Solution {
    public boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }
    private boolean isValidBST(TreeNode node, Integer min, Integer max){
        if (node == null)return true;
        if ((min != null && node.val <= min)|| (max != null && node.val >= max))return false;    
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
