//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 排序 
// 👍 474 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
//        return solveByArray(nums);
        return solveByExchange(nums);
    }

    /**
     * Hash表空间换时间
     * @param nums
     * @return
     */
    public int solveByArray(int[] nums) {
        int[] condition = new int[nums.length];
        for (int num : nums) {
            if (condition[num] != 0) {
                return num;
            }
            condition[num] = 1;
        }
        return -1;
    }

    /**
     * 每个位置不停交换
     * @param nums
     * @return
     */
    public int solveByExchange(int[] nums) {
        /**
         *  针对每个位置遍历
         */
        for (int i = 0; i < nums.length; i++) {
            /**
             * 让下标为i的位置的值为i（每次交换能让nums[nums[i]]=nums[i]但不能保证nums[i]=i所以要循环）
             */
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                //让nums[nums[i]] == nums[i]
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
