package DailyChallenge.Trees.CousinsBinaryTree.Approcah1;
// https://leetcode.com/problems/cousins-in-binary-tree/
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
    public boolean isCousins(TreeNode root, int x, int y){
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        int levelX = level(root, xx, 0);
        int levelY = level(root, yy, 0);

        if ((levelX == levelY) && (!isSiblings(root, xx, yy))) {
            return true;
        }
        return false;
    }
    private TreeNode findNode(TreeNode node, int x){
        if (node == null) {
            return null;
        }
        if (node.val == x) {
            return node;
        }

        TreeNode leftSide = findNode(node.left, x);
        TreeNode rightSide = findNode(node.right, x);

        if(leftSide != null) return leftSide;
        else return rightSide;
    }
    private int level(TreeNode node, TreeNode x, int level){
        if(node == null) return 0;
        if (node == x) {
            return level;
        }
        int l = level(node.left, x, level+1);
        int r = level(node.right, x, level+1);
        return l != 0 ? l : r;
    }
    private boolean isSiblings(TreeNode node, TreeNode x, TreeNode y){
           if (node == null) {
            return false;
           }
           if ((node.left == x && node.right == y) || (node.left == y && node.right == x)){
             return true;
           }
           return isSiblings(node.left, x, y) || isSiblings(node.right, x, y) ;
    }
}
