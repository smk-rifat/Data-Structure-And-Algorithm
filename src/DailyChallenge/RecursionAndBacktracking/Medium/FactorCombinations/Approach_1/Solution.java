package DailyChallenge.RecursionAndBacktracking.Medium.FactorCombinations.Approach_1;
// https://leetcode.com/problems/factor-combinations/submissions/1312961113/
import java.util.List;

import java.util.*;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
          List<List<Integer>> result = new ArrayList<>();
          return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> com, int n, int start, int upper){
        if (n <= 1){
            if (com.size() >1 ){
                result.add(new ArrayList<>(com));
            }
            return;
        }

        for (int i = start; i <= n ; i++) {
            if (i > upper){
                i = n;
            }
            int sqrt = (int)Math.sqrt(n);
            if (n % i == 0){
                com.add(i);
                backtrack(result, com, n/i, i, sqrt);
                com.remove(com.size()-1);
            }
        }
    }

}

