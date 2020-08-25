import java.util.HashMap;
import java.util.Map;

public class FruitsAndBaskets {

    public static void main(String[] args) {
        findLength(new int[] {3,3,3,1,2,1,1,2,3,3,4});
    }

    public static int findLength(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int rv = 0, windowStart = 0;
        Map<Integer, Integer> fruits = new HashMap<>();

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            fruits.put(arr[windowEnd], fruits.getOrDefault(arr[windowEnd], 0) + 1);
            
            while(fruits.size() >= 3){
                fruits.put(arr[windowStart], fruits.get(arr[windowStart]) - 1);
                if(fruits.get(arr[windowStart]) == 0)
                    fruits.remove(arr[windowStart]);
                windowStart++;
            }
            rv = Math.max(windowEnd - windowStart + 1, rv);
        }
        System.out.println("rv: " + rv);
        return rv;
    }
}