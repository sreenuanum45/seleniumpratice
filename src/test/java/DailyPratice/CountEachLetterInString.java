package DailyPratice;

import java.util.HashMap;
import java.util.Map;

public class CountEachLetterInString {
    public static void main(String[] args) {
        String s = "software test engineeringz";
        char[] c = s.toCharArray();
        /*//count the each letter in string
        for (int i = 0; i < c.length; i++) {
            int count = 0;
            boolean flag = false;
            for (int j = i + 1; j <=c.length-1; j++) {
                if (c[i] == c[j]) {
                    *//*      c[j] = '0';*//*
                    flag = true;
                    count++;
                }

            }
            *//*if (c[i] != '0') {
                System.out.println(c[i] + " is " + count);
            }*//*
            if (flag != false) {
                System.out.println(c[i] + " is " + count);
            }
        }*/
        Map<Character,Integer> countletters=new HashMap<>();
        for(int i=0;i<c.length;i++) {
            if (countletters.containsKey(c[i])) {
                countletters.put(c[i], countletters.get(c[i]) + 1);
            }  else {
                countletters.put(c[i], 1);
            }
        }
        System.out.println(countletters);
    }
}
