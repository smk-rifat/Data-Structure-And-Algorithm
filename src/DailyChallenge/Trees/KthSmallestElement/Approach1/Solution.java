package DailyChallenge.Trees.KthSmallestElement.Approach1;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(){}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public int kthSmallest(TreeNode root, int k){
        List<Integer> list = new ArrayList<>();
        int level = 0;
        traverse(root, list, level);
        return list.get(k-1);
    }
    private void traverse(TreeNode node, List<Integer> list, int level){
        if (node == null) {
            return;
        }
        list.add(list.size()-level-1);
        traverse(node.left, list, level+1);
        traverse(node.right, list, level+1);
    }
}
