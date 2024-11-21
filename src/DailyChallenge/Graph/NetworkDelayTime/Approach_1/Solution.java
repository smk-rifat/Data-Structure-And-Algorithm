package DailyChallenge.Graph.NetworkDelayTime.Approach_1;
// https://leetcode.com/problems/network-delay-time/description/

import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] edge : times){
            int src = edge[0], trgt = edge[1], w = edge[2];
            adj.putIfAbsent(src, new ArrayList<int[]>());
            adj.get(src).add(new int[]{trgt, w});
        }

        Map<Integer, Integer> distance = new HashMap<>();
        for (int i = 1; i <= n ; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
        distance.put(k, 0);

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[]{k,0});

        while (!minHeap.isEmpty()){
            int[] cur = minHeap.remove();
            int n1 = cur[0];
            int t1 = cur[1];

            if (distance.get(n1) < t1) continue;

            List<int[]> neighbors = adj.getOrDefault(n1, new ArrayList<>());
            for(int[] neighbor : neighbors){
                int n2 = neighbor[0];
                int t2 = neighbor[1];

                if (distance.get(n2) > t1+t2){
                    distance.put(n2, t1+t2);
                    minHeap.offer(new int[]{n2, t1+t2});
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <=n ; i++) {
            if (distance.get(i) != Integer.MAX_VALUE){
                max = Math.max(max, distance.get(i));
            } else return -1;
        }
        return max;
    }
}
