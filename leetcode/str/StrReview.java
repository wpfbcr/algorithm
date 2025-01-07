package str;

import java.util.HashMap;
import java.util.Map;

public class StrReview {

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 0};
        int i = Solution560.subarraySum(nums, 0);
        System.out.printf("Solution560:" + i + "\n");
    }


    /**
     * NO.560
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     *
     * 子数组是数组中元素的连续非空序列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     */
    static class Solution560 {
        public static int subarraySum(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            map.put(0,1);
            int count = 0;
            int pre = 0;
            for(int i = 0;i<nums.length;i++){
                pre += nums[i];
                if(map.containsKey(k-nums[i])){
                    count += map.get(k-nums[i]);
                }
                map.put(pre, map.getOrDefault(pre,0) + 1);
            }
            return count;
        }
    }
}
