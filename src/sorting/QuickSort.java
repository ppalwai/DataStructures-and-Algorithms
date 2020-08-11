package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{15, 5, 24, 8, 1, 3, 16, 10, 20})));

        //System.out.println(Arrays.toString(partition(new int[]{15, 5, 24, 8, 1, 3, 16, 10, 20}, 0, 8)));
    }

    static int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    static int[] quickSort(int[] arr, int lb, int ub) {
        if(lb < ub) {
            int pivotLoc = partition(arr, lb, ub);
            quickSort(arr, lb, pivotLoc - 1);
            quickSort(arr, pivotLoc + 1, ub);
        }
        return arr;
    }

    /**
     *
     * @param arr
     * @param lb
     * @param ub
     */
    static int partition(int[] arr, int lb, int ub) {
       System.out.println("array before partition: " + Arrays.toString(arr) + " : " + lb + " : " + ub);
       int pivot = arr[lb], start = lb, end = ub;
       int temp = 0;
       while(start < end) {
           while(arr[start] <= pivot) start++;
           while(arr[end] > pivot) end--;
           if(start < end) {
               temp = arr[start];
               arr[start] = arr[end];
               arr[end] = temp;
           }
       }
       temp = arr[lb];
       arr[lb] = arr[end];
       arr[end] = temp;
       System.out.println("array after parition: " + Arrays.toString(arr));
       return end;
    }
}