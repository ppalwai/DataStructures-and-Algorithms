public class CheckSecondMax {
    public static void main(String[] args) {
        int rv = findSecondMaximum(new int[]{9,2,3,6});
        System.out.println("findSecondMaximum(new int[]{9,2,3,6}): " + rv);
        assert rv == 6;

        rv = findSecondMaximum(new int[]{4,2,1,5,0});
        System.out.println("findSecondMaximum(new int[]{4,2,1,5,0}): " + rv);
        assert rv == 4;

        rv = findSecondMaximum(new int[]{6,6,2,1,5,0});
        System.out.println("findSecondMaximum(new int[]{6,6,2,1,5,0}): " + rv);
        assert rv == 5;
    }

    public static int findSecondMaximum(int[] arr) {
        int max=arr[0], secondMax=Integer.MIN_VALUE;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            } else if (arr[i] >= secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }

        return secondMax;
    }
}