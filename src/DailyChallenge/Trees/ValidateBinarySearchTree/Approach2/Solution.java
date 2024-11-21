package DailyChallenge.Trees.ValidateBinarySearchTree.Approach2;

import java.util.LinkedList;
import java.util.Queue;


class TreeNode{
    int val;
    TreeNode left, right;
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
    public boolean isValidBST(TreeNode root){
        if (root == null) {
            return true;
        }
        Queue<TreeNode> st = new LinkedList<>();
        inOrder(st, root);
        TreeNode pre = null;
        while(!st.isEmpty()){
            TreeNode node = st.poll();
            if (pre != null && node.val <= pre.val) {
                return false;
            }
            pre = node;
        }
        return true;
    }
    private void inOrder(Queue<TreeNode> nodes, TreeNode node){
        if(node == null) return;
        inOrder(nodes, node.left);
        nodes.add(node);
        inOrder(nodes, node.right);
    }
}
