package DailyChallenge.Stack.CarFlet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        int target = 12;
        System.out.println(stackSolution(target,position,speed));
    }
    public static int sick(int target, int[] position, int[] speed)
    {
       int ans = 0;
       double[] time = new double[target]; // track every car required time from 0 to 11 position
        for (int i = 0; i < position.length; i++) {
            double t = (double) ((target-position[i]) / speed[i]);
            time[position[i]] = t;
        }
        double prev = 0.0;
        for (int i = time.length-1; i >=0 ; i--) {
            double cur = time[i];
            if (cur>prev) {
                ans++;
                prev = cur;

            }
        }
        return ans;
    }
    public static int hashMapSolution(int target, int[] position, int[] speed)
    {
        int ans = 0;
        HashMap<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < position.length; i++) {
            double time =(double) (target-position[i])/speed[i];
            map.put(position[i], time);
        }
        Arrays.sort(position);
        double prev = 0.0;
        for (int i = position.length-1; i >=0 ; i--) {
            double cur = map.get(position[i]);
            if (cur>prev)
            {
                prev = cur;
                ans++;
            }
        }
        return ans;
    }
    public static int stackSolution(int target, int[] position, int[] speed)
    {
        if (position.length == 1) return 1;
        Stack<Double> fleet = new Stack<>();
        int[][] combine = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; // it sorts the array of arrays based on the values in the first position of each sub array
            }
        };
        Arrays.sort(combine, comp);

        for (int i = combine.length-1; i >=0 ; i--) {
            double curTime = (double) (target - combine[i][0]) / combine[i][1];
            if (!fleet.isEmpty() && curTime <= fleet.peek()) // counting number of fleet only
            {
                // if this condition meets that's mean current car is fleet with its next car
                continue;
            }
            fleet.push(curTime);
        }
        return fleet.size();
    }
}