package DailyChallenge.DP.MatchsticksToSquare.Tabulation;

import java.util.Arrays;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        if (n < 4)
            return false;

        int sum = 0;
        for (int s : matchsticks) {
            sum += s;
        }

        int target = sum / 4;
        if (target * 4 != sum)
            return false;
        
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
      
        for (int mask = 0; mask < 1 << n; mask++) {
            if (dp[mask] == -1)
                continue;

            for (int i = 0; i < n; i++) {
                if (((mask) & (1 << i)) != 0)
                    continue;
                int newMask = mask | (1 << i);

                if (dp[mask] + matchsticks[i] <= target) {
                    dp[newMask] = (dp[mask] + matchsticks[i]) % target;
                }
            }
        }
        
        return dp[(1 << n) - 1] == 0;
    }

    public void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
