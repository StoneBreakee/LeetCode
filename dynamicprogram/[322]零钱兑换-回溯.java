//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划 
// 👍 724 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        // 使用贪心算法 + 剪枝
        // 回溯 写法
        // 从最大的开始
        Arrays.sort(coins);
        coinChange(coins, coins.length - 1, 0, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * @param coins  零钱数组
     * @param index  当前使用的哪种零钱
     * @param count  当前总共使用零钱的个数
     * @param amount 还需要再拼凑出的金钱
     */
    private void coinChange(int[] coins, int index, int count, int amount) {
        // 已经凑出amount
        if (amount == 0) {
            ans = Math.min(count, ans);
            return;
        }

        // 不能拼凑出amount
        if (index < 0) {
            return;
        }

        int i = amount / coins[index];
        for (int k = i; k >= 0 && k + count < ans; k--) {
            coinChange(coins, index - 1, k + count, amount - k * coins[index]);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
