package DailyPratice.LAMBAEXPRESSIONS;

import java.lang.reflect.Field;

public class ReflectionApi_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class objectClass=Class.forName("DailyPratice.LAMBAEXPRESSIONS.Customer");
        Field[] fields=objectClass.getFields();

        for(Field field:fields){
            System.out.println(field.getName());
        }

    }
}
