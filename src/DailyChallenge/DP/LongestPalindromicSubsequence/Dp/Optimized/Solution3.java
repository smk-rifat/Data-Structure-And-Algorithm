package DailyChallenge.DP.LongestPalindromicSubsequence.Dp.Optimized;

import java.util.Arrays;

class Solution3 {
    public int longestPalindromeSubseq(String s){
        int n = s.length();

        int[] minus1 = new int[n];
        int[] minus2 = new int[n];
        int[] cur = new int[n];

        // base case for length 1;
        Arrays.fill(minus2, 1);
        // base case for length 2
        for (int i = 0; i < n-1; i++) {
            minus1[i] = s.charAt(i) == s.charAt(i+1) ? 2 : 1;
        }

        for (int length = 3; length <= n; length++) {
            for (int start = 0; start <= n- length; start++) {
                int end = start +length-1;

                if (s.charAt(start) == s.charAt(end)){
                    cur[start] = 2 + minus2[start];
                } else {
                    cur[start] = Math.max(minus1[start], minus1[start+1]);
                }
            }
            swap(minus1, minus2);
            swap(cur, minus1);
        }

        return minus1[0];
    }
    public void swap(int[] source, int[] destination){
        int[] temp = destination;
        destination = source;
        source = temp;
    }

    public static void main(String[] args) {
        
    }
}
