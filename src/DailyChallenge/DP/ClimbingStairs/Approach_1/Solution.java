package DailyChallenge.DP.ClimbingStairs.Approach_1;
// https://leetcode.com/problems/climbing-stairs/
class Solution {
    public int climbStairs(int n) {
        return helper(n, 0);
    }
    public int helper(int n, int count){
        if(n <= 1){
            count++;
            return count;
        }
        count += helper(n-1, count) + helper(n-2, count);
        return count;
    }

}
// time limit exceed for bigger input