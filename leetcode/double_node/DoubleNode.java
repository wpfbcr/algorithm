package double_node;

import java.util.*;

public class DoubleNode {


    public static void main(String[] args) {

        int[] p = new int[]{0, 1, 0, 3, 12};
        Solution283.moveZeroes(p);
        System.out.printf("Solution283 :" + Arrays.toString(p) + "\n");

        int[] area = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = Solution11.maxArea(area);
        System.out.printf("Solution11 :" + maxArea + "\n");

        int[] treeSum = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> tresList = Solution15.threeSum(treeSum);
        System.out.printf("Solution15 :" + tresList.toString() + "\n");


        int[] trapArray = new int[]{4, 2, 3};
        int ret = Solution42.trap(trapArray);
        System.out.printf("Solution42 :" + ret + "\n");

    }

    /**
     * NO.283
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [0,1,0,3,12] 100312，
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * <p>
     * 输入: nums = [0]
     * 输出: [0]
     */

    static class Solution283 {
        public static void moveZeroes(int[] nums) {
            int left = 0;
            int right = 0;
            while (right < nums.length) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    left++;
                }
                right++;
            }
        }

        private static void swap(int[] nums, int left, int right) {
            nums[left] = nums[right];
            nums[right] = 0;
        }
    }


    /**
     * no.11 核心思想：双指针移动时保证面积最大化。固定较长边
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     */

    static class Solution11 {
        public static int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxArea = 0;
            while (left < right) {
                maxArea = Math.max(height[right] > height[left] ? height[left] * (right - left) : height[right] * (right - left), maxArea);
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return maxArea;
        }
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> ans = new ArrayList<>();

            for (int begin = 0; begin < nums.length; begin++) {
                if (begin > 0 && nums[begin - 1] == nums[begin]) {
                    continue;
                }
                int start = begin + 1;
                int end = nums.length - 1;

                while (start < end) {
                    int value = nums[start] + nums[end] + nums[begin];
                    if (value == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[begin]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        ans.add(list);
                        while ((start + 1) < end && nums[start + 1] == nums[start]) ++start;
                        while ((end - 1) > start && nums[end - 1] == nums[end]) --end;
                        ++start;
                        --end;
                    }
                    if (value < 0) {
                        ++start;
                    } else if (value > 0) {
                        --end;
                    }
                }
            }
            return ans;
        }
    }

    /**
     * NO.15  核心思想，排序，过滤头尾不相同的元素
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
     */

    static class Solution15 {
        public static List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ret = new ArrayList<>();
            int left = 0;
            if (nums.length <= 1) {
                return ret;
            }
            for (int i = left; i < nums.length; i++) {
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int var = nums[i] + nums[start] + nums[end];
                    if (var == 0) {
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[i]);
                        integers.add(nums[start]);
                        integers.add(nums[end]);
                        ret.add(integers);
                        while ((start + 1) < end && nums[start + 1] == nums[start]) ++start;
                        while ((end - 1) > start && nums[end - 1] == nums[end]) --end;
                        ++start;
                        --end;
                    }
                    if (var < 0) {
                        ++start;
                    } else if (var > 0)
                        --end;
                }
            }

            return ret;
        }
    }


    /**
     * NO 42 单调栈、双指针
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     */

    static class Solution42 {
        public static int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int leftMax = 0;
            int rightMax = 0;
            int ret = 0;

            while (left < right) {
                leftMax = Math.max(leftMax,height[left]);
                rightMax = Math.max(rightMax,height[right]);
                if(height[left] < height[right]){
                    ret+=(leftMax - height[left++]);
                }else{
                    ret+=(rightMax-height[right--]);
                }
            }
            return ret;
        }
    }


}


























