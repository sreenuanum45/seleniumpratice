package DailyPratice;

public class SwappingNumbers {
    public static void main(String[] args) {

        //swapping numbers technique without using third variable
        int a = 10;
        int b = 20;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a);
        System.out.println("b = " + b);


    }
}
