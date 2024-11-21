package DailyChallenge.DP.PartitionToK_EqualSumSubsets.Memoization;

import java.util.Arrays;

class Solution {

    int target;
    Boolean[] memo;

    public boolean canPartitionKSubsets(int[] arr, int k) {
        int n = arr.length;
        if (k > n)
            return false;

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        target = sum / k;
        if (target * k != sum)
            return false;

        memo = new Boolean[1 << n];
        Arrays.sort(arr);
        reverse(arr);

        return backtrack(arr, 0, k, 0, 0);
    }

    public boolean backtrack(int[] arr, int mask, int k, int curSum, int idx) {
        if (k == 0)
            return true;
        if (memo[mask] != null)
            return memo[mask];
        if (curSum == target)
            return backtrack(arr, mask, k - 1, 0, 0);
        
        for (int i = idx; i < arr.length; i++) {
            if (((mask) & (1 << i)) != 0)
                continue;
            if (curSum + arr[i] > target)
                continue;
            if (backtrack(arr, mask | (1 << i), k, curSum + arr[i], idx + 1)) {
                memo[mask] = true;
                return true;
            }
        }

        memo[mask] = false;
        return memo[mask];
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
