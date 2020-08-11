package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{15, 5, 24, 8, 1, 3, 16, 10, 20})));
    }

    static int[] mergeSort(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int[] mergeSort(int[] arr, int lb, int ub) {
        if(lb < ub) {
            int mid = (lb + ub)/2;
            mergeSort(arr, lb, mid);
            mergeSort(arr, mid+1, ub);
            merge(arr, lb, mid, ub);
        }
        return arr;
    }

    /**
     * Merge left and right sorted lists and return the updated list.
     * 1. compare each element of left array with right array and copy the lowest value to the result array,
     * depending on which ever array had the lowest value, move that pointer and also move the pointer for the result array.
     * 2. If the pointer for either left or right array reaches the end, copy all of the remaining elements from the other array into result array.
     * 3. Copy the result array into the original array and return the original array.
     * @param arr
     * @param lb
     * @param mid
     * @param ub
     * @return
     */
    static int [] merge(int[] arr, int lb, int mid, int ub) {
        System.out.println(Arrays.toString(arr) + " : " + lb + " : " + mid + " : " + ub);
        int leftIdx = lb, rightIdx = mid+1;
        System.out.println(Arrays.toString(arr));
        int[] rv = new int[ub - lb + 1];
        for(int i = 0; i < rv.length; i++) {
            if(leftIdx > mid) {
                rv[i] = arr[rightIdx++];
            } else if(rightIdx > ub) {
                rv[i] = arr[leftIdx++];
            } else if(arr[leftIdx] < arr[rightIdx]){
                rv[i] = arr[leftIdx++];
            } else {
                rv[i] = arr[rightIdx++];
            }
        }
        System.out.println("rv: " + Arrays.toString(rv));
        System.arraycopy(rv, 0, arr, lb, rv.length);
        return arr;
    }
}