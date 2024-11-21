package DailyChallenge.Trees.BinaryTreeRightSideView.Approach1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// https://leetcode.com/problems/binary-tree-right-side-view/
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) q.offer(node.right);
                if (i == levelSize-1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }
}
