package DailyChallenge.DP.NumberOfSubsequencesThatSatisfyTheGivenSumCondition.TwoPointer;

import java.util.Arrays;

class Solution {
    int MOD = 1000000007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0;

        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                ans += pow[right - left] % MOD;
                left++;
            } else {
                right++;
            }
        }

        return (int) ans;
    }
    // follow up: print all the subsequence that meets up the given condition;
}
