package DailyChallenge.LinkedList.HappyNumber;
// https://leetcode.com/problems/happy-number/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int num = 7;
        System.out.println(isHappy(num));
    }
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(n != 1){
            int sum = 0;
            while( n!= 0){
                sum += (int) Math.pow(n%10, 2);
                n = n/10;
            }
            if (sum == 1){
                return true;
            }
            n = sum;
            if (set.contains(sum)){
                return false;
            } else {
                set.add(sum);
            }
        }
        return true;
        // TC->log(1),SC->O(1)
    }
    // using fast and slow pointer
    static boolean fsp(int n){
        int slow = n;
        int fast = n;

        do {
            slow = sq(slow);
            fast = sq(sq(fast));
        } while (slow != fast);

        return slow == 1;
    }
    static int sq(int n ){
        int ans = 0;
        while(n > 0){
            int rem = n % 10;
            ans += (rem*rem);
            n /= 10;
        }
        return ans;
    }
}
