package DailyChallenge.DP.MCM.Dp;

import java.util.Arrays;

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp = new int[N][N];

        for (int i = 1; i < N; i++) {
            dp[i][i] = 0;
        }

        for (int L = 2; L < N; L++) {
            for (int i = 1; i <= N - L; i++) {
                int j = i + L -1;

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int temp = dp[i][k] + dp[k+1][j] + (arr[i-1] * arr[k] * arr[j]);
                    dp[i][j] = Math.min(temp, dp[i][j]);
                }
            }
        }
        for(int[] d : dp){
            System.out.println(Arrays.toString(d));
        }
         return dp[1][N-1];
    }
   public static void main(String[] args) {
       int[] arr = {1,2,3,4,5};
       System.out.println(matrixMultiplication(arr.length, arr));
   }
}
