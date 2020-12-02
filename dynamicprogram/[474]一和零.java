// 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//
//
// 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
//
//
//
//
// 示例 1：
//
//
// 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
// 输出：4
// 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
// 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于
// n 的值 3 。
//
//
// 示例 2：
//
//
// 输入：strs = ["10", "0", "1"], m = 1, n = 1
// 输出：2
// 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
//
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 600
// 1 <= strs[i].length <= 100
// strs[i] 仅由 '0' 和 '1' 组成
// 1 <= m, n <= 100
//
// Related Topics 动态规划
// 👍 278 👎 0

import java.util.HashMap;
import java.util.Map;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        // 背包问题的演化
        // dp[i][j] 表示i个0，j个1的最大子集个数
        // eles 中的每个元素只能使用一次
        int[][] dp = new int[m + 1][n + 1];
        for (int k = 0; k < strs.length; k++) {
            int[] eles = new int[2];
            eles[0] = strs[k].replaceAll("1", "").length();
            eles[1] = strs[k].replaceAll("0", "").length();
            // 倒序遍历，如果正序赋值会造成结果的包含重复的情况
            // “01” 在超过i=1,j=1之后，dp[i][j]的结果相当于重复利用了“01”
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (i >= eles[0] && j >= eles[1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - eles[0]][j - eles[1]] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
// leetcode submit region end(Prohibit modification and deletion)
