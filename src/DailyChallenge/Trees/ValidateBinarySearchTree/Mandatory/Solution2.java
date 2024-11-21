package DailyChallenge.Trees.ValidateBinarySearchTree.Mandatory;
// implement postOrder traversal

 class Solution2 {
    public boolean isValidBST(TreeNodE root){
        return postOrder(root, null, null);
    }
    private boolean postOrder(TreeNodE node, Integer min, Integer max){
        if(node == null) return true;

        boolean left = postOrder(node.left, min, node.val);
        boolean right = postOrder(node.right, node.val, max);

        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }

        return left && right;
    }
}
