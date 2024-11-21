package DailyChallenge.Trees.AverageOfLevelBT.Approach2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 public List<Double> averageOfLevels(TreeNode root){
    List<Double> ans = new ArrayList<>();
    if (root == null) {
        return ans;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) { // max N , where N is the number of nodes
        Double average = 0.0;
        int levelSize = queue.size();
        for (int i = 0; i < levelSize; i++) { // max comparison L where L is the size of the level which is last level
            TreeNode node = queue.poll();
            average += node.val;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        ans.add(average/levelSize); // also max L
    }
    return ans;
 }  
}
// O(N.(2L)) = O(NL)
// space O(N)