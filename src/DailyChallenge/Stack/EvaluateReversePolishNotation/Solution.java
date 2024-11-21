package DailyChallenge.Stack.EvaluateReversePolishNotation;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class Solution
{
    public static void main(String[] args)
    {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {

          Stack<Integer> number = new Stack<>();
          for (String str : tokens)
          {
              if(str.equals("+"))
              {
                  int value = number.pop()+number.pop();
                  number.push(value);
              } else if (str.equals("*")) {
                  int value = number.pop()*number.pop();
                  number.push(value);
              } else if (str.equals("-")) {
                  int a = number.pop();
                  int b = number.pop();
                  int value = b-a;
                  number.push(value);
              } else if (str.equals("/")) {
                  int x = number.pop();
                  int y = number.pop();
                  int value = y/x;
                  number.push(value);
              }
              else
              {
                  int value = Integer.parseInt(str);
                  number.push(value);
              }
          }
          return number.pop();
    }
}
