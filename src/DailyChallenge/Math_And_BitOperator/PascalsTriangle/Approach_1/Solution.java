package DailyChallenge.Math_And_BitOperator.PascalsTriangle.Approach_1;
// https://leetcode.com/problems/pascals-triangle/
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < numRows; r++) {
            List<Integer> row = new ArrayList<>();
            for (int c = 0; c <= r; c++) {
                if (c == 0 || c == r) {
                    row.add(1);
                } else {
                    row.add(result.get(r-1).get(c-1) + result.get(r-1).get(c));
                }
            }
            result.add(row);
        }
        return result;
    }
}