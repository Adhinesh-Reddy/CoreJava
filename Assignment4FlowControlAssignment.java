public class Assignment4FlowControlAssignment{
    public static void printNaturalNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printEvenNumbers() {
        for (int i = 2; i <= 100; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printOddNumbers() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int sumOfEvenNumbers(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }

    public static int sumOfOddNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }

    public static void printMultiplicationTable(int num) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
    }

    public static int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void printNaturalNumbersReverse(int n) {
        for (int i = n; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void printPrimeNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static int sumOfPrimes(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }

    public static boolean isArmstrong(int num) {
        int originalNum = num, sum = 0, digits = countDigits(num);
        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }
        return sum == originalNum;
    }
    
    public static void printArmstrongNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            if (isArmstrong(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static boolean isPerfect(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public static void printPerfectNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            if (isPerfect(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static boolean isStrong(int num) {
        int originalNum = num, sum = 0;
        while (num > 0) {
            sum += factorial(num % 10);
            num /= 10;
        }
        return sum == originalNum;
    }

    public static void printStrongNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            if (isStrong(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static int swapFirstLastDigit(int num) {
        String numStr = Integer.toString(num);
        if (numStr.length() == 1) return num; // Single digit number remains the same
        char[] chars = numStr.toCharArray();
        char temp = chars[0];
        chars[0] = chars[chars.length - 1];
        chars[chars.length - 1] = temp;
        return Integer.parseInt(new String(chars));
    }

    public static void swapUsingThirdVariable(int a, int b) {
        System.out.println("Before Swap: a = " + a + ", b = " + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("After Swap: a = " + a + ", b = " + b);
    }

    public static void swapWithoutThirdVariable(int a, int b) {
        System.out.println("Before Swap: a = " + a + ", b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After Swap: a = " + a + ", b = " + b);
    }

    public static int calculatePower(int base, int exp) {
        int result = 1;
        for (int i = 1; i <= exp; i++) {
            result *= base;
        }
        return result;
    }

    public static double calculatePowerUsingPow(int base, int exp) {
        return Math.pow(base, exp);
    }

    public static boolean isPalindrome(int num) {
        int originalNum = num, reversedNum = 0;
        while (num > 0) {
            reversedNum = reversedNum * 10 + num % 10;
            num /= 10;
        }
        return originalNum == reversedNum;
    }

    public static void printFibonacciSeries(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series: " + a + " " + b + " ");
        for (int i = 3; i <= n; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void printFibonacciRecursive(int n) {
        System.out.print("Fibonacci Series (Recursive): ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println();
    }

    public static void printDigitFrequency(int num) {
        int[] frequency = new int[10]; // Array to store frequency of digits (0-9)
        while (num > 0) {
            frequency[num % 10]++;
            num /= 10;
        }
        System.out.println("Digit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + ": " + frequency[i] + " times");
            }
        }
    }

    public static void printASCIICharacters() {
        System.out.println("ASCII Characters and their values:");
        for (int i = 0; i <= 255; i++) {
            System.out.println((char) i + " = " + i);
        }
    }

    public static void printAlphabets() {
        System.out.println("Lowercase alphabets:");
        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    public static void printUppercaseAlphabets() {
        System.out.println("Uppercase alphabets:");
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    public static void printLowercaseAlphabets() {
        System.out.println("Lowercase alphabets:");
        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    public static void printFactors(int num) {
        System.out.println("Factors of " + num + ":");
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    public static void printPrimeFactors(int num) {
        System.out.println("Prime Factors of " + num + ":");
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        printNaturalNumbers(5);

        printEvenNumbers();

        printOddNumbers();

        sumOfEvenNumbers(10);

        sumOfOddNumbers(10);

        printMultiplicationTable(5);

        countDigits(12345);

        sumOfDigits(12345);

        printNaturalNumbersReverse(5);

        isPrime(7);

        printPrimeNumbers(10);

        sumOfPrimes(10);

        isArmstrong(153);

        printArmstrongNumbers(1000);

        isPerfect(28);

        printPerfectNumbers(100);

        isStrong(145);

        printStrongNumbers(100);

        swapFirstLastDigit(12345);

        swapUsingThirdVariable(10, 20);

        swapWithoutThirdVariable(10, 20);

        calculatePower(2,3);

        calculatePowerUsingPow(2,3);

        isPalindrome(12321);

        printFibonacciSeries(10);

        fibonacciRecursive(10);

        printFibonacciRecursive(10);

        printDigitFrequency(12345);

        printASCIICharacters();

        printAlphabets();

        printUppercaseAlphabets();

        printLowercaseAlphabets();

        printFactors(10);

        findGCD(10, 20);

        findLCM(10, 20);

        printPrimeFactors(100);

    }
}