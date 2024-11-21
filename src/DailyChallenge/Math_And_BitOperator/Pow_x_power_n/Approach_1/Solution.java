package DailyChallenge.Math_And_BitOperator.Pow_x_power_n.Approach_1;

class Solution {
    public static double myPow(double x, int n) {
        if (n == 0) return 1.0; // Any number to the power of 0 is 1
        double ans = 1.0;
        if (n < 0){
            x = 1/x;
            n = -n;
        }
        for (int i = 0; i < n; i++) {
            ans *= x;
        }
        return ans;
    }

}