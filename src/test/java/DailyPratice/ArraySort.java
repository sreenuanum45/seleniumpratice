package DailyPratice;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        int[] x = {50,20,30,10,90};
        for (int i = 0; i < x.length; i++) {
            for (int k = 0; k < x.length-1; k++) {
                if (x[k] < x[k+1]) {//>ascending< for descending
                   int temp = x[k+1];
                    x[k+1] = x[k];
                    x[k] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(x));

    }
}
