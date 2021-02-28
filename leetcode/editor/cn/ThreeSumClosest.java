//
// 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 690 👎 0


import java.util.Arrays;
import java.util.Scanner;

//Java：最接近的三数之和
public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入nums数组:");
        String value = scanner.nextLine();
        int[] nums = Util.toIntegerArray(value);
        System.out.print("请输入target值:");
        value = scanner.nextLine();
        int target = Integer.parseInt(value);
        int result = solution.threeSumClosest(nums, target);
        System.out.println("执行结果为: " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int result = 10001;
            int offset = 10001;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end && result != target) {
                    int value = nums[i] + nums[start] + nums[end];
                    if (value > target) {
                        end--;
                    } else {
                        start++;
                    }
                    int o = Math.abs(target - value);
                    if (o < offset) {
                        result = value;
                        offset = o;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}