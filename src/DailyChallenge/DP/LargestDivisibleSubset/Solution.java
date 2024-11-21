package DailyChallenge.DP.LargestDivisibleSubset;
// https://leetcode.com/problems/largest-divisible-subset/

import java.util.*;
class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;

        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIndex = 0;
        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (maxIndex != -1) {
            ans.add(arr[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        Collections.reverse(ans);
        
        return ans;
    }
}
