package DailyChallenge.DP.MCM.BruteForce;
// https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        return solve(arr, 1, N-1);
    }
    public static int solve(int[] array, int s, int e){
        if (s == e) return 0;
        int max = Integer.MAX_VALUE;
        for (int k = s; k < e; k++) {
            int temp = solve(array, s, k) + solve(array, k+1, e) + (array[s-1] * array[k] * array[e]);
            max = Math.min(max, temp);    
        }
        return max;
    }

}
