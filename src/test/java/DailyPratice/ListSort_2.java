package DailyPratice;

import java.util.Arrays;
import java.util.List;

public class ListSort_2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11,2,44,55,30,99,105,322,22,1,1);
       int size = list.size();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size()-1;j++){
               if(list.get(j).compareTo(list.get(j+1))>0){
                   int temp=list.get(j+1);
                   list.set(j+1,list.get(j));
                   list.set(j,temp);
               }
            }
        }
        //removing duplicate
        /*for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                int temp1=list.get(i);
                int temp2=list.get(j);
                if(temp1==temp2){
                    list.remove(j);
               size--;

                }
            }
        }*/
        System.out.println(list);
        //sorting in descending
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size()-1;j++){
                if(list.get(j)<list.get(j+1)){
                    int temp=list.get(j+1);
                    list.set(j+1,list.get(j));
                    list.set(j,temp);
                }
            }
        }
        System.out.println(list);
        int key=44;
        int result=-1;
        int start=0;
        int end=list.size()-1;
        while(end>=start){
            int mid=(end+start)/2;
            if(key==list.get(mid)){
                result=mid;
                break;
            }
            if(key<list.get(mid)){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        if(result==-1){
            System.out.println("not found");
        }
        else {
            System.out.println("found at index " + result);
        }

    }
}
