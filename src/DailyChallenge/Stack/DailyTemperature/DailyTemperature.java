package DailyChallenge.Stack.DailyTemperature;

import java.util.Arrays;

public class DailyTemperature
{
    public static void main(String[] args)
    {
        int[] temp = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }
    public static int[] bruteForce(int[] temperatures)
    {
        int n = temperatures.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int cTemp = temperatures[i];
            for (int j = i+1; j < n; j++) {
                if (cTemp<temperatures[j])
                {
                    ans[i] = j-i;
                    break;
                }
            }
        }
        return ans;
        // here time complexity is O(n^2)
    }
    public static int[] dailyTemperatures(int[] temperatures){
        if (temperatures == null || temperatures.length < 1) {
            return new int[] {};
        }

        int hottest = Integer.MIN_VALUE;
        int[] results = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            int currentTemp = temperatures[i];
            if (currentTemp >= hottest) {
                hottest = currentTemp;
                continue;
            }

            int days = 1;
            while (temperatures[i + days] <= currentTemp) {
                days += results[i + days];
            }
            results[i] = days;
        }
        return results;
    }
}
