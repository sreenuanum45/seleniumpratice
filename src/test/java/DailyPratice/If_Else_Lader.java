package DailyPratice;

import java.util.Scanner;

public class If_Else_Lader {
    public static void main(String[] args) {
        // ladder if-else ladder with multiple conditions

        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        if (height > 120) {
            System.out.println("Tall enough to ride");
            int age = scanner.nextInt();
            if (age < 12) {
                System.out.println("Please pay $5");
            } else if (age < 18) {
                System.out.println("Please pay $10");
            } else {
                System.out.println("Please pay $15");
            }

        } else {
            System.out.println("Too short to ride");
        }

    }
}
