package DailyChallenge.Math_And_BitOperator.PascalsII.Approach_1;
// https://leetcode.com/problems/pascals-triangle-ii/submissions/1307200763/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

       for(int r = 0; r <= rowIndex; r++){
            List<Integer> row = new ArrayList<>();
            for(int c = 0; c <= r; c++){
                if(c == 0 || c == r){
                    row.add(1);
                } else {
                    row.add(result.get(r-1).get(c-1) + result.get(r-1).get(c));
                }
            }
            result.add(row);
       }
       return result.get(rowIndex);
    }

}