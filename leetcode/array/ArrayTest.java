package array;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ArrayTest {


    public static void main(String[] args) {
        int[] t = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = Solution53.maxSubArray(t);
        System.out.printf("Solution53 ans" + i + "\n");

    }

    /**
     * NO.53
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组
     * 是数组中的一个连续部分。
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     */
    static class Solution53 {
        public static int maxSubArray(int[] nums) {
            int pre = Integer.MIN_VALUE;
            int left = 0;
            int right = 0;
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= pre + nums[i]) {
                    pre = nums[i];
                    max = Math.max(max, nums[i]);
                    continue;
                }
                if (nums[i] + pre > pre) {
                    max = Math.max(max, nums[i] + pre);
                }
                pre += nums[i];
            }
            return max;
        }

        public static int maxSubArray2(int[] nums) {
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }
    }

    /**
     * NO.56
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     */
    static class Solution {
        public static int[][] merge(int[][] intervals) {
            int[][] ret = new int[intervals.length][2];
            int left = intervals[0][0];
            int right = intervals[0][1];
            int start = 0;

            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] > right) {
                    right = intervals[i][1];
                } else {
                    ret[start][0] = left;
                    ret[start][1] = right;
                    start++;
                    left = intervals[i][0];
                    right = intervals[i][1];
                }
            }
            return ret;
        }
    }

    /**
     * NP.41
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * <p>
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     */

    static class Solution41 {
        public static int firstMissingPositive(int[] nums) {
            int l = nums.length;
            for(int i = 0;i<l;i++){
                while(nums[i]>0 && nums[i]<=l && nums[nums[i]-1]!=nums[i]){
                    int tem = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = tem;
                }
            }
            for(int i = 0;i<l ;i++){
                if(nums[i]!=i+1){
                    return i+1;
                }
            }
            return nums.length+1;
        }
    }
}


















