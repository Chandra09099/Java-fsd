package sequence;

import java.util.Arrays;

public class LongIs {
    public static int LongIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 20, 90, 91, 34, 13, 1};
        int lisLength = LongIS(numbers);
        System.out.println("Length of the Longest Increasing Subsequence: " + lisLength);
    }
}
