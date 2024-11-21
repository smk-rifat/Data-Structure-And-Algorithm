package DailyChallenge.DP.LongestStringChain.BruteForce;

import java.util.*;

class Solution {
    Set<String> set;
    int n;
    Map<String, Integer> map;
    public int longestStrChain(String[] words) {
        n = words.length;
        set = new HashSet<>();
        map = new HashMap<>();

        for (String word : words) {
            set.add(word);
        }

        int maxLen = 0;

        for (String word : words) {
            int len = helper(word);
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    public int helper(String word) {
        if (map.containsKey(word))
            return map.get(word);

        int maxLen = 1;
        StringBuilder sb = new StringBuilder(word);

        for (int i = 0; i < word.length(); i++) {
            sb.deleteCharAt(i);

            String predecessor = sb.toString();
            if (set.contains(predecessor)) {
                int len = 1 + helper(predecessor);
                maxLen = Math.max(maxLen, len);
            }
            sb.insert(i, word.charAt(i));
        }
        map.put(word, maxLen);
        return maxLen;
    }
}
