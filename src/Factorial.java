public class Factorial {
    public static void main(String[] args) {
        System.out.println("factorialIterative(5): " + factorialIterative(5));
        System.out.println("factorialRecursive(5): " + factorialRecursive(5));
    }

    static long factorialRecursive(int input) {
        if(input == 1) return 1;
        return input * factorialRecursive(input - 1);
    }

    static long factorialIterative(int input) {
        long rv = 1;
        for(int i = 1; i <= input; i++) {
            rv *= i;
        }
        return rv;
    }
}