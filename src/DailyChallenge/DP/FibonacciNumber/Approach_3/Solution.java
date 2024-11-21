package DailyChallenge.DP.FibonacciNumber.Approach_3;

class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        int[] D = new int[]{0,1};
        for (int i = 2; i <= n; i++) {
            int temp = D[1];
            D[1] = D[0] + D[1];
            D[0] = temp;
        }
        return D[1];
    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        int n = 5;
        System.out.println(obj.fib(n));
    }
}