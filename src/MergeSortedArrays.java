import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{0, 3, 4, 31}, new int[]{4, 6, 30})));

        System.out.println(Arrays.toString(merge(new int[]{0, 3, 4, 31}, null)));

        System.out.println(Arrays.toString(merge(null, new int[]{4, 6, 30})));

        System.out.println(Arrays.toString(merge(new int[]{}, new int[]{4, 6, 30})));

        System.out.println(Arrays.toString(merge(new int[]{0, 3, 4, 31}, new int[]{})));
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        if(arr1 == null || arr1.length == 0) return arr2;
        if(arr2 == null || arr2.length == 0) return arr1;

        int[] rv = new int[arr1.length + arr2.length];

        int j= 0, k=0;

        for(int i = 0; i < rv.length; i++) {
            if(k == arr2.length || arr1[j] <= arr2[k]) {
                rv[i] = arr1[j];
                if(j < arr1.length) j++;
            } else if (j == arr1.length || arr2[k] < arr1[j]) {
                rv[i] = arr2[k];
                if(k < arr2.length) k++;
            }
        }
        return rv;
    }
}
