package hash;

import java.util.HashSet;
import java.util.Set;

public class HashTest {


    // 128 ：主体思想，在hash中找到一个可以当初始值的节点去遍历
    /*
      给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

    示例 1：

    输入：nums =[100,4,200,1,3,2]
    输出：4
    解释：最长数字连续序列是 [1,2,3,4]。它的长度为 4。
    示例 2：

    输入：nums =[0,3,7,2,5,8,4,6,0,1]
    输出：9
     */
    static class Solution {
        public int longestConsecutive(int[] nums) {
            int max = 0;
            Set<Integer> hashHappened = new HashSet<>();
            int right = 0;
            while (right < nums.length) {
                hashHappened.add(nums[right++]);
            }
            for (int num : hashHappened) { //遍历set去重
                if (!hashHappened.contains(num - 1)) { //点睛之笔，找到最小的数，才能是O(N）的时间复杂度
                   int length = 1;
                   int numBegin = num+1;
                   while(hashHappened.contains(numBegin)){
                       length++;
                       numBegin++;
                   }
                    max = Math.max(max,length);
                }
            }
            return max;
        }
    }
}
