package DailyChallenge.DP.PartitionToK_EqualSumSubsets.Tabulation;

import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int n = arr.length;
        if (k > n)
            return false;

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        int target = sum / k;

        if (target * k != sum)
            return false;

        Arrays.sort(arr);
        reverse(arr);

        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == -1)
                continue;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0)
                    continue;

                int newMask = mask | (1 << i);

                if (dp[mask] + arr[i] <= target) {
                    dp[newMask] = (dp[mask] + arr[i]) % target;
                }
            }
        }
        return dp[(1 << n) - 1] == 0;
    }

    private void reverse(int[] arr) {
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
