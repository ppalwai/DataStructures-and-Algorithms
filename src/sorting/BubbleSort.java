package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println("bubbleSort: " + Arrays.toString(bubbleSort(new int[]{2, 5, 1, 20, 8, 15, 0, 5, 2})));

        System.out.println("bubbleSort: " + Arrays.toString(bubbleSort(new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0})));

        System.out.println("bubbleSortNestedLoops: " + Arrays.toString(bubbleSortNestedLoops(new int[]{2, 5, 1, 20, 8, 15, 0, 5, 2})));

        System.out.println("bubbleSortNestedLoops: " + Arrays.toString(bubbleSortNestedLoops(new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0})));
    }

    static int[] bubbleSort(int[] arr) {
        boolean sort = true;
        int temp;
        while(sort) {
            sort = false;
            for(int i = 0; i < arr.length-1; i++) {
                if(arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sort = true;
                }
            }
        }
        return arr;
    }

    static int[] bubbleSortNestedLoops(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++){
                if(arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}