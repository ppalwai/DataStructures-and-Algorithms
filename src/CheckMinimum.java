import java.util.Arrays;

public class CheckMinimum {

    public static void main(String[] args) {

        int min = findMinimum_Streams(new int[]{100,12,34,40});
        System.out.println("streams testCase1 result: " + min);
        assert min == 12;

        min = findMinimum_Streams(new int[]{4,5,0,3,6});
        System.out.println("streams testCase2 result: " + min);
        assert min == 0;

        min = findMinimum(new int[]{100,12,34,40});
        System.out.println("Non-Stream testCase1 result: " + min);
        assert min == 12;

        min = findMinimum(new int[]{4,5,0,3,6});
        System.out.println("Non-Stream testCase2 result: " + min);
        assert min == 0;
    }

    public static int findMinimum_Streams(int[] arr) {
        return Arrays.stream(arr).min().getAsInt();
    }

    public static int findMinimum(int[] arr) {
        int rv = Integer.MAX_VALUE;
        for(int i : arr){
            if(i < rv) rv = i;
        }
        return rv;
    }
}