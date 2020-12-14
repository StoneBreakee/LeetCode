// 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
//
//
//
// 示例 1:
// 输入:
//
// "bbbab"
//
//
// 输出:
//
// 4
//
//
// 一个可能的最长回文子序列为 "bbbb"。
//
// 示例 2:
// 输入:
//
// "cbbd"
//
//
// 输出:
//
// 2
//
//
// 一个可能的最长回文子序列为 "bb"。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 只包含小写英文字母
//
// Related Topics 动态规划
// 👍 341 👎 0

import java.util.HashMap;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 子序列
    // bbab 的回文子序列 bbb,bab
    // bbab 的回文子串 bab
    // 因此 bbbab 的回文子串 bbb,bab
    // bbbab 的回文子序列 bbbb
    // 以bbab为例
    // 首 和 尾 都为 'b',则可以确定其回文 子 序列的长度为2
    // 在看 ba 其最长回文子序列为 1
    // 所以bbab 的最长回文子序列为 2 + 1 = 3
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        // 提升运行速度
        char[] arr = s.toCharArray();
        // 反着遍历保证状态的正确转移
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = dp[i + 1][j] > dp[i][j - 1] ? dp[i + 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[0][len - 1];
    }
}
// leetcode submit region end(Prohibit modification and deletion)
