package DailyChallenge.DP.UniqueBinarySearchTrees.BruteForce;
// https://leetcode.com/problems/unique-binary-search-trees/
class Solution {
    public int numTrees(int n) {
        return helper(n);
    }
    public int helper(int n){
        if(n == 1 || n == 0) return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int left = helper(i-1);
            int right = helper(n-i);
            count += (left * right);
        }
        return count;
    }
}