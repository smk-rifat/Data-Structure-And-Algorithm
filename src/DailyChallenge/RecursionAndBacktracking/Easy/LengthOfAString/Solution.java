package DailyChallenge.RecursionAndBacktracking.Easy.LengthOfAString;

public class Solution {
    public static void main(String[] args) {
        String s = "rifat";
        System.out.println(length(s));
    }
    static int length(String str){
        if (str.isEmpty()){
            return 0;
        }
        return length(str.substring(1))+1;
    }
}
