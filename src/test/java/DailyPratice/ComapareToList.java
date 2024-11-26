package DailyPratice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComapareToList {
    public static void main(String[] args) {
        String[] x = new String[]{"java", "python", "c++", "c", "javaScript"};
        String[] y= new String[]{"java", "python", "c++", "html", "javaScript"};
        List<String> list1 = Arrays.asList(x);
        List<String> list2 = Arrays.asList(y);
        Set<String> set = new HashSet<String>(list1);
     if(set.size()==list1.size() && list1.size()==list2.size())
     {
         System.out.println("true");
     }
     else
     {
         System.out.println("false");
     }

    }
}
