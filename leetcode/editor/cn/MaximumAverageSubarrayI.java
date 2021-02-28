//给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。 
//
// 
//
// 示例： 
//
// 
//输入：[1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 30,000。 
// 所给数据范围 [-10,000，10,000]。 
// 
// Related Topics 数组 
// 👍 142 👎 0


import java.util.Scanner;

//Java：子数组最大平均数 I
public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        Solution solution = new MaximumAverageSubarrayI().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数组:");
        String value = scanner.nextLine();
        int[] nums = Util.toIntegerArray(value);
        System.out.print("请输入k值:");
        value = scanner.nextLine();
        int target = Integer.parseInt(value);
        double result = solution.findMaxAverage(nums, target);
        System.out.println("执行结果为: " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int max = 0;
            for (int i = 0; i < k; i++) {
                max += nums[i];
            }
            int sum = max;
            int before = 0;
            int after = 0;
            for (int i = k; i < nums.length; i++) {
                after += nums[i];
                before += nums[i - k];
                if (before < after) {
                    sum = sum + after - before;
                    after = 0;
                    before = 0;
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
            return 1.0 * max / k;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}