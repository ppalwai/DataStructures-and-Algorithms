public class MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        System.out.println("findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}): " + findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("findMaxSumSubArray(2, new int[] {2, 3, 4, 1, 5}): " + findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));

        System.out.println("findMaxAverage(1, new int[] {-1}): " + findMaxAverage(1, new int[] {-1}));

        
    }

    private static double findMaxAverage(int k, int[] arr) {
        if(arr == null || arr.length < k) return 0;
        
        double rv = -10000;

        double sum = 0;
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(i >= k-1){
                if(sum/k > rv)
                    rv = sum/k;
                sum -= arr[j++];
            }
        }
        return rv;
    }

    private static int findMaxSumSubArray(int k, int[] arr) {
        if(arr == null || arr.length < k) return 0;

        int rv = Integer.MIN_VALUE;

        int sum = 0, j = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(i >= k-1){
                if(sum > rv)
                    rv = sum;
                sum -= arr[j++];
            }
        }
        return rv;
    }
}