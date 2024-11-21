package DailyChallenge.Trees.AverageOfLevelBT.Approach1;
import java.util.ArrayList;
// https://leetcode.com/problems/average-of-levels-in-binary-tree/
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> avg = new ArrayList<>();
        List<Double> ans = new ArrayList<>();
        int level = 0;
        traverse(root, avg, level);
        for (int i = 0; i < avg.size(); i++) { // logN times
            ans.add(average(avg.get(i)));
        }
        return ans;
    }
    private static Double average(List<Integer> list){
        Double ans = 0.0;
        for(int n : list){
            ans += n;
        }
        return ans/list.size();
    }
    private static void traverse(TreeNode node, List<List<Integer>> avg, int level){
        if (node == null) return;
        if (avg.size() == level){
            avg.add(new ArrayList<>());
        }
        avg.get(level).add(node.val);
        traverse(node.left, avg, level+1);
        traverse(node.right, avg, level+1);
    }
    /*
     * TC-> O(N)
     */

}
