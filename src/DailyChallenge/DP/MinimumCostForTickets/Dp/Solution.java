package DailyChallenge.DP.MinimumCostForTickets.Dp;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length-1];
        int[] dp = new int[maxDay+1];
        Set<Integer> travelDay = new HashSet<>();
        for(int day : days){
            travelDay.add(day);
        }
        for (int day = 1; day <= maxDay; day++) {
            if (!travelDay.contains(day)){
                dp[day] = dp[day-1];
                continue;
            }
            int costPass1 = costs[0] + dp[day-1];
            int costPass7 = costs[1] + dp[Math.max(0, day -7)];
            int costPass30 = costs[2] + dp[Math.max(0, day - 30)];
            dp[day] = Math.min(costPass1, Math.min(costPass30, costPass7));
        }

        return dp[maxDay];
    }
}

