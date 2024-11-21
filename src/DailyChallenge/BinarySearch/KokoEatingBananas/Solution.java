package DailyChallenge.BinarySearch.KokoEatingBananas;
//
class Solution {
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        //System.out.println(bruteForce(piles,h));
        System.out.println(binarySearch(piles, h));
    }
    public static int bruteForce(int[] piles, int h) {
        int ans = 0;
        int maxPile = maxPile(piles);
        for (int k = 1; k <= maxPile; k++) {
            int reqTime = 0;
            for (int pile : piles) {
                reqTime += (int) Math.ceil((double) pile/k);
            }
            if (reqTime <=h){
                ans = k;
                break;
            }
        }
        return ans;
    }
    public static int maxPile(int[] piles)
    {
        int maxPile = 0;
        for (int pile : piles)
        {
            maxPile = Math.max(maxPile, pile);
        }
        return maxPile;
    }
    public static int binarySearch(int[] piles, int h){
        int ans = 0;
        int start = 1;
        int end = 1000000000;
        int reqTime = 0;

        while (start <= end) {
            int mid = (start+end)/2;
            reqTime = reqTimeFork(piles, mid);
            if (reqTime <= h) {
                ans = mid;
                end = mid-1;
            }
            else {
                start = mid+1;
            }

        }
      return ans;
    }
    public static int reqTimeFork(int[] piles, int k) {
        int reqTime = 0;
        for (int pile : piles) {
            reqTime += (int) Math.ceil(1.0* pile/k);
        }
        return reqTime;
    }
}
