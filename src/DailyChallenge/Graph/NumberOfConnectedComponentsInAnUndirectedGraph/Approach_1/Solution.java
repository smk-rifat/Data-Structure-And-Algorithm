package DailyChallenge.Graph.NumberOfConnectedComponentsInAnUndirectedGraph.Approach_1;
// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for(int[] neighbor : edges){
            int p = neighbor[0];
            int c = neighbor[1];
            map.putIfAbsent(p, new ArrayList<>());
            map.putIfAbsent(c, new ArrayList<>());

            map.get(p).add(c);
            map.get(c).add(p);
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                count++;
                connect(map, i, -1, visited);
            }
        }
        return count;
    }
    public void connect(Map<Integer, List<Integer>> map, int currentNode, int parent, boolean[] visited){
        visited[currentNode] = true;
        for(int neighbor : map.get(currentNode)){
            if (visited[neighbor] && parent == neighbor){
                continue;
            }
            if (!visited[neighbor]){
                connect(map, neighbor, currentNode, visited);
            }
        }
    }
}