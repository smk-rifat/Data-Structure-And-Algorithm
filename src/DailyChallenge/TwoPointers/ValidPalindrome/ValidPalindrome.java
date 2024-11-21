package DailyChallenge.TwoPointers.ValidPalindrome;

// https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public static void main(String[] args)
    {
       String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length()-1;

        while (i<j)
        {
            char start = s.charAt(i);
            char end = s.charAt(j);
            if (!Character.isLetterOrDigit(start))
            {
                i++; // here we put the pointer to a letter.
                continue; // if we don't use continue here then i will again increment at the end
            }
            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(start) != Character.toLowerCase(end))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
