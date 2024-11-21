package DailyChallenge.Greedy.JumpGame_II.Approach_2;

class Solution {
    public static int jump(int[] nums) {
        int jump = 0;
        int near = 0;
        int far = 0;
        int n = nums.length;

        while (far < n-1){
            int farthest = 0;
            for (int i = near; i <= far; i++) {
                farthest = Math.max(farthest, nums[i]+i);
            }
            near = far+1;
            far = farthest;
            jump++;
        }
        return jump;
    }
    public static void main(String[] args){
        int[] nums ={2,3,1,1,4};
        System.out.println(jump(nums));
    }
}