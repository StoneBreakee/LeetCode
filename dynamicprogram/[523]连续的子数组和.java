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

import java.util.HashMap;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 如果出现0的情况
        map.put(0, -1);
        int sum = 0;
        // 2,5,33,6,7
        // 只列举了 2,5 2,5,33 缺少了5,33的情况，为什么结果也是正确的？
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                // 解释：如果该数组存在子数组和为n*k的情况，则必然会出现 sum[i] == sum[j]的情况
                // 因此不用穷举数组的子数组的所有情况
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
