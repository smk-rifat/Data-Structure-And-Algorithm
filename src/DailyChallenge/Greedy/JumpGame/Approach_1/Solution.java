package DailyChallenge.Greedy.JumpGame.Approach_1;
// https://leetcode.com/problems/jump-game/

class Solution {
    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }
    public boolean canJumpFromPosition(int position, int[] nums){

        if(position == nums.length -1) return true;
        int furtherJump = Math.min(position + nums[position], nums.length-1);

        for (int nextPosition = position+1; nextPosition <= furtherJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }
}