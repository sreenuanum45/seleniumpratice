package DailyPratice;

public class Test1111 {
    public static void main(String[] args) {
        //reverse a string

        String str = "Hello";
        String rev = "";
        for(int i = str.length()-1; i>=0; i--) {
            rev = rev + str.charAt(i);
        }
        System.out.println(rev);
    }
}
