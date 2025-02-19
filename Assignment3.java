public class Assignment3 {

    public static void max2(int a, int b){
        if (a > b) {
            System.out.println("Maximum number is: " + a);
        } else {
            System.out.println("Maximum number is: " + b);
        }
    }

    public static void max3(int a, int b, int c){
        int maxi = 0;
        if (a >= b && a >= c) {
            maxi = a;
        } else if (b >= a && b >= c) {
            maxi = b;
        } else {
            maxi = c;
        }
    }

    public static void divisible3(int a){
        if (a % 3 == 0) {
            System.out.println(a + " is divisible by 3.");
        } else {
            System.out.println(a + " is not divisible by 3.");
        }
    }

    public static void divisible5(int a){
        if (a % 5 == 0) {
            System.out.println(a + " is divisible by 5.");
        } else {
            System.out.println(a + " is not divisible by 5.");
        }
    }

    public static void divisible11(int a){
        if (a % 11 == 0) {
            System.out.println(a + " is divisible by 11.");
        } else {
            System.out.println(a + " is not divisible by 11.");
        }
    }

    public static void oddOrEven(int a){
        if (a % 2 == 0) {
            System.out.println(a + " is an even number.");
        } else {
            System.out.println(a + " is an odd number.");
        }
    }

    public static void leapYear(int a){
        if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0)) {
            System.out.println(a + " is a leap year.");
        } else {
            System.out.println(a + " is not a leap year.");
        }
    }

    public static void digitOrNot(char a){
        if (a >= '0' && a <= '9') {
            System.out.println(a + " is a digit.");
        } else {
            System.out.println(a + " is not a digit.");
        }
    }

    public static void alphabetOrNot(char a){
        if ((a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z')) {
            System.out.println(a + " is an alphabet.");
        } else {
            System.out.println(a + " is not an alphabet.");
        }
    }

    public static void typeOfaaracter(char a){
        if ((a >= 'A' && a <= 'Z') || (a >= 'a' && a <= 'z')) {
            System.out.println(a + " is an Alphabet.");
        }
        else if (a >= '0' && a <= '9') {
            System.out.println(a + " is a Digit.");
        }
        else {
            System.out.println(a + " is a Special aaracter.");
        }
    }

    public static void positiveOrNegative(int a){
        if (a > 0) {
            System.out.println(a + " is a positive number.");
        } else if (a < 0) {
            System.out.println(a + " is a negative number.");
        } else {
            System.out.println("The number is zero.");
        }
    }

    public static void celciusToFahrenheit(int c){
        if (c >= -273.15) {
            double f = (c * 9 / 5) + 32;
            System.out.println("Temperature in Fahrenheit: " + f);
        } else {
            System.out.println("Temperature cannot be below -273.15°C.");
        }
    }

    public static void fahrenheitToCelcuius(int f){
        if (f >= -459.67) {
            double c = (f - 32) * 5 / 9;
            System.out.println("Temperature in Celsius: " + c);
        } else {
            System.out.println("Temperature cannot be below -459.67°F.");
        }
    }

    public static void vowelOrConsonent(char a){
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
            System.out.println(a + " is a vowel.");
        } else if ((a >= 'a' && a <= 'z')) {
            System.out.println(a + " is a consonant.");
        } else {
            System.out.println(a + " is not a valid alphabet.");
        }
    }

    public static void uppercaseLowercaseCheck(char a){
        if (a >= 'A' && a <= 'Z') {
            System.out.println(a + " is an uppercase letter.");
        } else if (a >= 'a' && a <= 'z') {
            System.out.println(a + " is a lowercase letter.");
        } else {
            System.out.println(a + " is not an alphabet letter.");
        }
    }

    public static void weekday(int a){
        if (a == 1) {
            System.out.println("1: Sunday");
        } else if (a == 2) {
            System.out.println("2: Monday");
        } else if (a == 3) {
            System.out.println("3: Tuesday");
        } else if (a == 4) {
            System.out.println("4: Wednesday");
        } else if (a == 5) {
            System.out.println("5: Thursday");
        } else if (a == 6) {
            System.out.println("6: Friday");
        } else if (a == 7) {
            System.out.println("7: Saturday");
        } else {
            System.out.println("Invalid input! Please enter a number between 1 and 7.");
        }
    }

    public static void triangleType(int a, int b, int c){
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Invalid triangle sides. Sides must be positive.");
        }
        else if (a == b && b == c) {
            System.out.println("The triangle is Equilateral.");
        } else if (a == b || b == c || a == c) {
            System.out.println("The triangle is Isosceles.");
        } else {
            System.out.println("The triangle is Scalene.");
        }
    }

    public static void votingEligibility(int a){
        if (a >= 18) {
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }
    }

    public static void studentDivision(int a){
        if (a >= 60) {
            System.out.println("Division 1");
        } else if (a >= 45) {
            System.out.println("Division 2");
        } else if (a >= 30) {
            System.out.println("Division 3");
        } else {
            System.out.println("Fail");
        }
    }

    public static void studentPercentage(double maths, double physics, double chemistry, double english, double hindi){
        double totalMarks = maths + physics + chemistry + english + hindi;
        double percentage = (totalMarks / 500) * 100;
        System.out.println("Total Percentage: " + percentage + "%");

        if (percentage >= 90) {
            System.out.println("Grade A");
        } else if (percentage >= 80) {
            System.out.println("Grade B");
        } else if (percentage >= 70) {
            System.out.println("Grade C");
        } else if (percentage >= 60) {
            System.out.println("Grade D");
        } else if (percentage >= 40) {
            System.out.println("Grade E");
        } else {
            System.out.println("Grade F");
        }
    }

    public static void main(String[] ars){
        max2(1,2);

        max3(1,2,3);

        divisible3(3);

        divisible5(5);

        divisible11(11);

        oddOrEven(2);

        leapYear(2025);

        digitOrNot('5');

        alphabetOrNot('a');

        typeOfaaracter('%');

        celciusToFahrenheit(25);

        fahrenheitToCelcuius(32);

        vowelOrConsonent('a');

        uppercaseLowercaseCheck('A');

        weekday(5);

        triangleType(3,4,5);

        votingEligibility(18);

        studentDivision(75);


    }
}
