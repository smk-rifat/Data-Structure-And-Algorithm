package DailyChallenge.Greedy.MaximumUnitsOnTruck.Approach_1;
// https://leetcode.com/problems/maximum-units-on-a-truck/

import java.util.Comparator;
import java.util.PriorityQueue;


class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        Comparator<Data> comp = (a, b) -> b.weight - a.weight;
        PriorityQueue<Data> queue = new PriorityQueue<>(comp);

        for(int[] d: boxTypes){
            Data db = new Data(d[0], d[1]);
            queue.add(db);
        }

        while (truckSize > 0 && !queue.isEmpty()){
            Data poll = queue.poll();
            if (truckSize >= poll.box){
                result += (poll.box * poll.weight);
                truckSize = truckSize - poll.box;
            } else {
                result += truckSize * poll.weight;
                truckSize = 0;
            }
        }

        return result;
    }
}
class Data{
    int box;
    int weight;

    public Data(int box, int weight) {
        this.box = box;
        this.weight = weight;
    }
}