// 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
// 说明：
//
//
// 拆分时可以重复使用字典中的单词。
// 你可以假设字典中没有重复的单词。
//
//
// 示例 1：
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
// 输出: true
// 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//
//
// 示例 2：
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
// 输出: true
// 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//   注意你可以重复使用字典中的单词。
//
//
// 示例 3：
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
// 输出: false
//
// Related Topics 动态规划
// 👍 785 👎 0

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0) {
            return false;
        }
        char[] arr = s.toCharArray();
        boolean[] dp = new boolean[arr.length];
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        for (String str : wordDict) {
            set.add(str);
            maxLen = maxLen < str.length() ? str.length() : maxLen;
        }
        for (int i = 0; i < arr.length; i++) {
            dp[i] = set.contains(new String(arr, 0, i + 1));
            for (int j = i - 1; j >= 0 && j >= i - maxLen && !dp[i]; j--) {
                dp[i] = dp[j] && set.contains(new String(arr, j + 1, i - j));
            }
        }
        return dp[dp.length - 1];
    }
}
// leetcode submit region end(Prohibit modification and deletion)
