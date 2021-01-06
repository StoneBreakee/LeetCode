//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。 
//
// 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。 
//
// 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。 
//
// 
//
// 示例： 
//
// 
//输入：[[1,2], [2,3], [3,4]]
//输出：2
//解释：最长的数对链是 [1,2] -> [3,4]
// 
//
// 
//
// 提示： 
//
// 
// 给出数对的个数在 [1, 1000] 范围内。 
// 
// Related Topics 动态规划 
// 👍 139 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length <= 1) {
            return pairs.length;
        }
        Arrays.sort(pairs, (o1, o2) -> {
            int res = o1[0] - o2[0];
            if (res == 0) {
                return o1[1] - o2[1];
            }
            return res;
        });
        int[] dp = new int[pairs.length];
        int[] max = pairs[0];
        dp[0] = 1;
        for (int i = 1; i < pairs.length; i++) {
            dp[i] = dp[i - 1];
            if (pairs[i][0] > max[1]) {
                max = pairs[i];
                dp[i] = dp[i] + 1;
            } else {
                // 调整max的最小值
                if (max[1] > pairs[i][1]) {
                    max = pairs[i];
                }
            }
        }
        return dp[pairs.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
