package DailyChallenge.Heap.K_ClosestPointsToOrigin.BruteForce;

import java.util.*;
class Node{
    int x;
    int y;
    int dis;
    Node(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
class Solution {
    public  int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        HashMap<Node, Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        int idx = 0;
        for (int[] point : points){
            Node node = new Node(point[0], point[1], distance(point));
            list.add(node);
            map.put(node, idx);
            idx++;
        }
        Comparator<Node> com = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dis - o2.dis;
            }
        };
        list.sort(com);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = points[map.get(list.removeFirst())];
        }
        return ans;
    }
    public int distance(int[] point){
        int a = point[0] * point[0];
        int b = point[1] * point[1];
        return (a+b);
    }
}