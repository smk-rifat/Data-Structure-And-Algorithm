package DailyChallenge.DP.PalindromePartitioning_II.ExpandAroundCentre;

import java.util.Arrays;

class Solution {
    public int minCut(String s) {
        int length = s.length();
        // Array to store the minimum number of cuts required for each prefix of the string
        int[] minCuts = new int[length];
        
        // Initialize minCuts: maximum cuts needed for a string of length i is i
        for (int i = 0; i < length; i++) {
            minCuts[i] = i; // In the worst case, we need i cuts for the first i+1 characters
        }
        
        // Check every possible center for a palindrome
        for (int center = 0; center < length; center++) {
            // Expand around the center for palindromes of odd length
            expandAroundCenter(center, center, minCuts, s);
            // Expand around the center for palindromes of even length
            expandAroundCenter(center - 1, center, minCuts, s);
        }
        System.out.println(Arrays.toString(minCuts));
        // The result is the minimum number of cuts for the whole string
        return minCuts[length - 1];
    }

    // Function to expand around the center and update minCuts array
    private void expandAroundCenter(int left, int right, int[] minCuts, String s) {
        // Expand as long as we have a valid palindrome
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // If the palindrome starts from the beginning of the string, no cuts needed
            // Otherwise, 1 cut is added for the substring before this palindrome
            int cutForCurrentPalindrome = (left == 0) ? 0 : minCuts[left - 1] + 1;
            
            // Update the minimum cuts needed for the current end of the palindrome
            minCuts[right] = Math.min(minCuts[right], cutForCurrentPalindrome);
            
            // Expand outwards
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        String s = "babab";
        Solution obj = new Solution();
        System.out.println(obj.minCut(s));
    }
}
