package DailyChallenge.DP.LongestPalindromicSubsequence.Dp.Optimized;

class Solution2 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        // If the string is just one character long, the longest palindromic subsequence is itself
        if (n == 1) return 1;

        // Arrays to store the length of the longest palindromic subsequence
        // for different lengths of substrings
        int[] lengthForLengthMinus2 = new int[n];
        int[] lengthForLengthMinus1 = new int[n];
        int[] lengthForCurrent = new int[n];

        // Base case: For substrings of length 1, the longest palindromic subsequence is 1
        for (int i = 0; i < n; i++) {
            lengthForLengthMinus2[i] = 1;
        }

        // Base case: For substrings of length 2, check if the two characters are the same
        // If yes, the longest palindromic subsequence is 2; otherwise, it's 1
        for (int i = 0; i < n - 1; i++) {
            lengthForLengthMinus1[i] = (s.charAt(i) == s.charAt(i + 1)) ? 2 : 1;
        }

        // Process substrings of length 3 up to n
        for (int length = 3; length <= n; length++) {
            for (int start = 0; start <= n - length; start++) {
                int end = start + length - 1;
                // If the characters at the start and end of the substring are the same
                if (s.charAt(start) == s.charAt(end)) {
                    // Include these characters in the subsequence
                    lengthForCurrent[start] = lengthForLengthMinus2[start + 1] + 2;
                } else {
                    // Otherwise, take the maximum length by either excluding the start or end character
                    lengthForCurrent[start] = Math.max(lengthForLengthMinus1[start], lengthForLengthMinus1[start + 1]);
                }
            }
            // Move the current lengths to the previous lengths for the next iteration
            copyArray(lengthForLengthMinus1, lengthForLengthMinus2);
            copyArray(lengthForCurrent, lengthForLengthMinus1);
        }

        // The result for the whole string is now stored at the start of the array
        return lengthForLengthMinus1[0];
    }

    // Helper method to copy contents from one array to another
    private static void copyArray(int[] source, int[] destination) {
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String test = "bbbab";
        int result = solution.longestPalindromeSubseq(test);
        System.out.println("The length of the longest palindromic subsequence is: " + result);
    }
}