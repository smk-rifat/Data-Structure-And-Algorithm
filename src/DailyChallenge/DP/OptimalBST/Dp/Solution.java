package DailyChallenge.DP.OptimalBST.Dp;

class Solution{
    static int optimalSearchTree(int keys[], int freq[], int n){
        int[][] dp = new int[n+1][n+1];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j <n; j++) 
            {
                if (i > j){
                    dp[i][j] = 0;
                    continue;
                } else if (i == j) {
                    dp[i][i] = freq[i];
                    continue;
                }
            
            int minCost = Integer.MAX_VALUE;
            for (int k = i; k <= j; k++) {
                int leftCost = (k > i) ? dp[i][k-1] : 0;
                int rightCost = (k < j) ? dp[k+1][j] : 0;
                minCost = Math.min(minCost, (leftCost+rightCost));
            }
            minCost += levelUp(freq,i, j);
            dp[i][j] = minCost;

            }
        }
        return dp[0][n-1];
    }
    public static int levelUp(int[] freq, int i, int j){
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += freq[k];
        }
        return sum;
    }
}
