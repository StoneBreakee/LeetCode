// 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
// 择一个符号添加在前面。
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
//
//
//
// 示例：
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
// 输出：5
// 解释：
//
// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3
//
// 一共有5种方法让最终目标和为3。
//
//
//
//
// 提示：
//
//
// 数组非空，且长度不会超过 20 。
// 初始的数组的和不会超过 1000 。
// 保证返回的最终结果能被 32 位整数存下。
//
// Related Topics 深度优先搜索 动态规划
// 👍 482 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumPerEle(nums, S, 0);
    }

    private int findTargetSumPerEle(int[] nums, int s, int i) {
        if (i >= nums.length) {
            return s == 0 ? 1 : 0;
        }
        int useAdd = findTargetSumPerEle(nums, s - nums[i], i + 1);
        int useSubstract = findTargetSumPerEle(nums, s + nums[i], i + 1);
        return useAdd + useSubstract;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
