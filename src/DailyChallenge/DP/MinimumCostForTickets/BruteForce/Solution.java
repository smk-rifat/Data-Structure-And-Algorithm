package DailyChallenge.DP.MinimumCostForTickets.BruteForce;
// https://leetcode.com/problems/minimum-cost-for-tickets/
class Solution {
    public int mincostTickets(int[] travelDays, int[] ticketCosts) {
        return bruteForce(travelDays, ticketCosts, 0);
    }
    public int bruteForce(int[] days, int[] cost, int idx){
        if (idx == days.length) return 0;

        int pass1 = cost[0]+ bruteForce(days, cost, idx+1);

        int nextIdx = idx;

        while (nextIdx < days.length && days[nextIdx] < days[idx]+7) {
            nextIdx++;
        }

        int pass7 = cost[1]+ bruteForce(days, cost, nextIdx);

        nextIdx = idx;
        while (nextIdx < days.length && days[nextIdx] < days[idx] + 30) {
            nextIdx++;
        }

        int pass30 = cost[2] + bruteForce(days, cost, nextIdx);

        return Math.min(pass1, Math.min(pass7, pass30));
    }
}
