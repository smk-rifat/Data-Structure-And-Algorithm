package DailyChallenge.Greedy.HandOfStraights.Approach_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/hand-of-straights/
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Map<Integer, Integer> cardCount = new HashMap<>();
        Arrays.sort(hand);

        for(int card : hand){
            cardCount.put(card, cardCount.getOrDefault(card, 0) +1);
        }

        for(int card : hand){
            if (cardCount.get(card) == 0) {
                continue;
            }

            for (int i = 0; i < groupSize; i++) {
                int remaining = cardCount.getOrDefault(card + i, 0);
                
                if (remaining > 0) {
                    cardCount.put(card + i, cardCount.get(card + i) -1);
                } else {
                    return false;
                }
            }

        }
        return true;
    }
}