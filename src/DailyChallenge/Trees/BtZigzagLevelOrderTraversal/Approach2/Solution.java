package DailyChallenge.Trees.BtZigzagLevelOrderTraversal.Approach2;

import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        int level = 0;
        bfs(root, level, result);
        return result;
    }
    private void bfs(TreeNode node, int level, List<List<Integer>> result){
        if (node == null) return;
        if (result.size() == level){
            result.add(new ArrayList<>());
        }
        if (level % 2 == 0){
            result.get(level).addFirst(node.val);
        } else {
            result.get(level).add(node.val);
        }
        bfs(node.left, level+1, result);
        bfs(node.right, level+1, result);
    }
}
