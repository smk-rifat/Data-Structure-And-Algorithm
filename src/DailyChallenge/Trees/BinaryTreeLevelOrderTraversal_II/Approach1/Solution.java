package DailyChallenge.Trees.BinaryTreeLevelOrderTraversal_II.Approach1;
//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left, right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> cLevel = new ArrayList<>();
            for (int i = 0; i <levelSize ; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                cLevel.add(node.val);
            }
            result.addFirst(cLevel);
        }
        return result;
    }
}