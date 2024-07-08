package DailyPratice.LAMBAEXPRESSIONS;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
Function<String,Integer> functional1= x-> x.length();
       int r1= functional1.apply("Hello");
       System.out.println(r1);
       Function<Integer,Integer> functional2= x->x*2;
      int result= functional1.andThen(functional2).apply("Sreenu");
      System.out.println(result);
        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
        int result1 = binaryOperator.apply(10, 20);
        System.out.println(result1);
        //byfunction
        BiFunction<Integer, Integer, Integer> byFunction = (x, y) -> x + y;
        int result2 = byFunction.apply(100, 20);
        System.out.println(result2);
        //unary operator
    UnaryOperator<String> unaryOperator = x -> x.toUpperCase();
        String result3 = unaryOperator.apply("hello");
        System.out.println(result3);
        UnaryOperator<Integer> un1=x->x*2;
        int result4=un1.apply(1);
        System.out.println(result4);
        //predicate
        Predicate<Integer> predicate = x -> x > 5;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> resultlist=list.stream().filter(predicate).collect(Collectors.toList());
        System.out.println(resultlist);
        Predicate<String> predicate1 = x -> x.startsWith("j");
        List<String>langList=Arrays.asList("java","python","c++","c","javaScript");
        List<String> resultlist1=langList.stream().filter(x->x.startsWith("j")||x.startsWith("c")).collect(Collectors.toList());
        System.out.println(resultlist1);
        //foreach
        list.forEach(x-> System.out.println(x));
        //iterartor
        Iterator<String> iterator = langList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //foreach remaining
        iterator= langList.iterator();
    iterator.forEachRemaining(x-> System.out.println(x));
    //foreach
        for(String x:langList){
            System.out.println(x);
        }
        //for index
        for(int i=0;i<langList.size();i++){
            System.out.println(langList.get(i));
        }
        //list iterator
        ListIterator<String> listIterator=langList.listIterator();
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }




    }
}
