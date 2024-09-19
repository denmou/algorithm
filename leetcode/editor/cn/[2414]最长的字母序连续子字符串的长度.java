//字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连
//续字符串 。 
//
// 
// 例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。 
// 
//
// 给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abacaba"
//输出：2
//解释：共有 4 个不同的字母序连续子字符串 "a"、"b"、"c" 和 "ab" 。
//"ab" 是最长的字母序连续子字符串。
// 
//
// 示例 2： 
//
// 输入：s = "abcde"
//输出：5
//解释："abcde" 是最长的字母序连续子字符串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 👍 30 👎 0


import java.util.Scanner;

//Java[2414]：最长的字母序连续子字符串的长度
class LengthOfTheLongestAlphabeticalContinuousSubstring {
    public static void main(String[] args) {
        Solution solution = new LengthOfTheLongestAlphabeticalContinuousSubstring().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter parameters:");
            String value = scanner.nextLine();
            // Parameter processing
            Object result = solution.longestContinuousSubstring(value);
            System.out.println("Results of execution:");
            System.out.println(result);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestContinuousSubstring(String s) {
            int max = 1;
            int current = 1;
            char rootChar = s.charAt(0);
            char currentChar;
            for (int i = 1; i < s.length(); i++) {
                currentChar = s.charAt(i);
                if (currentChar - rootChar == 1) {
                    current++;
                } else {
                    max = Math.max(max, current);
                    current = 1;
                }
                rootChar = currentChar;
            }
            return Math.max(max, current);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}