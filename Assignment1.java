public class Assignment1{

    //swap 2 numbers
    public static void swapWithTemp(int a, int b){ // as1
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
        System.out.println(a +" " + b);
    }
    public static void swapWithOutTemp(int a, int b){ //as2
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println(a +" " + b);
    }

    //swap 3 numbers
    public static void swapWithTemp(int a, int b, int c){ //as3
        int temp=0;
        temp = a;
        a = b;
        b = c;
        c = temp;
        System.out.println(a+" " + b+" "+c);
    }
    public static void swapWithOutTemp(int a, int b, int c){ //as4
        a = a+b+c;
        b = a-(b+c);
        c = a-(b+c);
        a = a-(b+c);
        System.out.println(a +" " + b +" "+c);
    }

    //swap 4 numbers
    public static void swapWithTemp(int a, int b, int c, int d){ //as5
        int temp=0;
        temp = a;
        a = b;
        b = c;
        c = d;
        c = temp;
        System.out.println(a+" " + b+" "+c+" "+d);
    }
    public static void swapWithOutTemp(int a, int b, int c, int d){ //as6
        a = a+b+c;
        b = a-(b+c);
        c = a-(b+c);
        a = a-(b+c);
        System.out.println(a +" " + b +" "+c+" "+d);
    }

    public static void silverPlanCost(float cost, float gst){ //as7
        System.out.println("Final plan cost "+ (cost+gst/100*cost));
    }

    public static void dominosBill(float price, float count, float discount){ // as8
        System.out.println("Total Bill " + (price*count*(1-discount/100)));
    }

    public static void inHandSalary(float salary, float tax){ // as9
        System.out.println("In hand Salary is " +(salary*(1-tax/100)));
    }

    public static void interestAmount(float deposit, float years, float interest){
        float totalInterest = deposit*years*interest/100;
        System.out.println("Interest amount " +  totalInterest + "Final Amount "+ (deposit + totalInterest));
    }


    public static void main(String[] args){
        swapWithTemp(1,2);
        swapWithOutTemp(1,2);

        swapWithTemp(1,2,3);
        swapWithOutTemp(1,2,3);

        swapWithTemp(1,2,3,4);
        swapWithOutTemp(1,2,3,4);

        silverPlanCost(699, 18);

        dominosBill(399, 2, 20);

        inHandSalary(85000, 20);

        interestAmount(500000, 5, 6.8f);



    }
}