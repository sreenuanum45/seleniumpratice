package DailyPratice;

import java.util.Scanner;

public class ArmStrongNumber {

    public static void main(String[] args) {
        //100 to 1000 arm strong number

        /*for (int i = 100; i <= 1000; i++) {
            int sum = 0;
            int temp = i;
            while (temp > 0) {
                int rem = temp % 10;
                sum = sum + (rem * rem * rem);
                temp = temp / 10;
            }
            if (sum == i) {
                System.out.println(i);
            }
        }*/
        // iwant take values from user
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int temp = n;
        int count = 0;
        while (temp > 0) {
            temp = temp / 10;
            count++;
        }
        temp = n;
        while (temp > 0) {
            int rem = temp % 10;
            sum = sum + (int) Math.pow(rem, count);
            temp = temp / 10;

        }
        if (sum == n) {
            System.out.println(n+"is armstrong number");
        } else {
            System.out.println(n+"is not armstrong number");
        }
        //please add with reverse number to get original number and check if it is armstrong number



    }
}
