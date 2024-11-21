package DailyChallenge.Greedy.ValidParenthesisString.Approach_1;
// https://leetcode.com/problems/valid-parenthesis-string/
class Solution {
    public boolean checkValidString(String s) {
        if(s.isEmpty()) return false;
        return isValid(s, 0,0);
    }
    public  boolean isValid(String s, int idx, int count){
        if(count < 0) return false;
        if(idx == s.length()){
            return count == 0;
        }
        if(s.charAt(idx) == '('){
            return isValid(s, idx+1, count+1);
        } else if(s.charAt(idx) == ')'){
            return isValid(s, idx+1, count -1);
        } else {
            return isValid(s, idx+1, count+1) || isValid(s, idx+1, count-1) || isValid(s, idx+1, count);
        }
    }
}