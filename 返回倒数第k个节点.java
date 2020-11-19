/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 *
 * 执行用时：
 * 0 ms
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 * 内存消耗：
 * 35.9 MB
 * , 在所有 Java 提交中击败了
 * 93.43%
 * 的用户
 */

//为什么同样的题用Java写更快！！
class 返回倒数第k个节点 {
    public int kthToLast(ListNode head, int k) {
        ListNode fast=head;
        ListNode slow=head;
        for(int i=1;i<=k;i++)
            fast=fast.next;
        while(fast!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow.val;
    }}