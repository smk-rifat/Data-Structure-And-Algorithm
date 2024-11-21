package DailyChallenge.Trees.SymmetricTree.Approach1;// https://leetcode.com/problems/symmetric-tree/
import java.util.LinkedList;
import java.util.Queue;
class TreeNode{
  int val;
  TreeNode left, right;
  TreeNode(){}
  TreeNode(int val){ this. val = val;}
  TreeNode(int val , TreeNode left, TreeNode right){
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
class Solution1 {
  public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root.left);
    q.offer(root.right);
    while (!q.isEmpty()) {
        TreeNode left = q.poll();
        TreeNode right = q.poll();

        if (left == null && right == null) {
            continue;
        }
        if((left == null) ||(right == null) ||(left.val != right.val)) return false;
        q.offer(left.left);
        q.offer(right.right);
        q.offer(left.right);
        q.offer((right.left));
    }
    return true;
  }
}