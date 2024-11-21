package DailyChallenge.BinarySearch.SearchA2Dmatrix;

public class Solution2 {
    public static void main(String[] args) {
        
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            int start = 0;
            int end = col-1;
            if (target == matrix[i][start] || target == matrix[i][end]) {
                return true;
            } else if (target> matrix[i][start] && target<matrix[i][end]) {
                if (binary(matrix,target,i,start,end)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean binary(int[][] matrix, int target, int row,int start, int end){
        while (start<=end) {
            int mid = (start+end)/2;
            if (target>matrix[row][mid]) {
                start = mid+1;
            } else if (target<matrix[row][mid]) {
                end = mid-1;
            }
            else
                return true;
        }
        return false;
    }
}
