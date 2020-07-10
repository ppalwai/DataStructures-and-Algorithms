public class StringReverse {
    public static void main(String[] args){
        System.out.println(reverse("Hi My name is Praveen"));

        System.out.println(efficient_reverse("Hi My name is Praveen"));
    }

    //Works but not very efficient, since we are creating many intermediate strings and
    //compiler cannot optimize it to use StringBuilder since we are doing the concatenation inside a loop
    private static String reverse(String str){
        if(null == str) return null;

        if(str.length() < 2) return str;

        String rv = "";
        for(int i = str.length() - 1; i >= 0; i--){
            rv += str.charAt(i);
        }
        return rv;
    }

    private static String efficient_reverse(String str){
        if(null == str) return null;

        if(str.length() < 2) return str;

        StringBuilder sb = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
