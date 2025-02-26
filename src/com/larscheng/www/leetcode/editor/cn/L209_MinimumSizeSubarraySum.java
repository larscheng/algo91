//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其
//长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2226 👎 0

package com.larscheng.www.leetcode.editor.cn;


public class L209_MinimumSizeSubarraySum{
      
  public static void main(String[] args) {
       Solution solution = new L209_MinimumSizeSubarraySum().new Solution();
       
  }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 滑动窗口
     * 不断收缩左边界，寻找最小子数组，时间复杂度O(n)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum+=nums[right];
            while (sum>=target){
                res = Math.min(res, right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE?0:res;
    }

    /**
     * 暴力循环,时间复杂度O(n^2)
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum>=target){
                res = Math.min(res, 1);
                break;
            }
            for (int j = i+1; j < nums.length ; j++) {
                sum += nums[j];
                if (sum>=target){
                    res = Math.min(res, j-i+1);
                }
            }
        }
        return res == Integer.MAX_VALUE? 0:res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}