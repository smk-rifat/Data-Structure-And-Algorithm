package DailyChallenge.DP.OptimalBST.Memoization;

class Solution{
    static int optimalSearchTree(int keys[], int freq[], int n){
        Integer[][] memo = new Integer[n][n];
        return helper(freq, 0,n-1, memo);
    }
    public static int helper(int[] freq, int i, int j, Integer[][] memo){
        if (i > j) return 0;
        if (i == j) return freq[i];
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int minCost = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            int leftCost = helper(freq, i, k-1, memo);
            int rightCost = helper(freq, k+1, j, memo);
            minCost = Math.min(minCost, (leftCost+rightCost));
        }
        minCost += levelUp(freq,i, j);
        memo[i][j] = minCost;
        return memo[i][j];
    }
    public static int levelUp(int[] freq, int i, int j){
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += freq[k];
        }
        return sum;
    }
}