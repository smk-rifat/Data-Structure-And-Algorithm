package DailyChallenge.DP.PalindromicSubstrings.ManacherAlgo;
// https://leetcode.com/problems/palindromic-substrings/

import java.util.Arrays;

class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() < 2) return s.length(); // If the string has only one character, each character is a palindrome.

        StringBuilder sb = new StringBuilder();
        sb.append('^');

        for (int i = 0; i < s.length(); i++) {
            sb.append('#').append(s.charAt(i));
        }
        sb.append("#$");

        String updatedString = sb.toString();
        System.out.println(updatedString);
        int[] diameter = new int[updatedString.length()];

        int centre = 0;
        int range = 0;

        // Use Manacher's algorithm to find the diameter of palindromes centered at each position
        for (int i = 1; i < diameter.length - 1; i++) {
            int mirror = 2 * centre - i;

            if (i < range) {
                diameter[i] = Math.min(diameter[mirror], range - i);
            }

            // Try to expand the palindrome centered at i
            while (updatedString.charAt(i + diameter[i] + 1) == updatedString.charAt(i - diameter[i] - 1)) {
                diameter[i]++;
            }

            // Update the centre and range if we've expanded beyond the current range
            if (i + diameter[i] > range) {
                centre = i;
                range = i + diameter[i];
            }
        }

        int count = 0;

        // Calculate the total number of palindromic substrings
        for (int i = 1; i < diameter.length - 1; i++) {
            // Each entry diameter[i] represents the number of palindromic radii around center i
            // Count all palindromes of length 1 to diameter[i]
            count += (diameter[i] + 1) / 2;
        }
        System.out.println(Arrays.toString(diameter));
        return count;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        String str = "pqpqpqp";
        System.out.println(obj.countSubstrings(str)); // Output: 6
    }
}
