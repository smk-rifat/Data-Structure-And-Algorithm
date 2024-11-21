package DailyChallenge.DP.LongestPalindromicSubsequence.Dp.Optimized;

class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int[] dp = new int[n];  // Array to store the length of the longest palindromic subsequence

        // Initialize the first element to 1, as any single character is a palindrome of length 1
        dp[0] = 1;

        // Loop through each character in the string
        for (int i = 1; i < n; i++) {
            dp[i] = 1;  // Every single character is a palindrome of length 1
            int max = 0;  // Variable to store the maximum value from the previous subproblem

            // Check for palindromic subsequences ending at character i
            for (int j = i - 1; j >= 0; j--) {
                int previousValue = dp[j];  // Store the current dp[j] before it gets updated

                // If characters match, update dp[j] for the longest subsequence ending at i
                if (str[i] == str[j]) {
                    dp[j] = 2 + max;  // Update dp[j] to include the matching characters
                }

                // Update max to the largest dp value so far, which is used in the next iteration
                max = Math.max(max, previousValue);
            }
        }

        // Find the maximum value in the dp array, which represents the longest palindromic subsequence
        int longestPalindromeLength = 0;
        for (int length : dp) {
            longestPalindromeLength = Math.max(length, longestPalindromeLength);
        }

        return longestPalindromeLength;
    }
}

