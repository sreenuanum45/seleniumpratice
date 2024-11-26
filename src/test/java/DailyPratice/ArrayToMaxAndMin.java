package DailyPratice;

public class ArrayToMaxAndMin {
    public static void main(String[] args) {
        int[]x={100,200,300,450,600,200};
        int max=x[0];
        int min=x[0];
        for(int i=1;i<x.length;i++)
        {
            if(max<x[i])
            {
             max=x[i];
        }
            if(min>x[i]){
        min=x[i];}
        }
        System.out.println(max);
        System.out.println(min);
    }
}
