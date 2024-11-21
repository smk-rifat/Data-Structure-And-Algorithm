package DailyChallenge.ArrayAndHashing.FirstMissingPositive;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {

    }
    public static int firstMissingPositive(int[] nums){
        int ans = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if (num > 0){
               set.add(num);
            }
        }
        boolean found = false;
        int i = 1;
        while (!found){
            if (!set.contains(i)){
                ans = i;
                found = true;
            }
            i++;
        }
        return ans;
    }
}
