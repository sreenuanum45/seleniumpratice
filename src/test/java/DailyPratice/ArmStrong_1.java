package DailyPratice;

public class ArmStrong_1 {
    public static void main(String[] args) {
        int count = 0;
        int sum=0;
      int  n=153;
        int temp=  n;
        while(temp!=0){
            temp=temp/10;
            count++;
        }
        while(n!=0){
            int rem=n%10;
            n=n/10;
          sum= sum +(int) (Math.pow(rem,count));
        }
        if(sum==n){
            System.out.println("armstrong number");
        }
    }
}
