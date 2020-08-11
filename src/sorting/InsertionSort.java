package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println("insertionSort: " + Arrays.toString(insertionSort(new int[]{2, 5, 1, 20, 8, 15, 0, 5, 2})));

        System.out.println("insertionSort: " + Arrays.toString(insertionSort(new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0})));
    }

    static int[] insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        return arr;
    }
}