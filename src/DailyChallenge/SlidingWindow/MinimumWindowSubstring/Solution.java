package DailyChallenge.SlidingWindow.MinimumWindowSubstring;

import java.util.HashMap;

// https://leetcode.com/problems/minimum-window-substring/description/
class Solution {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String ans = minWindow(s, t);
        System.out.println(ans);
    }

    //sliding window
    public static String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c ,0)+1);
        }

        int matched = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int subStr = 0;

        for(int end_window = 0; end_window < s.length(); end_window++){
            char right = s.charAt(end_window);
            if(map.containsKey(right)){
                map.put(right, map.getOrDefault(right, 0)-1);
                if (map.get(right) == 0) {
                    matched++;
                }
            }

            while(matched == map.size()){
                int sizeOfTheWindow = end_window-start+1;
                minLength = Math.min(minLength, sizeOfTheWindow);
                subStr = start;
                char pop = s.charAt(start);
                start++;
                if (map.containsKey(pop)) {
                    if (map.get(pop) == 0) {
                        matched--;
                    }
                    map.put(pop, map.getOrDefault(pop, 0)+1);
                }
            }
        }
        return s.substring(subStr, subStr+minLength);
    }
    
}

