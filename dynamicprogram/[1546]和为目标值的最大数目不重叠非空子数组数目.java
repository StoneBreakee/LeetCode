
// 给你一个数组 nums 和一个整数 target 。
//
// 请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。
//
//
//
// 示例 1：
//
// 输入：nums = [1,1,1,1,1], target = 2
// 输出：2
// 解释：总共有 2 个不重叠子数组（加粗数字表示） [1,1,1,1,1] ，它们的和为目标值 2 。
//
//
// 示例 2：
//
// 输入：nums = [-1,3,5,1,4,2,-9], target = 6
// 输出：2
// 解释：总共有 3 个子数组和为 6 。
// ([5,1], [4,2], [3,5,1,4,2,-9]) 但只有前 2 个是不重叠的。
//
// 示例 3：
//
// 输入：nums = [-2,6,6,3,5,4,1,2,8], target = 10
// 输出：3
//
//
// 示例 4：
//
// 输入：nums = [0,0,0], target = 0
// 输出：3
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 0 <= target <= 10^6
//
// Related Topics 动态规划
// 👍 19 👎 0

import java.util.HashSet;
import java.util.Set;

/**
 * tips1:子数组表示也是原数组的连续子数组
 * tips2: 转换为求出原数组有多少连续子数组的和为target,不重复
 */

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int count = 0;
        int curSum = 0;
        for (int i : nums) {
            curSum += i;
            if (set.contains(curSum - target)) {
                count++;
                set.clear();
                set.add(0);
                curSum = 0;
            } else {
                set.add(curSum);
            }
        }
        return count;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
