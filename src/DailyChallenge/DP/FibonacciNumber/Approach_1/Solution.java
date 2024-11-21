package DailyChallenge.DP.FibonacciNumber.Approach_1;
// https://leetcode.com/problems/fibonacci-number/
class Solution {
    public int fib(int n) {
        return bruteForce(n);
    }
    public int bruteForce(int n){
        if(n <= 1) return n;
        return bruteForce(n-1) + bruteForce(n -2);
    }
}