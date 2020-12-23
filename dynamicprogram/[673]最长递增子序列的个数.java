class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int[] times = new int[nums.length];
        int max;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            times[i] = 1;
            max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] == max && dp[i] == dp[j] + 1) {
                        times[i] += times[j];
                    } else if (dp[i] > max) {
                        max = dp[i];
                        times[i] = times[j];
                    }
                }
            }
        }
        max = dp[0];
        int occur = times[0];
        for (int i = 1; i < dp.length; i++) {
            if (max == dp[i]) {
                occur += times[i];
            } else if (max < dp[i]) {
                max = dp[i];
                occur = times[i];
            }
        }
        return occur;

    }
}
