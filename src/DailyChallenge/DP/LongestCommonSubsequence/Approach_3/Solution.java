package DailyChallenge.DP.LongestCommonSubsequence.Approach_3;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        if(text1.equals(text2)) return text1.length();
        if (text2.length() > text1.length()) return longestCommonSubsequence(text2, text1);

        int l1 = text1.length();
        int l2 = text2.length();

        int[] prev = new int[l2 + 1];
        int[] cur = new int[l2 + 1];

        for (int i = 1; i <= l1 ; i++) {
            for (int j = 1; j <= l2 ; j++) {
                if (text1.charAt( i-1) == text2.charAt(j-1))
                    cur[j] = prev[j - 1] + 1;
                else
                    cur[j] = Math.max(prev[j], cur[j-1]);
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;

        }
        return prev[l2];
    }
}