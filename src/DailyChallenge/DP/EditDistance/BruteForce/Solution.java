package DailyChallenge.DP.EditDistance.BruteForce;
// https://leetcode.com/problems/edit-distance/

class Solution {
    public int minDistance(String word1, String word2) {
        return bruteForce(word1, word2, 0, 0);
    }
    public int bruteForce(String s1, String s2, int i, int j){
        if (i >= s1.length() || s1.isEmpty()){
            return s2.length() - j;
        }
        if (j >= s2.length() || s2.isEmpty()){
            return s1.length() - i;
        }

        if (s1.charAt(i) == s2.charAt(j)){
            return bruteForce(s1, s2, i+1, j+1);
        } else {
            int insert = 1+ bruteForce(s1,s2, i, j+1);
            int replace = 1+ bruteForce(s1, s2, i+1, j+1);
            int remove = 1+ bruteForce(s1, s2,i+1, j);
            return Math.min(Math.min(insert, remove), replace);
        }
    }

}