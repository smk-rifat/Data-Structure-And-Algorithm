package DailyChallenge.Math_And_BitOperator.Theory.Find_ith_Bit;

public class Solution {
    public static void main(String[] args) {
      int n = 1000101;
      int i = 7;
      int ans = (int) (n/Math.pow(2, i));
      System.out.println( ans & 1);
    }
}
