//
// 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 746 👎 0


import java.util.*;

//Java：四数之和
public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入nums数组:");
        String value = scanner.nextLine();
        int[] nums = Util.toIntegerArray(value);
        System.out.print("请输入target值:");
        value = scanner.nextLine();
        int target = Integer.parseInt(value);
        Object result = solution.fourSum(nums, target);
        System.out.println("执行结果为: " + result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            int length = nums.length - 3;
            int loop = nums.length - 2;
            int endIndex = nums.length - 1;
            for (int i = 0; i < length; i++) {
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                if (nums[i] + nums[length] + nums[length + 1] + nums[length + 2] < target) {
                    continue;
                }
                for (int j = i + 1; j < loop; j++) {
                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if (nums[i] + nums[loop] + nums[loop + 1] + nums[j] < target) {
                        continue;
                    }
                    int start = j + 1;
                    int end = endIndex;
                    while (start < end) {
                        int value = nums[i] + nums[start] + nums[end] + nums[j];
                        if (value == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[start]);
                            list.add(nums[end]);
                            list.add(nums[j]);
                            result.add(list);
                            while (nums[end] == nums[end - 1] && end - 1 > start) {
                                end--;
                            }
                            while (nums[start] == nums[start + 1] && start + 1 < end) {
                                start++;
                            }
                            end--;
                            start++;
                        } else if (value > target) {
                            end--;
                        } else {
                            start++;
                        }
                    }
                    while (nums[j] == nums[j + 1] && j < loop) {
                        j++;
                    }
                }
                while (nums[i] == nums[i + 1] && i < length) {
                    i++;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}