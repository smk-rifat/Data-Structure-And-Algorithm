package DailyChallenge.Greedy.JumpGame_II.Approach_1;
// https://leetcode.com/problems/jump-game-ii/

class Solution {
    public int jump(int[] nums) {

        return jumpPosition(0, nums, 0);
    }
    public int jumpPosition(int position, int[] nums, int jumps){
        if (position == nums.length -1) return jumps;

        int minJump = Integer.MAX_VALUE;
        int furtherJump = Math.min(nums[position]+position, nums.length-1);

        for (int nextPosition = 0; nextPosition <= furtherJump; nextPosition++) {
            int currentJump = jumpPosition(nextPosition, nums, jumps+1);
            minJump = Math.min(minJump, currentJump);
        }

        return minJump;
    }
}