package DailyChallenge.Math_And_BitOperator.Pow_x_power_n.Approach_2;

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(x == 0) return 0;

        if(n < 0){
            x = 1/x;
        }
        return x;
    } public double helper(double x, Long N){
        if(N == 0) return 1.0;

        double half = helper(x, N/2);

        if (N % 2 == 0){
            return half * half;
        } else {
            return half * half * x;
        }
    }
}