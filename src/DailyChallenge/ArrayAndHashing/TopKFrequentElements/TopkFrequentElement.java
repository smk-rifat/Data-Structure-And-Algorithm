package DailyChallenge.ArrayAndHashing.TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopkFrequentElement
{
    public static void main(String[] args) {

    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> map.get(b)- map.get(a));
        for (int i = 0; i< map.keySet().size(); i++){
            pq.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;

        // time complexity analysis:
        // O(n+ ulog(n) + k log(u)), where n is the number of element in array, u is the unique element
        // if u close to n then
        //O(n+n log(n) + k log(u)) here dominant factor is n log (n)
        // time complexity is O(n log(n))..............
    }
    @SuppressWarnings("unchecked")
    public static int[] optimal(int[] nums, int k)
    {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length+1];
        for (int n : nums){
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0)+1);
        }

        for (int n : frequencyMap.keySet()){
            int frequency = frequencyMap.get(n);
            if (bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(n);
        }
        int[] ans = new int[k];
        int counter = 0;

        for (int i = bucket.length-1; i >=0 && counter<k ; i--) {
            if (bucket[i] != null){
                for (Integer integer : bucket[i]){
                    if (counter == k)
                    {
                        break;
                    }
                    ans[counter++] = integer;
                }
            }
        }
        return ans;

    }
}
