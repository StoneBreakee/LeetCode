// 给定两个字符串 s 和 t，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
// 请找出在 t 中被添加的字母。
//
//
//
// 示例 1：
//
// 输入：s = "abcd", t = "abcde"
// 输出："e"
// 解释：'e' 是那个被添加的字母。
//
//
// 示例 2：
//
// 输入：s = "", t = "y"
// 输出："y"
//
//
// 示例 3：
//
// 输入：s = "a", t = "aa"
// 输出："a"
//
//
// 示例 4：
//
// 输入：s = "ae", t = "aea"
// 输出："a"
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 1000
// t.length == s.length + 1
// s 和 t 只包含小写字母
//
// Related Topics 位运算 哈希表
// 👍 197 👎 0

import java.util.HashMap;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0) {
            return t.charAt(0);
        }
        char[] arr = t.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>(1000);
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]);
                if (count == 1) {
                    map.remove(arr[i]);
                } else {
                    map.put(arr[i], count - 1);
                }
            } else {
                return arr[i];
            }
        }
        Character[] result = new Character[1];
        map.keySet().toArray(result);
        return result[0];
    }
}
// leetcode submit region end(Prohibit modification and deletion)
