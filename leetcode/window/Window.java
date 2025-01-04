import java.util.ArrayList;
import java.util.List;

public class Window {


    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> anagrams = Solution.findAnagrams(s, p);
        System.out.println(anagrams);
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
