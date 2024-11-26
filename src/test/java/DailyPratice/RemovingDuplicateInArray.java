package DailyPratice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class RemovingDuplicateInArray {
    public static void main(String[] args) {
        int[]x={1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,0};

        for(int i=0;i<x.length;i++){
            int count=1;
            for(int j=i+1;j<x.length;j++){
                if(x[i]==x[j]){
                    x[j]=0;
                    count++;
                }
            }
            if(x[i]!=0){
                System.out.println(x[i]+"is count "+count);
            }
        }
        int y[]={2,112,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,0};
        /*int size=y.length;
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(y[i]==y[j]){

                    y[j]=0;

                    size--;

                }
            }
        }
        System.out.println(Arrays.toString(y));*/
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        // Add elements from the array to the set
        for (int num : y) {
            set.add(num);
        }
        int[] uniqueArray = new int[set.size()];
        int i = 0;
        for (int num : set) {
            uniqueArray[i++] = num;
        }
        System.out.println(Arrays.toString(uniqueArray));
        //
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0};
        int[] uniqueArray1 = Arrays.stream(arr).distinct().toArray();
        // removing duplicate in the arrray with out using any collect concept
        int arrsize=arr.length;
        for(int a=0;i<arrsize;a++){
            for(int b=a+1;b<arrsize;b++){
                if(arr[a]==arr[b]){
                    for(int c=b;c<arrsize-1;c++){
                        arr[c]=arr[c+1];
                    }
                    b--;
                    arrsize--;
                }
            }
        }
       System.out.println(arr.length);
    }


    }
