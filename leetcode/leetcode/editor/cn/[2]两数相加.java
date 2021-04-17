//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 6048 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     *  1- 两数相加之后进位
     *  2- 考虑当前节点已经被进位了之后求和
     *  3- 返回链表需要保存头节点
     *  4- next到下一个节点的时候也要判空
     *  5- 两个加数都为null且进位为0的时候才终止
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode curNode = new ListNode();
        result.next = curNode;

        // 1）两个链表的交互要在两条链表都没节点后才终止
        while (l1 != null || l2 != null) {
            // 2）①取进位
            int tmp = curNode.val;
            // 2）②取加数1
            if (l1 != null) {
                tmp += l1.val;
                l1 = l1.next;
            }
            // 2）③取加数2
            if (l2 != null) {
                tmp += l2.val;
                l2 = l2.next;
            }
            // 3）计算进位和余数并更新当前val
            int carry = tmp/10;
            int rest = tmp%10;
            curNode.val = rest;

            // 4）判断是否结束
            if (l1 == null && l2 == null && carry == 0) {
                return result.next;
            }

            // 5) 未结束继续迭代
            curNode.next = new ListNode(carry);
            curNode = curNode.next;

        }
        return result.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
