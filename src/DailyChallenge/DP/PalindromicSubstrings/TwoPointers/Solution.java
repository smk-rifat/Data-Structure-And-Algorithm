package DailyChallenge.DP.PalindromicSubstrings.TwoPointers;

class Solution {
    public int countSubstrings(String s) {
       int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += helper(s, i, i);
            count += helper(s, i, i+1);
        }
        return count;
    }
    public int helper(String s, int left, int right){
        int count = 0;

        while (left >= 0 && right < s.length()){
            if (s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            } else
                break;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.countSubstrings("aaa"));
    }
}