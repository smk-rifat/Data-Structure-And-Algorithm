package DailyChallenge.SlidingWindow.PermutationInString;
// https://leetcode.com/problems/permutation-in-string/
import java.util.Arrays;
class Solution {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
    static boolean bruteForce(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[] freq1 = new int[26];
        for(int i= 0; i <n; i++){
            freq1[s1.charAt(i)-'a']++;
        }
        for (int i = 0; i <= m-n; i++) {
            int[] freq2 = new int[26];
            for (int j = i; j < n+i; j++) {
                freq2[s2.charAt(j)-'a']++;
            }
            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }
        return false;
        // time complexity O(n)+O(n*m)
    }
    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        // populate the array with the char frequency of the s1 string
        for(int i = 0; i <n; i++){
            freq1[s1.charAt(i)-'a']++;
        }
        // using sliding window to compare each slide with the freqS1
        for(int i = 0; i < m; i++){
            freq2[s2.charAt(i)-'a']++;

            if (i >= n) { // this condition for sliding the size of the s1, if it exceeds the size of the s1 then remove the left most one from the frequency
                freq2[s2.charAt(i-n)-'a']--;
            }
            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }
        return false;
    }
     
}