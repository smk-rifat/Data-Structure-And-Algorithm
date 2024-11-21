package DailyChallenge.Graph.NetworkDelayTime.Approach_2;

import java.util.*;

class Solution {
    Map<Integer, List<Node>> map = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        for(int[] edge : times){
            int s = edge[0], d = edge[1], w = edge[2];
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(new Node(w,d));
        }
        Comparator<Node> comp = new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2){
                return Integer.compare(n1.weight, n2.weight);
            }
        };
        for(List<Node> nodes : map.values()){
            nodes.sort(comp);
        }
        int[] destination = new int[n+1];
        Arrays.fill(destination, 1, destination.length, Integer.MAX_VALUE);
        dfs(destination, k, 0);
        int max = 0;
        for (int i = 1; i < destination.length; i++) {
            if (destination[i] != Integer.MAX_VALUE){
                max = Math.max(max, destination[i]);
            } else return -1;
        }

        return max;
    }
    private void dfs(int[] destination, int currentNode, int currentTime){
        if (destination[currentNode] <= currentTime) return;
        destination[currentNode] = currentTime;

        if (map.containsKey(currentNode)){
            for(Node neighbor : map.get(currentNode)){
                dfs(destination, neighbor.target, currentTime+neighbor.weight);
            }
        }
    }
}
class Node{
    int weight;
    int target;
    Node(int weight, int target){
        this.target = target;
        this.weight = weight;
    }
}
