package DailyChallenge.Trees.BtZigzagLevelOrderTraversal.Approach1;

import java.util.*;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        boolean reverseOrder = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> cLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);

                if (reverseOrder){
                    cLevel.addFirst(node.val);
                } else {
                    cLevel.add(node.val);
                }
            }
            result.add(cLevel);
            reverseOrder = !reverseOrder;
        }
        return result;
    }
}