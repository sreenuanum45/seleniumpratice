package DailyPratice.LAMBAEXPRESSIONS;

import java.util.Optional;

public class Test3 {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public static void main(String[] args) {
       Optional<String> s= Optional.of("java");
       s.ifPresent(System.out::println);
        Optional<String> s1=Optional.ofNullable("java");
        System.out.println(s1.orElse("no value"));
    }
    @MyAnnotation
    public void test(){
        System.out.println("test");
    }
}
