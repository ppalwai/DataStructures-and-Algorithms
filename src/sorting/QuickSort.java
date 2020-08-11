package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{15, 5, 24, 8, 1, 3, 16, 10, 20})));

        //System.out.println(partition(new int[]{15, 5, 24, 8, 1, 3, 16, 10, 20}, 0, 8));
    }

    static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    static int[] quickSort(int[] arr, int lb, int ub) {
        if(lb < ub) {
            int pivotIndex = partition(arr, lb, ub);
            quickSort(arr, lb, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, ub);
        }
        return arr;
    }

    /**
     * Use the first element as the pivot
     * @param arr
     * @param lb
     * @param ub
     */
    /*
    static int partition(int[] arr, int lb, int ub) {
        System.out.println("array before partition: " + Arrays.toString(arr) + " : " + lb + " : " + ub);
        int start = lb, end = ub;
        while(start < end) {
            while (start < ub && arr[start] <= arr[lb]) start++;
            while (end > lb && arr[end] > arr[lb]) end--;
            if(start < end) {
                swap(arr, start, end);
            }
        }
        swap(arr, lb, end);
        System.out.println("array after parition: " + Arrays.toString(arr));

        return end;
    }
    */

    /**
     * Use last element as the pivot
     * @param arr
     * @param lb
     * @param ub
     * @return
     */
    static int partition(int[] arr, int lb, int ub) {
        System.out.println("array before partition: " + Arrays.toString(arr) + " : " + lb + " : " + ub);
        int pivotIndex = lb;
        for(int i = lb; i < ub; i++) {
            if(arr[i] <= arr[ub]) {
                swap(arr, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(arr, ub, pivotIndex);
        System.out.println("array after parition: " + Arrays.toString(arr));
        return pivotIndex;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}