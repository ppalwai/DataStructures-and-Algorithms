package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println("selectionSort: " + Arrays.toString(selectionSort(new int[]{2, 5, 1, 20, 8, 15, 0, 5, 2})));

        System.out.println("selectionSort: " + Arrays.toString(selectionSort(new int[]{99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0})));
    }

    static int[] selectionSort(int[] arr) {
        int idx, temp;
        for(int i = 0; i < arr.length; i++) {
            idx = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] < arr[idx]){
                    idx = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
        return arr;
    }
}