package DailyChallenge.Trees.BtZigzagLevelOrderTraversal.Approach3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(){}
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        boolean reverse = false;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> cLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node;
                if (!reverse){
                    node = deque.pollFirst();
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                } else {
                    node = deque.pollLast();
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);

                }
                cLevel.add(node.val);
            }
            reverse = !reverse;
            result.add(cLevel);
        }
        return result;
    }
}
