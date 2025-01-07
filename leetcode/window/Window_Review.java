package window;

import java.util.ArrayList;
import java.util.List;

public class Window_Review {

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> anagrams = Solution438.findAnagrams(s, p);
        System.out.println(anagrams);


    }
    /**
     * NO.438. 找到字符串中所有字母异位词
     * 已解答
     * 中等
     * 相关标签
     * 相关企业
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的
     * 异位词
     * 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     * 示例 2:
     * <p>
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     */


    static class Solution438 {
        public static List<Integer> findAnagrams(String s, String p) {
            List<Integer> ret = new ArrayList<>();
            int sArray[] = new int[128];
            int pArray[] = new int[128];
            int count = 0;

            for(int i = 0;i<p.length();i++){
                if(++pArray[p.charAt(i)-'a'] == 1){
                    count++;
                }
            }


            int left = 0;
            int right = 0;
            while(right<s.length()){
                char sc = s.charAt(right);
                if(++sArray[sc-'a'] == pArray[sc-'a']){
                    count--;
                }

                while(count == 0){
                    if(right - left ==  p.length()-1){
                        ret.add(left);
                    }
                    char sl = s.charAt(left);
                    if(sArray[sl-'a']-- == pArray[sl-'a']){
                        count++;
                    }
                    left++;
                }
                right++;
            }
            return ret;
        }
    }
}
