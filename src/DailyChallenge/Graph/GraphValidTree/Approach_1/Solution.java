package DailyChallenge.Graph.GraphValidTree.Approach_1;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        for(int[] neighbor : edges){
            int p = neighbor[0];
            int c = neighbor[1];
            map.putIfAbsent(p, new ArrayList<>());
            map.putIfAbsent(c, new ArrayList<>());

            map.get(p).add(c);
            map.get(c).add(p);
        }
        if (hasCycle(map, 0, visited, -1)) return false;
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                return false;
            }
        }
        return true;
    }
    public boolean hasCycle(Map<Integer, List<Integer>> adj, int currentNode, boolean[] visited, int parent){
        visited[currentNode] = true;
        for(int neighbor : adj.get(currentNode)){
            if (visited[neighbor] && neighbor != parent) return true;
            if (!visited[neighbor] && hasCycle(adj, neighbor, visited, currentNode)) return true;
        }
        return false;
    }
}

