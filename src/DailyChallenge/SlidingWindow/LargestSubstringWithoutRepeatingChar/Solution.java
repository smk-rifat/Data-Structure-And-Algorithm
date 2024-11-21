package DailyChallenge.SlidingWindow.LargestSubstringWithoutRepeatingChar;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1193693929/
import java.util.HashMap;
import java.util.Map;


class Solution {
    public static void main(String[] args) {
        String s = "abcabcbb";
        String s1 = "dvdf";
        int ans = brute(s);
        System.out.println(s+"="+ans);
        System.out.println(s1+"="+brute(s1));
    }
    static int brute(String s){
        int n = s.length();
        int maxLength = 0;
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                String str = String.valueOf(s.charAt(j));
                if (sb.indexOf(str) != -1){
                    break;
                }
                sb.append(str);
                maxLength = Math.max(maxLength, j-i+1);
            }
        }
        return maxLength;
        // here time and space complexity is O(n^2) and O(n)
    }
    public static int betterApproach(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < n){
            char ch = s.charAt(right);
            if (map.containsKey(ch) && map.get(ch) >= left){
                left = map.get(ch)+1;
            }
            maxLength = Math.max(maxLength, right-left+1);
            map.put(ch, right);
            right++;
        }
        return maxLength;
        // time complexity is O(n)
    }
    static int anotherApproach(String s){
        int n = s.length();
        int ans = 0;
        int left = 0;
        int right = 0;

        while( right < n){
            char ch = s.charAt(right);
            int appearance = s.indexOf(ch, left);
            if (appearance != right && appearance >= left){
                left = appearance+1;
            }
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;
        // this one beats 99% :)
    }
    // O(n)
}