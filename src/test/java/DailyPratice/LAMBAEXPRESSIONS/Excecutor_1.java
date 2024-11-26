package DailyPratice.LAMBAEXPRESSIONS;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Excecutor_1 {
    public static void main(String[] args) {
        Executor executor= Executors.newFixedThreadPool(10);
        executor.execute(()->{
            System.out.println("taskComplted");
        });
    }

}
