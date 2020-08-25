public class SmallestSubarrayWithGivenSum {

    public static void main(String[] args) {
        System.out.println("findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2}): " + findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2}));

        System.out.println("findMinSubArray(7, new int[] {2, 1, 5, 2, 8}): " + findMinSubArray(7, new int[] {2, 1, 5, 2, 8}));

        System.out.println("findMinSubArray(8, new int[] {3, 4, 1, 1, 6}): " + findMinSubArray(8, new int[] {3, 4, 1, 1, 6}));

        assert findMinSubArray(7, new int[] {2, 1, 5, 2, 3, 2}) == 2;

        assert findMinSubArray(7, new int[] {2, 1, 5, 2, 8}) == 1;

        assert findMinSubArray(8, new int[] {3, 4, 1, 1, 6}) == 3;

    }

    public static int findMinSubArray(int S, int[] arr) {
        int rv = arr.length+1, sum = 0, j = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum > S){
                while(sum >= S){
                    if(i - j + 1 < rv){
                        rv = i - j + 1;
                    }
                    sum -= arr[j];
                    j++;
                }
            }
        }
        if(rv == arr.length + 1) return 0;
        return rv;
    }
    
}