package DailyChallenge.Greedy.HandOfStraights.Approach_1;
// https://leetcode.com/problems/hand-of-straights/

import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        Map<Integer, Integer> cardCount = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int card : hand){
            cardCount.put(card, cardCount.getOrDefault(card, 0) +1);
        }

        for(int key : cardCount.keySet()){
            minHeap.offer(key);
        }

        while(!minHeap.isEmpty()){
            int firstCard = minHeap.peek();

            for(int i = 0; i < groupSize; i++){
                int card = firstCard + i;

                if(!cardCount.containsKey(card) || cardCount.get(card) == 0) return false;

                cardCount.put(card, cardCount.get(card) -1);

                if(cardCount.get(card) == 0){
                    if(card != minHeap.peek()) return false;
                    minHeap.poll();
                }
            }
        }
        return true;
    }
}