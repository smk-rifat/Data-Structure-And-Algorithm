package DailyChallenge.Greedy.GasStation.Approach_1;
//https://leetcode.com/problems/gas-station/
class  Solution{
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int start = 0; start < n; start++) {
            int tank = 0;
            boolean canComplete = true;

            for (int i = 0; i < n; i++) {
                int currentStation = (start + i) % n;
                tank += gas[currentStation] - cost[currentStation];

                if (tank < 0){
                    canComplete = false;
                    break;
                }
            }
            if (canComplete) return start;
        }
        return -1;
     }
}