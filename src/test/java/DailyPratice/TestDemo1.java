package DailyPratice;

import java.util.Scanner;

public class TestDemo1
{
    public static void main(String[] args) {
        // checck with even or odd

        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        if (x % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}
