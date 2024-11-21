package DailyChallenge.DP.PalindromePartitioning_II.Memoization;

class Solution {
    public int minCut(String s) {
     int n = s.length();
     Integer[] memo  = new Integer[n+1];
     return memoization(s, 0, n-1, memo);
    }
    public int memoization(String s, int start,int end,Integer[] memo){
        if (memo[start] != null) return memo[start];
        if (start == end || isPalindrome(s, start, end)) return 0;

        int min = Integer.MAX_VALUE;

        for (int cuts = start; cuts < end; cuts++) {
            if (isPalindrome(s, start, cuts)){
                int cost = 1 + memoization(s, cuts+1, end, memo);
                min = Math.min(min, cost);
            }
        }
        memo[start] = min;
        return memo[start];
    }
    public boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right--;
        }
        return true;
    }
}