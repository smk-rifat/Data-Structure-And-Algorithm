package DailyChallenge.BinarySearch.SearchA2Dmatrix;
// https://leetcode.com/problems/search-a-2d-matrix/solutions/
public class Solution {
    public static void main(String[] args) {
       int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
       int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int n = row*col;
        int start = 0;
        int end = n-1;

        while (start <= end)
        {
            int mid = (start+end)/2;
            int r = mid/col;
            int c = mid%col;
            if (target>matrix[r][c])
            {
                start = mid+1;
            } else if (target<matrix[r][c]) {
                end = mid-1;
            }
            else
                return true;
        }
        return false;
    }
}
