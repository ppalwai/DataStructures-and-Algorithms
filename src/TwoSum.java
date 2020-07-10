import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        var values = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(values.containsKey(target - nums[i])){
                return new int[]{values.get(target - nums[i]), i};
            } else {
                values.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
