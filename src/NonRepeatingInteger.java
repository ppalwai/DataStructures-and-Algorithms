import java.util.HashMap;
import java.util.Map;

public class NonRepeatingInteger {

    public static void main(String[] args) {
        int rv = findFirstUnique(new int[]{4,4,4,3});
        System.out.println("findFirstUnique(new int[]{4,4,4,3}): " + rv);
        assert rv == 3;

        rv = findFirstUnique(new int[]{4,5,1,2,0,4});
        System.out.println("findFirstUnique(new int[]{4,5,1,2,0,4}): " + rv);
        assert rv == 5;
    }

    public static int findFirstUnique(int[] arr) {
        Map<Integer, Integer> nums = new HashMap<>();
        for(int i : arr){
            if(nums.containsKey(i)) {
                nums.put(i, nums.get(i)+1);
            } else {
                nums.put(i, 1);
            }
        }

        for(int i : arr) {
            if(nums.get(i) == 1) return i;
        }
        return -1;
    }
}