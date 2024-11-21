package DailyChallenge.Graph.RedundantConnection.Approach_1;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/redundant-connection/
class Solution {
    List<Integer> parent;
    List<Integer> rank;
    public int[] findRedundantConnection(int[][] edges) {
         parent = new ArrayList<>();
         rank = new ArrayList<>();
         int n = edges.length;

        for (int i = 1; i <= n; i++) {
            parent.add(i);
            rank.add(0);
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            if (!unionByRank(node1, node2, parent, rank)) {
                return edge;
            }
        }

        return edges[0];
    }
    public int findParent (int node){
        if (node == parent.get(node)){
            return node;
        }

        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);

        return ultimateParent;
    }
    public boolean unionByRank(int node1, int node2, List<Integer> parent, List<Integer> rank){
        int rootNode1 = findParent(node1);
        int rootNode2 = findParent(node2);

        if (rootNode1 == rootNode2) return false;

        if (rank.get(rootNode1) < rank.get(rootNode2)){
            parent.set(rootNode1, rootNode2);
        } else if(rank.get(rootNode1) > rank.get(rootNode2)){
            parent.set(rootNode2, rootNode1);
        } else {
            parent.set(rootNode1, rootNode2);
            rank.set(rootNode2, rank.get(rootNode2)+1);
        }

        return true;
    }
}