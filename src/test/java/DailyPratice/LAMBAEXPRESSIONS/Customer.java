package DailyPratice.LAMBAEXPRESSIONS;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

public class Customer {
    private String name;
    private int age;
    public Customer(String name, int age){
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", age=" + age + "]";
    }
    public static void main(String[] args) {
        List<Customer> list= Arrays.asList(
                new Customer("sreenu",20),
                new Customer("naveen",21),
                new Customer("veeresh",22),
                new Customer("sathaiah",23));
       Customer customer=list.stream().filter((x)->"sreenu".equals(x.getName())&&x.getAge()>=20)
                .findAny()
                .orElse(null);
        System.out.println(customer);
        List<String> stringList=list.stream().map(Customer::getName).collect(Collectors.toList());
        System.out.println(stringList);
        list.forEach(System.out::println);
    }
}
