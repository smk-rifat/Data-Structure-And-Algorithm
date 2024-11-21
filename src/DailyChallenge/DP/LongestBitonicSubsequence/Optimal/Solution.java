package DailyChallenge.DP.LongestBitonicSubsequence.Optimal;

class Solution {
    public static int LongestBitonicSequence(int n, int[] arr) {
        if (n <= 1)
            return n;

        int[] lis = new int[n];
        int[] tailLis = new int[n];

        int lenLis = 0;

        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int pos = binarySearch(tailLis, lenLis, key);

            if (pos < lenLis) {
                tailLis[pos] = key;
            } else {
                tailLis[lenLis] = key;
                lenLis++;
            }
            lis[i] = pos + 1;
        }

        int[] lds = new int[n];
        int[] tailLds = new int[n];
        int lenLds = 0;

        for (int i = n - 1; i >= 0; i--) {
            int key = arr[i];
            int pos = binarySearch(tailLds, lenLds, key);

            if (pos < lenLds) {
                tailLds[pos] = key;
            } else {
                tailLds[lenLds] = key;
                lenLds++;
            }
            lds[i] = pos + 1;
        }
        
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (lds[i] > 1 && lis[i] > 1) {
                max = Math.max(max, lds[i] + lis[1] - 1);
            }
        }

        return max;
    }

    public static int binarySearch(int[] tail, int length, int key) {
        int low = 0, high = length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (tail[mid] >= key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
