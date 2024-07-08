package DailyPratice;

import java.util.Scanner;

public class CheekNumber {
    public static void main(String[] args) {
        //checck positive or negative

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x > 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Negative");
        }
    }
}
