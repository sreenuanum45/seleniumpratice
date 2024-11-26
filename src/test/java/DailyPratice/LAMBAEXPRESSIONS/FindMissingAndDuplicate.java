package DailyPratice.LAMBAEXPRESSIONS;

public class FindMissingAndDuplicate {
    public static void findMissingAndDuplicate(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];  // To track numbers
        // Initialize a variable to store the duplicate number
        int duplicate = -1;
        // Iterate over the array to find the duplicate number
        for (int num : nums) {
            if (seen[num]) {
                duplicate = num;
            }
            seen[num] = true;
        }
        // Initialize a variable to store the missing number
        int missing = -1;
        // Find the missing number
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                missing = i;
                break;
            }
        }
        System.out.println("Duplicate number: " + duplicate);
        System.out.println("Missing number: " + missing);
    }
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 5, 4};  // Example array with a duplicate and a missing number
        findMissingAndDuplicate(nums);
    }
}
