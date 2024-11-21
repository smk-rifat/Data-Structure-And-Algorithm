package DailyChallenge.Trees.ConstructBinaryTreeFromPreorderAndInorderTraversal.Approach1;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    public TreeNode buildTree(int[] preorder, int[] inorder){
       Map<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i < inorder.length; i++){
        map.put(inorder[i], i);
       }
       int root = 0;
       int left = 0;
       int right = inorder.length;
       return construct(map, root, left, right, preorder, inorder);
    }
    private TreeNode construct(Map<Integer, Integer> map, int root, int left, int right, int[] preorder, int[] inorder){
        if(left == right) return null;
        int rootIndex = map.get(preorder[root]);
        TreeNode rootNode = new TreeNode(preorder[root]);
        int leftSubTreeSize = rootIndex-left;
        rootNode.left = construct(map, root+1, left, rootIndex, preorder, inorder);
        rootNode.right = construct(map, root+leftSubTreeSize+1, rootIndex+1, right, preorder, inorder);
        return rootNode;
    }      
}
