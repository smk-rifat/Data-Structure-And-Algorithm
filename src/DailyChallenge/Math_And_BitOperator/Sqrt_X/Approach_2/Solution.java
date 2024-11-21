package DailyChallenge.Math_And_BitOperator.Sqrt_X.Approach_2;
// https://leetcode.com/problems/sqrtx/
class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        int ans = 0;
        for (int i = 0; i*i <= x ; i++) {
            ans = i;
        }
        return ans;
    }
}