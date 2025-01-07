# algorithm
 about a little test
```markdown
# 算法书

## 目录
1. [移动零](#移动零)
2. [盛最多水的容器](#盛最多水的容器)
3. [三数之和](#三数之和)
4. [接雨水](#接雨水)
5. [最长连续序列](#最长连续序列)
6. [找到字符串中的所有字母异位词](#找到字符串中的所有字母异位词)

---

## 移动零

### 问题描述
给定一个数组 `nums`，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。请注意，必须在不复制数组的情况下原地对数组进行操作。

### 示例
- 输入: `nums = [0,1,0,3,12]`
- 输出: `[1,3,12,0,0]`

### 复杂度分析
- 时间复杂度: O(n)
- 空间复杂度: O(1)

### 代码
```java
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
```

---

## 盛最多水的容器

### 问题描述
给定 n 条垂线，找出两条线与 x 轴共同构成的容器可以容纳最多的水。

### 示例
- 输入: `height = [1,8,6,2,5,4,8,3,7]`
- 输出: `49`

### 复杂度分析
- 时间复杂度: O(n)
- 空间复杂度: O(1)

### 代码
```java
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
```

---

## 三数之和

### 问题描述
给定一个整数数组，找出所有不重复的三元组，使得它们的和为零。

### 示例
- 输入: `nums = [-1,0,1,2,-1,-4]`
- 输出: `[[-1,-1,2],[-1,0,1]]`

### 复杂度分析
- 时间复杂度: O(n^2)
- 空间复杂度: O(1)

### 代码
```java
public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ret = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        int start = i + 1, end = nums.length - 1;
        while (start < end) {
            int sum = nums[i] + nums[start] + nums[end];
            if (sum == 0) {
                ret.add(Arrays.asList(nums[i], nums[start], nums[end]));
                while (start < end && nums[start] == nums[start + 1]) start++;
                while (start < end && nums[end] == nums[end - 1]) end--;
                start++;
                end--;
            } else if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
    }
    return ret;
}
```

---

## 接雨水

### 问题描述
给定 n 个非负整数，计算按此排列的柱子下雨后能接多少雨水。

### 示例
- 输入: `height = [4,2,0,3,2,5]`
- 输出: `9`

### 复杂度分析
- 时间复杂度: O(n)
- 空间复杂度: O(1)

### 代码
```java
public static int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0;
    int ret = 0;
    while (left < right) {
        leftMax = Math.max(leftMax, height[left]);
        rightMax = Math.max(rightMax, height[right]);
        if (height[left] < height[right]) {
            ret += (leftMax - height[left++]);
        } else {
            ret += (rightMax - height[right--]);
        }
    }
    return ret;
}
```

---

## 最长连续序列

### 问题描述
给定一个未排序的整数数组，找出数字连续的最长序列的长度。

### 示例
- 输入: `nums = [100,4,200,1,3,2]`
- 输出: `4` （最长连续序列是 `[1,2,3,4]`）

### 复杂度分析
- 时间复杂度: O(n)
- 空间复杂度: O(n)

### 代码
```java
public int longestConsecutive(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) numSet.add(num);
    int maxLength = 0;
    for (int num : nums) {
        if (!numSet.contains(num - 1)) {
            int length = 1;
            while (numSet.contains(num + length)) length++;
            maxLength = Math.max(maxLength, length);
        }
    }
    return maxLength;
}
```

---

## 找到字符串中的所有字母异位词

### 问题描述
给定字符串 s 和非空字符串 p，找到 p 的所有异位词在 s 中的起始索引。

### 示例
- 输入: `s = "cbaebabacd", p = "abc"`
- 输出: `[0, 6]`

### 复杂度分析
- 时间复杂度: O(n)
- 空间复杂度: O(1)

### 代码
```java
public static List<Integer> findAnagrams(String s, String p) {
    int[] pCount = new int[26];
    int[] sCount = new int[26];
    for (char c : p.toCharArray()) pCount[c - 'a']++;
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
        sCount[s.charAt(i) - 'a']++;
        if (i >= p.length()) sCount[s.charAt(i - p.length()) - 'a']--;
        if (Arrays.equals(pCount, sCount)) result.add(i - p.length() + 1);
    }
    return result;
}
```

---

## 结论
本书涵盖了多种常见的算法问题及其解决方案，适合希望提高算法能力的读者。欢迎探索代码并进行测试，任何贡献和建议都非常欢迎！
```

