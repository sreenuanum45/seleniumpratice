package DailyPratice;

import java.util.Scanner;

public class LargestNumber {

    public static void main(String[] args) {
       //ternary operator

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int largest = a > b ? a : b;

        System.out.println("largestnumber"+largest);
    }
}


