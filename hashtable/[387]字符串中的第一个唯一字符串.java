// 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
// 返回 0
//
// s = "loveleetcode"
// 返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串
// 👍 331 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        // 记录出现次数
        int[] occurs = new int[26];
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            occurs[sArr[i] - 'a']++;
        }
        for (int i = 0; i < sArr.length; i++) {
            if (occurs[sArr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
