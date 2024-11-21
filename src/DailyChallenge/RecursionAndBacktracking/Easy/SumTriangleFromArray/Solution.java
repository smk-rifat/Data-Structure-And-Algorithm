package DailyChallenge.RecursionAndBacktracking.Easy.SumTriangleFromArray;

import java.util.Arrays;

// https://www.geeksforgeeks.org/sum-triangle-from-array/
public class Solution {
    public static void main(String[] args) {
       int[] array = {1,2,3,4,5};
       trianglePrint(array);
    }
    static void triangle(int[] array){
        if (array.length == 1){
            System.out.println(Arrays.toString(array));
            return;
        }
        int[] temp = new int[array.length-1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = array[i+1]+array[i];
        }

        triangle(temp);
        System.out.println(Arrays.toString(array));
    }
    // using recursion instead of for loop
    static void trianglePrint(int[] array){
        if (array.length ==1){
            System.out.println(Arrays.toString(array));
            return;
        }
        int[] temp = new int[array.length-1];
        downCall(array, temp, 0); // this method populate the temp array using recursion
        triangle(temp);
        System.out.println(Arrays.toString(array));

    }

    private static void downCall(int[] array, int[] temp, int index) {
        if (index == temp.length){
            return;
        }
        temp[index] = array[index] + array[index+1];
        downCall(array, temp, index+1);
    }
}
