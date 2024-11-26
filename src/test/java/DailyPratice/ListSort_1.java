package DailyPratice;

import java.util.Arrays;
import java.util.List;

public class ListSort_1 {
    public static void main(String[] args) {
List<Integer> list = Arrays.asList(11,2,44,55,30,99,105,322,22,1,34,5);
for(int i=0;i<list.size();i++){
    for(int j=0;j<list.size()-1;j++){
        if(list.get(j)<list.get(j+1)){//< descending order and > and ascending
            int temp=list.get(j+1);
            list.set(j+1,list.get(j));
            list.set(j,temp);
        }
    }
}

        System.out.println(list);
System.out.println("largest value in the list:"+list.get(0));
System.out.println("smallest value in the list:"+list.get(list.size()-1));
for(int i=0;i<list.size()-1;i++){
    int temp1=list.get(i);
    int temp2=list.get(i+1);
    if(temp1==temp2){
        continue;
    }
    else
    {
        System.out.println("second largest value in the list:"+list.get(i+1));
        break;
    }
}
for(int i=list.size()-1;i>=0;i--){
    int temp1=list.get(i);
    int temp2=list.get(i-1);
    if(temp1==temp2){
        continue;
    }
    else
    {
        System.out.println("second smallest value in the list:"+list.get(i-1));
        break;
    }
}

    }
}
