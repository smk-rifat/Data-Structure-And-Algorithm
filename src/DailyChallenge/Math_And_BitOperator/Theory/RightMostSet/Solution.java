package DailyChallenge.Math_And_BitOperator.Theory.RightMostSet;

public class Solution {
    public static void main(String[] args) {
        int n = 10110110;
        boolean breakPoint = false;
        int ans = 1;
        while(!breakPoint){
            if ((n & 1) == 1){
                System.out.println(ans);
                breakPoint = true;
            }
            n = n >> 1;
            ans++;
        }
    }
}
