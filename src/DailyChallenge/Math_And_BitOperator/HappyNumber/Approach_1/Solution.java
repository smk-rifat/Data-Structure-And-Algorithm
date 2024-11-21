package DailyChallenge.Math_And_BitOperator.HappyNumber.Approach_1;
// https://leetcode.com/problems/happy-number/
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while( n != 1){
            if (!set.isEmpty() && set.contains(n)){
                return false;
            }
            set.add(n);
            int sum = 0;
            while (n != 0){
                int rem = n % 10;
                sum += rem *rem;
                n /= 10;
            }
            n = sum;
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 19;
        Solution obj = new Solution();
        System.out.println(obj.isHappy(num));
    }
}