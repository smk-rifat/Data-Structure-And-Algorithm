package DailyChallenge.Trees.KthSmallestElement.Approach2;
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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k);
    }
    public int helper(TreeNode node, int k) {
      if (node == null) {
        return 0;
      }
      int left = helper(node.left, k);
      if (left != 0) {
        return left;
      }

      count++;
      if (count == k) {
        return node.val;
      }
      return helper(node.right, k);
    }
}
