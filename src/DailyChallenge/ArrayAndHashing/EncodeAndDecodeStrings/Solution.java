package DailyChallenge.ArrayAndHashing.EncodeAndDecodeStrings;
// https://www.lintcode.com/problem/659/discuss
import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public String encode(List<String> strs) {
        // write your code here
      StringBuilder encode = new StringBuilder();
      for (String str : strs){
          int size = str.length();
          encode.append((char) size).append(str);
      }
      return encode.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> decode = new ArrayList<>();
        int start = 0;

        while (start <  str.length()){
            int size = str.charAt(start);
            start++;
            int end = size+start;
            decode.add(str.substring(start, end));
            start = end;
        }
        return decode;

    }
}
