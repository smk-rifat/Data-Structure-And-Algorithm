package DailyChallenge.SlidingWindow.LongestRepeatingCharacterReplacement;
// https://leetcode.com/problems/longest-repeating-character-replacement/
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
       String s = "AABABBA";
       int k = 1;
       int ans = characterReplacement(s, k);
        System.out.println(ans);
    }
    public static int characterReplacement(String s, int k){
        int n = s.length();
        int window_start = 0;
        int maxLength = 0;
        int maxAppearance = 0;
        int[] alpha = new int[26];
        for (int window_end = 0; window_end < n; window_end++){
            char ch = s.charAt(window_end);
            alpha[ch-'A']++;
            maxAppearance = Math.max(maxAppearance, alpha[ch-'A']);
            int window_size = window_end-window_start+1;
            if (window_size - maxAppearance > k){
                int start = s.charAt(window_start)-'A';
                alpha[start]--;
                window_start++;
            }
            maxLength = Math.max(maxLength, window_end-window_start+1);
        }
        return maxLength;
    }
    // using hashMap
    static int replacement(String s, int k){
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxAppearance = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < n){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            int appearanceOfCur = map.get(ch);
            maxAppearance = Math.max(maxAppearance , appearanceOfCur);
            int windowSize = right-left+1;
            int replaceable = windowSize - maxAppearance;
            if (replaceable > k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
            right++;
        }
        return maxLength;
    }
}