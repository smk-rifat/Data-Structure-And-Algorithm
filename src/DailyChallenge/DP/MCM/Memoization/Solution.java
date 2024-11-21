package DailyChallenge.DP.MCM.Memoization;

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        Integer[][] memo = new Integer[N][N];
        return solve(arr, 1, N-1, memo);
    }
    public static int solve(int[] array, int s, int e, Integer[][] memo){
        if (memo[s][e] != null) return memo[s][e];
        if (s == e) return 0;
        int max = Integer.MAX_VALUE;
        for (int k = s; k < e; k++) {
            int temp = solve(array, s, k, memo) + solve(array, k+1, e, memo) + (array[s-1] * array[k] * array[e]);
            max = Math.min(max, temp);    
        }
        memo[s][e] = max;
        return memo[s][e];
    }
}