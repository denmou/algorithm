//917

//给你一个字符串 s ，根据下述规则反转字符串： 
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
// Related Topics 双指针 字符串 👍 131 👎 0


public class ReverseOnlyLetters {
    public static void main(String[] args) {
        Solution solution = new ReverseOnlyLetters().new Solution();
        String result = solution.reverseOnlyLetters("ab-cd");
        System.out.println(result);
        result = solution.reverseOnlyLetters("a-bC-dEf-ghIj");
        System.out.println(result);
        result = solution.reverseOnlyLetters("Test1ng-Leet=code-Q!");
        System.out.println(result);
        result = solution.reverseOnlyLetters("7_28]");
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String s) {
            int p1 = 0;
            int p2 = s.length() - 1;
            char[] chars = s.toCharArray();
            while (true) {
                while (noLetter(chars[p1]) && p1 < p2) {
                    p1++;
                }
                while (noLetter(chars[p2]) && p1 < p2) {
                    p2--;
                }
                if (p1 >= p2) {
                    break;
                }
                char c = chars[p1];
                chars[p1++] = chars[p2];
                chars[p2--] = c;
            }
            return String.valueOf(chars);
        }

        private boolean noLetter(char c) {
            return c < 'A' || c > 'z' || c > 'Z' && c < 'a';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}