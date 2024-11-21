package DailyChallenge.Stack.DailyTemperature.HaHa;

import java.util.Arrays;

public class HaHa
{
    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        int sexy = Integer.MIN_VALUE;

        for (int i = temperatures.length-1; i >=0 ; i--) {
            int cDay = temperatures[i];
            if (cDay>sexy) { // that's mean there is no warmer day after this
                sexy = cDay;
            } else if (cDay<sexy) {

                int days = 1;
                while (temperatures[i+days] <= cDay) {
                    days += ans[i+days];
                }
                ans[i] = days;
            }

        }
        return ans;
    }
}
