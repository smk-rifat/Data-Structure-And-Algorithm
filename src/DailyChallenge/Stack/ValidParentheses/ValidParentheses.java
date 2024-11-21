package DailyChallenge.Stack.ValidParentheses;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    public static void main(String[] args) {
      String s3 = "(("; // false
        System.out.println(isValid(s3));
    }
    public static boolean isValid(String s) {
        int n = s.length();
        if (n%2 != 0) return false;
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray())
        {
            if ( c == '(')
            {
                st.push(')');
            } else if (c == '{') {
                st.push('}');
            } else if (c == '[') {
                st.push(']');
            }
            else if (st.isEmpty() || st.pop() != c) {
                return false;
            }
        }
        return st.isEmpty();
    }
}
