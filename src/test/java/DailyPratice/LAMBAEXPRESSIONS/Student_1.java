package DailyPratice.LAMBAEXPRESSIONS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class Student_1 implements Comparable<Student_1>{
    private static final Logger log = LoggerFactory.getLogger(Student_1.class);
    int id;
String name;
public Student_1(int id, String name) {
    this.id = id;
    this.name = name;
}

    public static void main(String[] args) {

        List<Student_1> list = Arrays.asList(
                new Student_1(1,"s1"),
                new Student_1(2,"s2"),
                new Student_1(3,"s3"),
                new Student_1(4,"s4")
        );

        list.stream().sorted().forEach(System.out::println);

    }

    @Override
    public String toString() {
        return "Student_1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public int compareTo(Student_1 o) {
        return this.id-o.id;
    }
}
