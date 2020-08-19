import java.util.Arrays;

public class CheckMaxMin {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        maxMin(arr);
        System.out.println("maxMin(new int[]{1,2,3,4,5,6,7}): " + Arrays.toString(arr));
        assert "[7, 1, 6, 2, 5, 3, 4]".equals(Arrays.toString(arr));

        arr = new int[]{-7,-6,-5,-4,-3,-2,-1,0};
        maxMin(arr);
        System.out.println("maxMin(new int[]{-7,-6,-5,-4,-3,-2,-1,0}): " + Arrays.toString(arr));
        assert "[0, -7, -1, -6, -2, -5, -3, -4]".equals(Arrays.toString(arr));
    }

    public static void maxMin(int[] arr) {
        int i = 0, j = arr.length - 1;
        int[] rv = new int[arr.length];
        int counter = 0;
        while(i < j) {
            rv[counter++] = arr[j--];
            rv[counter++] = arr[i++];
        }
        if(i == j) rv[counter] = arr[i];
        for(i = 0; i < arr.length; i++) {
            arr[i] = rv[i];
        }
    }
}