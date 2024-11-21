package DailyChallenge.Trees.SerializeandDeserializeBinaryTree.Approach1;
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
import DailyChallenge.Trees.TreeNode;
public class Codec {
    int index = 0;
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper1(root, sb);
        return sb.toString();
    }
    private void helper1(TreeNode node, StringBuilder sb){
        if (node == null){
            sb.append("null").append(",");
            return;
        }
        sb.append(node.val).append(",");
        helper1(node.left, sb);
        helper1(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data){
       String[] array = data.split(",");
       return helper2(array);
    }
    private TreeNode helper2(String[] arr){
        if (index >= arr.length || arr[index].equals("null")){
            index++;
            return null;
        }
        int val = Integer.parseInt(arr[index++]);
        TreeNode node = new TreeNode(val);
        node.left = helper2(arr);
        node.right = helper2(arr);
        return node;
    }
}
