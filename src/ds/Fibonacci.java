package ds;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("fibonacciIterative(0): " + fibonacciIterative(0));
        System.out.println("fibonacciIterative(1): " + fibonacciIterative(1));
        System.out.println("fibonacciIterative(2): " + fibonacciIterative(2));
        System.out.println("fibonacciIterative(12): " + fibonacciIterative(12));

        System.out.println("fibonacciRecursive(0): " + fibonacciRecursive(0));
        System.out.println("fibonacciRecursive(1): " + fibonacciRecursive(1));
        System.out.println("fibonacciRecursive(2): " + fibonacciRecursive(2));
        System.out.println("fibonacciRecursive(12): " + fibonacciRecursive(12));
    }

    static int fibonacciIterative(int n) {
        if(n < 2) return n;
        int i1 = 0, i2 = 1;
        int rv = 0;
        for(int i = 2; i <= n; i++) {
            rv = i1 + i2;
            i1 = i2;
            i2 = rv;
        }
        return rv;
    }

    static int fibonacciRecursive(int n) {
        if(n < 2) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}