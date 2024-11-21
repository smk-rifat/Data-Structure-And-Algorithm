package DailyChallenge.DP.TSP.BruteForce;

class Solution {
    int[][] cost;
    int n;

    public int total_cost(int[][] cost) {
        this.n = cost.length;
        this.cost = cost;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        return helper(0, 1, visited);
    }

    public int helper(int pos, int count, boolean[] visited) {
        if (count == n)
            return cost[pos][0];
        int minCost = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++) {
            if (!visited[city]) {
                visited[city] = true;
                int subProblem = cost[pos][city] + helper(city, count + 1, visited);
                minCost = Math.min(minCost, subProblem);
                visited[city] = false;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[][] cost = { { 0, 1000, 5000 }, { 5000, 0, 1000 },
                { 1000, 5000, 0 } };
        Solution obj = new Solution();
        System.out.println(obj.total_cost(cost));
    }
}
