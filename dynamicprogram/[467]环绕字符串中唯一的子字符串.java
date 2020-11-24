// 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklm
// nopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
//
// 现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同
// 的非空子串的数目。
//
// 注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。
//
//
//
// 示例 1:
//
//
// 输入: "a"
// 输出: 1
// 解释: 字符串 S 中只有一个"a"子字符。
//
//
//
//
// 示例 2:
//
//
// 输入: "cac"
// 输出: 2
// 解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
//
//
//
//
// 示例 3:
//
//
// 输入: "zab"
// 输出: 6
// 解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.
//
//
//
// Related Topics 动态规划
// 👍 112 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 优化方向，26个英文字母是固定的 无需使用map，使用长度为26的数组也可以
     *
     */
    public int findSubstringInWraproundString(String p) {
        if (p.length() <= 0)
            return p.length();
        int[] dict = new int[26];
        dict[p.charAt(0) - 'a'] = 1;
        int len = 1;
        for (int i = 1; i < p.length(); i++) {
            int currentChar = p.charAt(i);
            int gap = currentChar - p.charAt(i - 1);
            if (gap == 1 || gap == 'a' - 'z') {
                // dp[i] = dp[i-1] + 1
                len++;
            } else {
                len = 1;
            }
            dict[currentChar - 'a'] = Math.max(dict[currentChar - 'a'], len);
        }
        // 所有子数组的总和
        int sum = 0;
        for(int i:dict){
            sum += i;
        }
        return sum;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
