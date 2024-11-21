package DailyChallenge.Graph.MinCostToConnectAllPoints.Approach_1;
// https://leetcode.com/problems/min-cost-to-connect-all-points/


import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0,0}); // that's mean we are starting from 0 weight and index 0 of given points array
        int edges = 0;
        int cost = 0;

        while(edges < n){
            int[] cur = queue.poll();
            int weight = cur[0];
            int nodeIndex = cur[1];

            if (visited[nodeIndex]) continue;
            visited[nodeIndex] = true;
            cost += weight;
            edges++;

            for (int i = 0; i < n; i++) {
                if (!visited[i]){
                    int dis = distance(points[nodeIndex], points[i]);
                    queue.offer(new int[]{dis, i});
                }
            }
        }

        return cost;
    }
    public int distance(int[] point1, int[] point2){
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}
