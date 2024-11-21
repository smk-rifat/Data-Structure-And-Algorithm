package DailyChallenge.Trees.SerializeandDeserializeBinaryTree.Approach2;

import DailyChallenge.Trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        helper1(root, sb);
        return sb.toString();
    }
    private void helper1(TreeNode node, StringBuilder sb){
        if (node == null) {
            sb.append("null").append(",");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
           TreeNode temp = queue.poll();
           if (temp == null){
               sb.append("null").append(",");
               continue;
           }
           sb.append(temp.val).append(",");
           queue.offer(temp.left);
           queue.offer(temp.right);
        }
    }
    public TreeNode deserialize(String data){
         if(data == null || data.isEmpty()) return null;
         Queue<TreeNode> queue = new LinkedList<>();
         String[] array = data.split(",");
         if (array[0].equals("null")) return null;
         TreeNode rootNode = new TreeNode(Integer.parseInt(array[0]));
        queue.offer(rootNode);
        for (int i = 1; i < array.length; i++) {
            TreeNode parent = queue.poll();
            if (!array[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(array[i]));
                parent.left = left;
                queue.offer(left);
            }
            if (!array[++i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(array[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return rootNode;
    }

}
