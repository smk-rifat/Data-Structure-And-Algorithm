package DailyChallenge.Heap.LastStoneWeight.BruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int s : stones){
            list.add(s);
        }
        Collections.sort(list);
        while (list.size() > 1){
            int l = list.remove(list.size()-1);
            int sL = list.remove(list.size()-1);
            if (l - sL > 0) list.add(l-sL);
            Collections.sort(list);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
    // overall time complexity is n^2 log n.
}