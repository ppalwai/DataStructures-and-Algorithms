import java.util.HashSet;
import java.util.Set;

public class LongestSubstringKDistinct {

    public static void main(String[] args){
        assert findLength("araaci", 2) == 4;

        assert findLength("araaci", 1) == 2;

        assert findLength("cbbebi", 3) == 5;

        assert findLength("aaaabcccb", 2) == 5;

    }

    public static int findLength(String str, int k) {
        int rv = 0, j = 0;

        Set<Character> chars = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            chars.add(str.charAt(i));

            if(chars.size() > k){
                if(i-j > rv){
                    rv = i - j;
                }
                chars.remove(str.charAt(j++));
                while(!chars.contains(str.charAt(j))){
                    j++;
                }
            }
        }

        return rv;
    }
}