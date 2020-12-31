//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9914 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Java：两数之和
public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入nums数组:");
        String value = scanner.nextLine();
        String[] array = value.split("[,|，]");
        int[] nums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            nums[i] = Integer.parseInt(array[i].trim());
        }
        System.out.print("请输入target值:");
        value = scanner.nextLine();
        int target = Integer.parseInt(value);
        try {
            int[] result = solution.twoSum(nums, target);
            if (result != null) {
                System.out.print("执行结果为: [");
                for (int i = 0; i < result.length; i++) {
                    if (i > 0) {
                        System.out.print(", ");
                    }
                    System.out.print(result[i]);
                }
                System.out.println(']');
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(16);
            for (int i = 0; i < nums.length; i++) {
                int value = target - nums[i];
                if (map.containsKey(value)) {
                    return new int[]{map.get(value), i};
                } else {
                    map.put(nums[i], i);
                }
            }
            throw new RuntimeException("无符合结果");
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}