package DailyChallenge.RecursionAndBacktracking.Easy.FibonacciNumber;

class Solution {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }
    public static int fib(int n) {
        if (n <= 1){
            return n;
        }
        return fib(n-1)+(n-2);
    }
}