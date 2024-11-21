package DailyChallenge.Graph.CloneGraph.Approach_2;

import java.util.*;

class Node{
    public int val;
    public List<Node> neighbors;
    public Node(){}
    public Node(int val){
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
    public Node(int val, ArrayList<Node> neighbours){
        this.val = val;
        this.neighbors = neighbours;
    }
}
class Solution {
    public Node cloneGraph(Node node){
       if(node == null) return null;
       HashMap<Node, Node> map = new HashMap<>();
       Node newNode = new Node(node.val, new ArrayList<>());
       Queue<Node> queue = new LinkedList<>();
       map.put(node, newNode);
       queue.offer(node);

       while (!queue.isEmpty()){
           Node cur = queue.poll();

           for (Node neighbor : cur.neighbors){
               if (!map.containsKey(neighbor)){
                   Node temp = new Node(neighbor.val, new ArrayList<>());
                   queue.offer(neighbor);
                   map.put(neighbor, temp);
               }
               map.get(cur).neighbors.add(map.get(neighbor));
           }
       }
       return newNode;
    }
}
