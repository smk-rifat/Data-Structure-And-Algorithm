package DailyChallenge.ArrayAndHashing.DM;

public class ArrayDemo
{
    public static void main(String[] args) {

    }
    public int[] productExceptSelf(int[] nums)
    {
        int N = nums.length;
        int[] ans = new int[nums.length];
        int productOfLeft = 1; // cause there is no element before left most and right most element!!!

        for (int i = 0; i < N; i++)
        {
            ans[i] = productOfLeft;
            productOfLeft *= nums[i];
        }
        int productOfRight = 1;

        for (int i = N-1; i >= 0; i--)
        {
            ans[i] *= productOfRight;
            productOfRight *= nums[i];
        }
        return ans;
    }

}
