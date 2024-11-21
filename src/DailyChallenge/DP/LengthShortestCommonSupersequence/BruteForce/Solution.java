package DailyChallenge.DP.LengthShortestCommonSupersequence.BruteForce;
// https://www.geeksforgeeks.org/problems/shortest-common-supersequence0322/1

class Solution {
    public static int shortestCommonSupersequence(String X,String Y,int m,int n) {
        return bruteForce(X,Y,m, n, 0,0);
    }
    public static int bruteForce(String x, String y, int m, int n, int i, int j){
        if (i == m)
            return n - j;
        if (j == n)
            return m - i;

        if (x.charAt(i) != y.charAt(j)){
            return 1+ Math.min(bruteForce(x, y, m, n, i+1, j), bruteForce(x, y, m, n, i, j+1));
        } else
            return 1+bruteForce(x, y, m, n, i+1, j+1);
    }
}