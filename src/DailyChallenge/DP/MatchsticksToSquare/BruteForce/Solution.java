package DailyChallenge.DP.MatchsticksToSquare.BruteForce;
// https://leetcode.com/problems/matchsticks-to-square/

import java.util.Arrays;

class Solution {
    int target;
    int n;
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
        boolean[] isTaken = new boolean[n];

        return helper(matchsticks, 0, 4, 0, isTaken);
    }

    public boolean helper(int[] sticks, int idx, int k, int curSum, boolean[] isTaken) {
        if (k == 0)
            return true;
        if (curSum == target)
            return helper(sticks, 0, k - 1, 0, isTaken);
        
        for (int i = idx; i < n; i++) {
            if ((i > 0 && !isTaken[i - 1] && sticks[i - 1] == sticks[i]) || (isTaken[i] || curSum + sticks[i] > target))
                continue;
           
            isTaken[i] = true;
            if (helper(sticks, idx + 1, k, curSum + sticks[i], isTaken))
                return true;
            isTaken[i] = false;
        }
        
        return false;
    }
    public void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
