package DailyPratice;

import java.util.Scanner;

public class ConditionCheeck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maths = scanner.nextInt();
        int science = scanner.nextInt();
        int english = scanner.nextInt();
int total = 0;
    if(maths > 35&&science > 35&&english > 35){
        total = total + maths+science+english;
    }
    else{
        System.out.println("fail");
    }

    System.out.println("total marks = "+total);
    }
}
