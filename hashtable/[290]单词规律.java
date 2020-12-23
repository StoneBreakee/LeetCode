// 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
//
// 示例1:
//
// 输入: pattern = "abba", str = "dog cat cat dog"
// 输出: true
//
// 示例 2:
//
// 输入:pattern = "abba", str = "dog cat cat fish"
// 输出: false
//
// 示例 3:
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
// 输出: false
//
// 示例 4:
//
// 输入: pattern = "abba", str = "dog dog dog dog"
// 输出: false
//
// 说明:
// 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
// Related Topics 哈希表
// 👍 229 👎 0

import java.util.HashMap;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map1 = new HashMap<>();
        char[] pArr = pattern.toCharArray();
        String[] sArr = s.split(" ");
        if (pArr.length != sArr.length) {
            return false;
        }
        map.put(pArr[0], sArr[0]);
        map1.put(sArr[0], pArr[0]);
        for (int i = 1; i < pArr.length; i++) {
            if (map.containsKey(pArr[i])) {
                if (!sArr[i].equals(map.get(pArr[i]))) {
                    return false;
                }
            }
            if (map1.containsKey(sArr[i])) {
                if (!map1.get(sArr[i]).equals(pArr[i])) {
                    return false;
                }
                continue;
            }
            map.put(pArr[i], sArr[i]);
            map1.put(sArr[i], pArr[i]);
        }
        return true;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
