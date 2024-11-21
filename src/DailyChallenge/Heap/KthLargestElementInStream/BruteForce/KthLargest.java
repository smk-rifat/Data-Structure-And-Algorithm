package DailyChallenge.Heap.KthLargestElementInStream.BruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class KthLargest {
    List<Integer> list;
    int k;
    public KthLargest(int k, int[] nums) {
        list = new ArrayList<>();
        this.k = k;
        for(int n : nums) list.add(n);
    }
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size()-k);
    }
}