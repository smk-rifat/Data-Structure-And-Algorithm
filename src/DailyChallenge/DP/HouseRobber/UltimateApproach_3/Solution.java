package DailyChallenge.DP.HouseRobber.UltimateApproach_3;

class Solution {
    public int rob(int[] nums) {
        // If there are no houses, the maximum money to rob is 0
        if (nums.length == 0) return 0;

        // Array to keep track of the maximum money that can be robbed up to each house
        int[] maxRobbedMoney = new int[2];
        maxRobbedMoney[1] = nums[0]; // If there is only one house, rob it

        // Loop through each house starting from the second one
        for (int i = 1; i < nums.length; i++) {
            int previousMax = maxRobbedMoney[1]; // Money robbed up to the previous house
            int robCurrentHouse = nums[i] + maxRobbedMoney[0]; // Money if we rob the current house
            int skipCurrentHouse = maxRobbedMoney[1]; // Money if we skip the current house
            maxRobbedMoney[1] = Math.max(robCurrentHouse, skipCurrentHouse); // Choose the best option
            maxRobbedMoney[0] = previousMax; // Update the money robbed up to the previous house
        }

        // The maximum money that can be robbed is stored in maxRobbedMoney[1]
        return maxRobbedMoney[1];
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = {2, 1, 4, 5};
        System.out.println(obj.rob(nums)); // Output should be 7
    }
}
