import java.util.*;

public class Recursion {

    static int sum = 0;

    public static void main(String[] args) {
        // FUNCTIONS CALLING OTHER FUNCTION
        print1(1);

        // FUNCTION CALLING SAME FUNCTION --->> RECURSION
        System.out.println(print(1));
        System.out.println("Fibonacci >> ");
        System.out.println(fib(5));
        System.out.println("factorial >> ");
        System.out.println(fact(5));
        System.out.println("Sum upto n Natural number: ");
        System.out.println(sum(4));
        System.out.println("Summation  of digits of a number");
        System.out.println(sumDigits(1300));
        System.out.println("product of digits of a number");
        System.out.println(mulDigits(55));
        System.out.println("NUMBER FROM N TO 1 ");
        fun(5);
        System.out.println("REVERSE USING STATIC GLOBAL VARIABLE ");
        reverse(1234);
        System.out.println(sum);
        System.out.println("REVERSE USING HELPER FUNCTION");
        System.out.println(rev2(1234));
        int n = 12541;
        System.out.println("PALINDROME OR NOT");
        System.out.println(isPalin(n));

    }

    // FUNCTIONS CALLING OTHER FUNCTION **********

    public static void print1(int n) {
        System.out.print(n + " ");
        print2(2);
    }

    public static void print2(int n) {
        System.out.print(n + " ");
        print3(3);
    }

    public static void print3(int n) {
        System.out.print(n + " ");
        print4(4);
    }

    public static void print4(int n) {
        System.out.print(n + " ");
        print5(5);
    }

    public static void print5(int n) {
        System.out.println(n + " ");
    }

    // FUNCTION CALLING SAME FUNCTION --->> RECURSION **********************
    public static int print(int n) {
        // BASE CONDITION
        if (n == 5) {
            return n;
        }
        // IF NOT BASE CONDITION -->> PRINT THE NUMBER AND CALL FUNCTION FOR NEXT NUMBER
        System.out.print(n + " ");
        return print(n + 1);
    }

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        return (fib(n - 1) + fib(n - 2));
    }

    // FACTORIAL **********************

    public static double fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    // SUM OF N NUMBERS *********************
    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    // sum of digits of a number *********************
    public static int sumDigits(int n) {
        if (n <= 0) {
            return 0;
        }
        return n % 10 + sumDigits(n / 10);
    }

    // multiply of digits of a number  *********************
    public static int mulDigits(int n) {
        if (n % 10 == n) {
            return n;
        }
        return n % 10 * mulDigits(n / 10);
    }

    public static void fun(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        fun(--n);
    }

    // REVERSE USING STATIC GLOBAL VARIABLE - SUM *********************
    public static void reverse(int n) {
        if (n == 0) {
            return;
        }
        sum = sum * 10 + n % 10;
        reverse(n / 10);
    }

    public static int helper(int n, int digits) {
        if (digits == 1) {
            return n; // if 1 digit number
        }
        int rem = n % 10;
        return (int) (rem * Math.pow(10, digits - 1) + helper(n / 10, digits - 1));
    }

    // REVERSE USING HELPER FUNCTION *********************

    public static int rev2(int n) {
        // FIRST CALCULTE NO. OF DIGITS IN THE NUMBER
        int digits = (int) (Math.log10(n)) + 1;
        // USE HELPER FUNCTION TO
        return helper(n, digits);

    }

    // PALINDROME *********************
    public static boolean isPalin(int n) {
        return (n == rev2(n));
    }

}
