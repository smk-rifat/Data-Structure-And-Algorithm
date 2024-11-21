package DailyChallenge.Graph.MinCostToConnectAllPoints.Approach_2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minCostConnectPoints(int[][] points){
        Comparator<Edge> comp = new Comparator<Edge>(){
            @Override
            public int compare(Edge e1, Edge e2){
                return Integer.compare(e1.cost, e2.cost);
            }
        };
        Queue<Edge> queue = new PriorityQueue<Edge>(comp);
        int n = points.length;
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                queue.offer( new Edge(i,j, cost));
            }
        }

        int minCost = 0;
        int edgeUsed = 0;

        while (!queue.isEmpty() && edgeUsed < n-1){
            Edge edge = queue.poll();

            if (ds.uninionByRank(edge.point1, edge.point2)){
                minCost += edge.cost;
                edgeUsed++;
            }
        }
        return minCost;
    }

}
class Edge{
    int point1;
    int point2;
    int cost;
    Edge(int point1, int point2, int cost){
        this.point1 = point1;
        this.point2 = point2;
        this.cost = cost;
    }
}
class DisjointSet{
    int[] rank;
    int[] parent;

    DisjointSet(int n){
        rank = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int node){
        if (node == parent[node]) return node;
        int ulp = findParent(parent[node]);
        parent[node] = ulp;
        return parent[node];
    }

    public boolean uninionByRank(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v) return false;

        if (rank[ulp_u] < rank[ulp_v]){
            parent[ulp_u] = ulp_v;
        } else if (rank[ulp_u] > rank[ulp_v]) {
            parent[ulp_v] = ulp_u;
        } else{
            parent[ulp_u] = ulp_v;
            rank[ulp_v] ++;
        }
        return true;
    }
}
