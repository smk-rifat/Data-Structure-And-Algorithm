package DailyChallenge.DP.LongestBitonicSubsequence.BruteForce;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
class Solution {
    public static int LongestBitonicSequence(int n, int[] arr) {
        if (n <= 1)
            return 1;
        int[] LIS = new int[n];
        int[] LDS = new int[n];

        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && LIS[j] + 1 > LIS[i]) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && LDS[j] + 1 > LDS[i]) {
                    LDS[i] = LDS[j] + 1;
                }
            }
        }

        int maxBitonic = 0;

        for (int i = 0; i < n; i++) {
            if (LDS[i] > 1 && LIS[i] > 1) {
                maxBitonic = Math.max(maxBitonic, LDS[i] + LIS[i] - 1);
            }
        }
        return maxBitonic;
    }
}
