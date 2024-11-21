package DailyChallenge.Trees.BinaryTreeLevelOrderTraversal.Approach2;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
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
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        int level = 0;
        traverse(root, result, level);
        return result;
    }
    private void traverse(TreeNode node, List<List<Integer>> levels, int level){
        if(node == null) return;
        if (levels.size() == level){
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.val);
        traverse(node.left, levels, level+1);
        traverse(node.right, levels, level+1);
    }
}
