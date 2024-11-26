package DailyPratice.LAMBAEXPRESSIONS;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreams {
    public static void main(String[] args) {
       List<Integer>ll= IntStream.iterate(0, n->n+1).mapToObj(Integer::valueOf).limit(20).collect(Collectors.toList());
       System.out.println(ll);
        List<Integer>l2=  Stream.generate(()->(new Random()).nextInt(1000)).limit(10).collect(Collectors.toList());
        System.out.println(l2);
    }
}
