package DailyChallenge.Trees.CheckIfThereIsARootToLeafPathWithGivensequence.DFS;
import DailyChallenge.Trees.TreeNode;
public class Solution {
    public static void main(String[] args) {

    }
    public static boolean isExist(TreeNode node, int[] path, int index){
        if (node == null) return false;
        if (index >= path.length || node.val != path[index]) return false;
        if (node.left == null && node.right == null && index == path.length-1 && node.val == path[index]) return true;
        return  (node.val == path[index]) && (isExist(node.left, path, index+1) || isExist(node.right, path, index+1));
    }
}
