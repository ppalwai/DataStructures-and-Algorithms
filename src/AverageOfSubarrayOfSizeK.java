import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {
    public static void main(String[] args){
        System.out.println("findAverages(5, new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2}): " + Arrays.toString(findAverages(5, new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2})));

        System.out.println("findAveragesImproved(5, new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2}): " + Arrays.toString(findAveragesImproved(5, new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2})));

        System.out.println("findAveragesImproved(5, null): " + Arrays.toString(findAveragesImproved(5, null)));

        System.out.println("findAveragesImproved(5, new int[] {1,2,3,4}): " + Arrays.toString(findAveragesImproved(5, new int[]{1,2,3,4})));

        System.out.println("findAveragesImproved(5, new int[] {1,2,3,4,5}): " + Arrays.toString(findAveragesImproved(5, new int[]{1,2,3,4,5})));
        
    }

    //brute force approach
    private static double[] findAverages(int K, int[] arr) {
        if(arr == null || arr.length < K) return new double[]{0};

        double[] rv = new double[arr.length - 5 + 1];
        for(int i = 0; i <= arr.length - K; i++){
            double sum = 0;
            for(int j = i; j < i+5; j++){
                sum += arr[j];
            }
            rv[i] = sum/5;
        }

        return rv;
    }
    
    private static double[] findAveragesImproved(int K, int[] arr) {
        if(arr == null || arr.length < K) return new double[]{0};

        double[] rv = new double[arr.length - 5 + 1];
        double sum = 0;
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(i >= K - 1){
                rv[j] = sum/5;
                sum -= arr[j];
                j++;
            }
        }

        return rv;
    }
}