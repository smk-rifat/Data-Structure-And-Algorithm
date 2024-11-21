package DailyChallenge.DP.MinimumCostForTickets.Memoization;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Integer[] memo = new Integer[days.length];
        return memoization(days, costs, 0, memo);
    }
    public int memoization(int[] days, int[] cost, int idx, Integer[] memo){
        if (idx >= days.length) return 0;
        if(memo[idx] != null) return memo[idx];

        int pass1 = cost[0] + memoization(days, cost, idx+1, memo);

        int nextIdx = idx;

        while(nextIdx < days.length && days[nextIdx] < days[idx] + 7){
            nextIdx++;
        }

        int pass7 = cost[1] + memoization(days, cost, nextIdx, memo);

        nextIdx = idx;
        while(nextIdx < days.length && days[nextIdx] < days[idx] + 30){
            nextIdx++;
        }

        int pass30 = cost[2] + memoization(days, cost, nextIdx, memo);

        memo[idx] = Math.min(pass7,Math.min(pass1, pass30));
        return memo[idx];
    }
}