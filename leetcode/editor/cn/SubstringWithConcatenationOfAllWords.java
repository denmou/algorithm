//
// 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
// 
// Related Topics 哈希表 双指针 字符串 
// 👍 417 👎 0


import java.util.*;

//Java：串联所有单词的子串
public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入s值:");
        String s = scanner.nextLine();
        System.out.print("请输入words数组:");
        String value = scanner.nextLine();
        String[] words = Util.toArray(value);
        List<Integer> result = solution.findSubstring(s, words);
        System.out.print("执行结果为: [");
        if (result.size() > 0) {
            System.out.print(result.get(0));
        }
        for (int i = 1; i < result.size(); i++) {
            System.out.print("," + result.get(i));
        }
        System.out.println("]");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new ArrayList<>();
            if (words.length > 0) {
                int size = words[0].length();
                int offset = size * words.length;
                Map<String, Integer> wordMap = new HashMap<>(16);
                for (String word : words) {
                    int count = wordMap.getOrDefault(word, 0) + 1;
                    wordMap.put(word, count);
                }
                int length = s.length() - offset + 1;
                for (int i = 0; i < length; i++) {
                    int exist = 0;
                    Map<String, Integer> keyMap = new HashMap<>(16);
                    for (int j = 0; j < words.length; j++) {
                        int index = i + j * size;
                        String key = s.substring(index, index + size);
                        if (wordMap.containsKey(key)) {
                            int count = keyMap.getOrDefault(key, 0) + 1;
                            if (count > wordMap.get(key)) {
                                break;
                            }
                            keyMap.put(key, count);
                            exist++;
                        } else {
                            break;
                        }
                    }
                    if (exist == words.length) {
                        result.add(i);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}