package DailyChallenge.Greedy.GasStation.Approach_2;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tottalCost = 0, tottalGas = 0, tottal = 0, result = 0;

        for (int i = 0; i < gas.length; i++) {
            tottalCost += cost[i];
            tottalGas += gas[i];
        }
        if (tottalCost > tottalGas){
            return -1;
        }
        for (int i = 0; i < gas.length; i++) {
            tottal += gas[i] - cost[i];

            if (tottal < 0){
                tottal = 0;
                result = i+1;
            }
        }
        return result;
    }
}