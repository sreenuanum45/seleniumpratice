package DailyPratice;

import java.util.Scanner;

public class Simple_calculator {
    public static void main(String[] args) {
        //simple calculator with +,-,*,/ operators with switch case
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = scanner.nextInt();
        System.out.println("Enter the second number");
        int b = scanner.nextInt();
        System.out.println("Enter the operator");
        char c = scanner.next().charAt(0);
        int result = 0;
        switch(c){
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = a/b;
                break;
        }
    }
}
