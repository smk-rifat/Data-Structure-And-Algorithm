package DailyChallenge.DP.LastStoneWeightII.Approach_4;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for(int s : stones){
            totalSum += s;
        }
        int target = totalSum/2;
        int[] dp = new int[target +1];

        for(int stone : stones){
            for (int i = target; i >= stone ; i--) {
                dp[i] = Math.max(dp[i], dp[i- stone] + stone);
            }
        }
        int sum1 = dp[target];
        int sum2 = totalSum - sum1;
        return Math.abs(sum1 - sum2);
    }
}