package DailyChallenge.Trees.CheckIfThereIsARootToLeafPathWithGivensequence.Brute;
import DailyChallenge.Trees.TreeNode;
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        node2.left = node1;
        node2.right = node4;
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        node4.left = node6;
        node4.right = node8;
        int[] path = {5,2,4,8};
        System.out.println(isPathExist(root, path));
    }
    public static boolean isPathExist(TreeNode root, int[] path){
        int pathSequence = 0;
        for(int n : path){
            pathSequence = (pathSequence*10) + n;
        }
        int currentPath = 0;
        return isPathExist(root, pathSequence, currentPath);
    }
    private static boolean isPathExist(TreeNode node, int pathSequence, int currentPath){
        if (node == null) return true;
        currentPath = (currentPath*10) + node.val;

        if (node.left == null && node.right == null && currentPath == pathSequence) return true;

        boolean left = isPathExist(node.left, pathSequence, currentPath);
        boolean right = isPathExist(node.right, pathSequence, currentPath);
        return left || right;
    }
}
