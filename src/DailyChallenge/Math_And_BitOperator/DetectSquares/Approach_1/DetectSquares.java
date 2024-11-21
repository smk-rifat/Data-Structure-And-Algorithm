package DailyChallenge.Math_And_BitOperator.DetectSquares.Approach_1;

import java.util.HashMap;
import java.util.Map;

class DetectSquares {
    // Map to store counts of points: y -> (x -> count)
    Map<Integer, Map<Integer, Integer>> pointCounts;

    public DetectSquares() {
        pointCounts = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        pointCounts.putIfAbsent(y, new HashMap<>());
        Map<Integer, Integer> xMap = pointCounts.get(y);
        xMap.put(x, xMap.getOrDefault(x, 0) + 1);
    }

    public int count(int[] point) {
        int queryX = point[0];
        int queryY = point[1];
        int count = 0;

        if (!pointCounts.containsKey(queryY)) {
            return count;
        }

        Map<Integer, Integer> sameYPoints = pointCounts.get(queryY);

        for (Map.Entry<Integer, Integer> entry : sameYPoints.entrySet()) {
            int currentX = entry.getKey();
            int currentXCount = entry.getValue();
            int sideLength = Math.abs(queryX - currentX);

            if (sideLength == 0) continue;

            count += countSquares(queryX, queryY, currentX, queryY + sideLength, currentXCount);
            count += countSquares(queryX, queryY, currentX, queryY - sideLength, currentXCount);
        }

        return count;
    }

    private int countSquares(int queryX, int queryY, int currentX, int targetY, int currentXCount) {
        if (!pointCounts.containsKey(targetY)) {
            return 0;
        }

        Map<Integer, Integer> targetYPoints = pointCounts.get(targetY);
        int count1 = targetYPoints.getOrDefault(currentX, 0);
        int count2 = targetYPoints.getOrDefault(queryX, 0);

        return currentXCount * count1 * count2;
    }

    public static void main(String[] args) {
        DetectSquares obj = new DetectSquares();
        obj.add(new int[]{3, 10});
        obj.add(new int[]{11, 2});
        obj.add(new int[]{3, 2});
        obj.add(new int[]{11, 2});
        obj.add(new int[]{11, 10});
        System.out.println(obj.count(new int[]{11, 10})); // Expected output: 1
    }
}
