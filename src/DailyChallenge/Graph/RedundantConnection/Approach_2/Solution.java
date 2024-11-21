package DailyChallenge.Graph.RedundantConnection.Approach_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/redundant-connection/
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
       Map<Integer, List<Integer>> graph = new HashMap<>();
       for(int[] edge : edges){
           int p = edge[0];
           int c = edge[1];

           graph.putIfAbsent(p, new ArrayList<>());
           graph.putIfAbsent(c, new ArrayList<>());

       }

       for (int[] edge : edges){
           int node1 = edge[0];
           int node2 = edge[1];

           boolean[] visited = new boolean[edges.length+1];

           if (isCycle(graph, node1, node2, visited)){
               return edge;
           }

           graph.get(node1).add(node2);
           graph.get(node2).add(node1);
       }

       return new int[0];
    }
    public boolean isCycle(Map<Integer, List<Integer>> graph, int node1, int node2, boolean[] visited){
        if (node1 == node2) return true;
        visited[node1] = true;
        for(int neighbor : graph.get(node1)){
            if (!visited[neighbor]){
                if (isCycle(graph, neighbor, node2, visited)) return true;
            }
        }
        return false;
    }
}