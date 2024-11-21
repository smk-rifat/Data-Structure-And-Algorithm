package DailyChallenge.DP.PalindromicSubstrings.Memoization;

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        if (s.isEmpty()) return 0;
        if (s.length() < 2) return 1;
        Boolean[][] memo = new Boolean[n+1][n+1];
        int ans = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = i; j <n; j++) {
                if (isPalindrome(s, i, j, memo)){
                    ans++;
                }
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s, int left, int right, Boolean[][] memo){
        if (memo[left][right] != null) return memo[left][right];
        if (left >= right) return true;

        if (s.charAt(left) == s.charAt(right)) 
            memo[left][right] = isPalindrome(s, left+1, right-1, memo);
        else
            memo[left][right] = false;
        return memo[left][right];
    }

    public static void main(String[] args) {

    }
}