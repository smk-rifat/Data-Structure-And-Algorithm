package DailyChallenge.RecursionAndBacktracking.Easy.FindUpperCaseLetterInString;
// https://www.geeksforgeeks.org/first-uppercase-letter-in-a-string-iterative-and-recursive/
public class Solution {
    public static void main(String[] args) {
        String str = "rifAt";
        System.out.println(upperCaseLetter(str));
    }
    static char upperCaseLetter(String string){
        if (string.isEmpty()){
            return '0';
        }
        char ch = string.charAt(0);
        if ( !Character.isUpperCase(ch)){
            ch = upperCaseLetter(string.substring(1));
        }
        return ch;
    }
}
