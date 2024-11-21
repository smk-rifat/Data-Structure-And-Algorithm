package DailyChallenge.Trees.ValidateBinarySearchTree.Mandatory;
// implement inOrder Traversal
class TreeNode{
    int val;
    TreeNodE left, right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNodE left, TreeNodE right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 class Solution0 {
    public boolean isValidBST(TreeNodE root){
        Integer max = null;
        Integer min = null;
        return preOrder(root, min, max);
    }
    private boolean preOrder(TreeNodE node, Integer min, Integer max){
        if(node == null) return true;

        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        
        boolean left = preOrder(node.left, min, node.val);
        boolean right = preOrder(node.right, node.val, max);

        return left && right;
    }
}
