package DailyChallenge.Trees.FlattenBinaryTreeToLinkedList.Approach3;
import java.util.LinkedList;
import java.util.Queue;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
class Solution {
    public void flatten(TreeNode root){
         if (root == null) {
            return;
         }
         Queue<TreeNode> nodes = new LinkedList<>();
         preOrder(nodes, root);
         while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            node.right = nodes.peek();
            node.left = null;
         }
    }
    private void preOrder(Queue<TreeNode> nodes, TreeNode node){
        if(node == null) return;
        nodes.add(node);
        preOrder(nodes, node.left);
        preOrder(nodes, node.right);
    }
}
