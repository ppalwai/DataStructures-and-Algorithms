import java.util.HashSet;

public class FirstRecurringCharacter {

    public static void main(String[] args) {
        System.out.println(firstRecurringCharacter(new int[]{2,5,1,2,3,5,1,2,4}));

        System.out.println(firstRecurringCharacter(new int[]{2,1,1,2,3,5,1,2,4}));

        System.out.println(firstRecurringCharacter(new int[]{2,3,4,5}));

        System.out.println(firstRecurringCharacter(new int[]{2}));

        System.out.println(firstRecurringCharacter(new int[]{}));

        System.out.println(firstRecurringCharacter(null));
    }

    private static Integer firstRecurringCharacter(int[] arr) {
        if(arr == null || arr.length < 2) return null;
        var map = new HashSet<Integer>();
        for(int i = 0; i < arr.length; i++){
            if(map.contains(arr[i])) return arr[i];
            else map.add(arr[i]);
        }
        return null;
    }
}