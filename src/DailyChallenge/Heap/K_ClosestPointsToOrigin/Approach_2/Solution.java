package DailyChallenge.Heap.K_ClosestPointsToOrigin.Approach_2;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<Node> queue = new PriorityQueue<>(new Helper());
        for(int[] point : points){
            Node node = new Node(point[0], point[1], distance(point));
            queue.add(node);
        }
        for (int i = 0; i < ans.length && !queue.isEmpty(); i++) {
            Node node = queue.poll();
            ans[i][0] = node.x;
            ans[i][1] = node.y;
        }
        return ans;
    }
    public int distance(int[] point){
        return (point[0]*point[0]) + (point[1]*point[1]);
    }

}
class Helper implements Comparator<Node>{
    @Override
    public int compare(Node o1, Node o2) {
        return Integer.compare(o1.dis, o2.dis);
    }
}
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
