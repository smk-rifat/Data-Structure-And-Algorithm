package DailyChallenge.DP.LongestPalindromicSubstring.ExpandAroundCentre;

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(s.isEmpty()) return "";
        if(n < 2) return s;

        String res = "";
        int orb;
        int len;
        for(int ax = 0; ax < n; ax++){
            orb = 1;
            len = 1;

            while(ax - orb >= 0 && ax+orb < n){
                if(s.charAt(ax-orb) == s.charAt(ax+orb)){
                    orb++;
                    len+=2;
                } else{
                    break;
                }
            }

            if(len > res.length()){
                int si = ax - len/2;
                res = s.substring(si, si+len);
            }
        }

        for(int ax = 0; ax < n-1; ax++){
            orb = 1;
            len = 0;

            while(ax - orb+1 >= 0 && ax+orb < n){
                if(s.charAt(ax-orb+1) == s.charAt(ax+orb)){
                    orb++;
                    len += 2;
                } else{
                    break;
                }
            }

            if(len > res.length()){
                int si = ax - len/2+1;
                res = s.substring(si, si+len);
            }
        }

        return res;
    }
}