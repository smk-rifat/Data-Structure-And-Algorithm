package DailyChallenge.Stack.MinStack;

import java.util.Stack;

// https://leetcode.com/problems/min-stack/
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
       stack = new Stack<>();
       minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty())
        {
            minStack.push(val);
        }else
        {
            val = Math.min(val, minStack.peek());
            minStack.push(val);
        }
    }

    public void pop() {
         stack.pop();
         minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
