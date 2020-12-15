// 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
// 能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//
//
//
// 示例 1:
//
// 输入: 12258
// 输出: 5
// 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
//
//
//
// 提示：
//
//
// 0 <= num < 231
//
// 👍 162 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int len = arr.length;
        if (len <= 1) {
            return len;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            int pre = arr[i - 1] - '0';
            int cur = pre * 10 + arr[i] - '0';
            dp[i + 1] = (cur <= 25 && cur >= 10) ? dp[i] + dp[i - 1] : dp[i];
        }
        return dp[len];
    }
}
// leetcode submit region end(Prohibit modification and deletion)
