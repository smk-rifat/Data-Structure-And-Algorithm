package DailyChallenge.ArrayAndHashing.SetMismatch;

import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public int[] findErrorNums(int[] nums){
        int n = nums.length;
        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if(set.contains(num)){
                ans[0] = num;
            }
            else{
                set.add(num);
            }
        }
        for(int i = 1; i<=n; i++){
            if(!set.contains(i)){
                ans[1] = i;
                break;
            }
        }

        return ans;
    }

}
