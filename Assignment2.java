public class Assignment2 {

    public static void arithematicOperations(int a, int b){// as1
        int sum = a + b;
        int subtraction = a - b;
        int multiplication = a * b;

        System.out.println("Addition: " + sum);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        if (b != 0) {
            int division = a / b;
            int mod = a % b;
            System.out.println("Division: " + division);
            System.out.println("Modulus: " + mod);
        } else {
            System.out.println("Division and Modulus: Cannot divide by zero");
        }
    }

    public static void incrementDecrement(int n){// as2
        System.out.println("n: " + n);
        System.out.println("Pre-increment (++n): " + (++n));
        System.out.println("Post-increment (n++): " + (n++));
        System.out.println("Pre-decrement (--n): " + (--n));
        System.out.println("Post-decrement (n--): " + (n--));
    }

    public static void compoundOperators(int x){// as3
        System.out.println("x: " + x);
        x += 1;
        System.out.println("After x += 1: " + x);
        x -= 1;
        System.out.println("After x -= 1: " + x);
        x *= 2;
        System.out.println("After x *= 2: " + x);
        if (x != 0) {
            x /= 2;
            System.out.println("After x /= 2: " + x);
            x %= 2;
            System.out.println("After x %= 2: " + x);
        } else {
            System.out.println("Skipping division and modulus operations by zero");
        }
    }

    public static void relationalOperators(int a, int b){ //as 4
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));
    }

    public static void logicalOperators(boolean a, boolean b){// as 5
        System.out.println("x && y: " + (a && b));
        System.out.println("x || y: " + (a || b));
        System.out.println("!x: " + (!a));
        System.out.println("!y: " + (!b));
    }

    public static void bitwiseOperators(int a, int b){// as 6
        System.out.println("a & b (AND): " + (a & b));
        System.out.println("a | b (OR): " + (a | b));
        System.out.println("a ^ b (XOR): " + (a ^ b));
        System.out.println("~a (NOT a): " + (~a));
        System.out.println("~b (NOT b): " + (~b));
        System.out.println("a << 1 (Left Shift): " + (a << 1));
        System.out.println("b << 1 (Left Shift): " + (b << 1));
        System.out.println("a >> 1 (Right Shift): " + (a >> 1));
        System.out.println("b >> 1 (Right Shift): " + (b >> 1));
    }

    public static void ternaryOperator(int a){//as 7

        String result = (a % 2 == 0) ? "Even" : "Odd";
        System.out.println("The number " + a + " is " + result + ".");
    }

    public static void mixOperators(int a, int b, int c){// as 8
        boolean condition = (a + b > c) && (b != 0);
        System.out.println("(a + b > c) && (b != 0): " + condition);
    }


    public static void main(String[] args){
        arithematicOperations(10,5);

        incrementDecrement(10);

        compoundOperators(10);

        relationalOperators(5, 6);

        logicalOperators(true, false);

        bitwiseOperators(5,6);

        ternaryOperator(5);

        mixOperators(5,6,7);


    }
}
