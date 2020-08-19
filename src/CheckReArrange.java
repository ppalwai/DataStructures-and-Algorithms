import java.util.Arrays;

public class CheckReArrange {
    public static void main(String[] args) {
        int[] arr = new int[]{10,-1,20,4,5,-9,-6};
        reArrange(arr);
        System.out.println("reArrange(new int[]{10,-1,20,4,5,-9,-6}): " + Arrays.toString(arr));

        assert "[-6, -1, -9, 4, 5, 20, 10]".equals(Arrays.toString(arr));
    }

    public static void reArrange(int[] arr) {
        int i = 0, j = arr.length - 1;
        while(i < j) {
            if(arr[i] > 0) {
                while(arr[j] > 0) {
                    j--;
                }
                if(i < j) {
                    swap(arr, i, j);
                    j--;
                }
            }
            i++;
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}