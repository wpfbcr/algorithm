import java.util.ArrayList;
import java.util.List;

public class Window {


    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> anagrams = Solution.findAnagrams(s, p);
        System.out.println(anagrams);


        String input = "abcabcbb";
        int i = Solution5.lengthOfLongestSubstring(input);
        char c = 'c';
        System.out.printf("Solution5 answer:"+(i));
    }


    /**
     * NO.3
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
     * 子串
     * 的长度。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */


    static class Solution5 {
        public static int lengthOfLongestSubstring(String s) {
            int[] t = new int[128];
            int retMax = 0;
            int right = 0;
            int left= 0;
            while (right < s.length()) {
                char c = s.charAt(right);
                if(++t[c-32] >1){
                    retMax = Math.max(retMax,right-left);
                    while(left<right){
                        char d = s.charAt(left);
                        if(--t[d-32] ==1){
                            left++;
                            break;
                        }else{
                            left++;
                        }
                    }
                }else{
                    retMax = Math.max(retMax,right-left);
                }
                right++;
            }
            return retMax;
        }
    }



    static class Solution {
        public static List<Integer> findAnagrams(String s, String p) {

            int[] pWindow = new int[128];
            int[] sWindow = new int[128];
            int countDown = 0;

            for (int i = 0; i < p.length(); i++) {
                char pc =  p.charAt(i);
                if(++pWindow[pc-'a'] == 1){
                    countDown +=1;
                }
            }

            List<Integer> ret = new ArrayList<>();

            int left = 0;
            int right = 0;
            while (right<s.length()){
                char c = s.charAt(right);
                if(++sWindow[c-'a'] == pWindow[c-'a']){
                    countDown--;
                }

                while(countDown == 0){
                    if((right-left == p.length()-1)){
                        ret.add(left);
                    }
                    char b = s.charAt(left);
                    if(sWindow[b-'a']-- == pWindow[b-'a']){
                        countDown++;
                    }
                    left++;
                }
                right++;
            }
            return ret;
        }
    }
}
