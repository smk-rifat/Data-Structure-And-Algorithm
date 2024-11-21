package DailyChallenge.RecursionAndBacktracking.Theory.Recursion;

public class Skip {
    public static void main(String[] args) {
        String s = "abcappgapple";
        System.out.println(skipApp(s));
    }
    static void skip(String ans, String str){
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        if (ch != 'a'){
            skip(ans+ch, str.substring(1));
        }else {
            skip(ans, str.substring(1));
        }
    }
    static String skip2(String str) {
        if (str.isEmpty()) return "";
        char ch = str.charAt(0);
        if (ch != 'a'){
            return ch+skip2(str.substring(1));
        }else {
            return skip2(str.substring(1));
        }
    }
    static String skipApp(String string){
        if (string.isEmpty()) return "";
        char ch = string.charAt(0);
        if (string.startsWith("app") && !string.startsWith("apple")){
            return skipApp(string.substring(3));
        }else {
            return ch+skipApp(string.substring(1));
        }
    }
}
