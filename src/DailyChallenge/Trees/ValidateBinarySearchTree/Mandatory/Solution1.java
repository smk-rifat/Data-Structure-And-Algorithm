package DailyChallenge.Trees.ValidateBinarySearchTree.Mandatory;

// implement preOrder traversal 
class TreeNodE {
    int val;
    TreeNodE left, right;
    TreeNodE(){}
    TreeNodE(int val){
        this.val = val;
    }
    TreeNodE(int val, TreeNodE left, TreeNodE right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 class Solution1 {
    public boolean isValidBST(TreeNodE root){
        Integer preV = null;
        return inOrderTraversal(root, preV);
    }

    private boolean inOrderTraversal(TreeNodE node, Integer preV) {
        if (node == null)
            return true;

        boolean leftTree = inOrderTraversal(node.left, preV);

        if (preV != null && node.val <= preV) {
            return false;
        }
        preV = node.val;
        boolean rightTree = inOrderTraversal(node.right, preV);

        return leftTree && rightTree;
    }
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}
