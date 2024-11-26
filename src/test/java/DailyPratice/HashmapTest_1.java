package DailyPratice;

import java.util.HashMap;
import java.util.Map;

public class HashmapTest_1 {
    public static void main(String[] args) {
        Map<String,Integer> scores=new HashMap<>();
        scores.put("kohili",10);
        scores.put("dhoni",11);
        scores.put("rohit",33);
        for(Map.Entry<String,Integer> entry: scores.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
