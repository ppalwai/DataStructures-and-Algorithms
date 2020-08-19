import java.util.Arrays;

public class CheckRotateArray {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5};
        rotateArray(input);
        System.out.println("rotateArray(new int[]{1,2,3,4,5}): " + Arrays.toString(input));

        assert "[5, 1, 2, 3, 4]".equals(Arrays.toString(input));
    }

    public static void rotateArray(int[] arr){
        int temp = arr[arr.length - 1];
        for(int i = arr.length - 1; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }
}