package DailyChallenge.DP.LongestPalindromicSubstring.MancherAlgorithm;

class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('^');

        for(char c : s.toCharArray()){
            sb.append('#').append(c);
        }
        sb.append("#@");

        String updatedString = sb.toString();
        int[] diameter = new int[updatedString.length()];

        int centre = 0;
        int range = 0;

        for(int i = 1; i < diameter.length-1; i++){
            int mirror = 2 * centre - i; // centre - (i - centre)

            if( i < range){
                diameter[i] = Math.min(diameter[mirror], range - i);
            }

            while(updatedString.charAt(i + diameter[i] + 1) == updatedString.charAt(i - diameter[i] - 1)){
                diameter[i]++;
            }

            if(i + diameter[i] > range){
                centre = i;
                range = i+diameter[i];
            }
        }

        int maxDiameter = 0;
        int centreIndex = 0;

        for(int i = 1; i< diameter.length-1; i++){
            if(maxDiameter < diameter[i]){
                maxDiameter = diameter[i];
                centreIndex = i;
            }
        }

        int startIndex = (centreIndex - maxDiameter)/2;
        return s.substring(startIndex, startIndex+maxDiameter);
    }
}

