package DailyChallenge.Graph.CloneGraph.Approach_1;
// https://leetcode.com/problems/clone-graph/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
class Solution {
    HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node){
      if (node == null) return null;
      if (map.containsKey(node.val)) return map.get(node.val);
      Node newNode = new Node(node.val, new ArrayList<>());
      for(Node neighbour : node.neighbors){
          newNode.neighbors.add(cloneGraph(neighbour));
      }
      return newNode;
    }
}
