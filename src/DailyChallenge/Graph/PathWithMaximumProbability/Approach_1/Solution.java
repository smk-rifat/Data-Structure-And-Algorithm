package DailyChallenge.Graph.PathWithMaximumProbability.Approach_1;

import java.util.*;

// https://leetcode.com/problems/path-with-maximum-probability/
class Solution {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer , List<Node>> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0];
            int t = edges[i][1];
            double w = succProb[i];
            map.putIfAbsent(s, new ArrayList<>());
            map.putIfAbsent(t, new ArrayList<>());
            map.get(s).add(new Node(t, w));
            map.get(t).add( new Node(s, w));
        }
        double[] distance = new double[n];
        Arrays.fill(distance,0, distance.length, 0);
        distance[start_node] = 1.0;

        Comparator<Node> comp = (n1, n2) -> Double.compare(n2.weight, n1.weight);
        Queue<Node> queue = new PriorityQueue<>(comp);
        queue.offer(new Node(start_node, 1.0));
        Set<Integer> processed = new HashSet<>();

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int n1 = node.node;
            double w1 = node.weight;
            if (n1 == end_node) return w1;
            if (processed.contains(n1)) continue;
            processed.add(n1);

            if (map.containsKey(n1)){
                for(Node neighbor : map.get(n1)){
                    int n2 = neighbor.node;
                    double w2 = neighbor.weight;

                    if (distance[n2] < w1*w2){
                        distance[n2] = w1*w2;
                        queue.add(new Node(n2, w1*w2));
                    }
                }
            }
        }

        return 0.0;
    }

}
class Node{
    int node;
    double weight;
    Node(int node , double weight){
        this.node = node;
        this.weight = weight;
    }
}