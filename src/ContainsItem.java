import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContainsItem {
    public static void main(String args[]){
        String[] arr1 = {"a", "b", "c", "x"};
        String[] arr2 = {"z", "y", "r"};
        System.out.println(containsCommonItem(arr1, arr2));
    }

    private static boolean containsCommonItem(String[] arr1, String[] arr2) {
        Set<String> set = Stream.of(arr1).collect(Collectors.toCollection(HashSet::new));
        for(String item : arr2){
            if(set.contains(item)) return true;
        }
        return false;
    }
}