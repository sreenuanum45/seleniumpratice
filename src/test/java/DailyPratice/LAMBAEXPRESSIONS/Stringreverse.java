package DailyPratice.LAMBAEXPRESSIONS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stringreverse {
    public static void main(String[] args) {
        String s="madam";

        List<String> list= Arrays.asList("java","python","c++","c","javaScript","madam","racecar");
        list.stream().map(String::toString).map(x->new StringBuffer(x).reverse().toString()).filter(y-> y.equals(new StringBuffer(y).reverse().toString()) ).collect(Collectors.toList()).forEach(System.out::println);
    }
}
