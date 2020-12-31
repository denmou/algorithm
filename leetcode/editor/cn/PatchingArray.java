//给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都
//可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。 
//
// 示例 1: 
//
// 输入: nums = [1,3], n = 6
//输出: 1 
//解释:
//根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
//现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
//其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
//所以我们最少需要添加一个数字。 
//
// 示例 2: 
//
// 输入: nums = [1,5,10], n = 20
//输出: 2
//解释: 我们需要添加 [2, 4]。
// 
//
// 示例 3: 
//
// 输入: nums = [1,2,2], n = 5
//输出: 0
// 
// Related Topics 贪心算法 
// 👍 210 👎 0

import java.util.*;

//Java：按要求补齐数组
public class PatchingArray {
    public static void main(String[] args) {
        Solution solution = new PatchingArray().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入nums数组:");
        String value = scanner.nextLine();
        int[] nums = {};
        if (value.trim().length() > 0) {
            String[] array = value.split("[,|，]");
            nums = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                nums[i] = Integer.parseInt(array[i].trim());
            }
        }
        System.out.print("请输入n值:");
        value = scanner.nextLine();
        int target = Integer.parseInt(value);
        int result = solution.minPatches(nums, target);
        System.out.println("执行结果为: " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPatches(int[] nums, int n) {
            //int loop= 0;
            int index = 0;
            int count = 0;
            long total = 1L;
            while (total <= n) {
                //loop++;
                if (index < nums.length && nums[index] <= total) {
                    total += nums[index++];
                } else {
                    count++;
                    total *= 2;
                }
            }
            /**
             * 算法迭代流程：
             * 1、暴力迭代，暴毙在21亿上限超时
             * 2、指数步长，未考虑数组内已有数据，未通过 「没有深入，直接转向！」
             * 3、累加步长，已当前累计里程+1为下一步起点，存在重复步长重复判断分支
             *
             * 问题：题目分析存在误差，过早定论
             */
            /*
            long sum = 0L;
            int value;
            while (total <= n) {
                loop++;
                value = index < nums.length ? nums[index] : 0;
                sum += total;
                if (value != total) {
                    if (value == 0 || total < value) {
                        count++;
                    }
                }
                while (index < nums.length && nums[index] <= sum) {
                    loop++;
                    if (value == total) {
                        value = 0;
                        index++;
                    } else {
                        sum += nums[index++];
                    }
                }
                total = sum + 1;
            }
            System.out.println(loop);
            */
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}