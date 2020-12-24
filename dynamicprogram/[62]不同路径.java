// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
// 问总共有多少条不同的路径？
//
//
//
// 示例 1：
//
//
// 输入：m = 3, n = 7
// 输出：28
//
// 示例 2：
//
//
// 输入：m = 3, n = 2
// 输出：3
// 解释：
// 从左上角开始，总共有 3 条路径可以到达右下角。
// 1. 向右 -> 向右 -> 向下
// 2. 向右 -> 向下 -> 向右
// 3. 向下 -> 向右 -> 向右
//
//
// 示例 3：
//
//
// 输入：m = 7, n = 3
// 输出：28
//
//
// 示例 4：
//
//
// 输入：m = 3, n = 3
// 输出：6
//
//
//
// 提示：
//
//
// 1 <= m, n <= 100
// 题目数据保证答案小于等于 2 * 109
//
// Related Topics 数组 动态规划
// 👍 840 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        // 旧题新解
        // 机器人从[0,0] 移动到 [m-1,n-1] 一共要走 m-1 + n-1 步，即 m + n - 2
        // 包括向下移动m-1 和向右移动 n-1
        // 其中向下和向右移可以不分先后顺序
        // 也就相当于从 m + n - 2个空中，随机选取 m-1 个，剩下的就是向右移动的了
        int s = m + n - 2, k = m - 1;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            // res *= (s - k + i) / i ;先计算了后面的结果，但是可能会除不尽
            res = res * (s - k + i) / i;
        }
        return (int)res;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
