package DailyChallenge.Heap.KthLargestElementInAnArray;

import java.util.PriorityQueue;

class Solution {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int n : nums){
            heap.add(-n);
        }
        int ans = 0;

        while (k > 0 && !heap.isEmpty()){
            ans = heap.poll();
            k--;
        }
        return -ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
    }
}