package DailyChallenge.DP.MatchsticksToSquare.Approach_2;

import java.util.Arrays;

class Solution {
    int n;
    int target;
    Boolean[] memo;
    public boolean makesquare(int[] matchsticks) {
        n = matchsticks.length;
        if (n < 4)
            return false;

        int sum = 0;
        for (int m : matchsticks) {
            sum += m;
        }

        target = sum / 4;
        if (target * 4 != sum)
            return false;

        Arrays.sort(matchsticks);
        reverse(matchsticks);
        memo = new Boolean[1 << n];

        return memoization(matchsticks, 0, 4, 0, 0);
    }

    public boolean memoization(int[] sticks, int idx, int k, int curSum, int mask) {
        if (k == 0)
            return true;
        if (curSum == target)
            return memoization(sticks, 0, k - 1, 0, mask);
        if (memo[mask] != null)
            return memo[mask];
        
        for (int i = idx; i < n; i++) {
            if ((mask & (1 << i)) != 0)
                continue;
            if (curSum + sticks[i] > target)
                continue;
            if (memoization(sticks, i + 1, k, curSum + sticks[i], mask | (1 << i))) {
                memo[mask] = true;
                return true;
            }
        }

        memo[mask] = false;
        return false;
    }
    public void reverse(int[] sticks) {
        int left = 0;
        int right = sticks.length - 1;

        while (left < right) {
            int temp = sticks[left];
            sticks[left] = sticks[right];
            sticks[right] = temp;
            left++;
            right--;
        }
    }
}
