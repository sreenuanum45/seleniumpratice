package DailyPratice.LAMBAEXPRESSIONS;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test2 {
    public static void main(String[] args) {
        //anonynimous class
        List<String> langList= Arrays.asList("java","python","c++","c","javaScript");
        langList.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        //lambda expression
        langList.forEach(s->System.out.println(s));
        //method reference
        langList.forEach(System.out::println);

    }
}
