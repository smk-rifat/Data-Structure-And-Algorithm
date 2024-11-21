package DailyChallenge.RecursionAndBacktracking.Easy.RemoveDuplicateFromString;

public class Solution {
    public static void main(String[] args) {
        String str = "aaaabbbb";
        System.out.println(removeDuplicate(str));
    }
    static String removeDuplicate(String str){
        if (str.length() <=1){
            return str;
        }
        if (str.charAt(0) == str.charAt(1)){
            return removeDuplicate(str.substring(1));
        }
        else {
            return str.charAt(0)+ removeDuplicate(str.substring(1));
        }

    }
}
