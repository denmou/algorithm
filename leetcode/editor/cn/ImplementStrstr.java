//
// 实现 strStr() 函数。
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 709 👎 0


import java.util.Scanner;

//Java：实现 strStr()
public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入haystack值:");
        String haystack = scanner.nextLine();
        System.out.print("请输入needle值:");
        String needle = scanner.nextLine();
        Object result = solution.strStr(haystack, needle);
        System.out.println("执行结果为: " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            int count = haystack.length() - needle.length();
            for (int i = 0; i <= count; i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    int start = 0;
                    int end = needle.length() - 1;
                    boolean result = true;
                    while (start <= end) {
                        if (haystack.charAt(start + i) != needle.charAt(start)
                                || haystack.charAt(end + i) != needle.charAt(end)) {
                            result = false;
                            break;
                        }
                        start++;
                        end--;
                    }
                    if (result) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}