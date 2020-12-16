// 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//
// 示例:
//
// 输入: 3
// 输出: 5
// 解释:
// 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
// 1 3 3 2 1
// \ / / / \ \
// 3 2 1 1 3 2
// / / \ \
// 2 1 2 3
// Related Topics 树 动态规划
// 👍 922 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
// leetcode submit region end(Prohibit modification and deletion)
