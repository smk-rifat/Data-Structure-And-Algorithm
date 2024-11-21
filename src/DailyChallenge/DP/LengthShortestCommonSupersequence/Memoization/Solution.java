package DailyChallenge.DP.LengthShortestCommonSupersequence.Memoization;

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n){
        Integer[][] memo = new Integer[m+1][n+1];
        return memoization(X, Y, m, n, memo);
    }
    public static int memoization(String x, String y, int m, int n, Integer[][] memo){
        if (m == 0) return n;
        if (n == 0) return m;
        if (memo[m][n] != null) return memo[m][n];

        if (x.charAt(m-1) != y.charAt(n-1))
            memo[m][n] = 1+ Math.min(memoization(x, y, m-1, n, memo), memoization(x, y, m, n-1, memo));
        else
            memo[m][n] = 1+memoization(x,y,m-1,n-1, memo);

        return memo[m][n];
    }
}