// 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//
// 示例 1:
//
// 输入: 2
// 输出: 1
// 解释: 2 = 1 + 1, 1 × 1 = 1。
//
// 示例 2:
//
// 输入: 10
// 输出: 36
// 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。
// Related Topics 数学 动态规划
// 👍 357 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
// num 可以拆分为 j num-j
// dptable[j] 存储j可拆分后的最大乘积
// dptable[num-j] 存储num-j可拆分后的最大乘积
// dptable[num] = Max(max(j,dptable[j]) * max(num-j,dptable[num-j])) 1 <= j <= num
class Solution {
    public int integerBreak(int n) {
        int[] dptable = new int[n + 1];
        dptable[0] = 1;
        dptable[1] = 1;
        for (int i = 2; i <= n; i++) {
            int start = 1;
            while (start <= i / 2) {
                int maxStart = Math.max(start, dptable[start]);
                int maxEnd = Math.max(i - start, dptable[i - start]);
                dptable[i] = Math.max(maxStart * maxEnd, dptable[i]);
                start++;
            }
        }
        return dptable[n];
    }
}
// leetcode submit region end(Prohibit modification and deletion)
