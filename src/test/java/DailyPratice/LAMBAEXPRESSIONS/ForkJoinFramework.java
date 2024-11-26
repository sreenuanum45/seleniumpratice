package DailyPratice.LAMBAEXPRESSIONS;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinFramework {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MyRecursiveTask(10,20));
       int parallelism =pool.getParallelism();
       System.out.println(parallelism);
    }
}
