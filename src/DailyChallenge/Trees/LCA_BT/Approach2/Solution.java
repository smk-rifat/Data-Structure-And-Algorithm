package DailyChallenge.Trees.LCA_BT.Approach2;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
class TreeNode{
    int val;
    TreeNode left, right;
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     Map<TreeNode , TreeNode> parent = new HashMap<>();
     Queue<TreeNode> queue = new LinkedList<>();
     parent.put(root, null);
     queue.add(root);

     while ((!parent.containsKey(q)) || (!parent.containsKey(p))) {
        TreeNode node = queue.poll();

        if (node != null) {
            parent.put(node.left, node);
            parent.put(node.right, node);
            queue.add(node.left);
            queue.add(node.right);
        }
     }

     Set<TreeNode> st = new HashSet<>();

     while (p != null) {
        st.add(p);
        p = parent.get(p);
     }

     while (!st.contains(q)) {
        q = parent.get(q);
     }
     return q;
  }
  }
