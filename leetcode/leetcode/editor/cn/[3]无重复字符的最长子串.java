//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5335 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 1 - for循环的init只会执行一次
     * 2 - 采用set应对重复性问题
     * 3 - 用Character类型来接收char字符，Java的集合泛型目前都只支持包装类型，不支持基础类型(如：int/char等)
     * 4 - String -> length(), charAt()
     * 5 - Set -> contains(), new HashSet<>(), set.clear()
     *
     * 该问题主要是遍历给定的字符串，遇到重复字符/末尾后回退到当前子串开头(需要标记)(末尾可优化)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int curResult = 0;
        int begin = 0;
        Set<Character> set = new HashSet<>();
        for (int i = begin; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                curResult++;
            } else {
                set.clear();
                curResult = 0;
                begin++;
                // i要回退一位，因为下次循环体执行前要i++
                i = begin-1;
                continue;
            }
            if (curResult > result) {
                result = curResult;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
