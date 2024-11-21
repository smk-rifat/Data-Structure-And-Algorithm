package DailyChallenge.DP.OptimalBST.BruteForce;
// https://www.geeksforgeeks.org/problems/optimal-binary-search-tree2214/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

class Solution{
    static int optimalSearchTree(int keys[], int freq[], int n){
        return helper(freq, 0,n-1);
    }
    public static int helper(int[] freq, int i, int j){
        if (i > j) return 0;
        if (i == j) return freq[i];
        
        int minCost = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            int leftCost = helper(freq, i, k-1);
            int rightCost = helper(freq, k+1, j);
            minCost = Math.min(minCost, (leftCost+rightCost));
        }
        minCost += levelUp(freq,i, j);

        return minCost;
    }
    public static int levelUp(int[] freq, int i, int j){
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += freq[k];
        }
        return sum;
    }
}
