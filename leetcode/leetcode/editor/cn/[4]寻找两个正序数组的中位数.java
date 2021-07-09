//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4236 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1 == null ? 0:nums1.length;
        int n = nums2 == null ? 0:nums2.length;
        if (m == 0 && n == 0) {
            return 0;
        }

        int[] nums = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int i = 0;

        while (p1 < m || p2 < n) {
            // num1 和 num2 可比较时
            if (m!= 0 && n!=0) {
                if (nums1[p1] < nums2[p2]) {
                    nums[i] = nums1[p1];
                    p1++;
                } else {
                    nums[i] = nums2[p2];
                    p2++;
                }
                i++;
            }

            // num1 结束，剩余部分直接取num2
            if (p1 == m) {
                while (p2 < n) {
                    nums[i] = nums2[p2];
                    i++;
                    p2++;
                }
            }

            // num2 结束，剩余部分直接取num1
            if (p2 == n) {
                while (p1 < m) {
                    nums[i] = nums1[p1];
                    i++;
                    p1++;
                }
            }
        }


        if ((m+n)%2 == 0) {
            return (nums[((m + n)/2)-1]+nums[(m + n)/2])/2.0;
        }
        return nums[(m + n)/2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
