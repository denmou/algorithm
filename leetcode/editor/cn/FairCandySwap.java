//
// 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
//
// 因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。） 
//
// 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。 
//
// 如果有多个答案，你可以返回其中任何一个。保证答案存在。 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [1,1], B = [2,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：A = [1,2], B = [2,3]
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：A = [2], B = [1,3]
//输出：[2,3]
// 
//
// 示例 4： 
//
// 
//输入：A = [1,2,5], B = [2,4]
//输出：[5,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// 1 <= B.length <= 10000 
// 1 <= A[i] <= 100000 
// 1 <= B[i] <= 100000 
// 保证爱丽丝与鲍勃的糖果总量不同。 
// 答案肯定存在。 
// 
// Related Topics 数组 
// 👍 122 👎 0

import java.util.Scanner;

//Java：公平的糖果棒交换
public class FairCandySwap {
    public static void main(String[] args) {
        Solution solution = new FairCandySwap().new Solution();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入A数组:");
        String value = scanner.nextLine();
        int[] a = Util.toIntegerArray(value);
        System.out.print("请输入B数组:");
        value = scanner.nextLine();
        int[] b = Util.toIntegerArray(value);
        int[] result = solution.fairCandySwap(a, b);
        System.out.print('[');
        System.out.print(result[0]);
        System.out.print(',');
        System.out.print(result[1]);
        System.out.println(']');
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            //Set<Integer> set = new HashSet<>();
            boolean[] flag=new boolean[100001];//定义flag数组，纪录A中出现的数
            int sumB = 0;//对B数组求和
            for (int b : B) {
                sumB += b;
            }
            int sumA = 0;
            for (int num : A) {//计算sumB-sumA，并记录A中出现的数
                sumA += num;
                //set.add(num);
                flag[num]=true;
            }
            int offset = (sumA - sumB) / 2;
            for (int num : B) {//遍历B数组，找到A中符合条件的数，作为结果返回
                int t = num + offset;
                if (t > 0 && t < 100001 && flag[t]) {//判断A中是否存在这个数
                    return new int[]{t, num};
                }
            }
            return null;
            /*
            int sumA = 0, sumB = 0;
            Set<Integer> setB = new HashSet<>();
            for (int b : B) {
                sumB += b;
                setB.add(b);
            }
            for (int a : A) {
                sumA += a;
            }
            int offset = (sumB - sumA) / 2;
            for (int value : A) {
                int target = value + offset;
                if (target > 0 && setB.contains(target)) {
                    return new int[]{value, target};
                }
            }
            return null;
             */
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}