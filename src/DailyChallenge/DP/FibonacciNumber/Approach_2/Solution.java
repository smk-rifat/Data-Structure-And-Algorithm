package DailyChallenge.DP.FibonacciNumber.Approach_2;

import java.util.Arrays;

// https://leetcode.com/problems/fibonacci-number/
class Solution {
    public int fib(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        return memoization(n, cache);
    }
    public int memoization(int n, int[] cache){
        if (n <= 1)
            return n;
        if (cache[n] == -1)
            return cache[n] = memoization(n-1, cache ) + memoization(n-2, cache);
        else
            return cache[n];
    }
}