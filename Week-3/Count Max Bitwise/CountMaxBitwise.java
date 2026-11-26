import java.util.Scanner;

public class CountMaxBitwise {
    static int count = 0;
    static int maxOr = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(countMaxOrSubsets(nums));

        sc.close();
    }

    public static int countMaxOrSubsets(int[] nums) {
        maxOr = 0;
        count = 0;

        for (int num : nums) {
            maxOr |= num;
        }

        backtrack(nums, 0, 0);

        return count;
    }

    public static void backtrack(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr == maxOr) {
                count++;
            }
            return;
        }

        backtrack(nums, index + 1, currentOr | nums[index]);
        backtrack(nums, index + 1, currentOr);
    }
}