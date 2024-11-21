package DailyChallenge.DP.GenerateParentheses.BruteForce;
// https://leetcode.com/problems/generate-parentheses/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    static List<String> res = new ArrayList<>();
    static Stack<Character> st = new Stack<>();

    public List<String> generateParenthesis(int n) {
        helper(0,0,n);
        return res;
    }
    public void helper(int open, int close, int n){
        if (open == close && close == n){
            StringBuilder sb = new StringBuilder();
            for(char c : st){
                sb.append(c);
            }
            res.add(sb.toString());
        }

        if (open < n){
            st.push('(');
            helper(open+1, close, n);
            st.pop();
        }
        if (open > close){
            st.push(')');
            helper(open, close+1, n);
            st.pop();
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.generateParenthesis(3));
    }
}
