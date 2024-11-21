package DailyChallenge.Trees.CountGoodNodesInBinaryTree.Approach1;
// https://leetcode.com/problems/count-good-nodes-in-binary-tree/
import DailyChallenge.Trees.TreeNode;
class Solution {
    int ans = 0;
    public int goodNodes(TreeNode root) {
        int maxSoFar = root.val;
        goodNumbers(root, maxSoFar);
        return ans;
    }
    private void goodNumbers(TreeNode node, int maxSoFar){
        if (node == null) return;
        if (maxSoFar <= node.val){
            ans++;
            maxSoFar = node.val;
        }
        goodNumbers(node.left, maxSoFar);
        goodNumbers(node.right, maxSoFar);
    }
}