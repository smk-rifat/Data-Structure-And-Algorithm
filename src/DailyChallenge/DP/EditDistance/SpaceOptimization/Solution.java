package DailyChallenge.DP.EditDistance.SpaceOptimization;

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] prev = new int[n + 1];
        int[] cur = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            prev[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            cur[0] = i;

            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = prev[j - 1]; // Characters match
                } else {
                    cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1])); // Correct calculation
                }
            }

            prev = cur.clone(); // Copy current row to previous
        }

        return prev[n];
    }
}
