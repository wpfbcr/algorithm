package str;

import java.util.*;

/*
  字符串
 */
public class StrTest {

    /*
     * NO.560 思路 前缀和+哈希表
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     * 子数组是数组中元素的连续非空序列。
     * 示例 1：
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 0};
        int i = Solution560.subarraySum(nums, 0);
        System.out.printf("Solution560:" + i + "\n");

        nums = new int[]{9, 10, 9, -7, -4, -8, 2, -6};
        int[] ret = Solution239.maxSlidingWindow(nums, 5);
        System.out.printf("Solution239:" + Arrays.toString(ret) + "\n");

        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = Solution76.minWindow(s, t);
        System.out.printf("Solution76:" + s1 + "\n");
    }

    static class Solution560 {
        public static int subarraySum(int[] nums, int k) {
            int count = 0;
            int pre = 0;
            Map<Integer, Integer> preCount = new HashMap<>();
            preCount.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (preCount.containsKey(pre - k)) {
                    count += preCount.get(pre - k);
                }
                preCount.put(pre, preCount.getOrDefault(pre, 0) + 1);
            }
            return count;
        }
    }

    /**
     * NO.239
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     */


    static class Solution239 {
        public static int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> dq = new LinkedList<>();
            int[] ans = new int[nums.length - k + 1];
            for (int i = 0; i < k; ++i) {
                while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                    dq.pollLast();
                }
                dq.offerLast(i);
            }

            ans[0] = nums[dq.peekFirst()];
            for (int i = k; i < nums.length; i++) {
                while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                    dq.pollLast();
                }
                dq.offerLast(i);

                while (dq.peekFirst() <= i - k) {
                    dq.pollFirst();
                }
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
            return ans;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }


    /**
     * NO.76
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     */
    static class Solution76 {
        public static String minWindow(String s, String t) {
            int min = -1;
            int[] sArray = new int[128];
            int[] tArray = new int[128];
            int start = 0;
            int count = 0;
            while (start < t.length()) {
                char c = t.charAt(start++);
                if (++tArray[c - 'A'] == 1) {
                    count++;
                }
            }

            int left = 0;
            int right = 0;
            int ansLeft = 0;
            int ansRight = s.length()-1;
            while (right < s.length()) {
                char sc = s.charAt(right);
                if (++sArray[sc - 'A'] == tArray[sc - 'A']) {
                    count--;
                }

                while (count == 0) {
                    if ((ansRight - ansLeft) > (right - left)) {
                        min = 1;
                        ansRight = right;
                        ansLeft = left;
                    }

                    char lc = s.charAt(left);
                    if(sArray[lc-'A'] -- == tArray[sc-'A']){
                        count++;
                    }
                    left++;
                }
                right++;
            }
            return min==-1?"":s.substring(ansLeft,ansRight+1);
        }
    }
}

























