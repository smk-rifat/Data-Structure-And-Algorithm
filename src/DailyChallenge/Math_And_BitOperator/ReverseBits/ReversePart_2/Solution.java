package DailyChallenge.Math_And_BitOperator.ReverseBits.ReversePart_2;

public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseBit(8));
    }
    public static int reverseBit(int n){
        boolean flag = false;
        int rev = 0;
        int j = 0;
        for (int i = 31; i >= 0 ; i--) {
            int mask = 1 << i;
            if (flag){
                if ((n & mask) != 0){
                    int sMask = (1 << j);
                    rev |= sMask;
                }
                j++;
            } else {
                if ((n & mask) != 0){
                    flag = true;
                    int sMask = (1 << j);
                    rev |= sMask;
                    j++;
                }
            }
        }
        return rev;
    }
}
