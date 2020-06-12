package leetcode.editor.cn;
public class ReverseWordsInAStringIii{
public static 
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 示例 1: 
//
// 
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
// 
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverseEachWord(chars);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
    }

    private void reverseEachWord(char[] chars) {
        int n = chars.length;
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && chars[end] != ' ') end++;
            // 翻转单词
            reverse(chars, start, end - 1);
            // 更新start，去找下一个单词
            start = ++end;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}