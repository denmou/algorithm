//给你一个整数 x ，如果 x 是一个回文整数，返回 ture ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1379 👎 0


import java.util.Scanner;

//Java：回文数
public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入x值:");
        String value = scanner.nextLine();
        Integer target = Integer.parseInt(value);
        boolean result = solution.isPalindrome(target);
        System.out.println("执行结果为: " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            int count = 0;
            int value = x;
            while (value > 0) {
                count = count * 10 + value % 10;
                value /= 10;
            }
            return count == x;
            /*
            if (x == 0) {
                return true;
            }
            int length = 0;
            char[] array = new char[12];
            for (int i = 0; i < 12 && x > 0; i++) {
                array[i] = (char) (x % 10);
                x /= 10;
                length++;
            }
            if (length == 0) {
                return false;
            }
            int count = length / 2;
            for (int i = 0; i < count; i++) {
                if (array[i] != array[length - 1 - i]) {
                    return false;
                }
            }
            return true;
             */
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}