package DailyChallenge.RecursionAndBacktracking.Theory.Recursion.SubSet;

import java.util.ArrayList;

public class Subseq {
    public static void main(String[] args) {
        String string = "abc";
        System.out.println(seqList("", string));
    }
    static void seq(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        seq(p+ch, up.substring(1));
        seq(p, up.substring(1));
    }
    static ArrayList<String> seqList(String p, String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = seqList(p+ch, up.substring(1));
        ArrayList<String> right = seqList(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}
