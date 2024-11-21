package DailyChallenge.Greedy.ValidParenthesisString.Approach_2;

class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // Minimum possible number of unmatched '('
        int maxOpen = 0; // Maximum possible number of unmatched '('

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '(') {
                // '(' increases both minOpen and maxOpen
                minOpen++;
                maxOpen++;
            } else if (currentChar == ')') {
                // ')' decreases both minOpen and maxOpen
                if (minOpen > 0) {
                    minOpen--; // Ensure minOpen does not go below 0
                }
                maxOpen--;
            } else { // currentChar == '*'
                // '*' can be treated as '(', ')' or empty string
                if (minOpen > 0) {
                    minOpen--; // Treat '*' as ')' or empty string
                }
                maxOpen++; // Treat '*' as '('
            }

            // If maxOpen is negative, we have more ')' than '(' + '*' and it's invalid
            if (maxOpen < 0) {
                return false;
            }
        }

        // If minOpen is 0, it means all '(' can be matched appropriately
        return minOpen == 0;
    }

}
