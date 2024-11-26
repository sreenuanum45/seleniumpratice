package DailyPratice.LAMBAEXPRESSIONS;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumberWithStream {
    public static void main(String[] args) {
//System.out.println(isPrime(13));
        long count=Stream.iterate(0,n->n+1).limit(1000).parallel().filter(PrimeNumberWithStream::isPrime).distinct().flatMap(n->Stream.of(n)).peek(x->System.out.println(x)).count();
        System.out.println("total primenumber count:"+count);
    }
    public static boolean isPrime(int number) {
       if(number<=1){
           return false;
       }
           return !IntStream.rangeClosed(2, number/2).anyMatch(i -> number % i == 0);
       }
}
