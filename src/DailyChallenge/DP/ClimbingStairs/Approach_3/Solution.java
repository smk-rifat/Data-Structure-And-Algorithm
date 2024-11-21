package DailyChallenge.DP.ClimbingStairs.Approach_3;

class Solution {
    public int climbStairs(int n) {
        int[] steps = new int[]{1,1};
        for (int i = 2; i <= n; i++) {
            int temp = steps[1];
            steps[1] = steps[0] + steps[1];
            steps[0] = temp;
        }
        return steps[1];
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.climbStairs(45));
    }
}