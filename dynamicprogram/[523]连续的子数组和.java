// 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其
// 中 n 也是一个整数。
//
//
//
// 示例 1：
//
// 输入：[23,2,4,6,7], k = 6
// 输出：True
// 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
//
//
// 示例 2：
//
// 输入：[23,2,6,4,7], k = 6
// 输出：True
// 解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
//
//
//
//
// 说明：
//
//
// 数组的长度不会超过 10,000 。
// 你可以认为所有数字总和在 32 位有符号整数范围内。
//
// Related Topics 数学 动态规划
// 👍 193 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1) {
            return false;
        }
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = dp[i][j - 1] + nums[j];
                if (k == 0 && dp[i][j] == 0) {
                    return true;
                }
                if (k != 0 && dp[i][j] % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
