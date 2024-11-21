package DailyChallenge.ArrayAndHashing.MajorityElement;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        int[] nums = {2,2,3};
        System.out.println(majorityElement(nums));
    }
    static int bruteForce(int[] nums){
        int ans = -1;
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            int count = 0;
            for(int j = 0; j< nums.length; j++){
                if (temp == nums[j]){
                    count++;
                }
            }
            if (count > nums.length/2){
                ans = temp;
            }
        }
        return ans;
        // here time complexity is O(n^2)
    }
    static int betterway(int[] nums){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int key : map.keySet()){
            int count = map.get(key);
            if(count > n/2){
                return key;
            }
        }
        return -1;
    }
    public static int majorityElement(int[] nums) {
        int res = -1;
        int count = 0;
        for(int n : nums){
            if ( count == 0 || res == n){
                res = n;
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}
