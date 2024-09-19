//给你一个长度为 n 下标从 0 开始的整数数组 nums ，它包含 1 到 n 的所有数字，请你返回上升四元组的数目。 
//
// 如果一个四元组 (i, j, k, l) 满足以下条件，我们称它是上升的： 
//
// 
// 0 <= i < j < k < l < n 且 
// nums[i] < nums[k] < nums[j] < nums[l] 。 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,3,2,4,5]
//输出：2
//解释：
//- 当 i = 0 ，j = 1 ，k = 2 且 l = 3 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
//- 当 i = 0 ，j = 1 ，k = 2 且 l = 4 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
//没有其他的四元组，所以我们返回 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4]
//输出：0
//解释：只存在一个四元组 i = 0 ，j = 1 ，k = 2 ，l = 3 ，但是 nums[j] < nums[k] ，所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 4 <= nums.length <= 4000 
// 1 <= nums[i] <= nums.length 
// nums 中所有数字 互不相同 ，nums 是一个排列。 
// 
//
// Related Topics 树状数组 数组 动态规划 枚举 前缀和 👍 74 👎 0


import java.util.Scanner;

//Java[2552]：统计上升四元组
class CountIncreasingQuadruplets {
    public static void main(String[] args) {
        Solution solution = new CountIncreasingQuadruplets().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter parameters:");
            String value = scanner.nextLine();
            // Parameter processing
            int[] nums = Util.toIntegerArray(value);
            Object result = solution.countQuadruplets(nums);
            System.out.println("Results of execution:");
            System.out.println(result);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countQuadruplets(int[] nums) {
            long count = 0;
            /*int[][] lv = new int[nums.length][nums.length];
            int[][] iv = new int[nums.length][nums.length];
            int jc = nums.length - 2;
            int kc = nums.length - 1;
            for (int j = 1; j < jc; j++) {
                for (int k = jc; k > j; k--) {
                    if (nums[j] < nums[k + 1]) {
                        lv[j][j]++;
                    }
                    lv[j][k] = lv[j][j];
                }
            }
            for (int k = 2; k < kc; k++) {
                for (int j = 1; j < k; j++) {
                    if (nums[j - 1] < nums[k]) {
                        iv[k][k]++;
                    }
                    iv[j][k] = iv[k][k];
                }
            }
            for (int j = 1; j < jc; j++) {
                for (int k = jc; k > j; k--) {
                    if (nums[j] > nums[k]) {
                        count += (long) lv[j][k] * iv[j][k];
                    }
                }
            }*/
            int[] iv = new int[nums.length];
            int jc = nums.length - 2;
            for (int j = 1; j < jc; j++) {
                int lv = 0;
                for (int k = jc; k > j; k--) {
                    if (nums[j] < nums[k + 1]) {
                        lv++;
                    }
                    if (nums[j - 1] < nums[k]) {
                        iv[k]++;
                    }
                    if (nums[j] > nums[k]) {
                        count += (long) lv * iv[k];
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}