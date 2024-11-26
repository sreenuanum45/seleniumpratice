package DailyPratice.LAMBAEXPRESSIONS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Paralle_Stream_vsSequentialStream {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
       System.out.println( pool.getParallelism());
       Stream stream= Stream.of("naveen","sreenu","veeresh","sathaiah");
        stream.forEach(System.out::println);
        stream.map(s->s.toString().length()).forEach(System.out::println);
             AllAlaphabets().forEach(System.out::println);

        System.out.println("parallel");
        AllAlaphabets().parallelStream().forEach(System.out::println);

        System.out.println("sequential");
        AllAlaphabets().stream().forEach(System.out::println);
IntStream.rangeClosed(97,122).forEach(System.out::println);
System.out.println("parallel");
        IntStream.rangeClosed(97,122).parallel().forEach(System.out::println);
    }
    public static List<String>AllAlaphabets(){
        int n=97;
        List<String> list=new ArrayList<>();
        while (n<=122){
            char c=(char)n;
            list.add(String.valueOf(c));
            n++;
        }
        return  list;
    }
}
