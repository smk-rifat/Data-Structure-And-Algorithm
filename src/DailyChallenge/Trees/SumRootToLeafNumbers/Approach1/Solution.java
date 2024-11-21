package DailyChallenge.Trees.SumRootToLeafNumbers.Approach1;
// https://leetcode.com/problems/sum-root-to-leaf-numbers/
import DailyChallenge.Trees.TreeNode;
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root){
        sumNumbers(root, 0);
        return sum;
    }
    private void sumNumbers(TreeNode node, int pathSum){
        if(node == null) return;
        pathSum = (pathSum*10) + node.val;

        if (node.left == null && node.right == null){
            sum += pathSum;
            return;
        }
        sumNumbers(node.left, pathSum);
        sumNumbers(node.right, pathSum);
    }
}