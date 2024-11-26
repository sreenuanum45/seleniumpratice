package DailyPratice;

public class ArrayToFindSearchingWord {
    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int key = 60;
        int result = -1;
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == key) {
                result = mid;
                break;
            }
            if (key<a[mid]) {
                end = mid + 1;
            } else {
                start = mid - 1;
            }
        }
        if(result==-1) {
            System.out.println("not found");
        } else {
            System.out.println("found at index " + result);
        }
    }
}
